package com.teamaurora.frostburn_expansion.common.entity;

import com.teamaurora.frostburn_expansion.common.entity.ai.goal.BriskSwellGoal;
import gg.moonflower.pollen.pinwheel.api.common.animation.AnimatedEntity;
import gg.moonflower.pollen.pinwheel.api.common.animation.AnimationEffectHandler;
import gg.moonflower.pollen.pinwheel.api.common.animation.AnimationEffectSource;
import gg.moonflower.pollen.pinwheel.api.common.animation.AnimationState;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.JukeboxBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.JukeboxBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Brisk
 * @author mostly mojang lol
 *
 */
public class Brisk extends Monster implements PowerableMob, AnimatedEntity {
	private static final EntityDataAccessor<Integer> DATA_SWELL_DIR;
	private static final EntityDataAccessor<Boolean> DATA_IS_POWERED;
	private static final EntityDataAccessor<Boolean> DATA_IS_IGNITED;
	private int oldSwell;
	private int swell;
	private int maxSwell = 30;
	private int explosionRadius = 3;
	private final AnimationEffectHandler effectHandler;
	private AnimationState animationState;
	private AnimationState transitionAnimationState;
	private int animationTick;
	private int animationTransitionTick;
	private int animationTransitionLength;
	public static final AnimationState DANCE = new AnimationState(2000);
	public boolean isDancing = false;

