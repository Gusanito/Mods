package grim3212.nuclearcraft;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class NC_GenericItem extends Item{

	protected NC_GenericItem(int par1) {
		super(par1);
	}
	
	public void updateIcons(IconRegister par1IconRegister) {
		if (itemID == NuclearCraft.iron_parts.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("NuclearCraft:" + "iron_parts");
		}
		if (itemID == NuclearCraft.reactor_core_case.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("NuclearCraft:" + "reactor_core_case");
		}
		if (itemID == NuclearCraft.reactor_core.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("NuclearCraft:" + "reactor_core");
		}
		if (itemID == NuclearCraft.graphite_rod.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("NuclearCraft:" + "graphite_rod");
		}
		if (itemID == NuclearCraft.graphite.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("NuclearCraft:" + "graphite");
		}
		if (itemID == NuclearCraft.refined_plutonium.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("NuclearCraft:" + "refined_plutonium");
		}
		if (itemID == NuclearCraft.plutonium_ingot.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("NuclearCraft:" + "plutonium_ingot");
		}
		if (itemID == NuclearCraft.refined_uranium.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("NuclearCraft:" + "refined_uranium");
		}
		if (itemID == NuclearCraft.uranium_ingot.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("NuclearCraft:" + "uranium_ingot");
		}
    }

}
