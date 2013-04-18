package grim3212.mysticpack;

import java.util.Random;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockReinforcedGlass extends BlockBreakable
{
    public BlockReinforcedGlass(int i, String j, Material material, boolean flag)
    {
        super(i, j, material, flag);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 2;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int i, Random random, int j)
    {
        return MysticOres.obsidianShard.itemID;
    }

    public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("MysticPack:" + "reinforced_glass");
	}
}
