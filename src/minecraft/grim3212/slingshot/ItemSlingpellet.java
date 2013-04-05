package grim3212.slingshot;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemSlingpellet extends Item
{
    public ItemSlingpellet(int var1)
    {
        super(var1);
        this.maxStackSize = 64;
    }
    
    public void updateIcons(IconRegister par1IconRegister) {
		iconIndex = par1IconRegister.registerIcon("Slingshot:slingpellet");
	}
}
