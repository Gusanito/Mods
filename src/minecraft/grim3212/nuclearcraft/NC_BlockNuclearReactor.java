// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package grim3212.nuclearcraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess, World, 
//            EntityPlayer

public class NC_BlockNuclearReactor extends Block
{

    public NC_BlockNuclearReactor(int i, int j)
    {
        super(i, Material.circuits);
        on = true;
    }

    public boolean isIndirectlyPoweringTo(World world, int i, int j, int k, int l)
    {
        if(l == 0)
        {
            return isPoweringTo(world, i, j, k, l);
        } else
        {
            return false;
        }
    }

    public boolean canProvidePower()
    {
        return true;
    }

    public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(on)
        {
            on = false;
        } else
        {
            on = true;
        }
    }

    public boolean isPoweringTo(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(!on)
        {
            return false;
        }
        int i1 = iblockaccess.getBlockMetadata(i, j, k);
        if(i1 == 5 && l == 1)
        {
            return false;
        }
        if(i1 == 3 && l == 3)
        {
            return false;
        }
        if(i1 == 4 && l == 2)
        {
            return false;
        }
        if(i1 == 1 && l == 5)
        {
            return false;
        } else
        {
            return i1 != 2 || l != 4;
        }
    }

    public int idDropped(int i, Random random, int j)
    {
        return blockID;
    }
    
    public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("NuclearCraft:" + "nuclearReactor");
	}
    
    boolean on;
}
