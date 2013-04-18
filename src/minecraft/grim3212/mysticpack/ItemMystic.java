package grim3212.mysticpack;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemMystic extends Item {
	protected ItemMystic(int i) {
		super(i);
		setCreativeTab(MysticOres.customTab);
	}

	public void updateIcons(IconRegister par1IconRegister) {
		if (itemID == MysticOres.mithrilIngot.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "mithril_ingot");
		}
		if (itemID == MysticOres.adamantineIngot.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "adamantine_ingot");
		}
		if (itemID == MysticOres.verditeIngot.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "verdite_ingot");
		}
		if (itemID == MysticOres.emeraldGem.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "emerald_gem");
		}
		if (itemID == MysticOres.sapphireGem.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "sapphire_gem");
		}
		if (itemID == MysticOres.topazGem.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "topaz_gem");
		}
		if (itemID == MysticOres.amethystGem.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "amethyst_gem");
		}
		if (itemID == MysticOres.obsidianShard.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "obsidian_shard");
		}
		if (itemID == MysticOres.obsidianRod.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "obsidian_rod");
		}
		if (itemID == MysticOres.glassShard.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "glass_shard");
		}
		if (itemID == MysticOres.bloodstoneShard.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "bloodstone_shard");
		}
		if (itemID == MysticOres.iridiumIngot.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "iridium_ingot");
		}
		if (itemID == MysticOres.iridiumNugget.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "iridium_nugget");
		}
		if (itemID == MysticOres.mysticPowder.itemID) {
			iconIndex = par1IconRegister.registerIcon("MysticPack:" + "mystic_powder");
		}
	}
}
