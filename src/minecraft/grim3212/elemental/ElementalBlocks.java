// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package grim3212.elemental;

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
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "ElementalBlocks", name = "Elemental Blocks", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class ElementalBlocks {

	@SidedProxy(clientSide = "grim3212.elemental.common.ClientProxy", serverSide = "grim3212.elemental.common.CommonProxy")
	public static grim3212.elemental.common.CommonProxy proxy;
	@Instance("ElementalBlocks")
	public static ElementalBlocks instance;

	public int fireBlockID;
	public int waterBlockID;
	public int lavaBlockID;
	public static Block fireBlock;
	public static Block waterBlock;
	public static Block lavaBlock;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		ModMetadata data = event.getModMetadata();
    	data.autogenerated = false;
    	data.version = "1.0";
    	data.name = "Elemental Blocks";
    	data.description = "Adds in 3 blocks that when powered with redstone have either lava, water, or fire spawn on top.";
    	data.authorList.add("Grim3212");
    	data.authorList.add("Prowne");
    	data.url = "http://grim3212.wikispaces.com/";
    	data.credits = "Thanks to Prowne for the original mod.";
    	data.logoFile = "/mods/logo.png";
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		try {
			config.load();
			fireBlockID = config.get(Configuration.CATEGORY_BLOCK, "Fire Block ID", 2723).getInt(2723);
			lavaBlockID = config.get(Configuration.CATEGORY_BLOCK, "Lava Block ID", 2724).getInt(2724);
			waterBlockID = config.get(Configuration.CATEGORY_BLOCK, "Water Block ID", 2725).getInt(2725);
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, "Elemental Blocks has had a problem loading it's configuration");
		} finally {
			config.save();
		}
	}

	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderInformation();

		fireBlock = (new BlockElemental(fireBlockID, 0, "fire")).setHardness(2.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("fireblock").setCreativeTab(CreativeTabs.tabRedstone);
		waterBlock = (new BlockElemental(waterBlockID, 0, "water")).setHardness(2.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("waterblock").setCreativeTab(CreativeTabs.tabRedstone);
		lavaBlock = (new BlockElemental(lavaBlockID, 0, "lava")).setHardness(2.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("lavablock").setCreativeTab(CreativeTabs.tabRedstone);

		LanguageRegistry.addName(fireBlock, "Elemental Fire Block");
		LanguageRegistry.addName(waterBlock, "Elemental Water Block");
		LanguageRegistry.addName(lavaBlock, "Elemental Lava Block");
		GameRegistry.registerBlock(waterBlock);
		GameRegistry.registerBlock(lavaBlock);
		GameRegistry.registerBlock(fireBlock);
		GameRegistry.addRecipe(new ItemStack(fireBlock, 1), new Object[] { "###", "#!#", "###", Character.valueOf('#'), Block.blockSteel, Character.valueOf('!'), Item.flintAndSteel });
		GameRegistry.addRecipe(new ItemStack(waterBlock, 1), new Object[] { "###", "#!#", "###", Character.valueOf('#'), Block.blockSteel, Character.valueOf('!'), Item.bucketWater });
		GameRegistry.addRecipe(new ItemStack(lavaBlock, 1), new Object[] { "###", "#!#", "###", Character.valueOf('#'), Block.blockSteel, Character.valueOf('!'), Item.bucketLava });
	}

}
