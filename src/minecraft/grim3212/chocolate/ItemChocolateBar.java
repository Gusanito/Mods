package grim3212.chocolate;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemChocolateBar extends ItemFood
{
    private int field_35430_a;
    private int itemRand;

    public ItemChocolateBar(int i, int j, int k)
    {
        super(i, j, true);
        itemRand = k;
        field_35430_a = j;
        maxStackSize = 16;
    }
    
    public void updateIcons(IconRegister par1IconRegister) {
		if (itemID == Chocolate.ChocolateBar.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Chocolate:" + "chocolate_bar");
		}
		if (itemID == Chocolate.ChocolateBarWraped.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Chocolate:" + "chocolate_wrap");
		}
		if (itemID == Chocolate.ChocolateBall.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Chocolate:" + "chocolate_ball");
		}
	}
}
