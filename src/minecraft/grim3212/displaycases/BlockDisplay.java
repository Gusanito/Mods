package grim3212.displaycases;

import grim3212.displaycases.common.CommonProxy;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockDisplay extends BlockContainer {
	public BlockDisplay(int i, Block block) {
		super(i, Material.glass);
		setCreativeTab(CreativeTabs.tabDecorations);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		setTickRandomly(true);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving) {
		int l = MathHelper.floor_double((double) ((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		int j1 = world.getBlockMetadata(i, j, k) & 0xc;

		if (l == 0) {
			j1 |= 2;
		}
		if (l == 1) {
			j1 |= 1;
		}
		if (l == 2) {
			j1 |= 3;
		}
		if (l == 3) {
			j1 |= 0;
		}
		world.setBlock(i, j, k, j1);
	}

	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
		if (entityplayer.isSneaking()) {
			return false;
		}

		if (world.isRemote) {
			return true;
		}

		if (!world.isRemote) {
			TileEntityDisplay display = (TileEntityDisplay) world.getBlockTileEntity(i, j, k);

			if (display != null) {
				entityplayer.openGui(DisplayCases.instance, CommonProxy.displaycaseGUI_ID, world, i, j, k);
			}
		}

		return true;
	}

	public int damageDropped(int i) {
		return i & 0xc;
	}

	public void breakBlock(World world, int i, int j, int k, int par5, int par6) {
		TileEntityDisplay tileentitydisplay = (TileEntityDisplay) world.getBlockTileEntity(i, j, k);
		label0: for (int l = 0; l < tileentitydisplay.getSizeInventory(); l++) {
			ItemStack itemstack = tileentitydisplay.getStackInSlot(l);
			if (itemstack == null) {
				continue;
			}
			float f = world.rand.nextFloat() * 0.8F + 0.1F;
			float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
			float f2 = world.rand.nextFloat() * 0.8F + 0.1F;
			do {
				if (itemstack.stackSize <= 0) {
					continue label0;
				}
				int i1 = world.rand.nextInt(21) + 10;
				if (i1 > itemstack.stackSize) {
					i1 = itemstack.stackSize;
				}
				itemstack.stackSize -= i1;
				EntityItem entityitem = new EntityItem(world, (float) i + f, (float) j + f1, (float) k + f2, new ItemStack(itemstack.itemID, i1, itemstack.getItemDamage()));
				float f3 = 0.05F;
				entityitem.motionX = (float) world.rand.nextGaussian() * f3;
				entityitem.motionY = (float) world.rand.nextGaussian() * f3 + 0.2F;
				entityitem.motionZ = (float) world.rand.nextGaussian() * f3;
				world.spawnEntityInWorld(entityitem);
			} while (true);
		}

		super.breakBlock(world, i, j, k, par5, par6);
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		// TODO Auto-generated method stub
		return new TileEntityDisplay();
	}
	
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            super.updateTick(par1World, par2, par3, par4, par5Random);

            par1World.markBlockForRenderUpdate(par2, par3, par4);
    		par1World.markBlockForUpdate(par2, par3, par4);
        }
    }
	
	public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("DisplayCases:goldDisplay");
	}

}
