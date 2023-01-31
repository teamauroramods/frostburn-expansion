package com.teamaurora.frostburn_expansion.core.mixin;

import com.teamaurora.frostburn_expansion.core.fabric.FrostburnExpansionFabric;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    @Inject(method = "render", at = @At("RETURN"))
    private void onRenderTitleScreen (CallbackInfo ci) {
        FrostburnExpansionFabric.joinLocalWorld("New World");
    }
}
