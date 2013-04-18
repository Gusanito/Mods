package grim3212.mysticpack;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class BlockSoulstoneBlack extends Block
{
    protected BlockSoulstoneBlack(int i, int j)
    {
        super(i, Material.rock);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return random.nextInt(3) + 1;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int i, Random random, int j)
    {
        j = random.nextInt(5);

        if (j == 0)
        {
            return Item.coal.itemID;
        }

        if (j == 1)
        {
            return Item.gunpowder.itemID;
        }

        if (j == 2)
        {
            return MysticOres.obsidianShard.itemID;
        }

        if (j == 3)
        {
            return MysticOres.glassShard.itemID;
        }

        if (j == 4)
        {
            return MysticOres.obsidianShard.itemID;
        }
        else
        {
            return blockID;
        }
    }

    public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("MysticPack:" + "soulstone_black");
	}
}
