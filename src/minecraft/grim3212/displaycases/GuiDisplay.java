package grim3212.displaycases;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiDisplay extends GuiContainer
{
    public GuiDisplay(InventoryPlayer inventoryplayer, TileEntityDisplay tileentitydisplay)
    {
        super(new CraftingInventoryDisplayCB(inventoryplayer, tileentitydisplay));
    }

    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        fontRenderer.drawString("Display case", 60, 6, 0x404040);
        fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
    }

    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture("/mods/DisplayCases/textures/gui/displaygui.png");
        int l = width - xSize >> 1;
        int i1 = height - ySize >> 1;
        drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
    }
}
