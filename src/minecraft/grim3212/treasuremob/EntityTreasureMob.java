// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package grim3212.treasuremob;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

// Referenced classes of package net.minecraft.src:
//            EntityAnimal, Item, World, NBTTagCompound

public class EntityTreasureMob extends EntityAnimal
{

    public EntityTreasureMob(World world)
    {
        super(world);
        texture = "/mods/TreasureMob/textures/mobs/TreasureMob.png";
        setSize(0.9F, 1.3F);
        health = 40;
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
    }

    protected void dropFewItems(boolean par1, int par2)
    {
        int i = rand.nextInt(14);
        if(i == 0)
        {
            dropItem(Item.arrow.itemID, 1);
        }
        if(i == 1)
        {
            dropItem(Item.ingotGold.itemID, 2);
        }
        if(i == 2)
        {
            dropItem(Item.appleRed.itemID, 1);
        }
        if(i == 3)
        {
            dropItem(Item.slimeBall.itemID, 6);
        }
        if(i == 4)
        {
            dropItem(Item.saddle.itemID, 1);
        }
        if(i == 5)
        {
            dropItem(Item.cake.itemID, 1);
        }
        if(i == 6)
        {
            dropItem(Item.cookie.itemID, 4);
        }
        if(i == 7)
        {
            dropItem(Item.diamond.itemID, 6);
        }
        if(i == 8)
        {
            dropItem(Item.silk.itemID, 2);
        }
        if(i == 9)
        {
            dropItem(Item.ingotIron.itemID, 4);
        }
        if(i == 10)
        {
            dropItem(Item.helmetLeather.itemID, 1);
        }
        if(i == 11)
        {
            dropItem(Item.wheat.itemID, 4);
        }
        if(i == 12)
        {
            dropItem(Item.bread.itemID, 1);
        }
        if(i == 13)
        {
            dropItem(Item.coal.itemID, 10);
        }
        if(i == 14)
        {
            dropItem(Item.redstone.itemID, 20);
        }
    }

	public EntityAnimal spawnBabyAnimal(EntityAnimal var1) {
		return null;
	}

	public int getMaxHealth() {
		return this.health;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		return null;
	}
}
