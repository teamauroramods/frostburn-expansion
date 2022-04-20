package com.teamaurora.frostburn_expansion.core.registry;

import com.teamaurora.frostburn_expansion.common.block.ITimedLightBlockBase;
import com.teamaurora.frostburn_expansion.common.block.TimedLightBlock;
import com.teamaurora.frostburn_expansion.core.other.FBExSoundTypes;
import gg.moonflower.pollen.api.datagen.provider.model.PollinatedBlockModelGenerator;
import gg.moonflower.pollen.api.registry.PollinatedBlockRegistry;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.LootTables;

import java.util.function.Supplier;

/**
 * @author ebo2022
 */

@SuppressWarnings("unused")
public class FBExBlocks {
    public static final PollinatedBlockRegistry BLOCKS = PollinatedRegistry.createBlock(FBExItems.ITEMS);


    /* Basalt Variants */

    public static final Supplier<Block> MOSSY_BASALT = BLOCKS.registerWithItem("mossy_basalt", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BASALT)), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> DIRTY_BASALT = BLOCKS.registerWithItem("dirty_basalt", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BASALT)), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> OVERGROWN_BASALT = BLOCKS.registerWithItem("overgrown_basalt", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BASALT)), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));


    /* Borealene */

    public static final Supplier<Block> BOREALENE = BLOCKS.registerWithItem("borealene", () -> new Block(Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_SLAB = BLOCKS.registerWithItem("borealene_slab", () -> new SlabBlock(Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_STAIRS = BLOCKS.registerWithItem("borealene_stairs", () -> new StairBlock(FBExBlocks.BOREALENE.get().defaultBlockState(), Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_WALL = BLOCKS.registerWithItem("borealene_wall", () -> new WallBlock(Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_BRICKS = BLOCKS.registerWithItem("borealene_bricks", () -> new Block(Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_BRICK_SLAB = BLOCKS.registerWithItem("borealene_brick_slab", () -> new SlabBlock(Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_BRICK_STAIRS = BLOCKS.registerWithItem("borealene_brick_stairs", () -> new StairBlock(FBExBlocks.BOREALENE.get().defaultBlockState(), Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_BRICK_WALL = BLOCKS.registerWithItem("borealene_brick_wall", () -> new WallBlock(Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> CRACKED_BOREALENE_BRICKS = BLOCKS.registerWithItem("cracked_borealene_bricks", () -> new Block(Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> CHISELED_BOREALENE_BRICKS = BLOCKS.registerWithItem("chiseled_borealene_bricks", () -> new Block(Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_PILLAR = BLOCKS.registerWithItem("borealene_pillar", () -> new RotatedPillarBlock(Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_LAMP = BLOCKS.registerWithItem("borealene_lamp", () -> new Block(Properties.BOREALENE_LAMP), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    /* Solarene & Lunarene */

    public static final Supplier<Block> SOLARENE = BLOCKS.registerWithItem("solarene", () -> new TimedLightBlock(Properties.TIME_DEPENDENT_LIGHT_PROPERTIES, ITimedLightBlockBase::solareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SOLARENE_SLAB = BLOCKS.registerWithItem("solarene_slab", () -> new SlabBlock(Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SOLARENE_STAIRS = BLOCKS.registerWithItem("solarene_stairs", () -> new StairBlock(FBExBlocks.BOREALENE.get().defaultBlockState(), Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SOLARENE_WALL = BLOCKS.registerWithItem("solarene_wall", () -> new WallBlock(Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    /* Scoria */

    public static final Supplier<Block> SCORIA = BLOCKS.registerWithItem("scoria", () -> new Block(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SCORIA_SLAB = BLOCKS.registerWithItem("scoria_slab", () -> new SlabBlock(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SCORIA_STAIRS = BLOCKS.registerWithItem("scoria_stairs", () -> new StairBlock(FBExBlocks.SCORIA.get().defaultBlockState(), Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SCORIA_WALL = BLOCKS.registerWithItem("scoria_wall", () -> new WallBlock(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    public static final Supplier<Block> POLISHED_SCORIA = BLOCKS.registerWithItem("polished_scoria", () -> new Block(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> POLISHED_SCORIA_SLAB = BLOCKS.registerWithItem("polished_scoria_slab", () -> new SlabBlock(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> POLISHED_SCORIA_STAIRS = BLOCKS.registerWithItem("polished_scoria_stairs", () -> new StairBlock(FBExBlocks.SCORIA.get().defaultBlockState(), Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> POLISHED_SCORIA_WALL = BLOCKS.registerWithItem("polished_scoria_wall", () -> new WallBlock(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    public static final Supplier<Block> SCORIA_BRICKS = BLOCKS.registerWithItem("scoria_bricks", () -> new Block(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SCORIA_BRICK_SLAB = BLOCKS.registerWithItem("scoria_brick_slab", () -> new SlabBlock(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SCORIA_BRICK_STAIRS = BLOCKS.registerWithItem("scoria_brick_stairs", () -> new StairBlock(FBExBlocks.SCORIA_BRICKS.get().defaultBlockState(), Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SCORIA_BRICK_WALL = BLOCKS.registerWithItem("scoria_brick_wall", () -> new WallBlock(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    public static final Supplier<Block> SCORIA_TILES = BLOCKS.registerWithItem("scoria_tiles", () -> new Block(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SCORIA_TILE_SLAB = BLOCKS.registerWithItem("scoria_tile_slab", () -> new SlabBlock(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SCORIA_TILE_STAIRS = BLOCKS.registerWithItem("scoria_tile_stairs", () -> new StairBlock(FBExBlocks.SCORIA_BRICKS.get().defaultBlockState(), Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SCORIA_TILE_WALL = BLOCKS.registerWithItem("scoria_tile_wall", () -> new WallBlock(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    public static final Supplier<Block> IGNEOUS_SCORIA = BLOCKS.registerWithItem("igneous_scoria", () -> new MagmaBlock(Properties.IGNEOUS_SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));


    public static final class Properties {
        public static final BlockBehaviour.Properties FBEX_STONE = BlockBehaviour.Properties.copy(Blocks.STONE).sound(FBExSoundTypes.FBEX_STONE);
        public static final BlockBehaviour.Properties BOREALENE_LAMP = BlockBehaviour.Properties.copy(Blocks.STONE).sound(FBExSoundTypes.FBEX_STONE).lightLevel(s -> 14);
        public static final BlockBehaviour.Properties SCORIA = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.BASALT).strength(1.25f, 5.0f).requiresCorrectToolForDrops();
        public static final BlockBehaviour.Properties IGNEOUS_SCORIA = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).sound(SoundType.BASALT).strength(1.25f, 5.0f).requiresCorrectToolForDrops().lightLevel(s -> 3).emissiveRendering((bs, br, bp) -> true);
        public static final BlockBehaviour.Properties TIME_DEPENDENT_LIGHT_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.STONE).sound(FBExSoundTypes.FBEX_STONE).lightLevel(ITimedLightBlockBase::lightValue).randomTicks();
    }
}