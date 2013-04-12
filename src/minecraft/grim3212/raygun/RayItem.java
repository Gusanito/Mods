package grim3212.raygun;

import grim3212.healthpack.HealthPack;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class RayItem extends Item{

	public RayItem(int par1) {
		super(par1);
	}
	
	public void updateIcons(IconRegister par1IconRegister)
    {
    	if(itemID == Raygun.rayeItem.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("Raygun:" + "energyCanister");
    	}
    	if(itemID == Raygun.elemItem.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("Raygun:" + "elementItem");
    	}
    	if(itemID == Raygun.rayeeItem.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("Raygun:" + "emptyCanister");
    	}
    	if(itemID == Raygun.advrayeeItem.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("Raygun:" + "advEmptyCanister");
    	}
    	if(itemID == Raygun.advrayeItem.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("Raygun:" + "advEnergyCanister");
    	}
    	if(itemID == Raygun.ingotIronDark.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("Raygun:" + "taintedIronIngot");
    	}
    }

}
