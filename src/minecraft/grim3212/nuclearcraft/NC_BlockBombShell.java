// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package grim3212.nuclearcraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

// Referenced classes of package net.minecraft.src:
//            Block, Material

public class NC_BlockBombShell extends Block
{

    public NC_BlockBombShell(int i, int j)
    {
        super(i, Material.iron);
    }
    
    public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("NuclearCraft:" + "bombShell");
	}
}
