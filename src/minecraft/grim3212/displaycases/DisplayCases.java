package grim3212.displaycases;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.client.registry.ClientRegistry;
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

@Mod(modid = "DisplayCases", name = "Display Cases", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class DisplayCases {
	@SidedProxy(clientSide = "grim3212.displaycases.common.ClientProxy", serverSide = "grim3212.displaycases.common.CommonProxy")
	public static grim3212.displaycases.common.CommonProxy proxy;
	@Instance("DisplayCases")
	public static DisplayCases instance;

	public int DisplayID;
	public int Display2ID;
	public int Display3ID;
	public int Display4ID;
	public int Display5ID;
	public static Block display;
	public static Block display2;
	public static Block display3;
	public static Block display4;
	public static Block display5;
	public static int displayModelID;
	public static final float itemspace = 0.25F;
	public static final float width = 0.3333333F;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		
		ModMetadata data = event.getModMetadata();
    	data.autogenerated = false;
    	data.version = "1.0";
    	data.name = "Display Cases";
    	data.description = "Adds in display cases to display your favorite items.";
    	data.authorList.add("Grim3212");
    	data.authorList.add("Jukkeri");
    	data.url = "http://grim3212.wikispaces.com/";
    	data.credits = "Thanks to Jukkeri for the original mod.";
    	data.logoFile = "/mods/logo.png";
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		try {
			config.load();
			DisplayID = config.get(Configuration.CATEGORY_BLOCK, "Gold Display Case ID", 2661).getInt(2661);
			Display2ID = config.get(Configuration.CATEGORY_BLOCK, "Iron Display Case ID", 2662).getInt(2662);
			Display3ID = config.get(Configuration.CATEGORY_BLOCK, "Diamond Display Case ID", 2663).getInt(2663);
			Display4ID = config.get(Configuration.CATEGORY_BLOCK, "Wood Display Case ID", 2664).getInt(2664);
			Display5ID = config.get(Configuration.CATEGORY_BLOCK, "Stone Display Case ID", 2665).getInt(2665);

		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, "Display Cases has had a problem loading it's configuration");
		} finally {
			config.save();
		}
	}

	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderInformation();
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);

		TileEntityDisplayRenderer tileentitydisplayrenderer = new TileEntityDisplayRenderer();
		GameRegistry.registerTileEntity(TileEntityDisplay.class, "Display Case");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDisplay.class, new TileEntityDisplayRenderer());

		display = (new BlockDisplay(DisplayID, Block.glass)).setUnlocalizedName("display");
		display2 = (new BlockDisplay2(Display2ID, Block.glass)).setUnlocalizedName("display2");
		display3 = (new BlockDisplay3(Display3ID, Block.glass)).setUnlocalizedName("display3");
		display4 = (new BlockDisplay4(Display4ID, Block.glass)).setUnlocalizedName("display4");
		display5 = (new BlockDisplay5(Display5ID, Block.glass)).setUnlocalizedName("display5");
		GameRegistry.registerBlock(display, ItemDisplay.class);
		GameRegistry.registerBlock(display2, ItemDisplay2.class);
		GameRegistry.registerBlock(display3, ItemDisplay3.class);
		GameRegistry.registerBlock(display4, ItemDisplay4.class);
		GameRegistry.registerBlock(display5, ItemDisplay5.class);
		LanguageRegistry.addName(display, "Display");
		LanguageRegistry.addName(display2, "Display2");
		LanguageRegistry.addName(display3, "Display3");
		LanguageRegistry.addName(display4, "Display4");
		LanguageRegistry.addName(display5, "Display5");
		LanguageRegistry.addName(new ItemStack(display, 1, 0), "Gold display case");
		LanguageRegistry.addName(new ItemStack(display2, 1, 0), "Iron display case");
		LanguageRegistry.addName(new ItemStack(display3, 1, 0), "Diamond display case");
		LanguageRegistry.addName(new ItemStack(display4, 1, 0), "Wood display case");
		LanguageRegistry.addName(new ItemStack(display5, 1, 0), "Stone display case");

		GameRegistry.addRecipe(new ItemStack(display, 8, 0), new Object[] { "AAA", "A A", "ABA", Character.valueOf('A'), Block.glass, Character.valueOf('B'), Item.ingotGold });
		GameRegistry.addRecipe(new ItemStack(display2, 8, 0), new Object[] { "AAA", "A A", "ABA", Character.valueOf('A'), Block.glass, Character.valueOf('B'), Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(display3, 8, 0), new Object[] { "AAA", "A A", "ABA", Character.valueOf('A'), Block.glass, Character.valueOf('B'), Item.diamond });
		GameRegistry.addRecipe(new ItemStack(display4, 8, 0), new Object[] { "AAA", "A A", "ABA", Character.valueOf('A'), Block.glass, Character.valueOf('B'), Block.wood });
		GameRegistry.addRecipe(new ItemStack(display5, 8, 0), new Object[] { "AAA", "A A", "ABA", Character.valueOf('A'), Block.glass, Character.valueOf('B'), Block.stone });
	}
}
