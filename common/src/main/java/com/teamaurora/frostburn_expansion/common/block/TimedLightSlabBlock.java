package com.teamaurora.frostburn_expansion.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.function.Function;

@SuppressWarnings("deprecation")

public class TimedLightSlabBlock extends SlabBlock implements ITimedLightBlockBase {

    public Function<Level, Boolean> lightSupplier;

    public TimedLightSlabBlock(Properties properties, Function<Level, Boolean> lightSupplier) {
        super(properties);
        this.lightSupplier = lightSupplier;
        this.registerDefaultState(this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM).setValue(WATERLOGGED, false).setValue(LIT, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE, WATERLOGGED, LIT);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        Level worldIn = context.getLevel();
        BlockState blockState = worldIn.getBlockState(blockPos);
        if (blockState.is(this)) {
            return blockState.setValue(TYPE, SlabType.DOUBLE).setValue(WATERLOGGED, false).setValue(LIT, this.lightSupplier.apply(worldIn));
        } else {
            FluidState fluidState = worldIn.getFluidState(blockPos);
            BlockState blockState2 = this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER).setValue(LIT, this.lightSupplier.apply(worldIn));
            Direction direction = context.getClickedFace();
            return direction != Direction.DOWN && (direction == Direction.UP || !(context.getClickLocation().y - (double)blockPos.getY() > 0.5D)) ? blockState2 : (BlockState)blockState2.setValue(TYPE, SlabType.TOP).setValue(LIT, this.lightSupplier.apply(worldIn));
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
        this.Itick(state, worldIn, pos, rand, this.lightSupplier);
        super.tick(state, worldIn, pos, rand);
    }
}
