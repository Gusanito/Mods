// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package grim3212.nuclearcraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World

public class NC_BlockC4 extends Block
{

    public NC_BlockC4(int i, int j, int k)
    {
        super(i, Material.iron);
    }

    public Icon getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(i == 1)
        {
            return blockIcon;
        } else
        {
            return sideTexture;
        }
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        if(world.isBlockIndirectlyGettingPowered(i, j, k))
        {
            world.setBlock(i, j, k, 0);
            world.createExplosion(null, i, j, k, 7F, true);
        }
    }

    public void onBlockDestroyedByExplosion(World world, int i, int j, int k)
    {
        world.setBlock(i, j, k, 0);
        world.createExplosion(null, i, j, k, 7F, true);
    }

    public int idDropped(int i, Random random, int j)
    {
        return blockID;
    }
    
    public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("NuclearCraft:" + "blockC4");
		sideTexture = par1IconRegister.registerIcon("NuclearCraft:" + "sideBlockC4");
	}
    Icon sideTexture;
}
