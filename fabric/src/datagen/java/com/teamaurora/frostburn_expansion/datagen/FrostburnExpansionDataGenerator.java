package com.teamaurora.frostburn_expansion.datagen;

import com.teamaurora.frostburn_expansion.datagen.client.LanguageGenerator;
import com.teamaurora.frostburn_expansion.datagen.client.ModelGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class FrostburnExpansionDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator gen) {
        gen.addProvider(ModelGenerator::new);
        //gen.addProvider(LanguageGenerator::new);
    }
}
