package com.teamaurora.frostburn_expansion.common.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.RecordItem;

import java.util.function.Supplier;

public class FBExRecordItem extends RecordItem {
    public FBExRecordItem(int i, Supplier<SoundEvent> soundEvent, Properties properties) {
        super(i, soundEvent.get(), properties);
    }
}
