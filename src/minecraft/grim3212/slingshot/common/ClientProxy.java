package grim3212.slingshot.common;

import grim3212.slingshot.EntitySlingpellet;
import grim3212.slingshot.RenderSlingPellet;
import grim3212.slingshot.Slingshot;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
@Override
public void registerRenderInformation() 
  {  
	RenderingRegistry.registerEntityRenderingHandler(EntitySlingpellet.class, new RenderSlingPellet(Slingshot.Slingpellet, 3205));
  }


}
