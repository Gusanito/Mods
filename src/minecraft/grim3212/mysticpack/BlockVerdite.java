package grim3212.mysticpack;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockVerdite extends Block
{
    protected BlockVerdite(int i, int j)
    {
        super(i, Material.rock);
    }

    public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("MysticPack:" + "verdite");
	}
}
