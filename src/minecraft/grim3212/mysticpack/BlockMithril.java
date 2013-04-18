package grim3212.mysticpack;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockMithril extends Block
{
    protected BlockMithril(int i, int j, Material material)
    {
        super(i, material);
    }

    public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("MysticPack:" + "mithril");
	}
}
