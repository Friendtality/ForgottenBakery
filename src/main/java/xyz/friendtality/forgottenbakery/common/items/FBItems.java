package xyz.friendtality.forgottenbakery.common.items;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static xyz.friendtality.forgottenbakery.ForrgottenBakery.MODID;

public class FBItems {
    public static final DeferredRegister.Items FB_ITEMS =
            DeferredRegister.createItems(MODID);

    public static final DeferredItem RICE_PINNACLE = FB_ITEMS.register("rice_pinnacle", ()-> new Item(new Item.Properties()));

    public static void rgister(IEventBus eventBus){
        FB_ITEMS.register(eventBus);
    }
}
