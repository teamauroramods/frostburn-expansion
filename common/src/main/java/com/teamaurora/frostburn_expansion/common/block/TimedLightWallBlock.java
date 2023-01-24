package com.teamaurora.frostburn_expansion.common.block;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault
public class TimedLightWallBlock extends WallBlock implements ITimedLightBlockBase {
    public Function<Level, Boolean> lightSupplier;

    public TimedLightWallBlock(Properties properties, Function<Level, Boolean> lightSupplier) {
        super(properties);
        this.lightSupplier = lightSupplier;
        this.registerDefaultState(this.stateDefinition.any().setValue(UP, true).setValue(NORTH_WALL, WallSide.NONE).setValue(EAST_WALL, WallSide.NONE).setValue(SOUTH_WALL, WallSide.NONE).setValue(WEST_WALL, WallSide.NONE).setValue(WATERLOGGED, false).setValue(LIT, false));

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(UP, NORTH_WALL, EAST_WALL, WEST_WALL, SOUTH_WALL, WATERLOGGED, LIT);
    }

    @Override
    @NotNull
    public Map<BlockState, VoxelShape> makeShapes(float f, float g, float h, float i, float j, float k) {
        float l = 8.0f - f;
        float m = 8.0f + f;
        float n = 8.0f - g;
        float o = 8.0f + g;
        VoxelShape voxelShape = Block.box(l, 0.0, l, m, h, m);
        VoxelShape voxelShape2 = Block.box(n, i, 0.0, o, j, o);
        VoxelShape voxelShape3 = Block.box(n, i, n, o, j, 16.0);
        VoxelShape voxelShape4 = Block.box(0.0, i, n, o, j, o);
        VoxelShape voxelShape5 = Block.box(n, i, n, 16.0, j, o);
        VoxelShape voxelShape6 = Block.box(n, i, 0.0, o, k, o);
        VoxelShape voxelShape7 = Block.box(n, i, n, o, k, 16.0);
        VoxelShape voxelShape8 = Block.box(0.0, i, n, o, k, o);
        VoxelShape voxelShape9 = Block.box(n, i, n, 16.0, k, o);
        ImmutableMap.Builder<BlockState, VoxelShape> builder = ImmutableMap.builder();
        for (Boolean boolean_ : UP.getPossibleValues()) {
            for (WallSide wallSide : EAST_WALL.getPossibleValues()) {
                for (WallSide wallSide2 : NORTH_WALL.getPossibleValues()) {
                    for (WallSide wallSide3 : WEST_WALL.getPossibleValues()) {
                        for (WallSide wallSide4 : SOUTH_WALL.getPossibleValues()) {
                            VoxelShape voxelShape10 = Shapes.empty();
                            voxelShape10 = WallBlock.applyWallShape(voxelShape10, wallSide, voxelShape5, voxelShape9);
                            voxelShape10 = WallBlock.applyWallShape(voxelShape10, wallSide3, voxelShape4, voxelShape8);
                            voxelShape10 = WallBlock.applyWallShape(voxelShape10, wallSide2, voxelShape2, voxelShape6);
                            voxelShape10 = WallBlock.applyWallShape(voxelShape10, wallSide4, voxelShape3, voxelShape7);
                            if (boolean_) {
                                voxelShape10 = Shapes.or(voxelShape10, voxelShape);
                            }
                            BlockState blockState = this.defaultBlockState().setValue(UP, boolean_).setValue(EAST_WALL, wallSide).setValue(WEST_WALL, wallSide3).setValue(NORTH_WALL, wallSide2).setValue(SOUTH_WALL, wallSide4);
                            builder.put(blockState.setValue(WATERLOGGED, false).setValue(LIT, false), voxelShape10);
                            builder.put(blockState.setValue(WATERLOGGED, true).setValue(LIT, true), voxelShape10);
                            builder.put(blockState.setValue(WATERLOGGED, true).setValue(LIT, false), voxelShape10);
                            builder.put(blockState.setValue(WATERLOGGED, false).setValue(LIT, true), voxelShape10);
                        }
                    }
                }
            }
        }
        return builder.build();
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level levelReader = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        BlockPos blockPos2 = blockPos.north();
        BlockPos blockPos3 = blockPos.east();
        BlockPos blockPos4 = blockPos.south();
        BlockPos blockPos5 = blockPos.west();
        BlockPos blockPos6 = blockPos.above();
        BlockState blockState = levelReader.getBlockState(blockPos2);
        BlockState blockState2 = levelReader.getBlockState(blockPos3);
        BlockState blockState3 = levelReader.getBlockState(blockPos4);
        BlockState blockState4 = levelReader.getBlockState(blockPos5);
        BlockState blockState5 = levelReader.getBlockState(blockPos6);
        boolean bl = this.connectsTo(blockState, blockState.isFaceSturdy(levelReader, blockPos2, Direction.SOUTH), Direction.SOUTH);
        boolean bl2 = this.connectsTo(blockState2, blockState2.isFaceSturdy(levelReader, blockPos3, Direction.WEST), Direction.WEST);
        boolean bl3 = this.connectsTo(blockState3, blockState3.isFaceSturdy(levelReader, blockPos4, Direction.NORTH), Direction.NORTH);
        boolean bl4 = this.connectsTo(blockState4, blockState4.isFaceSturdy(levelReader, blockPos5, Direction.EAST), Direction.EAST);
        BlockState blockState6 = this.defaultBlockState().setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        return this.updateShape(levelReader, blockState6, blockPos6, blockState5, bl, bl2, bl3, bl4).setValue(LIT, lightSupplier.apply(levelReader));
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
