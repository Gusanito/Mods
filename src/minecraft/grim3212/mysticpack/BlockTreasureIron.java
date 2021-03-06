package grim3212.mysticpack;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class BlockTreasureIron extends Block
{
    protected BlockTreasureIron(int i, int j)
    {
        super(i, Material.wood);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return random.nextInt(4) + 6;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int i, Random random, int j)
    {
        j = random.nextInt(18);

        if (j == 0)
        {
            return Item.cookie.itemID;
        }

        if (j == 1)
        {
            return Item.cake.itemID;
        }

        if (j == 2)
        {
            return Item.appleRed.itemID;
        }

        if (j == 3)
        {
            return Block.blockSteel.blockID;
        }

        if (j == 4)
        {
            return Block.blockClay.blockID;
        }

        if (j == 5)
        {
            return Block.obsidian.blockID;
        }

        if (j == 6)
        {
            return Block.tnt.blockID;
        }

        if (j == 7)
        {
            return Block.brick.blockID;
        }

        if (j == 8)
        {
            return Block.slowSand.blockID;
        }
        else
        {
            return Item.ingotIron.itemID;
        }
    }

    public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("MysticPack:" + "treasure_iron");
	}
}
