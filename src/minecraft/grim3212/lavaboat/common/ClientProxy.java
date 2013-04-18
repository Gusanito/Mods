package grim3212.lavaboat.common;

import grim3212.lavaboat.EntityLavaBoat;
import grim3212.lavaboat.RenderLavaBoat;
import cpw.mods.fml.client.registry.RenderingRegistry;


public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderInformation() {
		RenderingRegistry.instance().registerEntityRenderingHandler(EntityLavaBoat.class, new RenderLavaBoat());
	}

}
