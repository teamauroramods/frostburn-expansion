package com.teamaurora.frostburn_expansion.core.forge;

import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import net.minecraftforge.fml.common.Mod;

@Mod(FrostburnExpansion.MOD_ID)
public class FrostburnExpansionForge {
    public FrostburnExpansionForge() {
        FrostburnExpansion.PLATFORM.setup();
    }
}
