package grim3212.chocolate;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemGeneric extends Item{

	public ItemGeneric(int par1) {
		super(par1);
	}
	
	public void updateIcons(IconRegister par1IconRegister) {
		this.iconIndex = par1IconRegister.registerIcon("Chocolate:" + "cocoa_dust");
	}
}
