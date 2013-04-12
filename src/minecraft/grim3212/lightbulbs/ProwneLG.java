package grim3212.lightbulbs;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ProwneLG extends Item{

	protected ProwneLG(int par1) {
		super(par1);
	}
	
	public void updateIcons(IconRegister par1IconRegister) {
		this.iconIndex = par1IconRegister.registerIcon("LightBulbs:" + "glassShard");
	}

}
