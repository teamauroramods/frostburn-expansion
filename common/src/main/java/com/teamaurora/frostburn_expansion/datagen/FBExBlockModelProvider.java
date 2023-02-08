package com.teamaurora.frostburn_expansion.datagen;

import com.google.gson.JsonElement;
import com.teamaurora.frostburn_expansion.core.registry.FBExBlocks;
import gg.moonflower.pollen.api.datagen.provider.model.PollinatedBlockModelGenerator;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FBExBlockModelProvider extends PollinatedBlockModelGenerator {

    public FBExBlockModelProvider(Consumer<BlockStateGenerator> blockStateOutput, BiConsumer<ResourceLocation, Supplier<JsonElement>> modelOutput, Consumer<Item> skippedAutoModelsOutput) {
        super(blockStateOutput, modelOutput, skippedAutoModelsOutput);
    }

    @Override
    public void run() {
        this.family(FBExBlocks.GABBRO_BRICKS.get())
                .wall(FBExBlocks.GABBRO_BRICK_WALL.get())
                .slab(FBExBlocks.GABBRO_BRICK_SLAB.get())
                .stairs(FBExBlocks.GABBRO_BRICK_STAIRS.get());

        this.woodProvider(FBExBlocks.CHARRED_LOG.get()).logWithHorizontal(FBExBlocks.CHARRED_LOG.get()).wood(FBExBlocks.CHARRED_WOOD.get());
        this.woodProvider(FBExBlocks.STRIPPED_CHARRED_LOG.get()).logWithHorizontal(FBExBlocks.STRIPPED_CHARRED_LOG.get()).wood(FBExBlocks.STRIPPED_CHARRED_WOOD.get());
        this.family(FBExBlocks.CHARRED_PLANKS.get())
                .stairs(FBExBlocks.CHARRED_STAIRS.get())
                .slab(FBExBlocks.CHARRED_SLAB.get())
                //.sign(FBExBlocks.CHARRED_SIGN.getFirst().get(), FBExBlocks.CHARRED_SIGN.getSecond().get())
                .pressurePlate(FBExBlocks.CHARRED_PRESSURE_PLATE.get())
                .button(FBExBlocks.CHARRED_BUTTON.get())
                .fence(FBExBlocks.CHARRED_FENCE.get())
                .fenceGate(FBExBlocks.CHARRED_FENCE_GATE.get());
        this.createDoor(FBExBlocks.CHARRED_DOOR.get());
        this.createOrientableTrapdoor(FBExBlocks.CHARRED_TRAPDOOR.get());

        this.woodProvider(FBExBlocks.FROSTWOOD_LOG.get()).logWithHorizontal(FBExBlocks.FROSTWOOD_LOG.get()).wood(FBExBlocks.FROSTWOOD_WOOD.get());
        this.woodProvider(FBExBlocks.STRIPPED_FROSTWOOD_LOG.get()).logWithHorizontal(FBExBlocks.STRIPPED_FROSTWOOD_LOG.get()).wood(FBExBlocks.STRIPPED_FROSTWOOD_WOOD.get());
        this.family(FBExBlocks.FROSTWOOD_PLANKS.get())
                .stairs(FBExBlocks.FROSTWOOD_STAIRS.get())
                .slab(FBExBlocks.FROSTWOOD_SLAB.get())
                //.sign(FBExBlocks.FROSTWOOD_SIGN.getFirst().get(), FBExBlocks.FROSTWOOD_SIGN.getSecond().get())
                .pressurePlate(FBExBlocks.FROSTWOOD_PRESSURE_PLATE.get())
                .button(FBExBlocks.FROSTWOOD_BUTTON.get())
                .fence(FBExBlocks.FROSTWOOD_FENCE.get())
                .fenceGate(FBExBlocks.FROSTWOOD_FENCE_GATE.get());
        this.createDoor(FBExBlocks.FROSTWOOD_DOOR.get());
        this.createOrientableTrapdoor(FBExBlocks.FROSTWOOD_TRAPDOOR.get());

        this.createTrivialBlock(FBExBlocks.MOSSY_PERIDOTITE.get(), TexturedModel.CUBE_TOP_BOTTOM);
    }
}
