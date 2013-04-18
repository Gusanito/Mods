package grim3212.mysticpack;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;

public class ItemMysticSpade extends ItemSpade
{
	public ItemMysticSpade(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, par2EnumToolMaterial);
        this.setCreativeTab(MysticOres.customTab);
    }

	public void updateIcons(IconRegister par1IconRegister) {
		if (itemID == MysticOres.verditeShovel.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "verdite_spade");
		}
		if (itemID == MysticOres.mithrilShovel.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "mithril_spade");
		}
		if (itemID == MysticOres.adamantineShovel.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "adamantine_spade");
		}
		if (itemID == MysticOres.bloodstoneShovel.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "bloodstone_spade");
		}
		if (itemID == MysticOres.obsidianShovel.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "obsidian_spade");
		}
		if (itemID == MysticOres.iridiumShovel.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "iridium_spade");
		}
	}
}
