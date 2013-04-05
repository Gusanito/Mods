package grim3212.pokeball.common;

import grim3212.pokeball.EntityPokeball;
import grim3212.pokeball.Pokeball;
import grim3212.pokeball.RenderPokeball;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
@Override
public void registerRenderInformation() 
  {  
	RenderingRegistry.registerEntityRenderingHandler(EntityPokeball.class, new RenderPokeball(Pokeball.pokeball, 3204));
  }


}
