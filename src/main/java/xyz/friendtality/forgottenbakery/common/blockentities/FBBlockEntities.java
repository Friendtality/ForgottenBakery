package xyz.friendtality.forgottenbakery.common.blockentities;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.apache.commons.lang3.function.FailableIntToLongFunction;
import xyz.friendtality.forgottenbakery.common.blocks.FBBlocks;
import xyz.friendtality.forgottenbakery.common.blocks.FBStoveBlock;

import java.util.function.Supplier;

import static net.neoforged.neoforge.internal.versions.neoforge.NeoForgeVersion.MOD_ID;

public class FBBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> FB_BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MOD_ID);
    
}
