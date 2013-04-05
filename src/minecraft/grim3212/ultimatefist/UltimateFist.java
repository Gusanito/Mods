// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package grim3212.ultimatefist;

import grim3212.ultimatefist.common.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

// Referenced classes of package net.minecraft.src:
//            Item, ItemStack, Block, EntityLiving, 
//            Entity

public class UltimateFist extends Item {

	public UltimateFist(int i) {
		super(i);
		maxStackSize = 1;
	}

	public boolean canHarvestBlock(Block block) {
		return true;
	}

	public float getStrVsBlock(ItemStack itemstack, Block block) {
		return 64F;
	}

	public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1) {
		itemstack.damageItem(2, entityliving1);
		return true;
	}

	public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving) {
		itemstack.damageItem(1, entityliving);
		return true;
	}

	public int getDamageVsEntity(Entity entity) {
		return 1561;
	}

	public boolean isFull3D() {
		return true;
	}

	public void updateIcons(IconRegister par1IconRegister) {
		iconIndex = par1IconRegister.registerIcon("UltimateFist:UltimateFist");
	}
}
