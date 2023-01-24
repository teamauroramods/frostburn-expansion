package com.teamaurora.frostburn_expansion.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;
import java.util.function.Function;

@ParametersAreNonnullByDefault
public class TimedLightStairBlock extends StairBlock implements ITimedLightBlockBase {

    public Function<Level, Boolean> lightSupplier;

    public TimedLightStairBlock(BlockState state, Properties properties, Function<Level, Boolean> lightSupplier) {
        super(state, properties);
        this.lightSupplier = lightSupplier;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HALF, Half.BOTTOM).setValue(SHAPE, StairsShape.STRAIGHT).setValue(WATERLOGGED, false).setValue(LIT, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF, SHAPE, WATERLOGGED, LIT);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getClickedFace();
        BlockPos blockPos = context.getClickedPos();
        FluidState fluidState = context.getLevel().getFluidState(blockPos);
        BlockState blockState = this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(HALF, direction != Direction.DOWN && (direction == Direction.UP || !(context.getClickLocation().y - (double)blockPos.getY() > 0.5D)) ? Half.BOTTOM : Half.TOP)                                                                                                .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER).setValue(LIT, this.lightSupplier.apply(context.getLevel()));
        return blockState.setValue(SHAPE, getStairsShape(blockState, context.getLevel(), blockPos)).setValue(LIT, this.lightSupplier.apply(context.getLevel()));
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
