package com.teamaurora.frostburn_expansion.core.registry;

import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import dev.architectury.injectables.annotations.ExpectPlatform;
import gg.moonflower.pollen.api.item.SpawnEggItemBase;
import gg.moonflower.pollen.api.platform.Platform;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import java.util.function.Supplier;

public class FBExItems {
    public static final PollinatedRegistry<Item> ITEMS = PollinatedRegistry.create(Registry.ITEM, FrostburnExpansion.MOD_ID);

    private static final Item.Properties MUSIC_DISC = new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_MISC).rarity(Rarity.EPIC);

    public static final Supplier<Item> BRISK_SPAWN_EGG = ITEMS.register("brisk_spawn_egg", () -> new SpawnEggItemBase<>(FBExEntities.BRISK, 0x84D6DB, 0x359289, true, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final Supplier<Item> MUSIC_DISC_BRISKSONG = ITEMS.register("music_disc_brisksong", createRecord(0, FBExSounds.MUSIC_DISC_BRISKSONG, MUSIC_DISC));

    @ExpectPlatform
    public static Supplier<Item> createRecord(int comparatorOutput, Supplier<SoundEvent> soundEventSupplier, Item.Properties properties) {
        return Platform.error();
    }
}
