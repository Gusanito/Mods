// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package grim3212.workbenchup;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;

// Referenced classes of package net.minecraft.src:
//            Container, InventoryCrafting, InventoryCraftResult, SlotCrafting, 
//            InventoryPlayer, World, Slot, CraftingManager, 
//            IInventory, ItemStack, EntityPlayer, mod_WorkbenchUpgrades, 
//            Block

public class ContainerDiamondWorkbench extends ContainerWorkbench
{
    private World worldObj;

    public ContainerDiamondWorkbench(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5)
    {
    	super(par1InventoryPlayer, par2World, par3, par4, par5);
        this.worldObj = par2World;
    }

    @Override
    public void onCraftMatrixChanged(IInventory iinventory)
    {
    	this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
        if(craftResult.getStackInSlot(0) != null)
        {
            if(craftResult.getStackInSlot(0).stackSize >= 32)
            {
                craftResult.getStackInSlot(0).stackSize = 127;
            } else
            {
                craftResult.getStackInSlot(0).stackSize *= 4;
            }
        }
    }

    @Override
    public void onCraftGuiClosed(EntityPlayer par1EntityPlayer)
    {
        super.onCraftGuiClosed(par1EntityPlayer);
    }

    @Override
    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return true;
    }
}
