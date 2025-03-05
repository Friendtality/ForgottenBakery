package xyz.friendtality.forgottenbakery.common.menus;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.friendtality.forgottenbakery.ForrgottenBakery;

import java.util.function.Supplier;

public class FBMenus {
    public static final DeferredRegister<MenuType<?>> FB_MEU_TYPES =
            DeferredRegister.create(Registries.MENU, ForrgottenBakery.MODID);

    public static final Supplier<MenuType<PortableJukeboxMenu>> PORTABLE_JUKEBOX_GUI =
            FB_MEU_TYPES.register("portable_jukebox_gui", ()-> new MenuType<>(PortableJukeboxMenu::new, FeatureFlags.DEFAULT_FLAGS));

    public static void register(IEventBus eventBus){
        FB_MEU_TYPES.register(eventBus);
    }
}
