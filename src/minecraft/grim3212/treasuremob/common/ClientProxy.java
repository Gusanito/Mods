package grim3212.treasuremob.common;

import grim3212.treasuremob.EntityTreasureMob;
import grim3212.treasuremob.ModelTreasureMob;
import grim3212.treasuremob.RenderTreasureMob;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
@Override
public void registerRenderInformation() 
  {  
	RenderingRegistry.instance().registerEntityRenderingHandler(EntityTreasureMob.class, new RenderTreasureMob(new ModelTreasureMob(), 0.5F));
  }


}
