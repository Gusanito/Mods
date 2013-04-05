package grim3212.calendar;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCalendar extends BlockContainer
{
    private Class calEntityClass;

    protected BlockCalendar(int i, int j, Class class1)
    {
        super(i, Material.wood);
        calEntityClass = class1;
        float f = 0.25F;
        float f1 = 1.0F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i, int j, int k)
    {
        setBlockBoundsBasedOnState(world, i, j, k);
        return super.getSelectedBoundingBoxFromPool(world, i, j, k);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.getBlockMetadata(i, j, k);
        float f = 0.11F;
        float f1 = 0.935F;
        float f2 = 0.25F;
        float f3 = 0.75F;
        float f4 = 0.125F;
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        if (l == 2)
        {
            setBlockBounds(f2, f, 1.0F - f4, f3, f1, 1.0F);
        }
        if (l == 3)
        {
            setBlockBounds(f2, f, 0.0F, f3, f1, f4);
        }
        if (l == 4)
        {
            setBlockBounds(1.0F - f4, f, f2, 1.0F, f1, f3);
        }
        if (l == 5)
        {
            setBlockBounds(0.0F, f, f2, f4, f1, f3);
        }
    }

    public int getRenderType()
    {
        return -1;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public int idDropped(int i, Random random, int j)
    {
        return Calendar.calendarItem.itemID;
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        boolean flag = false;
        int i1 = world.getBlockMetadata(i, j, k);
        flag = true;
        if (i1 == 2 && world.getBlockMaterial(i, j, k + 1).isSolid())
        {
            flag = false;
        }
        if (i1 == 3 && world.getBlockMaterial(i, j, k - 1).isSolid())
        {
            flag = false;
        }
        if (i1 == 4 && world.getBlockMaterial(i + 1, j, k).isSolid())
        {
            flag = false;
        }
        if (i1 == 5 && world.getBlockMaterial(i - 1, j, k).isSolid())
        {
            flag = false;
        }
        if (flag)
        {
            dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), 0);
            world.setBlock(i, j, k, 0);
        }
        super.onNeighborBlockChange(world, i, j, k, l);
    }
    
    public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("Calendar:calendar");
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityCalendar();
	}
}
