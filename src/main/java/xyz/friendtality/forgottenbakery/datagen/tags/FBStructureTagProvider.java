package xyz.friendtality.forgottenbakery.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.StructureTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import xyz.friendtality.forgottenbakery.ForrgottenBakery;

import java.util.concurrent.CompletableFuture;

public class FBStructureTagProvider extends StructureTagsProvider {
    public FBStructureTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, ForrgottenBakery.MODID, existingFileHelper);
    }
}
