package com.teamaurora.frostburn_expansion.core.fabric;

import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class FrostburnExpansionFabricDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        FrostburnExpansion.PLATFORM.dataSetup(dataGenerator);
    }
}
