// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package grim3212.ballistic;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

// Referenced classes of package net.minecraft.src:
//            Item, EntityBallisticKnife, ItemStack, World, 
//            mod_BallisticKnife, EntityPlayer, InventoryPlayer, Entity

public class ItemBallisticKnife extends Item {

	public ItemBallisticKnife(int i, boolean flag, int j) {
		super(i);
		a = 5;
		maxStackSize = 1;
		isLoaded = flag;
		isKnife = j;
	}

	public void updateIcons(IconRegister par1IconRegister) {
		if (itemID == BallisticKnife.loadedKnife.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("BallisticKnife:" + "loadedKnife");
		}
		if (itemID == BallisticKnife.unloadedKnife.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("BallisticKnife:" + "unloadedKnife");
		}
		if (itemID == BallisticKnife.ammoPart.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("BallisticKnife:" + "ammoPart");
		}
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if (isLoaded) {
			world.playSoundAtEntity(entityplayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isRemote) {
				world.spawnEntityInWorld(new EntityBallisticKnife(world, entityplayer, 2.0F));
			}
			return new ItemStack(BallisticKnife.unloadedKnife);
		}
		if (!isLoaded && isKnife == 1) {
			if (entityplayer.inventory.consumeInventoryItem(BallisticKnife.ammoPartID + 256)) {
				return new ItemStack(BallisticKnife.loadedKnife);
			} else {
				return itemstack;
			}
		} else {
			return itemstack;
		}
	}

	public int getDamageVsEntity(Entity entity) {
		return !isLoaded && isKnife != 0 ? 2 : 50;
	}

	private boolean isLoaded;
	private int a;
	private int isKnife;
}
