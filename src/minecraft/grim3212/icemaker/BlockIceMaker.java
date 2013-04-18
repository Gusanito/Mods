package grim3212.icemaker;

import java.text.NumberFormat;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.biome.WorldChunkManager;

public class BlockIceMaker extends Block {
	public Icon topf;
	public Icon top;
	public Icon top1;
	public Icon top2;

	protected BlockIceMaker(int i) {
		super(i, Material.wood);
		setTickRandomly(true);
	}

	public int tickRate() {
		return 20;
	}

	public boolean canPlaceBlockAt(World world, int i, int j, int k) {
		int l = world.getBlockId(i, j - 1, k);
		return l != 0;
	}

	public void updateTick(World world, int i, int j, int k, Random random) {
		super.updateTick(world, i, j, k, random);
		if (!world.isRemote) {
		WorldChunkManager worldchunkmanager = world.getWorldChunkManager();
		NumberFormat numberformat = NumberFormat.getPercentInstance();
		int l = 7;
		if (worldchunkmanager.getTemperatureAtHeight(i, j) == worldchunkmanager.getTemperatureAtHeight(i, j)) {
			double d = worldchunkmanager.getTemperatureAtHeight(i, j);
			if (d < 0.5D) {
				l = 10;
			}
		}
		
			int i1 = world.getBlockMetadata(i, j, k);
			if (i1 >= 5) {
				l = (l + (15 - i1)) - l;
			}
			if (i1 == 0) {
				world.setBlockMetadataWithNotify(i, j, k, 0, 2);
			} else if (i1 == 15) {
				world.setBlockMetadataWithNotify(i, j, k, 15, 2);
			} else {
				world.setBlockMetadataWithNotify(i, j, k, i1 + l, 2);
			}
		}
	}

	public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer) {
		if (world.getBlockMetadata(i, j, k) == 15) {
			if (!world.isRemote) {
				world.setBlock(i, j, k, blockID);
				float f = 0.7F;
				double d = (double) (world.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
				double d1 = (double) (world.rand.nextFloat() * f) + (double) (1.0F - f) * 0.20000000000000001D + 0.59999999999999998D;
				double d2 = (double) (world.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
				EntityItem entityitem = new EntityItem(world, (double) i + d, (double) j + d1, (double) k + d2, new ItemStack(Block.blocksList[79], 5));
				entityitem.delayBeforeCanPickup = 10;
				world.joinEntityInSurroundings(entityitem);
			}
		}
	}

	public Icon getBlockTextureFromSideAndMetadata(int i, int j) {
		if (i == 0) {
			return blockIcon;
		}
		if (i == 1) {
			if (j >= 15) {
				topf = top2;
			} else if (j >= 1) {
				topf = top1;
			} else {
				topf = top;
			}
			return topf;
		} else {
			return i == 0 ? topf : blockIcon;
		}
	}

	public void registerIcons(IconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("furnace_side");
		this.top = par1IconRegister.registerIcon("IceMaker:icemaker_top");
		this.top1 = par1IconRegister.registerIcon("IceMaker:icemaker_top2");
		this.top2 = par1IconRegister.registerIcon("IceMaker:icemaker_top3");
	}
}
