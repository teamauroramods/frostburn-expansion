package com.teamaurora.frostburn_expansion.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.util.Random;
import java.util.function.Function;

/**
 * A block that only emits light during a specified period of time.
 * Totally not stolen from Architects Palette :]
 * @author Jsburger
 * @author ebo2022 (slight modifications)
 */

@SuppressWarnings("deprecation")
public class TimeDependentLightBlock extends Block {

    public static final BooleanProperty LIGHT = BooleanProperty.create("lit");
    public Function<Level, Boolean> lightSupplier;

    public TimeDependentLightBlock(Properties properties, Function<Level, Boolean> getLightState) {
        super(properties);
        this.lightSupplier = getLightState;
        this.registerDefaultState(this.stateDefinition.any().setValue(LIGHT, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIGHT);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(LIGHT, this.lightSupplier.apply(context.getLevel()));
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
        if (!worldIn.isClientSide) {
            boolean lightstate = this.lightSupplier.apply(worldIn);
            if (!lightstate == (state.getValue(LIGHT))) {
                worldIn.setBlock(pos, state.setValue(LIGHT, lightstate), 2 | 4);
            }
        }
    }

    public static boolean solareneLightProperties(Level world) {
        return getLightFromTime(world, 0);
    }

    public static boolean lunareneLightProperties(Level world) {
        return getLightFromTime(world, 12000L);
    }

    private static boolean getLightFromTime(Level world, long offset) {
        MinecraftServer s = world.getServer();
        if (s == null) { return false; }
        ServerLevel overworld = s.getLevel(Level.OVERWORLD);
        if (overworld != null) {
            long time = (overworld.getDayTime() + offset) % 24000;
            if (time >= 12500 && time <= 23500) return false;
            if (time >= 3500 && time <= 8500) return true;
            return false;
        }
        return false;
    }

    public static boolean isOpaque(BlockState state, BlockGetter reader, BlockPos pos) {
        return !state.getValue(LIGHT);
    }

    public static boolean isLit(BlockState state, BlockGetter reader, BlockPos pos) {
        return state.getValue(LIGHT);
    }

    public static int lightValue(BlockState state) {
        return state.getValue(LIGHT) ? 14 : 0;
    }
}