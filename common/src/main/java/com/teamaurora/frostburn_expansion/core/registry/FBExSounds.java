package com.teamaurora.frostburn_expansion.core.registry;

import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class FBExSounds {
    public static final PollinatedRegistry<SoundEvent> SOUNDS = PollinatedRegistry.create(Registry.SOUND_EVENT, FrostburnExpansion.MOD_ID);

    public static final Supplier<SoundEvent> MUSIC_DISC_BRISKSONG = registerSound("music_disc.brisksong");

    private static Supplier<SoundEvent> registerSound(String id) {
        return SOUNDS.register(id, () -> new SoundEvent(FrostburnExpansion.generateResourceLocation(id)));
    }
}
