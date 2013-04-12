package grim3212.raygun;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAdvRayg extends Item {

	public ItemAdvRayg(int var1) {
		super(var1);
		this.maxStackSize = 1;
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
		if (var3.inventory.consumeInventoryItem(Raygun.advrayeItem.itemID)) {
			var2.playSoundAtEntity(var3, "raysh", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!var2.isRemote) {
				var2.spawnEntityInWorld(new EntityAdvRayw(var2, var3));
				ItemStack var4 = new ItemStack(Raygun.advrayeeItem.itemID, 1, 0);
				var3.inventory.addItemStackToInventory(var4);
			}
		}

		return var1;
	}

	public void updateIcons(IconRegister par1IconRegister) {
		this.iconIndex = par1IconRegister.registerIcon("Raygun:" + "advRaygun");
	}
}