	public Brisk(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
		this.effectHandler = new AnimationEffectHandler(this);
		this.animationState = AnimationState.EMPTY;
	}


	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new BriskSwellGoal(this));
		this.goalSelector.addGoal(3, new AvoidEntityGoal(this, Ocelot.class, 6.0F, 1.0D, 1.2D));
		this.goalSelector.addGoal(3, new AvoidEntityGoal(this, Cat.class, 6.0F, 1.0D, 1.2D));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(7, new BriskDanceGoal(this));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, true));
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this, new Class[0]));
	}

	public static Supplier<AttributeSupplier.Builder> createAttributes() {
		return () ->  Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.25D);
	}

	public int getMaxFallDistance() {
		return this.getTarget() == null ? 3 : 3 + (int)(this.getHealth() - 1.0F);
	}

	public boolean causeFallDamage(float f, float g, DamageSource damageSource) {
		boolean bl = super.causeFallDamage(f, g, damageSource);
		this.swell = (int)((float)this.swell + f * 1.5F);
		if (this.swell > this.maxSwell - 5) {
			this.swell = this.maxSwell - 5;
		}

		return bl;
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_SWELL_DIR, -1);
		this.entityData.define(DATA_IS_POWERED, false);
		this.entityData.define(DATA_IS_IGNITED, false);
	}

	public void addAdditionalSaveData(CompoundTag compoundTag) {
		super.addAdditionalSaveData(compoundTag);
		if ((Boolean)this.entityData.get(DATA_IS_POWERED)) {
			compoundTag.putBoolean("powered", true);
		}

		compoundTag.putShort("Fuse", (short)this.maxSwell);
		compoundTag.putByte("ExplosionRadius", (byte)this.explosionRadius);
		compoundTag.putBoolean("ignited", this.isIgnited());
	}

	public void readAdditionalSaveData(CompoundTag compoundTag) {
		super.readAdditionalSaveData(compoundTag);
		this.entityData.set(DATA_IS_POWERED, compoundTag.getBoolean("powered"));
		if (compoundTag.contains("Fuse", 99)) {
			this.maxSwell = compoundTag.getShort("Fuse");
		}

		if (compoundTag.contains("ExplosionRadius", 99)) {
			this.explosionRadius = compoundTag.getByte("ExplosionRadius");
		}

		if (compoundTag.getBoolean("ignited")) {
			this.ignite();
		}

	}

	public void tick() {
		if (this.isAlive()) {
			this.oldSwell = this.swell;
			if (this.isIgnited()) {
				this.setSwellDir(1);
			}

			int i = this.getSwellDir();
			if (i > 0 && this.swell == 0) {
				this.playSound(SoundEvents.CREEPER_PRIMED, 1.0F, 0.5F);
				this.gameEvent(GameEvent.PRIME_FUSE);
			}

			this.swell += i;
			if (this.swell < 0) {
				this.swell = 0;
			}

			if (this.swell >= this.maxSwell) {
				this.swell = this.maxSwell;
				this.explodeBrisk();
			}
		}

		super.tick();
	}

	public void setTarget(@Nullable LivingEntity livingEntity) {
		if (!(livingEntity instanceof Goat)) {
			super.setTarget(livingEntity);
		}
	}

	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return SoundEvents.CREEPER_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.CREEPER_DEATH;
	}

	public boolean doHurtTarget(Entity entity) {
		return true;
	}

	public boolean isPowered() {
		return (Boolean)this.entityData.get(DATA_IS_POWERED);
	}

	public float getSwelling(float f) {
		return Mth.lerp(f, (float)this.oldSwell, (float)this.swell) / (float)(this.maxSwell - 2);
	}

	public int getSwellDir() {
		return (Integer)this.entityData.get(DATA_SWELL_DIR);
	}

	public void setSwellDir(int i) {
		this.entityData.set(DATA_SWELL_DIR, i);
	}

	public void thunderHit(ServerLevel serverLevel, LightningBolt lightningBolt) {
		super.thunderHit(serverLevel, lightningBolt);
		this.entityData.set(DATA_IS_POWERED, true);
	}

	protected InteractionResult mobInteract(Player player, InteractionHand interactionHand) {
		ItemStack itemStack = player.getItemInHand(interactionHand);
		if (itemStack.is(Items.FLINT_AND_STEEL)) {
			this.setAnimationState(DANCE);
			this.level.playSound(player, this.getX(), this.getY(), this.getZ(), SoundEvents.FLINTANDSTEEL_USE, this.getSoundSource(), 1.0F, this.random.nextFloat() * 0.4F + 0.8F);
			if (!this.level.isClientSide) {
				this.ignite();
				itemStack.hurtAndBreak(1, player, (playerx) -> {
					playerx.broadcastBreakEvent(interactionHand);
				});
			}

			return InteractionResult.sidedSuccess(this.level.isClientSide);
		} else {
			return super.mobInteract(player, interactionHand);
		}
	}

	private void explodeBrisk() {
		if (!this.level.isClientSide) {
			Explosion.BlockInteraction blockInteraction = this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
			float f = this.isPowered() ? 2.0F : 1.0F;
			this.dead = true;
			this.level.explode(this, this.getX(), this.getY(), this.getZ(), (float)this.explosionRadius * f, blockInteraction);
			this.discard();
			this.spawnLingeringCloud();
		}

	}

	private void spawnLingeringCloud() {
		Collection<MobEffectInstance> collection = this.getActiveEffects();
		if (!collection.isEmpty()) {
			AreaEffectCloud areaEffectCloud = new AreaEffectCloud(this.level, this.getX(), this.getY(), this.getZ());
			areaEffectCloud.setRadius(2.5F);
			areaEffectCloud.setRadiusOnUse(-0.5F);
			areaEffectCloud.setWaitTime(10);
			areaEffectCloud.setDuration(areaEffectCloud.getDuration() / 2);
			areaEffectCloud.setRadiusPerTick(-areaEffectCloud.getRadius() / (float)areaEffectCloud.getDuration());
			Iterator var3 = collection.iterator();

			while(var3.hasNext()) {
				MobEffectInstance mobEffectInstance = (MobEffectInstance)var3.next();
				areaEffectCloud.addEffect(new MobEffectInstance(mobEffectInstance));
			}

			this.level.addFreshEntity(areaEffectCloud);
		}

	}

	public boolean isIgnited() {
		return (Boolean)this.entityData.get(DATA_IS_IGNITED);
	}

	public void ignite() {
		this.entityData.set(DATA_IS_IGNITED, true);
	}

	@Override
	public AnimationState[] getAnimationStates() {
		return new AnimationState[] {
				DANCE
		};
	}

	@Override
	public int getAnimationTick() {
		return animationTick;
	}

	@Override
	public void setAnimationTick(int tick) {
		this.animationTick = tick;
	}

	@Override
	public int getAnimationTransitionTick() {
		return animationTransitionTick;
	}

	@Override
	public void setAnimationTransitionTick(int animationTransitionTick) {
		this.animationTransitionTick = animationTransitionTick;
	}

	@Override
	public int getAnimationTransitionLength() {
		return animationTransitionLength;
	}

	@Override
	public void setAnimationTransitionLength(int animationTransitionLength) {
		this.animationTransitionLength = animationTransitionLength;
	}

	@Override
	public AnimationState getAnimationState() {
		return animationState;
	}

	@Override
	public AnimationState getTransitionAnimationState() {
		return transitionAnimationState;
	}

	@Override
	public void setAnimationState(AnimationState state) {
		this.onAnimationStop(this.animationState);
		this.animationState = state;
		this.setAnimationTick(0);
		this.setAnimationTransitionLength(0);
	}

	@Override
	public void setTransitionAnimationState(AnimationState state) {
		this.transitionAnimationState = state;
	}

	@Override
	public AnimationEffectHandler getAnimationEffects() {
		return effectHandler;
	}

	public void setDancing(boolean value) {
		this.isDancing = value;
	}

	private static class BriskDanceGoal extends Goal {
		private final Brisk brisk;

		protected BriskDanceGoal(Brisk brisk) {
			this.brisk = brisk;
		}


		@Override
		public boolean canUse() {
			return true;
		}

		@Override
		public boolean canContinueToUse() {
			return !brisk.isIgnited() && brisk.isAlive();
		}

		@Override
		public void start() {
			this.brisk.setDancing(true);
			this.brisk.setAnimationState(DANCE);
		}

		@Override
		public void stop() {
			this.brisk.setDancing(false);
		}
	}

	static {
		DATA_SWELL_DIR = SynchedEntityData.defineId(Brisk.class, EntityDataSerializers.INT);
		DATA_IS_POWERED = SynchedEntityData.defineId(Brisk.class, EntityDataSerializers.BOOLEAN);
		DATA_IS_IGNITED = SynchedEntityData.defineId(Brisk.class, EntityDataSerializers.BOOLEAN);
	}
}
