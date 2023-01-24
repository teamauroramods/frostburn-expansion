package com.teamaurora.frostburn_expansion.core;

import com.teamaurora.frostburn_expansion.client.render.entity.living.BriskRenderer;
import com.teamaurora.frostburn_expansion.core.registry.FBExBlocks;
import com.teamaurora.frostburn_expansion.core.registry.FBExEntities;
import com.teamaurora.frostburn_expansion.core.registry.FBExItems;
import com.teamaurora.frostburn_expansion.core.registry.FBExSounds;
import gg.moonflower.pollen.api.config.ConfigManager;
import gg.moonflower.pollen.api.config.PollinatedConfigType;
import gg.moonflower.pollen.api.platform.Platform;
import gg.moonflower.pollen.api.registry.client.EntityRendererRegistry;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("unused")
public class  FrostburnExpansion {
    public static final String MOD_ID = "frostburn_expansion";
    public static final FrostburnExpansionConfig.Client CLIENT_CONFIG = ConfigManager.register(MOD_ID, PollinatedConfigType.CLIENT, FrostburnExpansionConfig.Client::new);
    public static final FrostburnExpansionConfig.Common COMMON_CONFIG = ConfigManager.register(MOD_ID, PollinatedConfigType.COMMON, FrostburnExpansionConfig.Common::new);
    public static final Platform PLATFORM = Platform.builder(MOD_ID)
            .clientInit(FrostburnExpansion::onClientInit)
            .clientPostInit(FrostburnExpansion::onClientPostInit)
            .commonInit(FrostburnExpansion::onCommonInit)
            .commonPostInit(FrostburnExpansion::onCommonPostInit)
            .dataInit(FrostburnExpansion::onDataInit)
            .build();

    public static void onClientInit() {
        EntityRendererRegistry.register(FBExEntities.BRISK, BriskRenderer::new);
    }

    public static void onClientPostInit(Platform.ModSetupContext ctx) {
    }

    public static void onCommonInit() {
        FBExBlocks.BLOCKS.register(FrostburnExpansion.PLATFORM);
        FBExItems.ITEMS.register(FrostburnExpansion.PLATFORM);
        FBExSounds.SOUNDS.register(FrostburnExpansion.PLATFORM);
        FBExEntities.ENTITY_TYPES.register(FrostburnExpansion.PLATFORM);
        FBExEntities.registerEntityAttributes();
    }

    public static void onCommonPostInit(Platform.ModSetupContext ctx) {
    }

    public static void onDataInit(Platform.DataSetupContext ctx) {
    }

    public static ResourceLocation generateResourceLocation(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
