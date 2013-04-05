package grim3212.healthpack;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class HPItemFood extends ItemFood{

	public HPItemFood(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
	}
	
	public void updateIcons(IconRegister par1IconRegister)
    {
    	if(itemID == HealthPack.sweets.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("HealthPack:" + "sweets");
    	}
    	if(itemID == HealthPack.poweredSweets.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("HealthPack:" + "powered_sweets");
    	}
    }

}
