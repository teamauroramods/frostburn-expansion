package com.teamaurora.frostburn_expansion.client.render.entity.living;

import com.teamaurora.frostburn_expansion.common.entity.Brisk;
import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import gg.moonflower.pollen.pinwheel.api.client.animation.AnimatedEntityRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;


@Environment(EnvType.CLIENT)
public class BriskRenderer extends AnimatedEntityRenderer<Brisk> {
    public static final ResourceLocation BRISK_LOCATION = new ResourceLocation(FrostburnExpansion.MOD_ID, "brisk");

    public BriskRenderer(EntityRendererProvider.Context context) {
        super(context, FrostburnExpansion.generateResourceLocation("brisk"), 1.0F);
    }

    @Override
    public ResourceLocation getTextureTableLocation(Brisk entity) {
        return BRISK_LOCATION;
    }
}
