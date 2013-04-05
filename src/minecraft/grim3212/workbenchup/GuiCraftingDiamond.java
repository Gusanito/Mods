// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package grim3212.workbenchup;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiContainer, ContainerDiamondWorkbench, FontRenderer, RenderEngine, 
//            InventoryPlayer, World

public class GuiCraftingDiamond extends GuiContainer
{

    public GuiCraftingDiamond(EntityPlayer inventoryplayer, World world, int i, int j, int k)
    {
        super(new ContainerDiamondWorkbench(inventoryplayer.inventory, world, i, j, k));
    }

    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        fontRenderer.drawString("Diamond Crafting (4x)", 28, 6, 4210752);
        fontRenderer.drawString("Inventory", 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture("/gui/crafting.png");
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
    }
}
