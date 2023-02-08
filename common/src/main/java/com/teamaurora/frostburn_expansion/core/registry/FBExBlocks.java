package com.teamaurora.frostburn_expansion.core.registry;

import com.teamaurora.frostburn_expansion.common.block.*;
import com.teamaurora.frostburn_expansion.common.item.ItemTabPlacements;
import com.teamaurora.frostburn_expansion.core.other.FBExSoundTypes;
import com.teamaurora.frostburn_expansion.core.registry.util.Woodset;
import gg.moonflower.pollen.api.registry.PollinatedBlockRegistry;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

/**
 * @author ebo2022
 * @author JustinPlayzz
 */

@SuppressWarnings("unused")
public class FBExBlocks {
    public static final PollinatedBlockRegistry BLOCKS = PollinatedRegistry.createBlock(FBExItems.ITEMS);

    private static final Woodset CHARRED = new Woodset(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_ORANGE);
    private static final Woodset FROST = new Woodset(MaterialColor.COLOR_BLUE, MaterialColor.COLOR_CYAN);

    /* Basalt Variants */

    public static final Supplier<Block> MOSSY_BASALT = BLOCKS.registerWithItem("mossy_basalt", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BASALT)), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> DIRTY_BASALT = BLOCKS.registerWithItem("dirty_basalt", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BASALT)), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> OVERGROWN_BASALT = BLOCKS.registerWithItem("overgrown_basalt", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BASALT)), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    /* Borealene */

    public static final Supplier<Block> BOREALENE = BLOCKS.registerWithItem("borealene", () -> new Block(Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_SLAB = BLOCKS.registerWithItem("borealene_slab", () -> new SlabBlock(Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_STAIRS = BLOCKS.registerWithItem("borealene_stairs", () -> new StairBlock(BOREALENE.get().defaultBlockState(), Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_WALL = BLOCKS.registerWithItem("borealene_wall", () -> new WallBlock(Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_BRICKS = BLOCKS.registerWithItem("borealene_bricks", () -> new Block(Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_BRICK_SLAB = BLOCKS.registerWithItem("borealene_brick_slab", () -> new SlabBlock(Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_BRICK_STAIRS = BLOCKS.registerWithItem("borealene_brick_stairs", () -> new StairBlock(BOREALENE.get().defaultBlockState(), Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_BRICK_WALL = BLOCKS.registerWithItem("borealene_brick_wall", () -> new WallBlock(Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> CRACKED_BOREALENE_BRICKS = BLOCKS.registerWithItem("cracked_borealene_bricks", () -> new Block(Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> CHISELED_BOREALENE_BRICKS = BLOCKS.registerWithItem("chiseled_borealene_bricks", () -> new Block(Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_PILLAR = BLOCKS.registerWithItem("borealene_pillar", () -> new RotatedPillarBlock(Properties.FBEX_STONE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_LAMP = BLOCKS.registerWithItem("borealene_lamp", () -> new Block(Properties.BOREALENE_LAMP), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    /* Stellarene & Lunarene */

    public static final Supplier<Block> STELLARENE = BLOCKS.registerWithItem("stellarene", () -> new TimedLightBlock(Properties.STELLARENE, ITimedLightBlockBase::stellareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> STELLARENE_SLAB = BLOCKS.registerWithItem("stellarene_slab", () -> new TimedLightSlabBlock(Properties.STELLARENE, ITimedLightBlockBase::stellareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> STELLARENE_STAIRS = BLOCKS.registerWithItem("stellarene_stairs", () -> new TimedLightStairBlock(STELLARENE.get().defaultBlockState(), Properties.STELLARENE, ITimedLightBlockBase::stellareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> STELLARENE_WALL = BLOCKS.registerWithItem("stellarene_wall", () -> new TimedLightWallBlock(Properties.STELLARENE, ITimedLightBlockBase::stellareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    public static final Supplier<Block> POLISHED_STELLARENE = BLOCKS.registerWithItem("polished_stellarene", () -> new TimedLightBlock(Properties.STELLARENE, ITimedLightBlockBase::stellareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> POLISHED_STELLARENE_SLAB = BLOCKS.registerWithItem("polished_stellarene_slab", () -> new TimedLightSlabBlock(Properties.STELLARENE, ITimedLightBlockBase::stellareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> POLISHED_STELLARENE_STAIRS = BLOCKS.registerWithItem("polished_stellarene_stairs", () -> new TimedLightStairBlock(POLISHED_STELLARENE.get().defaultBlockState(), Properties.STELLARENE, ITimedLightBlockBase::stellareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> POLISHED_STELLARENE_WALL = BLOCKS.registerWithItem("polished_stellarene_wall", () -> new TimedLightWallBlock(Properties.STELLARENE, ITimedLightBlockBase::stellareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    public static final Supplier<Block> LUNARENE = BLOCKS.registerWithItem("lunarene", () -> new TimedLightBlock(Properties.LUNARENE, ITimedLightBlockBase::lunareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> LUNARENE_SLAB = BLOCKS.registerWithItem("lunarene_slab", () -> new TimedLightSlabBlock(Properties.LUNARENE, ITimedLightBlockBase::lunareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> LUNARENE_STAIRS = BLOCKS.registerWithItem("lunarene_stairs", () -> new TimedLightStairBlock(LUNARENE.get().defaultBlockState(), Properties.LUNARENE, ITimedLightBlockBase::lunareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> LUNARENE_WALL = BLOCKS.registerWithItem("lunarene_wall", () -> new TimedLightWallBlock(Properties.LUNARENE, ITimedLightBlockBase::lunareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    public static final Supplier<Block> POLISHED_LUNARENE = BLOCKS.registerWithItem("polished_lunarene", () -> new TimedLightBlock(Properties.LUNARENE, ITimedLightBlockBase::lunareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> POLISHED_LUNARENE_SLAB = BLOCKS.registerWithItem("polished_lunarene_slab", () -> new TimedLightSlabBlock(Properties.LUNARENE, ITimedLightBlockBase::lunareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> POLISHED_LUNARENE_STAIRS = BLOCKS.registerWithItem("polished_lunarene_stairs", () -> new TimedLightStairBlock(POLISHED_LUNARENE.get().defaultBlockState(), Properties.LUNARENE, ITimedLightBlockBase::lunareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> POLISHED_LUNARENE_WALL = BLOCKS.registerWithItem("polished_lunarene_wall", () -> new TimedLightWallBlock(Properties.LUNARENE, ITimedLightBlockBase::lunareneLightProperties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    /* Scoria */

    public static final Supplier<Block> SCORIA = BLOCKS.registerWithItem("scoria", () -> new Block(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SCORIA_SLAB = BLOCKS.registerWithItem("scoria_slab", () -> new SlabBlock(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SCORIA_STAIRS = BLOCKS.registerWithItem("scoria_stairs", () -> new StairBlock(FBExBlocks.SCORIA.get().defaultBlockState(), Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SCORIA_WALL = BLOCKS.registerWithItem("scoria_wall", () -> new WallBlock(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    public static final Supplier<Block> POLISHED_SCORIA = BLOCKS.registerWithItem("polished_scoria", () -> new Block(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> POLISHED_SCORIA_SLAB = BLOCKS.registerWithItem("polished_scoria_slab", () -> new SlabBlock(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> POLISHED_SCORIA_STAIRS = BLOCKS.registerWithItem("polished_scoria_stairs", () -> new StairBlock(FBExBlocks.POLISHED_SCORIA.get().defaultBlockState(), Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> POLISHED_SCORIA_WALL = BLOCKS.registerWithItem("polished_scoria_wall", () -> new WallBlock(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    public static final Supplier<Block> SCORIA_BRICKS = BLOCKS.registerWithItem("scoria_bricks", () -> new Block(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SCORIA_BRICK_SLAB = BLOCKS.registerWithItem("scoria_brick_slab", () -> new SlabBlock(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SCORIA_BRICK_STAIRS = BLOCKS.registerWithItem("scoria_brick_stairs", () -> new StairBlock(FBExBlocks.SCORIA_BRICKS.get().defaultBlockState(), Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SCORIA_BRICK_WALL = BLOCKS.registerWithItem("scoria_brick_wall", () -> new WallBlock(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    public static final Supplier<Block> SCORIA_TILES = BLOCKS.registerWithItem("scoria_tiles", () -> new Block(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SCORIA_TILE_SLAB = BLOCKS.registerWithItem("scoria_tile_slab", () -> new SlabBlock(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SCORIA_TILE_STAIRS = BLOCKS.registerWithItem("scoria_tile_stairs", () -> new StairBlock(SCORIA_TILES.get().defaultBlockState(), Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> SCORIA_TILE_WALL = BLOCKS.registerWithItem("scoria_tile_wall", () -> new WallBlock(Properties.SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    public static final Supplier<Block> IGNEOUS_SCORIA = BLOCKS.registerWithItem("igneous_scoria", () -> new MagmaBlock(Properties.IGNEOUS_SCORIA), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    /* Gabbro */

    public static final Supplier<Block> GABBRO = BLOCKS.registerWithItem("gabbro", () -> new Block(Properties.GABBRO), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> GABBRO_SLAB = BLOCKS.registerWithItem("gabbro_slab", () -> new SlabBlock(Properties.GABBRO), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> GABBRO_STAIRS = BLOCKS.registerWithItem("gabbro_stairs", () -> new StairBlock(GABBRO.get().defaultBlockState(), Properties.GABBRO), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> GABBRO_WALL = BLOCKS.registerWithItem("gabbro_wall", () -> new WallBlock(Properties.GABBRO), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    public static final Supplier<Block> GABBRO_BRICKS = BLOCKS.registerWithItem("gabbro_bricks", () -> new Block(Properties.GABBRO), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> GABBRO_BRICK_SLAB = BLOCKS.registerWithItem("gabbro_brick_slab", () -> new SlabBlock(Properties.GABBRO), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> GABBRO_BRICK_STAIRS = BLOCKS.registerWithItem("gabbro_brick_stairs", () -> new StairBlock(GABBRO_BRICKS.get().defaultBlockState(), Properties.GABBRO), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> GABBRO_BRICK_WALL = BLOCKS.registerWithItem("gabbro_brick_wall", () -> new WallBlock(Properties.GABBRO), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    /* Concept Blocks */

    public static final Supplier<Block> STRIPPED_CHARRED_LOG = BLOCKS.registerWithItem("stripped_charred_log", CHARRED.strippedLog(), ItemTabPlacements.STRIPPED_LOG);
    public static final Supplier<Block> STRIPPED_CHARRED_WOOD = BLOCKS.registerWithItem("stripped_charred_wood", CHARRED.strippedWood(), ItemTabPlacements.STRIPPED_WOOD);
    public static final Supplier<Block> CHARRED_LOG = BLOCKS.registerWithItem("charred_log", CHARRED.log(), ItemTabPlacements.LOG);
    public static final Supplier<Block> CHARRED_WOOD = BLOCKS.registerWithItem("charred_wood", CHARRED.wood(), ItemTabPlacements.WOOD);

    public static final Supplier<Block> CHARRED_PLANKS = BLOCKS.registerWithItem("charred_planks", CHARRED.planks(), ItemTabPlacements.PLANKS);
    public static final Supplier<Block> CHARRED_SLAB = BLOCKS.registerWithItem("charred_slab", CHARRED.slab(), ItemTabPlacements.SLAB);
    public static final Supplier<Block> CHARRED_STAIRS = BLOCKS.registerWithItem("charred_stairs", CHARRED.stairs(CHARRED_PLANKS), ItemTabPlacements.STAIRS);
    public static final Supplier<Block> CHARRED_PRESSURE_PLATE = BLOCKS.registerWithItem("charred_pressure_plate", CHARRED.pressurePlate(), ItemTabPlacements.WOOD_PRESSURE_PLATE);
    public static final Supplier<Block> CHARRED_BUTTON = BLOCKS.registerWithItem("charred_button", CHARRED.button(), ItemTabPlacements.WOOD_BUTTON);
    public static final Supplier<Block> CHARRED_FENCE = BLOCKS.registerWithItem("charred_fence", CHARRED.fence(), ItemTabPlacements.WOOD_FENCE);
    public static final Supplier<Block> CHARRED_FENCE_GATE = BLOCKS.registerWithItem("charred_fence_gate", CHARRED.fenceGate(), ItemTabPlacements.WOOD_FENCE_GATE);
    public static final Supplier<Block> CHARRED_DOOR = BLOCKS.registerWithItem("charred_door", CHARRED.door(), ItemTabPlacements.DOOR);
    public static final Supplier<Block> CHARRED_TRAPDOOR = BLOCKS.registerWithItem("charred_trapdoor", CHARRED.trapdoor(), ItemTabPlacements.TRAPDOOR);
    //public static final Pair<Supplier<PollinatedStandingSignBlock>, Supplier<PollinatedWallSignBlock>> CHARRED_SIGN = BLOCKS.registerSign("charred", Material.WOOD, MaterialColor.COLOR_GREEN);

    public static final Supplier<Block> STRIPPED_FROSTWOOD_LOG = BLOCKS.registerWithItem("stripped_frostwood_log", FROST.strippedLog(), ItemTabPlacements.STRIPPED_LOG);
    public static final Supplier<Block> STRIPPED_FROSTWOOD_WOOD = BLOCKS.registerWithItem("stripped_frostwood_wood", FROST.strippedWood(), ItemTabPlacements.STRIPPED_WOOD);
    public static final Supplier<Block> FROSTWOOD_LOG = BLOCKS.registerWithItem("frostwood_log", FROST.log(), ItemTabPlacements.LOG);
    public static final Supplier<Block> FROSTWOOD_WOOD = BLOCKS.registerWithItem("frostwood_wood", FROST.wood(), ItemTabPlacements.WOOD);

    public static final Supplier<Block> FROSTWOOD_PLANKS = BLOCKS.registerWithItem("frostwood_planks", FROST.planks(), ItemTabPlacements.PLANKS);
    public static final Supplier<Block> FROSTWOOD_SLAB = BLOCKS.registerWithItem("frostwood_slab", FROST.slab(), ItemTabPlacements.SLAB);
    public static final Supplier<Block> FROSTWOOD_STAIRS = BLOCKS.registerWithItem("frostwood_stairs", FROST.stairs(CHARRED_PLANKS), ItemTabPlacements.STAIRS);
    public static final Supplier<Block> FROSTWOOD_PRESSURE_PLATE = BLOCKS.registerWithItem("frostwood_pressure_plate", FROST.pressurePlate(), ItemTabPlacements.WOOD_PRESSURE_PLATE);
    public static final Supplier<Block> FROSTWOOD_BUTTON = BLOCKS.registerWithItem("frostwood_button", FROST.button(), ItemTabPlacements.WOOD_BUTTON);
    public static final Supplier<Block> FROSTWOOD_FENCE = BLOCKS.registerWithItem("frostwood_fence", FROST.fence(), ItemTabPlacements.WOOD_FENCE);
    public static final Supplier<Block> FROSTWOOD_FENCE_GATE = BLOCKS.registerWithItem("frostwood_fence_gate", FROST.fenceGate(), ItemTabPlacements.WOOD_FENCE_GATE);
    public static final Supplier<Block> FROSTWOOD_DOOR = BLOCKS.registerWithItem("frostwood_door", FROST.door(), ItemTabPlacements.DOOR);
    public static final Supplier<Block> FROSTWOOD_TRAPDOOR = BLOCKS.registerWithItem("frostwood_trapdoor", FROST.trapdoor(), ItemTabPlacements.TRAPDOOR);
    //public static final Pair<Supplier<PollinatedStandingSignBlock>, Supplier<PollinatedWallSignBlock>> FROSTWOOD_SIGN = BLOCKS.registerSign("frostwood", Material.WOOD, MaterialColor.COLOR_GREEN);

    public static final Supplier<Block> MOSSY_PERIDOTITE = BLOCKS.registerWithItem("mossy_peridotite", () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    public static final class Properties {
        public static final BlockBehaviour.Properties FBEX_STONE = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.5f, 6.0f).sound(FBExSoundTypes.FBEX_STONE);
        public static final BlockBehaviour.Properties BOREALENE_LAMP = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.5f, 6.0f).sound(FBExSoundTypes.FBEX_STONE).lightLevel(s -> 14);
        public static final BlockBehaviour.Properties SCORIA = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.BASALT).strength(1.75f, 5.0f).requiresCorrectToolForDrops();
        public static final BlockBehaviour.Properties IGNEOUS_SCORIA = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).sound(SoundType.BASALT).strength(1.25f, 5.0f).requiresCorrectToolForDrops().lightLevel(s -> 3).emissiveRendering((bs, br, bp) -> true);
        public static final BlockBehaviour.Properties STELLARENE = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.5f, 6.0f).color(MaterialColor.COLOR_YELLOW).sound(SoundType.GILDED_BLACKSTONE).lightLevel(ITimedLightBlockBase::lightValue).randomTicks();
        public static final BlockBehaviour.Properties LUNARENE = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.5f, 6.0f).color(MaterialColor.COLOR_LIGHT_BLUE).sound(SoundType.AMETHYST_CLUSTER).lightLevel(ITimedLightBlockBase::lightValue).randomTicks();
        public static final BlockBehaviour.Properties GABBRO = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(1.25f);

    }
}