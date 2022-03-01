package com.teamaurora.frostburn_expansion.core.fabric;

import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import net.fabricmc.api.ModInitializer;

public class FrostburnExpansionFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        FrostburnExpansion.PLATFORM.setup();
    }
}
