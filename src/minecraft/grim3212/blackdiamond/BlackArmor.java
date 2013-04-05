package grim3212.blackdiamond;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class BlackArmor extends ItemArmor implements IArmorTextureProvider {

	public BlackArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
	}

	@Override
	public String getArmorTextureFile(ItemStack itemstack) {
		if (itemstack.itemID == BlackDiamond.blackHelmet.itemID || itemstack.itemID == BlackDiamond.blackPlate.itemID || itemstack.itemID == BlackDiamond.blackBoots.itemID) {
			return "/mods/BlackDiamond/textures/armor/blackarmor_1.png";
		}
		if (itemstack.itemID == BlackDiamond.blackLeggings.itemID) {
			return "/mods/BlackDiamond/textures/armor/blackarmor_2.png";
		}
		return "/mods/BlackDiamond/textures/armor/blackarmor_1.png";
	}
	
	public void updateIcons(IconRegister par1IconRegister)
    {
    	if(itemID == BlackDiamond.blackHelmet.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("BlackDiamond:" + "blackHelmet");
    	}
    	if(itemID == BlackDiamond.blackPlate.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("BlackDiamond:" + "blackPlate");
    	}
    	if(itemID == BlackDiamond.blackLeggings.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("BlackDiamond:" + "blackLeggings");
    	}
    	if(itemID == BlackDiamond.blackBoots.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("BlackDiamond:" + "blackBoots");
    	}
    }

}
