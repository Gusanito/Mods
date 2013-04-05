// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package grim3212.workbenchup;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

// Referenced classes of package net.minecraft.src:
//            Block, Material, ModLoader, World, 
//            GuiCraftingDiamond, EntityPlayer

public class BlockDiamondWorkbench extends Block
{
	@SideOnly(Side.CLIENT)
    private Icon sideIcon;
    @SideOnly(Side.CLIENT)
    private Icon topIcon;

    protected BlockDiamondWorkbench(int i)
    {
        super(i, Material.iron);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public Icon getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(i == 0)
        {
            return blockIcon;
        }
        if(i == 1)
        {
            return topIcon;
        } else
        {
            return sideIcon;
        }
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float a, float b, float c)
    {
    	if (world.isRemote)
        {
            return true;
        }
        else
        {
        player.openGui(WorkbenchUpgrades.instance, WorkbenchUpgrades.diamondGUI, world, x, y, z);
        return true;
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("WorkbenchUpgrades:bottomDiamond");
        this.topIcon = par1IconRegister.registerIcon("WorkbenchUpgrades:topDiamond");
        this.sideIcon = par1IconRegister.registerIcon("WorkbenchUpgrades:sideDiamond");
    }
}
