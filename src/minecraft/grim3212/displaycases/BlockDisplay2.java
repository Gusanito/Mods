package grim3212.displaycases;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockDisplay2 extends BlockDisplay
{
    public BlockDisplay2(int i, Block block)
    {
        super(i, block);
    }
    

    public boolean isOpaqueCube()
    {
        return false;
    }

    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
    {
        int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        int i1 = world.getBlockMetadata(i, j, k) & 0xc;
        if (l == 0)
        {
            i1 |= 2;
        }
        if (l == 1)
        {
            i1 |= 1;
        }
        if (l == 2)
        {
            i1 |= 3;
        }
        if (l == 3)
        {
            i1 |= 0;
        }
        world.setBlock(i, j, k, i1);
    }

    public int damageDropped(int i)
    {
        return i & 0xc;
    }
    
    public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("DisplayCases:ironDisplay");
	}
}
