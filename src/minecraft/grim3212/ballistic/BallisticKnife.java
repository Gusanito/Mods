// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package grim3212.ballistic;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "BallisticKnife", name = "Ballistic Knife", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class BallisticKnife {
	@SidedProxy(clientSide = "grim3212.ballistic.common.ClientProxy", serverSide = "grim3212.ballistic.common.CommonProxy")
	public static grim3212.ballistic.common.CommonProxy proxy;
	@Instance("BallisticKnife")
	public static BallisticKnife instance;

	public static Item loadedKnife;
	public static Item unloadedKnife;
	public static Item ammoPart;
	public static Item buttonPart;
	public static Item springPart;
	public static Item casingPart;
	public static Item rodPart;

	public int loadedKnifeID;
	public int unloadedKnifeID;
	public int buttonPartID;
	public int springPartID;
	public int casingPartID;
	public int rodPartID;
	public static int ammoPartID;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		
		ModMetadata data = event.getModMetadata();
    	data.autogenerated = false;
    	data.version = "1.0";
    	data.name = "Ballistic Knife";
    	data.description = "Adds in a new wepon based on the ballistic knife from Call of Duty.";
    	data.authorList.add("Grim3212");
    	data.authorList.add("Prowne");
    	data.url = "http://grim3212.wikispaces.com/";
    	data.credits = "Thanks to Prowne for the original mod.";
    	data.logoFile = "/mods/logo.png";
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		try {
			config.load();
			loadedKnifeID = config.get(Configuration.CATEGORY_ITEM, "Loaded Ballistic Knife ID", 9071).getInt(9071);
			unloadedKnifeID = config.get(Configuration.CATEGORY_ITEM, "Unloaded Ballistic Knife ID", 9072).getInt(9072);
			buttonPartID = config.get(Configuration.CATEGORY_ITEM, "Ballistic Knife Button Part ID", 9073).getInt(9073);
			springPartID = config.get(Configuration.CATEGORY_ITEM, "Ballistic Knife Spring Part ID", 9074).getInt(9074);
			casingPartID = config.get(Configuration.CATEGORY_ITEM, "Ballistic Knife Casing Part ID", 9075).getInt(9075);
			rodPartID = config.get(Configuration.CATEGORY_ITEM, "Ballistic Knife Rod Part ID", 9076).getInt(9076);
			ammoPartID = config.get(Configuration.CATEGORY_ITEM, "Ballistic Knife Ammo Part ID", 9077).getInt(9077);
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, "Ballistic Knife has had a problem loading it's configuration");
		} finally {
			config.save();
		}
	}

	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderInformation();

		loadedKnife = (new ItemBallisticKnife(loadedKnifeID, true, 1)).setUnlocalizedName("loadedknife").setCreativeTab(CreativeTabs.tabCombat);
		unloadedKnife = (new ItemBallisticKnife(unloadedKnifeID, false, 1)).setMaxStackSize(1).setUnlocalizedName("unloadedknife").setCreativeTab(CreativeTabs.tabCombat);
		ammoPart = (new ItemBallisticKnife(ammoPartID, false, 0)).setMaxStackSize(64).setUnlocalizedName("ammopart").setCreativeTab(CreativeTabs.tabCombat);
		buttonPart = (new ItemGeneric(buttonPartID)).setMaxStackSize(1).setUnlocalizedName("buttonpart").setCreativeTab(CreativeTabs.tabMisc);
		springPart = (new ItemGeneric(springPartID)).setMaxStackSize(1).setUnlocalizedName("springpart").setCreativeTab(CreativeTabs.tabMisc);
		casingPart = (new ItemGeneric(casingPartID)).setMaxStackSize(1).setUnlocalizedName("casingpart").setCreativeTab(CreativeTabs.tabMisc);
		rodPart = (new ItemGeneric(rodPartID)).setMaxStackSize(64).setUnlocalizedName("rodpart").setCreativeTab(CreativeTabs.tabMisc);

		LanguageRegistry.addName(unloadedKnife, "Empty Ballistic Knife");
		LanguageRegistry.addName(loadedKnife, "Loaded Ballistic Knife");
		LanguageRegistry.addName(buttonPart, "Trigger");
		LanguageRegistry.addName(springPart, "Spring");
		LanguageRegistry.addName(casingPart, "Metal Casing");
		LanguageRegistry.addName(rodPart, "Metal Rod");
		LanguageRegistry.addName(ammoPart, "Ballistic Knife Blade");
		
		GameRegistry.addRecipe(new ItemStack(ammoPart, 1), new Object[] { "#  ", " # ", "  !", Character.valueOf('#'), Item.ingotIron, Character.valueOf('!'), rodPart });
		GameRegistry.addRecipe(new ItemStack(casingPart, 1), new Object[] { "# ", " #", Character.valueOf('#'), Item.flint });
		GameRegistry.addRecipe(new ItemStack(springPart, 1), new Object[] { "#  ", " ! ", "  #", Character.valueOf('#'), Item.ingotIron, Character.valueOf('!'), Item.silk });
		GameRegistry.addRecipe(new ItemStack(buttonPart, 1), new Object[] { " # ", "#!#", " # ", Character.valueOf('#'), Item.redstone, Character.valueOf('!'), Block.stoneButton });
		GameRegistry.addRecipe(new ItemStack(unloadedKnife, 1), new Object[] { " #", "! ", " @", Character.valueOf('#'), buttonPart, Character.valueOf('!'), springPart, Character.valueOf('@'), casingPart });
		GameRegistry.addRecipe(new ItemStack(rodPart, 1), new Object[] { "#", "#", Character.valueOf('#'), Item.ingotIron });

		EntityRegistry.registerModEntity(EntityBallisticKnife.class, "BallisticKnife", 1, this, 400, 20, true);
	}
}