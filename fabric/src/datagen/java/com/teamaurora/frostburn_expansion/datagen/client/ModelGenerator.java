package com.teamaurora.frostburn_expansion.datagen.client;

import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import com.teamaurora.frostburn_expansion.core.registry.FBExBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.core.Registry;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.Optional;

public final class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators gen) {

        createSlab(gen, FBExBlocks.GABBRO_BRICK_SLAB.get(), FBExBlocks.GABBRO_BRICKS.get());
        createStairs(gen, FBExBlocks.GABBRO_BRICK_STAIRS.get(), FBExBlocks.GABBRO_BRICKS.get());
        createWall(gen, FBExBlocks.GABBRO_BRICK_WALL.get(), FBExBlocks.GABBRO_BRICKS.get());
    }

    @Override
    public void generateItemModels(ItemModelGenerators gen) {
        gen.generateFlatItem(FBExBlocks.GABBRO_BRICK_SLAB.get().asItem(), create(FBExBlocks.GABBRO_BRICK_SLAB.get()));
        gen.generateFlatItem(FBExBlocks.GABBRO_BRICK_STAIRS.get().asItem(), create(FBExBlocks.GABBRO_BRICK_STAIRS.get()));
        //gen.generateFlatItem(FBExBlocks.GABBRO_BRICK_WALL.get().asItem(), create(FBExBlocks.GABBRO_BRICK_WALL.get()));
    }

    private void createSlab(BlockModelGenerators gen, Block block, Block block1) {
        ResourceLocation resourceLocation1 = ModelLocationUtils.getModelLocation(block1);
        TexturedModel texturedModel = TexturedModel.CUBE.get(block1);
        ResourceLocation resourceLocation2 = ModelTemplates.SLAB_BOTTOM.create(block, texturedModel.getMapping(), gen.modelOutput);
        ResourceLocation resourceLocation3 = ModelTemplates.SLAB_TOP.create(block, texturedModel.getMapping(), gen.modelOutput);
        gen.blockStateOutput.accept(BlockModelGenerators.createSlab(block, resourceLocation2, resourceLocation3, resourceLocation1));
    }

    private void createStairs(BlockModelGenerators gen, Block block, Block block1) {
        TexturedModel texturedModel = TexturedModel.CUBE.get(block1);
        ResourceLocation resourceLocation1 = ModelTemplates.STAIRS_INNER.create(block, texturedModel.getMapping(), gen.modelOutput);
        ResourceLocation resourceLocation2 = ModelTemplates.STAIRS_STRAIGHT.create(block, texturedModel.getMapping(), gen.modelOutput);
        ResourceLocation resourceLocation3 = ModelTemplates.STAIRS_OUTER.create(block, texturedModel.getMapping(), gen.modelOutput);
        gen.blockStateOutput.accept(BlockModelGenerators.createStairs(block, resourceLocation1, resourceLocation2, resourceLocation3));
    }

    private void createWall(BlockModelGenerators gen, Block block, Block block1) {
        TexturedModel texturedModel = TexturedModel.CUBE.get(block1);
        ResourceLocation resourceLocation1 = ModelTemplates.WALL_POST.create(block, texturedModel.getMapping(), gen.modelOutput);
        ResourceLocation resourceLocation2 = ModelTemplates.WALL_LOW_SIDE.create(block, texturedModel.getMapping(), gen.modelOutput);
        ResourceLocation resourceLocation3 = ModelTemplates.WALL_TALL_SIDE.create(block, texturedModel.getMapping(), gen.modelOutput);
        gen.blockStateOutput.accept(BlockModelGenerators.createWall(block, resourceLocation1, resourceLocation2, resourceLocation3));
        ResourceLocation resourceLocation4 = ModelTemplates.WALL_INVENTORY.create(block, texturedModel.getMapping(), gen.modelOutput);
        gen.delegateItemModel(block, resourceLocation4);
    }

    private static ModelTemplate create(Block block) {
        return new ModelTemplate(Optional.of(new ResourceLocation(FrostburnExpansion.MOD_ID, "block/" + Registry.BLOCK.getKey(block).getPath())), Optional.empty());
    }
}
