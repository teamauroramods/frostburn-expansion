package com.teamaurora.frostburn_expansion.core;

import com.teamaurora.frostburn_expansion.client.render.entity.living.BriskRenderer;
import com.teamaurora.frostburn_expansion.core.registry.FBExBlocks;
import com.teamaurora.frostburn_expansion.core.registry.FBExEntities;
import com.teamaurora.frostburn_expansion.core.registry.FBExItems;
import com.teamaurora.frostburn_expansion.core.registry.FBExSounds;
import com.teamaurora.frostburn_expansion.datagen.FBExBlockModelProvider;
import gg.moonflower.pollen.api.config.ConfigManager;
import gg.moonflower.pollen.api.config.PollinatedConfigType;
import gg.moonflower.pollen.api.datagen.provider.model.PollinatedModelProvider;
import gg.moonflower.pollen.api.platform.Platform;
import gg.moonflower.pollen.api.registry.StrippingRegistry;
import gg.moonflower.pollen.api.registry.client.EntityRendererRegistry;
import gg.moonflower.pollen.api.registry.client.RenderTypeRegistry;
import gg.moonflower.pollen.api.util.PollinatedModContainer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("unused")
public class  FrostburnExpansion {
    public static final String MOD_ID = "frostburn_expansion";
    public static final FrostburnExpansionConfig.Client CLIENT_CONFIG = ConfigManager.register(MOD_ID, PollinatedConfigType.CLIENT, FrostburnExpansionConfig.Client::new);
    public static final FrostburnExpansionConfig.Common COMMON_CONFIG = ConfigManager.register(MOD_ID, PollinatedConfigType.COMMON, FrostburnExpansionConfig.Common::new);
    public static final Platform PLATFORM = Platform.builder(MOD_ID)
            .clientInit(() -> FrostburnExpansion::onClientInit)
            .clientPostInit(() -> FrostburnExpansion::onClientPostInit)
            .commonInit(FrostburnExpansion::onCommonInit)
            .commonPostInit(FrostburnExpansion::onCommonPostInit)
            .dataInit(FrostburnExpansion::onDataInit)
            .build();

    public static void onClientInit() {
        EntityRendererRegistry.register(FBExEntities.BRISK, BriskRenderer::new);
    }

    public static void onClientPostInit(Platform.ModSetupContext ctx) {
        RenderTypeRegistry.register(FBExBlocks.FROSTWOOD_DOOR.get(), RenderType.cutoutMipped());
    }

    public static void onCommonInit() {
        FBExBlocks.BLOCKS.register(PLATFORM);
        FBExItems.ITEMS.register(PLATFORM);
        FBExSounds.SOUNDS.register(PLATFORM);
        FBExEntities.ENTITY_TYPES.register(PLATFORM);
        FBExEntities.registerEntityAttributes();
    }

    public static void onCommonPostInit(Platform.ModSetupContext ctx) {
        StrippingRegistry.register(FBExBlocks.CHARRED_LOG.get(), FBExBlocks.STRIPPED_CHARRED_LOG.get());
        StrippingRegistry.register(FBExBlocks.CHARRED_WOOD.get(), FBExBlocks.STRIPPED_CHARRED_WOOD.get());
        StrippingRegistry.register(FBExBlocks.FROSTWOOD_LOG.get(), FBExBlocks.STRIPPED_FROSTWOOD_LOG.get());
        StrippingRegistry.register(FBExBlocks.FROSTWOOD_WOOD.get(), FBExBlocks.STRIPPED_FROSTWOOD_WOOD.get());
    }

    private static void onDataInit(Platform.DataSetupContext ctx) {
        DataGenerator generator = ctx.getGenerator();
        PollinatedModContainer container = ctx.getMod();
        PollinatedModelProvider modelProvider = new PollinatedModelProvider(generator, container);
        modelProvider.addGenerator(FBExBlockModelProvider::new);
        generator.addProvider(modelProvider);
    }

    public static ResourceLocation generateResourceLocation(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
