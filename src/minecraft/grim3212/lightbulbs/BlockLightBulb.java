// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package grim3212.lightbulbs;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

// Referenced classes of package net.minecraft.src:
//            BlockBreakable, Material, mod_LightBulb, World, 
//            Block, BlockRedstoneWire, IBlockAccess

public class BlockLightBulb extends BlockBreakable {

	protected BlockLightBulb(int i, int j) {
		super(i, "lightbulb", Material.circuits, true);
		float f = 0.3F;
		setBlockBounds(0.5F - f, 0.3F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
		toDrop = LightBulb.unlitBulbID;
	}

	public int tickRate() {
		return 2;
	}

	public int getRenderType() {
		return 1;
	}

	public void onBlockAdded(World world, int i, int j, int k) {
		if (world.getBlockMetadata(i, j, k) == 0) {
			super.onBlockAdded(world, i, j, k);
		}
		updateTick(world, i, j, k, b);
	}

	public void updateTick(World world, int i, int j, int k, Random random) {
		if (world.getBlockId(i, j + 2, k) == Block.torchRedstoneActive.blockID || world.getBlockId(i, j + 1, k) == Block.torchRedstoneActive.blockID || world.isBlockIndirectlyGettingPowered(i, j, k) || world.isBlockIndirectlyGettingPowered(i, j + 1, k)) {
			world.setBlock(i, j, k, LightBulb.litBulbID);
		} else {
			world.setBlock(i, j, k, LightBulb.unlitBulbID);
		}
	}

	public void onNeighborBlockChange(World world, int i, int j, int k, int l) {
		super.onNeighborBlockChange(world, i, j, k, l);
		world.scheduleBlockUpdate(i, j, k, blockID, tickRate());
		h(world, i, j, k);
	}

	public int idDropped(int i, Random random, int par3) {
		return LightBulb.glassShard.itemID;
	}

	public int quantityDropped(Random random) {
		return 2 + random.nextInt(2);
	}

	public boolean canProvidePower() {
		return false;
	}

	public boolean canPlaceBlockAt(World world, int i, int j, int k) {
		int l = world.getBlockId(i, j + 1, k);
		return world.isBlockOpaqueCube(i, j + 1, k);
	}

	protected final void h(World world, int i, int j, int k) {
		if (!canBlockStay(world, i, j, k)) {
			toDrop = LightBulb.unlitBulbID;
			dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), 0);
			world.setBlock(i, j, k, 0);
		}
	}

	public boolean canBlockStay(World world, int i, int j, int k) {
		return canPlaceBlockAt(world, i, j, k);
	}

	public void registerIcons(IconRegister par1IconRegister) {
		if (blockID == LightBulb.unlitBulb.blockID) {
			this.blockIcon = par1IconRegister.registerIcon("LightBulbs:" + "unlitBulb");
		}
		if (blockID == LightBulb.litBulb.blockID) {
			this.blockIcon = par1IconRegister.registerIcon("LightBulbs:" + "litBulb");
		}
	}

	private boolean a;
	private BlockRedstoneWire wire;
	private IBlockAccess access;
	private Random b;
	private World myWorld;
	private int toDrop;
}
