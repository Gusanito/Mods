package grim3212.blackdiamond;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class BlackGeneric extends Item {

	protected BlackGeneric(int par1) {
		super(par1);
	}

	public void updateIcons(IconRegister par1IconRegister) {
		if (itemID == BlackDiamond.deskItem.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("BlackDiamond:" + "blackDiamond");
		}
		if (itemID == BlackDiamond.whiteItem.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("BlackDiamond:" + "whiteDiamond");
		}
	}

}
