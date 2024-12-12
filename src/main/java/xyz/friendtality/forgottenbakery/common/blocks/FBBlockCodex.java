package xyz.friendtality.forgottenbakery.common.blocks;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.codecs.SimpleMapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;

import static xyz.friendtality.forgottenbakery.ForrgottenBakery.MODID;

public class FBBlockCodex {
    public static final DeferredRegister<MapCodec<? extends Block>> FB_BC_R =
            DeferredRegister.create(Registries.BLOCK_TYPE, MODID);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<RicePlantBlock>> RICE_PLANT_BLOCK =
            FB_BC_R.register(
                    "rice_plant_block",
                    ()-> BlockBehaviour.simpleCodec(RicePlantBlock::new)
            );

    public static void register(IEventBus eventBus){
     FB_BC_R.register(eventBus);
    }


}