package grim3212.ballistic;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemGeneric extends Item {

	public ItemGeneric(int par1) {
		super(par1);
	}

	public void updateIcons(IconRegister par1IconRegister) {
		if (itemID == BallisticKnife.buttonPart.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("BallisticKnife:" + "buttonPart");
		}
		if (itemID == BallisticKnife.springPart.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("BallisticKnife:" + "springPart");
		}
		if (itemID == BallisticKnife.casingPart.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("BallisticKnife:" + "casingPart");
		}
		if (itemID == BallisticKnife.rodPart.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("BallisticKnife:" + "rodPart");
		}
	}

}
