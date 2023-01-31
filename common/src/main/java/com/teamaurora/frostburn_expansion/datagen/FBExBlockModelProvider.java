package com.teamaurora.frostburn_expansion.datagen;

import com.google.gson.JsonElement;
import com.teamaurora.frostburn_expansion.core.registry.FBExBlocks;
import gg.moonflower.pollen.api.datagen.provider.model.PollinatedBlockModelGenerator;
import net.minecraft.core.Registry;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FBExBlockModelProvider extends PollinatedBlockModelGenerator {

    public FBExBlockModelProvider(Consumer<BlockStateGenerator> blockStateOutput, BiConsumer<ResourceLocation, Supplier<JsonElement>> modelOutput, Consumer<Item> skippedAutoModelsOutput) {
        super(blockStateOutput, modelOutput, skippedAutoModelsOutput);
    }

    @Override
    public void run() {
        this.family(FBExBlocks.SCORIA_BRICKS.get())
                .wall(FBExBlocks.SCORIA_BRICK_WALL.get());
//        this.family(FBExBlocks.SCORIA_BRICKS.get())
//                .wall(FBExBlocks.SCORIA_BRICK_WALL.get());
//        this.family(FBExBlocks.SCORIA_BRICKS.get())
//                .wall(FBExBlocks.SCORIA_BRICK_WALL.get());
//        this.family(FBExBlocks.SCORIA_BRICKS.get())
//                .wall(FBExBlocks.SCORIA_BRICK_WALL.get());
//        this.family(FBExBlocks.SCORIA_BRICKS.get())
//                .wall(FBExBlocks.SCORIA_BRICK_WALL.get());
//        this.family(FBExBlocks.SCORIA_BRICKS.get())
//                .wall(FBExBlocks.SCORIA_BRICK_WALL.get());
    }
}
