package com.teamaurora.frostburn_expansion.core.registry;

import com.teamaurora.frostburn_expansion.common.block.*;
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

    /* Stellarene & Lunarene */

    public static final Supplier<Block> STELLARENE = BLOCKS.registerWithItem("stellarene", () -> new TimedLightBlock(Properties.STELLARENE, ITimedLightBlockBase::stellareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> STELLARENE_SLAB = BLOCKS.registerWithItem("stellarene_slab", () -> new TimedLightSlabBlock(Properties.STELLARENE, ITimedLightBlockBase::stellareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> STELLARENE_STAIRS = BLOCKS.registerWithItem("stellarene_stairs", () -> new TimedLightStairBlock(FBExBlocks.STELLARENE.get().defaultBlockState(), Properties.STELLARENE, ITimedLightBlockBase::stellareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> STELLARENE_WALL = BLOCKS.registerWithItem("stellarene_wall", () -> new TimedLightWallBlock(Properties.STELLARENE, ITimedLightBlockBase::stellareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    public static final Supplier<Block> POLISHED_STELLARENE = BLOCKS.registerWithItem("polished_stellarene", () -> new TimedLightBlock(Properties.STELLARENE, ITimedLightBlockBase::stellareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> POLISHED_STELLARENE_SLAB = BLOCKS.registerWithItem("polished_stellarene_slab", () -> new TimedLightSlabBlock(Properties.STELLARENE, ITimedLightBlockBase::stellareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> POLISHED_STELLARENE_STAIRS = BLOCKS.registerWithItem("polished_stellarene_stairs", () -> new TimedLightStairBlock(FBExBlocks.POLISHED_STELLARENE.get().defaultBlockState(), Properties.STELLARENE, ITimedLightBlockBase::stellareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> POLISHED_STELLARENE_WALL = BLOCKS.registerWithItem("polished_stellarene_wall", () -> new TimedLightWallBlock(Properties.STELLARENE, ITimedLightBlockBase::stellareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    public static final Supplier<Block> LUNARENE = BLOCKS.registerWithItem("lunarene", () -> new TimedLightBlock(Properties.LUNARENE, ITimedLightBlockBase::lunareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> LUNARENE_SLAB = BLOCKS.registerWithItem("lunarene_slab", () -> new TimedLightSlabBlock(Properties.LUNARENE, ITimedLightBlockBase::lunareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> LUNARENE_STAIRS = BLOCKS.registerWithItem("lunarene_stairs", () -> new TimedLightStairBlock(FBExBlocks.LUNARENE.get().defaultBlockState(), Properties.LUNARENE, ITimedLightBlockBase::lunareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> LUNARENE_WALL = BLOCKS.registerWithItem("lunarene_wall", () -> new TimedLightWallBlock(Properties.LUNARENE, ITimedLightBlockBase::lunareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
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
        public static final BlockBehaviour.Properties FBEX_STONE = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.5f, 6.0f).sound(FBExSoundTypes.FBEX_STONE);
        public static final BlockBehaviour.Properties BOREALENE_LAMP = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.5f, 6.0f).sound(FBExSoundTypes.FBEX_STONE).lightLevel(s -> 14);
        public static final BlockBehaviour.Properties SCORIA = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.BASALT).strength(1.25f, 5.0f).requiresCorrectToolForDrops();
        public static final BlockBehaviour.Properties IGNEOUS_SCORIA = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).sound(SoundType.BASALT).strength(1.25f, 5.0f).requiresCorrectToolForDrops().lightLevel(s -> 3).emissiveRendering((bs, br, bp) -> true);
        public static final BlockBehaviour.Properties STELLARENE = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.5f, 6.0f).color(MaterialColor.COLOR_YELLOW).sound(FBExSoundTypes.FBEX_STONE).lightLevel(ITimedLightBlockBase::lightValue).randomTicks();
        public static final BlockBehaviour.Properties LUNARENE = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.5f, 6.0f).color(MaterialColor.COLOR_LIGHT_BLUE).sound(FBExSoundTypes.FBEX_STONE).lightLevel(ITimedLightBlockBase::lightValue).randomTicks();

    }
}