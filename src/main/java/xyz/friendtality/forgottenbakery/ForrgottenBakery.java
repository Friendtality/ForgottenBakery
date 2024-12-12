package xyz.friendtality.forgottenbakery;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import xyz.friendtality.forgottenbakery.common.blocks.FBBlockCodex;
import xyz.friendtality.forgottenbakery.common.blocks.FBBlocks;
import xyz.friendtality.forgottenbakery.common.items.FBItems;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(ForrgottenBakery.MODID)
public class ForrgottenBakery
{

    public static final String MODID = "forgottenbakery";

    private static final Logger LOGGER = LogUtils.getLogger();

    public ForrgottenBakery(IEventBus modEventBus, ModContainer modContainer)
    {

        FBBlockCodex.register(modEventBus);

        FBItems.rgister(modEventBus);
        FBBlocks.register(modEventBus);

    }


}
