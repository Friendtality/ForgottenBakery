package xyz.friendtality.forgottenbakery.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.VanillaBlockTagsProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.internal.NeoForgeBlockTagsProvider;
import net.neoforged.neoforge.common.data.internal.NeoForgeItemTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import xyz.friendtality.forgottenbakery.datagen.tags.FBItemTagsProvider;

import java.util.concurrent.CompletableFuture;

import static xyz.friendtality.forgottenbakery.ForrgottenBakery.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class FBDatagenerators {
    @SubscribeEvent
    public static void gatehrDataEvent(GatherDataEvent event){
        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        dataGenerator.addProvider(event.includeClient(), new FBItemModelProvider(packOutput, fileHelper));

        NeoForgeBlockTagsProvider blockTagsProvider = new NeoForgeBlockTagsProvider(packOutput,lookupProvider,fileHelper);

        dataGenerator.addProvider(event.includeServer(), new FBItemTagsProvider(packOutput,lookupProvider,blockTagsProvider.contentsGetter(), fileHelper));
        }

    }
