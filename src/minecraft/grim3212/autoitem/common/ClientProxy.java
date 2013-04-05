package grim3212.autoitem.common;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy
{
@Override
public void registerRenderInformation() 
  {  
	TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
  }


}// End class Clien
