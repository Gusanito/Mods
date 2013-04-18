package grim3212.cactuscraft;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class CactusItem extends Item{

	public CactusItem(int par1) {
		super(par1);
	}
	
	public void updateIcons(IconRegister par1IconRegister) {
		this.iconIndex = par1IconRegister.registerIcon("CactusCraft:" + "stick");
	}

}
