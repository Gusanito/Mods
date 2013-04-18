package grim3212.chocolate;

import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class BlockCocoaSapling extends BlockFlower
{
    protected BlockCocoaSapling(int i, Material j)
    {
        super(i, j);
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        setTickRandomly(true);
        this.setCreativeTab(null);
    }

    public int idDropped(int i, Random random, int j)
    {
        return Chocolate.CocoaFruit.itemID;
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if (world.isRemote)
        {
            return;
        }
        super.updateTick(world, i, j, k, random);
        if (world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(5) == 0)
        {
            int l = world.getBlockMetadata(i, j, k);
            if (l < 15)
            {
                world.setBlockMetadataWithNotify(i, j, k, l + 1, 2);
            }
            else
            {
                c(world, i, j, k, random);
            }
        }
    }
    
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("Chocolate:cocoa_sapling");
    }

    public void c(World world, int i, int j, int k, Random random)
    {
        world.setBlock(i, j, k, 0);
        WorldGenCocoaTrees worldgencocoatrees = new WorldGenCocoaTrees();
        if (!worldgencocoatrees.generate(world, random, i, j, k))
        {
            world.setBlock(i, j, k, blockID);
        }
    }
}
