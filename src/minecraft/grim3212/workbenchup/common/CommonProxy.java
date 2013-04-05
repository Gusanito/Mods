package grim3212.workbenchup.common;

import grim3212.workbenchup.ContainerDiamondWorkbench;
import grim3212.workbenchup.ContainerIronWorkbench;
import grim3212.workbenchup.GuiCraftingDiamond;
import grim3212.workbenchup.GuiCraftingIron;
import grim3212.workbenchup.WorkbenchUpgrades;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {

	/**
	 * Client side only register stuff...
	 */
	public void registerRenderInformation() {
		// unused server side. -- see ClientProxy for implementation
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == WorkbenchUpgrades.ironGUI) {
			return new ContainerIronWorkbench(player.inventory, world, x, y, z);
		} else if (ID == WorkbenchUpgrades.diamondGUI) {
			return new ContainerDiamondWorkbench(player.inventory, world, x, y, z);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if (id == WorkbenchUpgrades.ironGUI) {
			return new GuiCraftingIron(player, world, x, y, z);
		} else if (id == WorkbenchUpgrades.diamondGUI) {
			return new GuiCraftingDiamond(player, world, x, y, z);
		}
		
		return null;
	}
}
