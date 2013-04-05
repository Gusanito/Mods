package grim3212.calendar;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ItemCalendar extends Item {
	public ItemCalendar(int i) {
		super(i);
		maxStackSize = 1;
		setCreativeTab(CreativeTabs.tabDecorations);
	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l, float par8, float par9, float par10) {
		if (l == 0) {
			return false;
		}
		if (!world.getBlockMaterial(i, j, k).isSolid()) {
			return false;
		}
		if (l == 1) {
			return false;
		}
		if (l == 2) {
			k--;
		}
		if (l == 3) {
			k++;
		}
		if (l == 4) {
			i--;
		}
		if (l == 5) {
			i++;
		}
		world.setBlock(i, j, k, Calendar.calendarBlock.blockID, l, 2);
		itemstack.stackSize--;
		TileEntity tileentity = world.getBlockTileEntity(i, j, k);
		return true;
	}

	public void updateIcons(IconRegister par1IconRegister) {
		iconIndex = par1IconRegister.registerIcon("Calendar:calendarItem");
	}
}
