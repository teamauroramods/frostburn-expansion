package com.teamaurora.frostburn_expansion.core.registry;

import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import gg.moonflower.pollen.api.item.SpawnEggItemBase;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class FBExItems {
    public static final PollinatedRegistry<Item> ITEMS = PollinatedRegistry.create(Registry.ITEM, FrostburnExpansion.MOD_ID);

    public static final Supplier<Item> BRISK_SPAWN_EGG = ITEMS.register("brisk_spawn_egg", () -> new SpawnEggItemBase<>(FBExEntities.BRISK, 54685468, 340958348, true, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}
