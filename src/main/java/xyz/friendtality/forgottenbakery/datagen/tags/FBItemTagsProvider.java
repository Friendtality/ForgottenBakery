package xyz.friendtality.forgottenbakery.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import xyz.friendtality.forgottenbakery.ForrgottenBakery;

import java.util.concurrent.CompletableFuture;

public class FBItemTagsProvider extends ItemTagsProvider {
    public FBItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, ExistingFileHelper fileHelper) {
        super(output, lookupProvider, blockTags, ForrgottenBakery.MODID, fileHelper);
    }


    @Override
    protected void addTags(HolderLookup.Provider provider) {
    }
}
