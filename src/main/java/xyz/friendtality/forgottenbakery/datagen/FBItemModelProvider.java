package xyz.friendtality.forgottenbakery.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import xyz.friendtality.forgottenbakery.common.items.FBItems;

import static xyz.friendtality.forgottenbakery.ForrgottenBakery.MODID;

public class FBItemModelProvider extends ItemModelProvider {
    public FBItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(FBItems.RICE_PINNACLE.asItem());
    }
}
