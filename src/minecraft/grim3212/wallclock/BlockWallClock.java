package grim3212.wallclock;

import java.util.Random;

import cpw.mods.fml.client.FMLClientHandler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWallClock extends Block 
{
    protected BlockWallClock(int i, int j)
    {
        super(i, Material.circuits);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
    }

    public int idDropped(int i, Random random, int j)
    {
        return WallClock.WallClockItem.itemID;
    }
    
    public void registerIcons(IconRegister par1IconRegister) {
    	FMLClientHandler.instance().getClient().renderEngine.textureMapBlocks.setTextureEntry("WallClock:" + "wallclockBlock", new TextureFXWallClock());
    	blockIcon = TextureFXWallClock.wallClockTexture;
	}

    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.getBlockMetadata(i, j, k);
        float f = 0.125F;
        if (l == 2)
        {
            setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        }
        if (l == 3)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        }
        if (l == 4)
        {
            setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        if (l == 5)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        }
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        super.getCollisionBoundingBoxFromPool(world, i, j, k);
        int l = world.getBlockMetadata(i, j, k);
        float f = 0.125F;
        if (l == 2)
        {
            setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        }
        if (l == 3)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        }
        if (l == 4)
        {
            setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        if (l == 5)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        }
        return super.getCollisionBoundingBoxFromPool(world, i, j, k);
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i, int j, int k)
    {
        super.getSelectedBoundingBoxFromPool(world, i, j, k);
        int l = world.getBlockMetadata(i, j, k);
        float f = 0.125F;
        if (l == 2)
        {
            setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        }
        if (l == 3)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        }
        if (l == 4)
        {
            setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        if (l == 5)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        }
        return super.getSelectedBoundingBoxFromPool(world, i, j, k);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public int getRenderType()
    {
        return super.getRenderType();
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        if (world.isBlockOpaqueCube(i - 1, j, k))
        {
            return true;
        }
        if (world.isBlockOpaqueCube(i + 1, j, k))
        {
            return true;
        }
        if (world.isBlockOpaqueCube(i, j, k - 1))
        {
            return true;
        }
        else
        {
            return world.isBlockOpaqueCube(i, j, k + 1);
        }
    }

    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
        int i1 = par1World.getBlockMetadata(par2, par3, par4);
        if ((i1 == 0 || par5 == 2) && par1World.isBlockOpaqueCube(par2, par3, par4 + 1))
        {
            i1 = 2;
        }
        if ((i1 == 0 || par5 == 3) && par1World.isBlockOpaqueCube(par2, par3, par4 - 1))
        {
            i1 = 3;
        }
        if ((i1 == 0 || par5 == 4) && par1World.isBlockOpaqueCube(par2 + 1, par3, par4))
        {
            i1 = 4;
        }
        if ((i1 == 0 || par5 == 5) && par1World.isBlockOpaqueCube(par2 - 1, par3, par4))
        {
            i1 = 5;
        }
        par1World.setBlockMetadataWithNotify(par2, par3, par4, i1, 0);
        return i1;
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        int i1 = world.getBlockMetadata(i, j, k);
        boolean flag = false;
        if (i1 == 2 && world.isBlockOpaqueCube(i, j, k + 1))
        {
            flag = true;
        }
        if (i1 == 3 && world.isBlockOpaqueCube(i, j, k - 1))
        {
            flag = true;
        }
        if (i1 == 4 && world.isBlockOpaqueCube(i + 1, j, k))
        {
            flag = true;
        }
        if (i1 == 5 && world.isBlockOpaqueCube(i - 1, j, k))
        {
            flag = true;
        }
        if (!flag)
        {
            dropBlockAsItem(world, i, j, k, i1, 0);
            world.setBlock(i, j, k, 0);
        }
        super.onNeighborBlockChange(world, i, j, k, l);
    }
}
