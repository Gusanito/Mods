package grim3212.displaycases.common;

import grim3212.displaycases.CraftingInventoryDisplayCB;
import grim3212.displaycases.GuiDisplay;
import grim3212.displaycases.TileEntityDisplay;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{
	public static int displaycaseGUI_ID = 4;

/**
 * Client side only register stuff...
 */
public void registerRenderInformation() 
  {
  //unused server side. -- see ClientProxy for implementation
  }

@Override
public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
  {
  // TODO Auto-generated method stub
	if (ID == displaycaseGUI_ID) {
        TileEntityDisplay display = (TileEntityDisplay)world.getBlockTileEntity(x, y, z);
        return new CraftingInventoryDisplayCB(player.inventory, display);
    }
    
    return null;
  }

@Override
public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
  {
  // TODO Auto-generated method stub
	if (ID == displaycaseGUI_ID) {
		TileEntityDisplay display = (TileEntityDisplay)world.getBlockTileEntity(x, y, z);
        return new GuiDisplay(player.inventory, display);
    }
    
    return null;
  }

}// End class CommonProxy
