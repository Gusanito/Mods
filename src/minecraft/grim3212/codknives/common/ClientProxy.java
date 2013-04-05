package grim3212.codknives.common;

import grim3212.codknives.EntityBKnife;
import grim3212.codknives.EntityKnife;
import grim3212.codknives.EntityTomahawk;
import grim3212.codknives.RenderBKnife;
import grim3212.codknives.RenderKnife;
import grim3212.codknives.RenderTomahawk;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
@Override
public void registerRenderInformation() 
  {  
	RenderingRegistry.registerEntityRenderingHandler(EntityTomahawk.class, new RenderTomahawk());
	RenderingRegistry.registerEntityRenderingHandler(EntityBKnife.class, new RenderBKnife());
	RenderingRegistry.registerEntityRenderingHandler(EntityKnife.class, new RenderKnife());
  }


}
