package com.teamaurora.frostburn_expansion.datagen.common.loot;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public final class BlockLootGenerator extends FabricBlockLootTableProvider {
    public BlockLootGenerator(FabricDataGenerator gen) {
        super(gen);
    }

    @Override
    protected void generateBlockLootTables() {
//        this.dropSelf(Blocks.BlockName.get());
    }
}
