package xyz.friendtality.forgottenbakery.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class RicePlantBlock extends DoublePlantBlock implements BonemealableBlock {

    public static final BooleanProperty WATELOGGED = BlockStateProperties.WATERLOGGED;

    public RicePlantBlock(Properties properties) {
        super(properties);
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

   public boolean hasSufficiantLight(LevelReader level, BlockPos pos){
        return level.getRawBrightness(pos,0) >= 8;
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
