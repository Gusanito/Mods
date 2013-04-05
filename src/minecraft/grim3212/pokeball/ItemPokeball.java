package grim3212.pokeball;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPokeball extends ItemEgg {

   public ItemPokeball(int var1) {
      super(var1);
      this.maxStackSize = 1;
      this.setMaxDamage(1000000);
      this.setCreativeTab(CreativeTabs.tabMisc);
   }

   public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
	   if (!var3.capabilities.isCreativeMode)
       {
           --var1.stackSize;
       }
	   
      var2.playSoundAtEntity(var3, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
      
      if(!var2.isRemote) {
         var2.spawnEntityInWorld(new EntityPokeball(var2, var3, var1.getItemDamage()));
      }

      return var1;
   }
   
   public void updateIcons(IconRegister par1IconRegister) {
		iconIndex = par1IconRegister.registerIcon("Pokeball:pokeball");
	}
}
