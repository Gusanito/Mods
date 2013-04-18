package grim3212.mysticpack;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class BlockSoulstoneBlue extends Block
{
    protected BlockSoulstoneBlue(int i, int j)
    {
        super(i, Material.rock);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 1;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int i, Random random, int j)
    {
        j = random.nextInt(9);

        if (j == 0)
        {
            return MysticOres.emeraldGem.itemID;
        }

        if (j == 1)
        {
            return MysticOres.sapphireGem.itemID;
        }

        if (j == 2)
        {
            return MysticOres.topazGem.itemID;
        }

        if (j == 3)
        {
            return MysticOres.amethystGem.itemID;
        }

        if (j == 4)
        {
            return Item.diamond.itemID;
        }

        if (j == 5)
        {
            return MysticOres.iridiumNugget.itemID;
        }

        if (j == 6)
        {
            return Item.gunpowder.itemID;
        }

        if (j == 7)
        {
            return Block.obsidian.blockID;
        }

        if (j == 8)
        {
            return Item.lightStoneDust.itemID;
        }
        else
        {
            return blockID;
        }
    }

    public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("MysticPack:" + "soulstone_blue");
	}
}
