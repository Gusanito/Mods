package grim3212.floatingislands;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "FloatingIslands", name = "Floating Islands", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class FloatingIslands {

	@SidedProxy(clientSide = "grim3212.floatingislands.common.ClientProxy", serverSide = "grim3212.floatingislands.common.CommonProxy")
	public static grim3212.floatingislands.common.CommonProxy proxy;

	@PreInit
	public void preInit(FMLPreInitializationEvent event){
		ModMetadata data = event.getModMetadata();
    	data.autogenerated = false;
    	data.version = "1.0";
    	data.name = "Floating Islands";
    	data.description = "A mod that adds in floating islands all around your world.";
    	data.authorList.add("Grim3212");
    	data.authorList.add("Scokeev9");
    	data.url = "http://grim3212.wikispaces.com/";
    	data.credits = "Thanks to Scokeev9 for the original mod.";
    	data.logoFile = "/mods/logo.png";
	}
	
	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderInformation();
		GameRegistry.registerWorldGenerator(new FloatingIslandsGenerator());

		FloatingIslandsGenerator.myArr.add(Integer.valueOf(8));
		FloatingIslandsGenerator.myArr.add(Integer.valueOf(9));
		FloatingIslandsGenerator.myArr.add(Integer.valueOf(10));
		FloatingIslandsGenerator.myArr.add(Integer.valueOf(11));
		FloatingIslandsGenerator.myArr.add(Integer.valueOf(12));
		FloatingIslandsGenerator.myArr.add(Integer.valueOf(17));
		FloatingIslandsGenerator.myArr.add(Integer.valueOf(18));
		FloatingIslandsGenerator.myArr.add(Integer.valueOf(79));
	}
}
