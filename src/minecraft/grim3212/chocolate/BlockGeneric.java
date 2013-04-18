package grim3212.chocolate;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockGeneric extends Block {

	public BlockGeneric(int par1, Material par2Material) {
		super(par1, par2Material);
	}

	public void registerIcons(IconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("Chocolate:" + "chocolate_block");
	}

}
