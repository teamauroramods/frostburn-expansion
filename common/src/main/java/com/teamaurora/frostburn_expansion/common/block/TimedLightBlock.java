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
public class TimedLightBlock extends Block implements ITimedLightBlockBase {

    public Function<Level, Boolean> lightSupplier;

    public TimedLightBlock(Properties properties, Function<Level, Boolean> getLightState) {
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


}