package grim3212.chisel;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ChiselItem extends Item{

	public ChiselItem(int par1) {
		super(par1);
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	public void updateIcons(IconRegister par1IconRegister) {
		if (itemID == ChiselCore.IronOre.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Chisel:" + "iron");
		}
		if (itemID == ChiselCore.GoldOre.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Chisel:" + "gold");
		}
	}
}
