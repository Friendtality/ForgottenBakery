package xyz.friendtality.forgottenbakery.common.menus;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import xyz.friendtality.forgottenbakery.common.items.FBItems;
import xyz.friendtality.forgottenbakery.common.menus.slots.MusicDiskSlot;

public class PortableJukeboxMenu extends AbstractContainerMenu {
    private static final int DISK_SLOT = 0;
    private ItemStack jukebox;



    public PortableJukeboxMenu(int containerId, Inventory playerInv) {
        this(containerId, playerInv, ItemStack.EMPTY);
    }

    public PortableJukeboxMenu(int containerId, Inventory playerInv, ItemStack itemStack) {
        this(containerId, playerInv ,new ItemStackHandler(1));
        this.jukebox =jukebox;
    }

    public PortableJukeboxMenu(int containerID, Inventory playerInv, IItemHandler itemStack){
        super(FBMenus.PORTABLE_JUKEBOX_GUI.get(), containerID);
        addSlot(new MusicDiskSlot(itemStack, DISK_SLOT,80,32));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; k++) {
            this.addSlot(new Slot(playerInv, k, 8 + k * 18, 142));
        }
    }


    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return player.getItemBySlot(EquipmentSlot.MAINHAND).is(FBItems.PORTABLE_JUKEBOX.asItem())
                || player.getItemBySlot(EquipmentSlot.OFFHAND).is(FBItems.PORTABLE_JUKEBOX.asItem());
    }

}