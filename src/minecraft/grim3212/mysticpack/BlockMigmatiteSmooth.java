package grim3212.mysticpack;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockMigmatiteSmooth extends Block
{
    protected BlockMigmatiteSmooth(int i, int j)
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
        return MysticStones.migmatite.blockID;
    }

    public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("MysticPack:" + "migmatite_smooth");
	}
}
