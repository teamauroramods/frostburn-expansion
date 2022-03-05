package com.teamaurora.frostburn_expansion.core.registry;

import com.teamaurora.frostburn_expansion.common.item.FollowItemLike;
import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import com.teamaurora.frostburn_expansion.core.registry.FBExItems;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import gg.moonflower.pollen.pinwheel.api.client.blockdata.BlockData;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class FBExBlocks {
    public static final PollinatedRegistry<Block> BLOCKS = PollinatedRegistry.create(Registry.BLOCK, FrostburnExpansion.MOD_ID);

    public static final Supplier<Block> MOSSY_BASALT = registerBlock("mossy_basalt", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BASALT)), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> DIRTY_BASALT = registerBlock("dirty_basalt", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BASALT)), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> OVERGROWN_BASALT = registerBlock("overgrown_basalt", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BASALT)), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    public static final Supplier<Block> BOREALENE = registerBlock("borealene", () -> new Block(Properties.BOREALENE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_SLAB = registerBlock("borealene_slab", () -> new SlabBlock(Properties.BOREALENE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_STAIRS = registerBlock("borealene_stairs", () -> new StairBlock(FBExBlocks.BOREALENE.get().defaultBlockState(), Properties.BOREALENE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_WALL = registerBlock("borealene_wall", () -> new WallBlock(Properties.BOREALENE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_BRICKS = registerBlock("borealene_bricks", () -> new Block(Properties.BOREALENE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_BRICK_SLAB = registerBlock("borealene_brick_slab", () -> new SlabBlock(Properties.BOREALENE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_BRICK_STAIRS = registerBlock("borealene_brick_stairs", () -> new StairBlock(FBExBlocks.BOREALENE.get().defaultBlockState(), Properties.BOREALENE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_BRICK_WALL = registerBlock("borealene_brick_wall", () -> new WallBlock(Properties.BOREALENE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> CRACKED_BOREALENE_BRICKS = registerBlock("cracked_borealene_bricks", () -> new Block(Properties.BOREALENE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> CHISELED_BOREALENE_BRICKS = registerBlock("chiseled_borealene_bricks", () -> new Block(Properties.BOREALENE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_PILLAR = registerBlock("borealene_pillar", () -> new RotatedPillarBlock(Properties.BOREALENE), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> BOREALENE_LAMP = registerBlock("borealene_lamp", () -> new Block(Properties.BOREALENE_LAMP), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    private static Supplier<Block> registerBlock(String id, Supplier<Block> block, Item.Properties properties) {
        Supplier<Block> register = BLOCKS.register(id, block);
        FBExItems.ITEMS.register(id, () -> new BlockItem(register.get(), properties));
        return register;
    }

    public static final class Properties {
        public static final BlockBehaviour.Properties BOREALENE = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_MAGENTA).strength(1.5f, 6.0f).requiresCorrectToolForDrops();
        public static final BlockBehaviour.Properties BOREALENE_LAMP = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_MAGENTA).strength(1.5f, 6.0f).requiresCorrectToolForDrops().lightLevel(s -> 14);
    }
}