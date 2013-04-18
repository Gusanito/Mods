package grim3212.mysticpack.common;

import grim3212.mysticpack.MysticOres;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MysticTab extends CreativeTabs{

	public MysticTab(String label) {
		super(label);
	}
	
	@Override
	public ItemStack getIconItemStack() {
	    return new ItemStack(MysticOres.mysticPowder);
	}

}
