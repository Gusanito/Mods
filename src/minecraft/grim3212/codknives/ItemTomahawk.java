package grim3212.codknives;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTomahawk extends Item {

   public ItemTomahawk(int var1) {
      super(var1);
      this.maxStackSize = 2;
   }

   public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
      --var1.stackSize;
      var2.playSoundAtEntity(var3, "random.wood click", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
      if(!var2.isRemote) {
         var2.spawnEntityInWorld(new EntityTomahawk(var2, var3));
      }

      return var1;
   }
   
   public void updateIcons(IconRegister par1IconRegister) {
		iconIndex = par1IconRegister.registerIcon("CodKnives:tomahawk");
	}
}
