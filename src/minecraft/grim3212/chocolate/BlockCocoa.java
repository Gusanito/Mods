package grim3212.chocolate;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockCocoa extends Block
{
    protected BlockCocoa(int i, int j)
    {
        super(i, Material.circuits);
        float f = 0.1F;
        setBlockBounds(0.5F - f, 0.3F, 0.5F - f, 0.7F + f, 1.0F, 0.7F + f);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }

    public int idDropped(int i, Random random, int j)
    {
        return Chocolate.CocoaFruit.itemID;
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        int l = world.getBlockId(i, j + 1, k);
        return l == 18;
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        h(world, i, j, k);
    }

    protected final void h(World world, int i, int j, int k)
    {
        if (!canBlockStay(world, i, j, k))
        {
            dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), 0);
            world.setBlock(i, j, k, 0);
        }
    }

    public boolean canBlockStay(World world, int i, int j, int k)
    {
        return canPlaceBlockAt(world, i, j, k);
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("Chocolate:cocoa_block");
    }

    public boolean isOpaqueCube()
    {
        return false;
    }
}
