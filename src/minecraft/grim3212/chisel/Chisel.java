package grim3212.chisel;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Chisel extends Item {
	ItemStack itemResult;
	protected EnumToolMaterial a;
	int type;

	public Chisel(int i, int j) {
		super(i);
		maxStackSize = 1;
		setMaxDamage(32 * j);
		setCreativeTab(CreativeTabs.tabTools);
	}

	public void updateIcons(IconRegister par1IconRegister) {
		if (itemID == ChiselCore.Chisel.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Chisel:" + "chisel");
		}
		if (itemID == ChiselCore.DiamondChisel.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Chisel:" + "diamond_chisel");
		}
	}

	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l, float par8, float par9, float par10) {
		int i1 = world.getBlockId(i, j, k);
		if (chiselAPI.chiselBlocks.contains(Integer.valueOf(i1))) {
			int j1 = world.rand.nextInt(100);
			type = chiselAPI.chiselBlocks.indexOf(Integer.valueOf(i1));
			world.setBlock(i, j, k, ((Integer) chiselAPI.chiselReturnb.get(type)).intValue());
			float f = 0.7F;
			float f1 = world.rand.nextFloat() * f + (1.0F - f) * 0.5F;
			float f2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5F;
			float f3 = world.rand.nextFloat() * f + (1.0F - f) * 0.5F;
			byte byte0 = (byte) (world.rand.nextInt(10) != 0 ? 1 : 2);
			int k1 = 0;
			if (!world.isRemote) {

				if (k1 >= 0) {
					Item item = (Item) chiselAPI.chiselItem.get(type);
					int l1 = ((Integer) chiselAPI.chiselItemQuantity.get(type)).intValue();
					int i2 = ((Integer) chiselAPI.chiselItemDamage.get(type)).intValue();
					world.spawnEntityInWorld(new EntityItem(world, (double) i + f1, (double) j + f2, (double) k + f3, new ItemStack(item, l1, i2)));

					if (j1 >= 94) {
						EntityItem entityitem1 = new EntityItem(world, (float) i + f1, (float) j + f2, (float) k + f3, new ItemStack(item, l1, i2));
						world.spawnEntityInWorld(entityitem1);
						itemstack.damageItem(1, entityplayer);
					}

					itemstack.damageItem(1, entityplayer);
					world.playSoundEffect(i, j, k, "step.stone", 1.0F, 1.0F);
					return false;
				}
			}
		}
		return true;
	}
}
