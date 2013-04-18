package grim3212.mysticpack;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockMigmatite extends Block
{
    protected BlockMigmatite(int i, int j)
    {
        super(i, Material.rock);
    }

    public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("MysticPack:" + "migmatite");
	}
}
