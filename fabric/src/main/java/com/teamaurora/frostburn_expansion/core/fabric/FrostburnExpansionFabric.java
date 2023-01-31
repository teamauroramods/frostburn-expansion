package com.teamaurora.frostburn_expansion.core.fabric;

import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.storage.LevelStorageException;
import net.minecraft.world.level.storage.LevelSummary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FrostburnExpansionFabric implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger(FrostburnExpansion.MOD_ID);

    @Override
    public void onInitialize() {
        FrostburnExpansion.PLATFORM.setup();

        LOGGER.info("Frosting the screen");
    }

    public static void joinLocalWorld(String worldName) {
        Minecraft client = Minecraft.getInstance();

        try {
            for (LevelSummary level : client.getLevelSource().getLevelList()) {
                if (level.getLevelId().equalsIgnoreCase(worldName)) {
                    client.loadLevel(level.getLevelId());
                    return;
                }
            }

            LOGGER.warn("couldn't find local world {}", worldName);
        } catch (LevelStorageException e) {
            LOGGER.error("couldn't load local world {}", worldName, e);
        }
    }
}