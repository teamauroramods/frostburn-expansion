package com.teamaurora.frostburn_expansion.common.entity.ai.goal;

import com.teamaurora.frostburn_expansion.common.entity.Brisk;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

/**
 * Brisk
 * @author mostly mojang lol
 * @author ebo2022 (porting :p)
 */
public class BriskSwellGoal extends Goal {
	private final Brisk brisk;
	@Nullable
	private LivingEntity target;

	public BriskSwellGoal(Brisk brisk) {
		this.brisk = brisk;
		this.setFlags(EnumSet.of(Flag.MOVE));
	}

	public boolean canUse() {
		LivingEntity livingEntity = this.brisk.getTarget();
		return this.brisk.getSwellDir() > 0 || livingEntity != null && this.brisk.distanceToSqr(livingEntity) < 9.0D;
	}

	public void start() {
		this.brisk.getNavigation().stop();
		this.target = this.brisk.getTarget();
	}

	public void stop() {
		this.target = null;
	}

	public boolean requiresUpdateEveryTick() {
		return true;
	}

	public void tick() {
		if (this.target == null) {
			this.brisk.setSwellDir(-1);
		} else if (this.brisk.distanceToSqr(this.target) > 49.0D) {
			this.brisk.setSwellDir(-1);
		} else if (!this.brisk.getSensing().hasLineOfSight(this.target)) {
			this.brisk.setSwellDir(-1);
		} else {
			this.brisk.setSwellDir(1);
		}
	}
}

