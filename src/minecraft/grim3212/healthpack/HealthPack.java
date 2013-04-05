// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package grim3212.healthpack;

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
//            BaseModMp, ModLoader, ItemStack, Block, 
//            Item, ItemHealthPack, ItemFood
@Mod(modid = "HealthPack", name = "Health Pack", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class HealthPack {

	@SidedProxy(clientSide = "grim3212.healthpack.common.ClientProxy", serverSide = "grim3212.healthpack.common.CommonProxy")
	public static grim3212.healthpack.common.CommonProxy proxy;
	@Instance("HealthPack")
	public static HealthPack instance;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		
		ModMetadata data = event.getModMetadata();
		data.autogenerated = false;
		data.version = "1.0";
		data.name = "Health Pack";
		data.description = "This mod adds in a few new items that can replenish your hunger bar and also some things that directly heal you.";
		data.authorList.add("Grim3212");
		data.authorList.add("LFalch");
		data.url = "http://grim3212.wikispaces.com/";
		data.credits = "Thanks to LFalch for the original mod.";
		data.logoFile = "/mods/logo.png";
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		try {
			config.load();
			p1ID = config.get(Configuration.CATEGORY_ITEM, "Health Pack ID", 9040).getInt(9040);
			p2ID = config.get(Configuration.CATEGORY_ITEM, "Super Health Pack ID", 9041).getInt(9041);
			sweetsID = config.get(Configuration.CATEGORY_ITEM, "Sugar Sweets ID", 9042).getInt(9042);
			bandageID = config.get(Configuration.CATEGORY_ITEM, "Bandage ID", 9043).getInt(9043);
			poweredSweetsID = config.get(Configuration.CATEGORY_ITEM, "Super Sugar Sweets ID", 9044).getInt(9044);
			poweredSugarID = config.get(Configuration.CATEGORY_ITEM, "Super Sugar ID", 9045).getInt(9045);

		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, "Health Pack has had a problem loading it's configuration");
		} finally {
			config.save();
		}
	}

	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderInformation();

		poweredSweets = (new HPItemFood(poweredSweetsID, 6, 0.3F, false)).setUnlocalizedName("super-sweets").setCreativeTab(CreativeTabs.tabFood);
		poweredSugar = (new HPItem(poweredSugarID)).setUnlocalizedName("power_sugar").setCreativeTab(CreativeTabs.tabFood);
		sweets = (new HPItemFood(sweetsID, 2, 0.1F, false)).setUnlocalizedName("sweets").setCreativeTab(CreativeTabs.tabFood);
		bandage = (new ItemHealthPack(bandageID, 3)).setUnlocalizedName("bandage").setMaxStackSize(16).setCreativeTab(CreativeTabs.tabMisc);
		healthP2 = (new ItemHealthPack(p2ID, 12)).setUnlocalizedName("hp2").setMaxStackSize(4).setCreativeTab(CreativeTabs.tabMisc);
		healthP1 = (new ItemHealthPack(p1ID, 5)).setUnlocalizedName("hp1").setMaxStackSize(4).setCreativeTab(CreativeTabs.tabMisc);

		LanguageRegistry.addName(healthP1, "Health Pack");
		GameRegistry.addRecipe(new ItemStack(healthP1, 1), new Object[] { " # ", "#S#", " # ", Character.valueOf('#'), Block.cloth, Character.valueOf('S'), Item.sugar });
		LanguageRegistry.addName(healthP2, "Super Health Pack");
		GameRegistry.addRecipe(new ItemStack(healthP2, 1), new Object[] { " # ", "#R#", " # ", Character.valueOf('#'), Block.cloth, Character.valueOf('R'), poweredSugar });
		LanguageRegistry.addName(bandage, "Bandage");
		GameRegistry.addRecipe(new ItemStack(bandage, 2), new Object[] { "P#P", Character.valueOf('#'), Block.cloth, Character.valueOf('P'), Item.paper });
		LanguageRegistry.addName(sweets, "Sugar Sweets");
		GameRegistry.addShapelessRecipe(new ItemStack(sweets, 8), new Object[] { Item.sugar, Item.paper });
		LanguageRegistry.addName(poweredSweets, "Super Sugar Sweets");
		GameRegistry.addShapelessRecipe(new ItemStack(poweredSweets, 8), new Object[] { poweredSugar, Item.paper });
		LanguageRegistry.addName(poweredSugar, "Super Sugar");
		GameRegistry.addShapelessRecipe(new ItemStack(poweredSugar, 1), new Object[] { Item.redstone, Item.sugar });
	}

	public static Item healthP1;
	public static Item healthP2;
	public static Item bandage;
	public static Item sweets;
	public static Item poweredSugar;
	public static Item poweredSweets;
	public static int p1ID;
	public static int p2ID;
	public static int bandageID;
	public static int sweetsID;
	public static int poweredSugarID;
	public static int poweredSweetsID;

}