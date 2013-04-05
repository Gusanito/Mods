// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package grim3212.workbenchup;

import java.util.logging.Level;

import net.minecraft.block.Block;
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
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


// Referenced classes of package net.minecraft.src:
//            BaseMod, ModLoader, ItemStack, Block, 
//            BlockIronWorkbench, BlockDiamondWorkbench
@Mod(modid = "WorkbenchUpgrades", name = "Workbench Upgrades", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class WorkbenchUpgrades
{
	@SidedProxy(clientSide = "grim3212.workbenchup.common.ClientProxy", serverSide = "grim3212.workbenchup.common.CommonProxy")
	public static grim3212.workbenchup.common.CommonProxy proxy;
	@Instance("WorkbenchUpgrades")
	public static WorkbenchUpgrades instance = new WorkbenchUpgrades();
	

    public static Block ironWorkbench;
    public static Block diamondWorkbench;
    
    public static final int ironGUI = 1;
    public static final int diamondGUI = 2;
    
    public int ironWBID;
    public int diamondWBID;
    
    @PreInit
	public void preInit(FMLPreInitializationEvent event) {
    	
    	ModMetadata data = event.getModMetadata();
		data.autogenerated = false;
		data.version = "1.0";
		data.name = "Workbench Upgrades";
		data.description = "A mod that adds in two new workbenches that give you more items when you craft them.";
		data.authorList.add("Grim3212");
		data.authorList.add("propeng");
		data.url = "http://grim3212.wikispaces.com/";
		data.credits = "Thanks to propeng for the original mod.";
		data.logoFile = "/mods/logo.png";
    	
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		try {
			config.load();
			ironWBID = config.get(Configuration.CATEGORY_BLOCK, "Iron Workbench ID", 2687).getInt(2687);
			diamondWBID = config.get(Configuration.CATEGORY_BLOCK, "Diamond Workbench ID", 2688).getInt(2688);
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, "Workbench Upgrades has had a problem loading it's configuration");
		} finally {
			config.save();
		}
	}

    @Init
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderInformation();
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		
		ironWorkbench = (new BlockIronWorkbench(ironWBID)).setHardness(3F).setResistance(5F).setUnlocalizedName("ironwb");
		diamondWorkbench = (new BlockDiamondWorkbench(diamondWBID)).setHardness(5F).setResistance(5F).setUnlocalizedName("diamondwb");
		
    	GameRegistry.registerBlock(ironWorkbench);
        GameRegistry.registerBlock(diamondWorkbench);
        LanguageRegistry.addName(ironWorkbench, "Iron Workbench");
        LanguageRegistry.addName(diamondWorkbench, "Diamond Workbench");
        GameRegistry.addRecipe(new ItemStack(ironWorkbench), new Object[] {
            " X ", "X=X", " X ", Character.valueOf('X'), Block.blockSteel, Character.valueOf('='), Block.workbench
        });
        GameRegistry.addRecipe(new ItemStack(diamondWorkbench), new Object[] {
            " X ", "X=X", " X ", Character.valueOf('X'), Block.blockDiamond, Character.valueOf('='), Block.workbench
        });
    }
    }