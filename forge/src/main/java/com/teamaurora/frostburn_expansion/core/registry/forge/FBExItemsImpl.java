package com.teamaurora.frostburn_expansion.core.registry.forge;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;

import java.util.function.Supplier;

public class FBExItemsImpl {
    public static Supplier<Item> createRecord(int comparatorOutput, Supplier<SoundEvent> soundEventSupplier, Item.Properties properties) {
        return () -> new RecordItem(comparatorOutput, soundEventSupplier, properties);
    }
}
