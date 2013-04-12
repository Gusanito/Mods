package grim3212.ballistic.common;

import grim3212.ballistic.EntityBallisticKnife;
import grim3212.ballistic.RenderBallisticKnife;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderInformation() {
		RenderingRegistry.instance().registerEntityRenderingHandler(EntityBallisticKnife.class, new RenderBallisticKnife());
	}

}
