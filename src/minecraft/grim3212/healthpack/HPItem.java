package grim3212.healthpack;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class HPItem extends Item {

	protected HPItem(int par1) {
		super(par1);
	}

	public void updateIcons(IconRegister par1IconRegister) {
		this.iconIndex = par1IconRegister.registerIcon("HealthPack:" + "sugar");
	}

}
