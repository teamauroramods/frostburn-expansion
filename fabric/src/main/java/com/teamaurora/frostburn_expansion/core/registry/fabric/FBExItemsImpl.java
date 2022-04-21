package com.teamaurora.frostburn_expansion.core.registry.fabric;

import com.teamaurora.frostburn_expansion.common.item.FBExRecordItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class FBExItemsImpl {
    public static Supplier<Item> createRecord(int comparatorOutput, Supplier<SoundEvent> soundEventSupplier, Item.Properties properties) {
        return () -> new FBExRecordItem(comparatorOutput, soundEventSupplier.get(), properties);
    }
}
