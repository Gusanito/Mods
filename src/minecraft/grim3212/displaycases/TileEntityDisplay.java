package grim3212.displaycases;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDisplay extends TileEntity implements IInventory {
	private ItemStack items[];
	private int field_82349_r = 16;

	public TileEntityDisplay() {
		items = new ItemStack[9];
	}

	public int getSizeInventory() {
		return items.length;
	}

	public void updateContainingBlockInfo() {
		super.updateContainingBlockInfo();
	}

	public ItemStack getStackInSlot(int i) {
		return items[i];
	}

	public ItemStack decrStackSize(int i, int j) {
		if (items[i] != null) {
			if (items[i].stackSize <= j) {
				ItemStack itemstack = items[i];
				items[i] = null;
				onInventoryChanged();
				return itemstack;
			}
			ItemStack itemstack1 = items[i].splitStack(j);
			if (items[i].stackSize == 0) {
				items[i] = null;
			}
			onInventoryChanged();
			return itemstack1;
		} else {
			return null;
		}
	}

	public void setInventorySlotContents(int i, ItemStack itemstack) {
		items[i] = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}
		onInventoryChanged();
	}

	public String getInvName() {
		return "Display Case";
	}

	public void readFromNBT(NBTTagCompound nbttagcompound) {
		super.readFromNBT(nbttagcompound);
		NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
		items = new ItemStack[getSizeInventory()];
		for (int i = 0; i < nbttaglist.tagCount(); i++) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 0xff;
			if (j >= 0 && j < items.length) {
				items[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
	}

	public void writeToNBT(NBTTagCompound nbttagcompound) {
		super.writeToNBT(nbttagcompound);
		NBTTagList nbttaglist = new NBTTagList();
		for (byte byte0 = 0; byte0 < items.length; byte0++) {
			if (items[byte0] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", byte0);
				items[byte0].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		nbttagcompound.setTag("Items", nbttaglist);
	}

	public int getInventoryStackLimit() {
		return 1;
	}

	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this) {
			return false;
		} else {
			return entityplayer.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64D;
		}
	}

	public void updateEntity() {

		super.updateEntity();
	}

	public void openChest() {
	}

	public void closeChest() {
	}

	public ItemStack getStackInSlotOnClosing(int par1) {
		if (this.items[par1] != null) {
			ItemStack var2 = this.items[par1];
			this.items[par1] = null;
			return var2;
		} else {
			return null;
		}
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public boolean isStackValidForSlot(int i, ItemStack itemstack) {
		return false;
	}
}
