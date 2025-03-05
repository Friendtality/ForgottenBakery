package xyz.friendtality.forgottenbakery.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import xyz.friendtality.forgottenbakery.ForrgottenBakery;
import xyz.friendtality.forgottenbakery.client.screens.PortableJukeboxScreen;
import xyz.friendtality.forgottenbakery.common.menus.FBMenus;

import javax.xml.transform.sax.SAXTransformerFactory;

@EventBusSubscriber(modid = ForrgottenBakery.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHaneler {

    @SubscribeEvent
    public static  void registerScreens(RegisterMenuScreensEvent event){
        event.register(FBMenus.PORTABLE_JUKEBOX_GUI.get(), PortableJukeboxScreen::new);
    }
}
