package xyz.friendtality.forgottenbakery;

import net.neoforged.bus.EventBus;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import xyz.friendtality.forgottenbakery.common.blocks.FBBlockCodex;
import xyz.friendtality.forgottenbakery.common.blocks.FBBlocks;
import xyz.friendtality.forgottenbakery.common.items.FBItems;
import xyz.friendtality.forgottenbakery.common.menus.FBMenus;
import xyz.friendtality.forgottenbakery.common.mobeffects.FBMobEffects;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(ForrgottenBakery.MODID)
public class ForrgottenBakery
{

    public static final String MODID = "forgottenbakery";

    private static final Logger LOGGER = LogUtils.getLogger();

    public ForrgottenBakery(IEventBus modEventBus, ModContainer modContainer){
        LOGGER.debug("Starting Forgotten Bakery Registration Progress");
        FBBlockCodex.register(modEventBus);

        FBItems.rgister(modEventBus);
        FBBlocks.register(modEventBus);
        FBMobEffects.register(modEventBus);
        FBMenus.register(modEventBus);

        LOGGER.debug("Ending FB registration");
    }
}
