package xyz.friendtality.forgottenbakery.common.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static xyz.friendtality.forgottenbakery.ForrgottenBakery.MODID;

public class FBBlocks {
    public static final DeferredRegister.Blocks FB_BLOCKS =
            DeferredRegister.createBlocks(MODID);

    public static final DeferredBlock RICE_PLANT =
            FB_BLOCKS.register("rice_plant" , ()-> new RicePlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));

    public static void register(IEventBus eventBus){
        FB_BLOCKS.register(eventBus);
    }
}
