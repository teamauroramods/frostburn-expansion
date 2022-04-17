package com.teamaurora.frostburn_expansion.core.registry;

import com.teamaurora.frostburn_expansion.common.entity.Brisk;
import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import gg.moonflower.pollen.api.registry.EntityAttributeRegistry;
import gg.moonflower.pollen.api.registry.PollinatedEntityRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class FBExEntities {
    public static final PollinatedEntityRegistry ENTITY_TYPES = PollinatedEntityRegistry.createEntity(FrostburnExpansion.MOD_ID);

    public static final Supplier<EntityType<Brisk>> BRISK = ENTITY_TYPES.register("brisk", () -> EntityType.Builder.of(Brisk::new, MobCategory.MONSTER).sized(0.6F, 1.7F).build(FrostburnExpansion.MOD_ID));

    public static void registerEntityAttributes() {
        EntityAttributeRegistry.register(BRISK, Brisk.createAttributes());
    }
}
