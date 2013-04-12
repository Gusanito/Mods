// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package grim3212.elemental;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockElemental extends Block {
	@SideOnly(Side.CLIENT)
	private Icon field_94458_cO;

	protected BlockElemental(int i, int j, String s) {
		super(i, Material.rock);
		topTexture = j;
		soundPowderFootstep = s;
	}

	public void registerIcons(IconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("ElementalBlocks:elementalSide");
		if (soundPowderFootstep == "fire") {
			this.field_94458_cO = par1IconRegister.registerIcon("ElementalBlocks:elementalFire");
		}
		if (soundPowderFootstep == "lava") {
			this.field_94458_cO = par1IconRegister.registerIcon("ElementalBlocks:elementalLava");
		}
		if (soundPowderFootstep == "water") {
			this.field_94458_cO = par1IconRegister.registerIcon("ElementalBlocks:elementalWater");
		}
	}

	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		if(par1 == 1){
			return field_94458_cO;
		}
		if(par1 == 0){
			return blockIcon;
		}else{
			return blockIcon;
		}
	}

	public int tickRate() {
		return 1;
	}

	public void onBlockAdded(World world, int i, int j, int k) {
		if (world.getBlockMetadata(i, j, k) == 0) {
			super.onBlockAdded(world, i, j, k);
		}
		updateTick(world, i, j, k, b);
	}

	public void updateTick(World world, int i, int j, int k, Random random) {
		if (world.isBlockIndirectlyGettingPowered(i, j, k)) {
			if (world.getBlockId(i, j + 1, k) == 0) {
				if (soundPowderFootstep == "water") {
					world.setBlock(i, j + 1, k, Block.waterStill.blockID);
				} else if (soundPowderFootstep == "fire") {
					world.setBlock(i, j + 1, k, Block.fire.blockID);
				} else if (soundPowderFootstep == "lava") {
					world.setBlock(i, j + 1, k, Block.lavaStill.blockID);
				}
			}
		} else if (world.getBlockId(i, j + 1, k) == 8 || world.getBlockId(i, j + 1, k) == 9 || world.getBlockId(i, j + 1, k) == 10 || world.getBlockId(i, j + 1, k) == 11 || world.getBlockId(i, j + 1, k) == Block.fire.blockID) {
			world.setBlock(i, j + 1, k, 0);
		}
	}

	public void onNeighborBlockChange(World world, int i, int j, int k, int l) {
		super.onNeighborBlockChange(world, i, j, k, l);
		world.scheduleBlockUpdate(i, j, k, blockID, tickRate());
	}

	public boolean canProvidePower() {
		return false;
	}

	public boolean canPlaceBlockAt(World world, int i, int j, int k) {
		int l = world.getBlockId(i, j + 1, k);
		if (l == 0) {
			return true;
		}
		return l == 8 || l == 9 || l == 10 || l == 11 || l == Block.fire.blockID;
	}

	protected final void h(World world, int i, int j, int k) {
		if (!canBlockStay(world, i, j, k)) {
			dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), 0);
			world.setBlock(i, j, k, 0);
		}
	}

	public boolean canBlockStay(World world, int i, int j, int k) {
		return canPlaceBlockAt(world, i, j, k);
	}

	private boolean a;
	private BlockRedstoneWire wire;
	private IBlockAccess access;
	private Random b;
	private World myWorld;
	private int toDrop;
	private String soundPowderFootstep;
	private int topTexture;
}
