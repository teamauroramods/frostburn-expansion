package com.teamaurora.frostburn_expansion.core.registry;

import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;

public class FBExItems {
    public static final PollinatedRegistry<Item> ITEMS = PollinatedRegistry.create(Registry.ITEM, FrostburnExpansion.MOD_ID);
}
