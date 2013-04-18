package grim3212.mysticpack;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;

public class ItemMysticAxe extends ItemAxe {

	protected ItemMysticAxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(MysticOres.customTab);
	}

	public void updateIcons(IconRegister par1IconRegister) {
		if (itemID == MysticOres.verditeAxe.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "verdite_axe");
		}
		if (itemID == MysticOres.mithrilAxe.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "mithril_axe");
		}
		if (itemID == MysticOres.adamantineAxe.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "adamantine_axe");
		}
		if (itemID == MysticOres.bloodstoneAxe.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "bloodstone_axe");
		}
		if (itemID == MysticOres.obsidianAxe.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "obsidian_axe");
		}
		if (itemID == MysticOres.iridiumAxe.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "iridium_axe");
		}
	}
}
