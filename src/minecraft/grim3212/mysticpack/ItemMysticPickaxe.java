package grim3212.mysticpack;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class ItemMysticPickaxe extends ItemPickaxe
{
	public ItemMysticPickaxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(MysticOres.customTab);
	}
	
	public void updateIcons(IconRegister par1IconRegister) {
		if (itemID == MysticOres.verditePick.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "verdite_pickaxe");
		}
		if (itemID == MysticOres.mithrilPick.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "mithril_pickaxe");
		}
		if (itemID == MysticOres.adamantinePick.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "adamantine_pickaxe");
		}
		if (itemID == MysticOres.bloodstonePick.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "bloodstone_pickaxe");
		}
		if (itemID == MysticOres.obsidianPick.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "obsidian_pickaxe");
		}
		if (itemID == MysticOres.iridiumPick.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "iridium_pickaxe");
		}
	}
}
