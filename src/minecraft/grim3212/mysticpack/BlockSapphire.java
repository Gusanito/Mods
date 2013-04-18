package grim3212.mysticpack;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockSapphire extends Block
{
    protected BlockSapphire(int i, int j)
    {
        super(i, Material.rock);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 1 + random.nextInt(2);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int i, Random random, int j)
    {
        j = random.nextInt(100);

        if (j <= 6)
        {
            return MysticOres.mysticPowder.itemID;
        }

        if (j >= 7)
        {
            return MysticOres.sapphireGem.itemID;
        }
        else
        {
            return blockID;
        }
    }

    public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("MysticPack:" + "sapphire");
	}
}
