package xyz.friendtality.forgottenbakery.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static xyz.friendtality.forgottenbakery.ForrgottenBakery.MODID;

public class FBBlockStateProvider extends BlockModelProvider {
    public FBBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}
