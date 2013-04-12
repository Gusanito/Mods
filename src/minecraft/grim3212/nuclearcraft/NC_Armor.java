package grim3212.nuclearcraft;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class NC_Armor extends ItemArmor implements IArmorTextureProvider {

	public NC_Armor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
	}

	@Override
	public String getArmorTextureFile(ItemStack itemstack) {
		if (itemstack.itemID == NuclearCraft.rs_helmet.itemID || itemstack.itemID == NuclearCraft.rs_chest.itemID || itemstack.itemID == NuclearCraft.rs_boots.itemID) {
			return "/mods/NuclearCraft/textures/armor/nucleararmor_1.png";
		}
		if (itemstack.itemID == NuclearCraft.rs_legs.itemID) {
			return "/mods/NuclearCraft/textures/armor/nucleararmor_2.png";
		}
		return "/mods/NuclearCraft/textures/armor/nucleararmor_1.png";
	}

	public void updateIcons(IconRegister par1IconRegister) {
		if (itemID == NuclearCraft.rs_boots.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("NuclearCraft:" + "rs_boots");
		}
		if (itemID == NuclearCraft.rs_legs.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("NuclearCraft:" + "rs_legs");
		}
		if (itemID == NuclearCraft.rs_chest.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("NuclearCraft:" + "rs_chest");
		}
		if (itemID == NuclearCraft.rs_helmet.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("NuclearCraft:" + "rs_helmet");
		}
	}

}
