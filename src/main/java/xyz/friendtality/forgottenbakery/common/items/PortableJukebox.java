package xyz.friendtality.forgottenbakery.common.items;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import xyz.friendtality.forgottenbakery.common.menus.PortableJukeboxMenu;

public class PortableJukebox extends Item {
    public PortableJukebox(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        HolderGetter<MenuType<?>> lookup = level.registryAccess().asGetterLookup().lookupOrThrow(Registries.MENU);
        if(player.isCrouching()){
            player.openMenu(new SimpleMenuProvider(((containerId, playerInventory, user) -> new PortableJukeboxMenu(containerId, playerInventory, player.getItemInHand(usedHand))),
                    getName(player.getItemInHand(usedHand))));
            return InteractionResultHolder.success(player.getItemInHand(usedHand));
        }
        return super.use(level, player, usedHand);
    }

}
