package grim3212.mysticpack;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class ItemMysticSword extends ItemSword
{
	public ItemMysticSword(int itemID, EnumToolMaterial toolMaterial) {
		super(itemID, toolMaterial);
		this.setCreativeTab(MysticOres.customTab);
	}

	public void updateIcons(IconRegister par1IconRegister) {
		if (itemID == MysticOres.verditeSword.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "verdite_sword");
		}
		if (itemID == MysticOres.mithrilSword.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "mithril_sword");
		}
		if (itemID == MysticOres.adamantineSword.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "adamantine_sword");
		}
		if (itemID == MysticOres.bloodstoneSword.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "bloodstone_sword");
		}
		if (itemID == MysticOres.obsidianSword.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "obsidian_sword");
		}
		if (itemID == MysticOres.iridiumSword.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "iridium_sword");
		}
	}
}
