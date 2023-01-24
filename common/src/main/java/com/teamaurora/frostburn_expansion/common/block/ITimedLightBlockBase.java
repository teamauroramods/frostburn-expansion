package com.teamaurora.frostburn_expansion.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.util.Random;
import java.util.function.Function;

@SuppressWarnings("unused")
public interface ITimedLightBlockBase {
    BooleanProperty LIT = BooleanProperty.create("lit");


    static boolean stellareneLightProperties(Level world) {
        return getLightFromTime(world, 0);
    }

    static boolean lunareneLightProperties(Level world) {
        return getLightFromTime(world, 12000L);
    }

    static boolean getLightFromTime(Level world, long offset) {
        MinecraftServer s = world.getServer();
        if (s == null) { return false; }
        ServerLevel overworld = s.getLevel(Level.OVERWORLD);
        if (overworld != null) {
            long time = (overworld.getDayTime() + offset) % 24000;
            if (time >= 12500 && time <= 23500) return false;
            if (time >= 3500 && time <= 8500) return true;
        }
        return true;
    }

    static boolean isOpaque(BlockState state, BlockGetter reader, BlockPos pos) {
        return !state.getValue(LIT);
    }

    static boolean isLit(BlockState state, BlockGetter reader, BlockPos pos) {
        return state.getValue(LIT);
    }

    static int lightValue(BlockState state) {
        return state.getValue(LIT) ? 14 : 0;
    }

    default void Itick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand, Function<Level, Boolean> lightSupplier) {
        if (!worldIn.isClientSide) {
            boolean lightstate = lightSupplier.apply(worldIn);
            if (!lightstate == (state.getValue(LIT))) {
                worldIn.setBlock(pos, state.setValue(LIT, lightstate), 2 | 4);
            }
        }
    }
}