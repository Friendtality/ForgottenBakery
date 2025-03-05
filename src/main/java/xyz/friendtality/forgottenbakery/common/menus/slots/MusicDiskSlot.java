package xyz.friendtality.forgottenbakery.common.menus.slots;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.internal.NeoForgeItemTagsProvider;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import org.jetbrains.annotations.NotNull;

import javax.swing.plaf.basic.BasicComboBoxUI;

public class MusicDiskSlot extends Slot {

    private final IItemHandler itemHandler;
    private static final Container emptyInventory = new SimpleContainer(0);
    public MusicDiskSlot(IItemHandler pItemHandler,int slot, int x, int y) {
        super(emptyInventory, slot, x, y);
        itemHandler = pItemHandler;

    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return stack.is(Tags.Items.MUSIC_DISCS);
    }

    @Override
    public boolean mayPickup(Player player) {
        return !this.getItemHandler().extractItem(index, 1, true).isEmpty();
    }


    @Override
    public @NotNull ItemStack getItem() {
        return this.getItemHandler().getStackInSlot(index);
    }

    // Override if your IItemHandler does not implement IItemHandlerModifiable
    @Override
    public void set(ItemStack stack) {
        ((IItemHandlerModifiable) this.getItemHandler()).setStackInSlot(index, stack);
        this.setChanged();
    }

    public IItemHandler getItemHandler() {
        return itemHandler;
    }
}
