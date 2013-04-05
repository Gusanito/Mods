package grim3212.codknives;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItembKnife extends Item {

   public ItembKnife(int var1) {
      super(var1);
      this.maxStackSize = 1;
   }

   public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
      if(var3.inventory.consumeInventoryItem(Knives.Bknife.itemID)) {
         var2.playSoundAtEntity(var3, "random.wood click", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
         return new ItemStack(Knives.bknifefull);
      } else {
         return var1;
      }
   }
   
   public void updateIcons(IconRegister par1IconRegister) {
		iconIndex = par1IconRegister.registerIcon("CodKnives:bknife_empty");
	}
}
