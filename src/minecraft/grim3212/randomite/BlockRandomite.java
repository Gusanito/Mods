package grim3212.randomite;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class BlockRandomite extends Block {

	protected BlockRandomite(int var1, int var2) {
		super(var1, Material.rock);
	}

	public int idDropped(int var1, Random var2, int var3) {
		int var4 = var2.nextInt(50);
		return var4 > 0 && var4 < 18 ? Item.coal.itemID : (var4 > 18 && var4 < 31 ? Block.oreIron.blockID : (var4 > 31 && var4 < 35 ? Block.oreGold.blockID : (var4 > 35 && var4 < 38 ? Item.diamond.itemID : (var4 > 35 && var4 < 38 ? Item.emerald.itemID : (var4 > 38 && var4 < 48 ? Item.redstone.itemID : Item.egg.itemID)))));
	}

	public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("Randomite:" + "randomite");
	}
}
