package grim3212.mysticpack;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class BlockSoulstoneRed extends Block
{
    protected BlockSoulstoneRed(int i, int j)
    {
        super(i, Material.rock);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return random.nextInt(2) + 1;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int i, Random random, int j)
    {
        j = random.nextInt(7);

        if (j == 0)
        {
            return MysticOres.glassShard.itemID;
        }

        if (j == 1)
        {
            return Item.lightStoneDust.itemID;
        }

        if (j == 2)
        {
            return MysticOres.obsidianShard.itemID;
        }

        if (j == 3)
        {
            return Item.redstone.itemID;
        }

        if (j == 4)
        {
            return Item.gunpowder.itemID;
        }

        if (j == 5)
        {
            return MysticOres.mysticPowder.itemID;
        }

        if (j == 6)
        {
            return Block.obsidian.blockID;
        }
        else
        {
            return blockID;
        }
    }

    public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("MysticPack:" + "soulstone_red");
	}
}
