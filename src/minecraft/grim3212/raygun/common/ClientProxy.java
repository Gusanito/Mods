package grim3212.raygun.common;

import grim3212.raygun.EntityAdvRayw;
import grim3212.raygun.EntityRayw;
import grim3212.raygun.RenderAdvRayw;
import grim3212.raygun.RenderRayw;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
@Override
public void registerRenderInformation() 
  {  
	RenderingRegistry.instance().registerEntityRenderingHandler(EntityRayw.class, new RenderRayw(0));
	RenderingRegistry.instance().registerEntityRenderingHandler(EntityAdvRayw.class, new RenderAdvRayw(0));
  }


}
