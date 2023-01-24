package com.teamaurora.frostburn_expansion.datagen.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public final class LanguageGenerator implements DataProvider {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private final Map<String, String> data = new TreeMap<>();
    private final DataGenerator generator;

    public LanguageGenerator(DataGenerator generator) {
        this.generator = generator;
    }

    @ParametersAreNonnullByDefault
    @Override
    public void run(HashCache cache) throws IOException {
        this.addTranslations();
        Path path = this.generator.getOutputFolder().resolve("assets/assembly/lang/en_us.json");
        DataProvider.save(GSON, cache, GSON.toJsonTree(this.data), path);
    }

    @NotNull
    @Override
    public String getName() {
        return "Language: en_us";
    }

    private void addTranslations() {
        // Blocks
//        this.block(AssemblyBlocks.WAX_BLOCK_SLAB.get(), "Wax Block Slab");
//        this.block(AssemblyBlocks.WAX_BLOCK_STAIRS.get(), "Wax Block Stairs");
//        this.block(AssemblyBlocks.POLISHED_DIRT_SLAB.get(), "Polished Dirt Slab");
//        this.block(AssemblyBlocks.POLISHED_DIRT_STAIRS.get(), "Polished Dirt Stairs");
    }

    private void block(Block entry, String name) {
        this.add(entry.getDescriptionId(), name);
    }

    private void add(String key, String value) {
        if (this.data.put(key, value) != null) throw new IllegalStateException("Duplicate translation key " + key);
    }
}