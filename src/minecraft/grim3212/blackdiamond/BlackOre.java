// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package grim3212.blackdiamond;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

// Referenced classes of package net.minecraft.src:
//            Block, Material

public class BlackOre extends Block
{

    protected BlackOre(int i, int j)
    {
        super(i, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("BlackDiamond:" + "blackOre");
	}
}
