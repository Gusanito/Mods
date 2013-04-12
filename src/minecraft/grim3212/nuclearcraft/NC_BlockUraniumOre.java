// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package grim3212.nuclearcraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

// Referenced classes of package net.minecraft.src:
//            Block, Material, EntityPlayer, InventoryPlayer, 
//            ItemStack, Entity, World

public class NC_BlockUraniumOre extends Block
{

    public NC_BlockUraniumOre(int i, int j)
    {
        super(i, Material.iron);
    }

    public void onEntityWalking(World world, int i, int j, int k, Entity entity)
    {
        int l = 4;
        if(entity instanceof EntityPlayer)
        {
            if(((EntityPlayer)entity).inventory.armorItemInSlot(0) != null && ((EntityPlayer)entity).inventory.armorItemInSlot(0).itemID == 390)
            {
                l--;
            }
            if(((EntityPlayer)entity).inventory.armorItemInSlot(1) != null && ((EntityPlayer)entity).inventory.armorItemInSlot(1).itemID == 389)
            {
                l--;
            }
            if(((EntityPlayer)entity).inventory.armorItemInSlot(2) != null && ((EntityPlayer)entity).inventory.armorItemInSlot(2).itemID == 388)
            {
                l--;
            }
            if(((EntityPlayer)entity).inventory.armorItemInSlot(3) != null && ((EntityPlayer)entity).inventory.armorItemInSlot(3).itemID == 387)
            {
                l--;
            }
        }
    }

    public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        int l = 4;
        if(entityplayer.inventory.armorItemInSlot(3) != null && entityplayer.inventory.armorItemInSlot(3).itemID == NuclearCraft.rs_helmet.itemID)
        {
            l--;
        }
        if(entityplayer.inventory.armorItemInSlot(2) != null && entityplayer.inventory.armorItemInSlot(2).itemID == NuclearCraft.rs_chest.itemID)
        {
            l--;
        }
        if(entityplayer.inventory.armorItemInSlot(1) != null && entityplayer.inventory.armorItemInSlot(1).itemID == NuclearCraft.rs_legs.itemID)
        {
            l--;
        }
        if(entityplayer.inventory.armorItemInSlot(0) != null && entityplayer.inventory.armorItemInSlot(0).itemID == NuclearCraft.rs_boots.itemID)
        {
            l--;
        }
        if(l != 0)
        {
            entityplayer.attackEntityFrom(DamageSource.magic, l);
        }
    }
    
    public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("NuclearCraft:" + "uraniumOre");
	}
}
