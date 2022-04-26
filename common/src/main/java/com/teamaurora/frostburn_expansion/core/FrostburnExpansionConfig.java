package com.teamaurora.frostburn_expansion.core;

import gg.moonflower.pollen.api.config.PollinatedConfigBuilder;
import gg.moonflower.pollen.api.config.PollinatedConfigBuilder.ConfigValue;

public class FrostburnExpansionConfig {
    public static class Client {
        public final ConfigValue<Boolean> enableAuroraParticles;
        public final ConfigValue<Boolean> brisksDanceToBrisksong;

        protected Client(PollinatedConfigBuilder builder) {
            builder.push("Auroras");
            {
                this.enableAuroraParticles = builder.comment("Whether experience particles should become rainbow during Aurora events.").define("Enable Aurora Particles", true);
            }
            builder.pop();
            builder.push("Brisks");
            {
                this.brisksDanceToBrisksong = builder.comment("Whether Brisks should play a dancing animation when in close proximity to a Jukebox playing Brisksong.").define("Brisks Dance to Brisksong", true);
            }
            builder.pop();
        }
    }
    public static class Common {
        public final ConfigValue<Float> auroraEventChance;
        public final ConfigValue<Double> auroraExpMultiplier;
        public final ConfigValue<Boolean> enableIceSpikeAdditions;
        public final ConfigValue<Boolean> enableDesertAdditions;
        public final ConfigValue<Boolean> enableFrostPlants;

        protected Common(PollinatedConfigBuilder builder) {
            builder.push("Auroras");
            {
                this.auroraExpMultiplier = builder.comment("Defines how much extra experience a player gets during Aurora events.").define("Aurora EXP Multiplier", 1.5D);
                this.auroraEventChance = builder.comment("The probability of an Aurora event occurring each night.").define("Aurora Chance", 0.05F);
            }
            builder.pop();
            builder.push("Worldgen");
            {
                this.enableIceSpikeAdditions = builder.comment("Whether the Ice Spikes biome should generate with additional FBEx features.").define("Enable Ice Spike Improvements", true);
                this.enableDesertAdditions = builder.comment("Whether the Desert should generate with additional FBEx features.").define("Enable Desert Improvements", true);
                this.enableFrostPlants = builder.comment("Whether frosty foliage (Frosty Grass & Roses) should generate in snowy biomes.").define("Enable Frost Plants", true);
            }
            builder.pop();
        }
    }
}
