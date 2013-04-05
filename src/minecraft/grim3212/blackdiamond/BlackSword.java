package grim3212.blackdiamond;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class BlackSword extends ItemSword {
	public BlackSword(int itemID, EnumToolMaterial toolMaterial) {
		super(itemID, toolMaterial);
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	public void updateIcons(IconRegister par1IconRegister) {
		this.iconIndex = par1IconRegister.registerIcon("BlackDiamond:" + "blackSword");
	}
}