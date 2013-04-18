package grim3212.mysticpack;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockVines extends Block
{
    protected BlockVines(int i, int j)
    {
        super(i, Material.plants);
        float f = 0.375F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
        setTickRandomly(true);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if (world.isAirBlock(i, j - 1, k) && world.isAirBlock(i, j - 2, k))
        {
            int l;

            for (l = 1; world.getBlockId(i, j - l, k) == blockID; l++) { }

            if (l < 6)
            {
                int i1 = world.getBlockMetadata(i, j, k);

                if (i1 == 15)
                {
                    world.setBlock(i, j - 1, k, blockID);
                    world.setBlock(i, j, k, 0);
                }
                else
                {
                    world.setBlockMetadataWithNotify(i, j, k, i1 + 1, i1);
                }
            }
        }
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        int l = world.getBlockId(i, j + 1, k);

        if (l == blockID)
        {
            return true;
        }
        else
        {
            return l == Block.grass.blockID || l == Block.dirt.blockID || l == Block.leaves.blockID || l == Block.stone.blockID;
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        checkBlockCoordValid(world, i, j, k);
    }

    protected final void checkBlockCoordValid(World world, int i, int j, int k)
    {
        if (!canBlockStay(world, i, j, k))
        {
            world.setBlock(i, j, k, 0);
        }
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World world, int i, int j, int k)
    {
        return canPlaceBlockAt(world, i, j, k);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 1;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return random.nextInt(6);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int i, Random random, int j)
    {
        j = random.nextInt(44);

        if (j == 0)
        {
            return MysticRuins.vinesStrand.itemID;
        }

        if (j == 1)
        {
            return MysticRuins.vinesStrand.itemID;
        }

        if (j == 2)
        {
            return MysticRuins.vinesStrand.itemID;
        }

        if (j == 3)
        {
            return Item.stick.itemID;
        }

        if (j == 4)
        {
            return Item.stick.itemID;
        }

        if (j == 5)
        {
            return Item.stick.itemID;
        }

        if (j == 6)
        {
            return Item.stick.itemID;
        }
        else
        {
            return -1;
        }
    }

    public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("MysticPack:" + "vines");
	}
}
