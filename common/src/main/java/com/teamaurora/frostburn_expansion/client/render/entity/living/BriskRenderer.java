package com.teamaurora.frostburn_expansion.client.render.entity.living;

import com.mojang.blaze3d.vertex.PoseStack;
import com.teamaurora.frostburn_expansion.common.entity.Brisk;
import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import gg.moonflower.pollen.pinwheel.api.client.animation.AnimatedEntityRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

@Environment(EnvType.CLIENT)
public class BriskRenderer extends AnimatedEntityRenderer<Brisk> {
    public static final ResourceLocation BRISK_LOCATION = new ResourceLocation(FrostburnExpansion.MOD_ID, "brisk");
    private static final ResourceLocation[] DANCE_ANIMATION = new ResourceLocation[]{new ResourceLocation(FrostburnExpansion.MOD_ID, "brisk.setup"), new ResourceLocation(FrostburnExpansion.MOD_ID, "brisk.dance")};


    public BriskRenderer(EntityRendererProvider.Context context) {
        super(context, FrostburnExpansion.generateResourceLocation("brisk"), 1.0F);
    }

    @Override
    public ResourceLocation[] getAnimations(Brisk entity) {
        if (entity.isDancing)
            return DANCE_ANIMATION;
        return super.getAnimations(entity);
    }

    protected void scale(Brisk brisk, PoseStack poseStack, float f) {
        float g = brisk.getSwelling(f);
        float h = 1.0F + Mth.sin(g * 100.0F) * g * 0.01F;
        g = Mth.clamp(g, 0.0F, 1.0F);
        g *= g;
        g *= g;
        float i = (1.0F + g * 0.4F) * h;
        float j = (1.0F + g * 0.1F) / h;
        poseStack.scale(i, j, i);
    }

    protected float getWhiteOverlayProgress(Brisk brisk, float f) {
        float g = brisk.getSwelling(f);
        return (int)(g * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(g, 0.5F, 1.0F);
    }

    @Override
    public ResourceLocation getTextureTableLocation(Brisk entity) {
        return BRISK_LOCATION;
    }
}
