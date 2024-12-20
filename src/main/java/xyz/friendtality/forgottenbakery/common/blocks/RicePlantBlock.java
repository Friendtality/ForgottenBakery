package xyz.friendtality.forgottenbakery.common.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RicePlantBlock extends DoublePlantBlock implements BonemealableBlock, SimpleWaterloggedBlock {
    public static final BooleanProperty WATELOGGED = BlockStateProperties.WATERLOGGED;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_7;
    public static final int MAX_AGE = 7;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(1.0F, 0.0F, 10F, 15.0F, 0.0F, 15.0F),
            Block.box(1.0F, 0.0F, 1.0F, 15.0F, 4.0F, 15.0F),
            Block.box(1.0F, 0.0F, 1.0F, 15.0F, 8.0F, 15.0F),
            Block.box(1.0F, 0.0F, 1.0F, 15.0F, 12.0F, 15.0F),
            Block.box(1.0F, 0.0F, 1.0F, 15.0F, 16.0F, 15.0F)
    };


    public RicePlantBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition()
                .any()
                .setValue(this.getAgeProperty(), Integer.valueOf(0))
        );
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState();
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if(state.getValue(HALF) == DoubleBlockHalf.UPPER ){
            if(!level.getBlockState(pos.below()).is(FBBlocks.RICE_PLANT)){
                return false;
            }
            return !state.getValue(WATELOGGED);
        }else{
            if(level.getBlockState(pos).is(Blocks.MUD)){
                return false;
            }
            return state.getValue(WATELOGGED);
        }
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(HALF) == DoubleBlockHalf.UPPER
                ? SHAPE_BY_AGE[Math.min(4, state.getValue(AGE) + 1)]
                : SHAPE_BY_AGE[Math.max(0, state.getValue(AGE) - 4)];
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Block.box(0,0,0,0 ,0,0);

    }

    protected IntegerProperty getAgeProperty(){
        return AGE;
    }

    public boolean hasSufficiantLight(LevelReader level, BlockPos pos){
        return level.getRawBrightness(pos,0) >= 8;
   }

    @Override
    public MapCodec<RicePlantBlock> codec() {
        return FBBlockCodex.RICE_PLANT_BLOCK.value();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder
                .add(AGE)
                .add(WATELOGGED);
        super.createBlockStateDefinition(builder);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return false;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return false;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {

    }


}
