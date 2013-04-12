package grim3212.raygun;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockElement extends Block {

   protected BlockElement(int var1, int var2) {
      super(var1, Material.rock);
   }

   public int idDropped(int var1, Random var2, int var3) {
      return Raygun.elemItem.itemID;
   }

   public int quantityDropped(Random var1) {
      return 3 + var1.nextInt(2);
   }
   
   public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("Raygun:" + "element115");
	}
}
