package grim3212.mysticpack;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemVinesStrand extends Item {
	public ItemVinesStrand(int i) {
		super(i);
	}

	/**
	 * Callback for item usage. If the item does something special on right
	 * clicking, he will have one of those. Return True if something happen and
	 * false if it don't. This is for ITEMS, not BLOCKS !
	 */
	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l, float par8, float par9, float par10) {
		int i1 = world.getBlockId(i, j, k);

		if (i1 == Block.dirt.blockID && world.isAirBlock(i, j - 1, k) || i1 == Block.grass.blockID && world.isAirBlock(i, j - 1, k) || i1 == Block.stone.blockID && world.isAirBlock(i, j - 1, k) || i1 == Block.leaves.blockID && world.isAirBlock(i, j - 1, k)) {
			world.playSoundEffect((double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, "step.grass4", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
			world.setBlock(i, j - 1, k, MysticRuins.vines.blockID);
			itemstack.stackSize--;
			return true;
		}

		if (i1 == Block.cobblestone.blockID) {
			world.playSoundEffect((double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, "step.grass4", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
			world.setBlock(i, j, k, Block.cobblestoneMossy.blockID);
			itemstack.stackSize--;
			return true;
		} else {
			return false;
		}
	}

	public void updateIcons(IconRegister par1IconRegister) {
		iconIndex = par1IconRegister.registerIcon("MysticPack:" + "vines_strand");
	}
}
