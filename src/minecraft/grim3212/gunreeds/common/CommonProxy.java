package grim3212.gunreeds.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{

/**
 * Client side only register stuff...
 */
public void registerRenderInformation() 
  {
  }

@Override
public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
  {
  return null;
  }

@Override
public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
  {
  return null;
  }

}