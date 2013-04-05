package grim3212.displaycases;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class CraftingInventoryDisplayCB extends Container
{
    private TileEntityDisplay entity;
    private IInventory inventory;

    public CraftingInventoryDisplayCB(IInventory iinventory, TileEntityDisplay tileentitydisplay)
    {
        entity = tileentitydisplay;
        addSlotToContainer(new Slot(tileentitydisplay, 2, 79, 35));
        for (int i = 0; i < 3; i++)
        {
            for (int k = 0; k < 9; k++)
            {
            	addSlotToContainer(new Slot(iinventory, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }
        }

        for (int j = 0; j < 9; j++)
        {
        	addSlotToContainer(new Slot(iinventory, j, 8 + j * 18, 142));
        }
    }

    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return entity.isUseableByPlayer(entityplayer);
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityplayer, int i)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)inventorySlots.get(i);
        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (i < 36)
            {
                if (!mergeItemStack(itemstack1, 36, inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!mergeItemStack(itemstack1, 0, 36, false))
            {
                return null;
            }
            if (itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }
        return itemstack;
    }
}
