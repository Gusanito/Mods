package grim3212.codknives;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class GenericItem extends Item {

	public GenericItem(int par1) {
		super(par1);
	}

	public void updateIcons(IconRegister par1IconRegister) {
		if (itemID == Knives.grip.itemID) {
			iconIndex = par1IconRegister.registerIcon("CodKnives:grip");
		}
		if (itemID == Knives.Bknife.itemID) {
			iconIndex = par1IconRegister.registerIcon("CodKnives:bknife");
		}
	}

}
