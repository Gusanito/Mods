// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package grim3212.healthpack;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


// Referenced classes of package net.minecraft.src:
//            Item, EntityPlayer, ItemStack, World

public class ItemHealthPack extends Item
{

    public ItemHealthPack(int i, int j)
    {
        super(i);
        healAmount = j;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if(entityplayer.getHealth() < 20)
        {
            itemstack.stackSize--;
            entityplayer.heal(healAmount);
        }
        return itemstack;
    }

    public int getHealAmount()
    {
        return healAmount;
    }
    
    public void updateIcons(IconRegister par1IconRegister)
    {
    	if(itemID == HealthPack.bandage.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("HealthPack:" + "bandage");
    	}
    	if(itemID == HealthPack.healthP1.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("HealthPack:" + "health_pack");
    	}
    	if(itemID == HealthPack.healthP2.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("HealthPack:" + "health_pack2");
    	}
    }

    private int healAmount;
}
