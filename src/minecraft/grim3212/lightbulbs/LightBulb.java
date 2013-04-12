// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package grim3212.lightbulbs;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

// Referenced classes of package net.minecraft.src:
//            BaseMod, ItemStack, BlockLightBulb, Item, 
//            ModLoader, Block, PROWNE
@Mod(modid = "LightBulb", name = "Light Bulbs", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class LightBulb {
	@SidedProxy(clientSide = "grim3212.lightbulbs.common.ClientProxy", serverSide = "grim3212.lightbulbs.common.CommonProxy")
	public static grim3212.lightbulbs.common.CommonProxy proxy;
	@Instance("LightBulb")
	public static LightBulb instance;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		ModMetadata data = event.getModMetadata();
    	data.autogenerated = false;
    	data.version = "1.0";
    	data.name = "Light Bulbs";
    	data.description = "Adds ina  new block which when powered by redstone emits light.  Looks like a lightbulb and can only be placed on the ceiling.";
    	data.authorList.add("Grim3212");
    	data.authorList.add("Prowne");
    	data.url = "http://grim3212.wikispaces.com/";
    	data.credits = "Thanks to Prowne for the original mod.";
    	data.logoFile = "/mods/logo.png";
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		try {
			config.load();
			litBulbID = config.get(Configuration.CATEGORY_BLOCK, "Lit Bulb ID", 2652).getInt(2652);
			unlitBulbID = config.get(Configuration.CATEGORY_BLOCK, "Unlit Bulb ID", 2653).getInt(2653);
			glassShardID = config.get(Configuration.CATEGORY_ITEM, "Glass Shard ID", 9001).getInt(9001);
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, "LightBulbs has had a problem loading it's configuration");
		} finally {
			config.save();
		}
	}

	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderInformation();

		litBulb = (new BlockLightBulb(litBulbID, 0)).setHardness(0.1F).setLightValue(1.0F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("litbulb");
		unlitBulb = (new BlockLightBulb(unlitBulbID, 1)).setHardness(0.1F).setLightValue(0.0F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("unlitbulb").setCreativeTab(CreativeTabs.tabRedstone);
		glassShard = (new ProwneLG(glassShardID)).setMaxStackSize(64).setUnlocalizedName("glassshard").setCreativeTab(CreativeTabs.tabMaterials);

		LanguageRegistry.addName(glassShard, "Glass Shard");
		LanguageRegistry.addName(litBulb, "Lit Light Bulb");
		LanguageRegistry.addName(unlitBulb, "Light Bulb");
		GameRegistry.registerBlock(litBulb);
		GameRegistry.registerBlock(unlitBulb);
		GameRegistry.addRecipe(new ItemStack(Block.glass, 1), new Object[] { "##", "##", Character.valueOf('#'), glassShard });
		GameRegistry.addRecipe(new ItemStack(unlitBulb, 1), new Object[] { "###", "#$#", " ! ", Character.valueOf('#'), Block.glass, Character.valueOf('$'), Block.torchRedstoneActive, Character.valueOf('!'), Item.ingotIron });
	}

	public static int litBulbID;
	public static int unlitBulbID;
	public static int glassShardID;

	public static Block litBulb;
	public static Block unlitBulb;
	public static Item glassShard;
}
