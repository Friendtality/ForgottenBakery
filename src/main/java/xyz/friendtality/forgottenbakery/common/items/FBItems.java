package xyz.friendtality.forgottenbakery.common.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Properties;

import static xyz.friendtality.forgottenbakery.ForrgottenBakery.MODID;

public class FBItems {
    public static final DeferredRegister.Items FB_ITEMS =
            DeferredRegister.createItems(MODID);

    //Crops

    public static final DeferredItem RICE_PINNACLE =
            FB_ITEMS.register("rice_pinnacle", ()-> new Item(new Item.Properties()));

    //Edible Crops

    public static final DeferredItem TOMATO =
            FB_ITEMS.register("tomato" ,()-> new ItemNameBlockItem(Blocks.DIRT,new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.6f).build())));

    public static final DeferredItem LETTUCE =
            FB_ITEMS.register("lettuce" ,()-> new ItemNameBlockItem(Blocks.DIRT,new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.6f).build())));

    //Items

    public static final DeferredItem PORTABLE_JUKEBOX=
            FB_ITEMS.register("portable_jukebox", ()-> new PortableJukebox(new Item.Properties()));

    public static void rgister(IEventBus eventBus){
        FB_ITEMS.register(eventBus);
    }
}
