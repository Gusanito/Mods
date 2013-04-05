package grim3212.slingshot;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSlingshot extends Item
{
    public static int x = 0;

    public ItemSlingshot(int var1)
    {
        super(var1);
        this.maxStackSize = 1;
    }

    public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
    {
        if (!var3.capabilities.isCreativeMode && !var3.inventory.hasItem(Slingshot.Slingpellet.itemID))
        {
            return var1;
        }
        else
        {
            var3.inventory.consumeInventoryItem(Slingshot.Slingpellet.itemID);
            var2.playSoundAtEntity(var3, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if (!var2.isRemote)
            {
                var2.spawnEntityInWorld(new EntitySlingpellet(var2, var3));
            }

            return var1;
        }
    }
    
    public void updateIcons(IconRegister par1IconRegister) {
		iconIndex = par1IconRegister.registerIcon("Slingshot:slingshot");
	}
}
