// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package grim3212.soda;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

// Referenced classes of package net.minecraft.src:
//            Item

public class ItemSodaBottle extends Item {
	public static final String[] dyeColorNames = new String[] { "Apple Soda", "Soda Bottle", "Slurm", "Co2", "Golden Apple Soda", "Spiked Orange Soda", "Root Beer", "Cream Orange Soda", "Diamond Soda", "Orange Soda", "Cocoa Soda", "Carbonated Water", "Mushroom Soda" };
	public static final String[] field_94595_b = new String[] { "appleSoda", "sodaBottle", "slurm", "co2", "goldenappleSoda", "spikedorangeSoda", "rootBeer", "creamorangeSoda", "diamondSoda", "orangeSoda", "cocoaSoda", "carbonatedWater", "mushroomSoda" };
	@SideOnly(Side.CLIENT)
	private Icon[] field_94594_d;

	public ItemSodaBottle(int i) {
		super(i);
		maxStackSize = 16;
		setHasSubtypes(true);
		setMaxDamage(0);
		this.setCreativeTab(CreativeTabs.tabFood);
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if (itemstack.getItemDamage() == 0) {
			entityplayer.heal(10);
		} 
		if (itemstack.getItemDamage() == 2) {
			entityplayer.heal(3);
		}
		if (itemstack.getItemDamage() == 4) {
			entityplayer.heal(20);
		}
		if (itemstack.getItemDamage() == 5) {
			entityplayer.heal(-8);
		}
		if (itemstack.getItemDamage() == 6) {
			entityplayer.heal(5);
		}
		if (itemstack.getItemDamage() == 7) {
			entityplayer.heal(10);
		}
		if (itemstack.getItemDamage() == 8) {
			entityplayer.heal(20);
		}
		if (itemstack.getItemDamage() == 9) {
			entityplayer.heal(8);
		}
		if (itemstack.getItemDamage() == 10) {
			entityplayer.heal(14);
		}
		if (itemstack.getItemDamage() == 11) {
			entityplayer.heal(2);
		}
		if (itemstack.getItemDamage() == 12) {
			entityplayer.heal(5);
		}else {
			entityplayer.heal(0);
		}
		itemstack.stackSize--;
		return itemstack;
	}

	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1) {
		int j = MathHelper.clamp_int(par1, 0, 13);
		return this.field_94594_d[j];
	}

	public String getUnlocalizedName(ItemStack par1ItemStack) {
		int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 13);
		return super.getUnlocalizedName() + "." + dyeColorNames[i];
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int j = 0; j < 13; ++j) {
			par3List.add(new ItemStack(par1, 1, j));
		}
	}

	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister par1IconRegister) {
		this.field_94594_d = new Icon[field_94595_b.length];

		for (int i = 0; i < field_94595_b.length; ++i) {
			this.field_94594_d[i] = par1IconRegister.registerIcon("Soda:" + field_94595_b[i]);
		}
	}
}
