package grim3212.mysticpack;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;

public class ItemMysticHoe extends ItemHoe
{
	public ItemMysticHoe(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, par2EnumToolMaterial);
        this.setCreativeTab(MysticOres.customTab);
    }

	public void updateIcons(IconRegister par1IconRegister) {
		if (itemID == MysticOres.verditeHoe.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "verdite_hoe");
		}
		if (itemID == MysticOres.mithrilHoe.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "mithril_hoe");
		}
		if (itemID == MysticOres.adamantineHoe.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "adamantine_hoe");
		}
		if (itemID == MysticOres.bloodstoneHoe.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "bloodstone_hoe");
		}
		if (itemID == MysticOres.obsidianHoe.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "obsidian_hoe");
		}
		if (itemID == MysticOres.iridiumHoe.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "iridium_hoe");
		}
	}
}
