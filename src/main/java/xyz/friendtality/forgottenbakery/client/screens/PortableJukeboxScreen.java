package xyz.friendtality.forgottenbakery.client.screens;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import xyz.friendtality.forgottenbakery.ForrgottenBakery;
import xyz.friendtality.forgottenbakery.common.menus.PortableJukeboxMenu;

public class PortableJukeboxScreen extends AbstractContainerScreen<PortableJukeboxMenu> {

    private static final ResourceLocation INVENTORY_BACKGROUND =
            ResourceLocation.fromNamespaceAndPath(ForrgottenBakery.MODID, "textures/gui/container/portable_jukebox_gui.png");

    public PortableJukeboxScreen(PortableJukeboxMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        guiGraphics.blit(INVENTORY_BACKGROUND, this.leftPos, this.topPos,0,0,this.imageWidth,this.imageHeight);
    }
}
