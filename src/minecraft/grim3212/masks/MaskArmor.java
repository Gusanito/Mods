package grim3212.masks;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class MaskArmor extends ItemArmor{

	public MaskArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		setCreativeTab(CreativeTabs.tabMisc);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		if (stack.itemID == Masks.blazemask.itemID) {
			return "/mods/Masks/textures/armor/BlazeMask_1.png";
		}
		if (stack.itemID == Masks.cavemask.itemID) {
			return "/mods/Masks/textures/armor/CaveMask_1.png";
		}
		if (stack.itemID == Masks.chickmask.itemID) {
			return "/mods/Masks/textures/armor/ChickenMask_1.png";
		}
		if (stack.itemID == Masks.cowmask.itemID) {
			return "/mods/Masks/textures/armor/CowMask_1.png";
		}
		if (stack.itemID == Masks.creepermask.itemID) {
			return "/mods/Masks/textures/armor/CreeperMask_1.png";
		}
		if (stack.itemID == Masks.emptymask.itemID) {
			return "/mods/Masks/textures/armor/EmptyMask_1.png";
		}
		if (stack.itemID == Masks.endermask.itemID) {
			return "/mods/Masks/textures/armor/EnderMask_1.png";
		}
		if (stack.itemID == Masks.ghastmask.itemID) {
			return "/mods/Masks/textures/armor/GhastMask_1.png";
		}
		if (stack.itemID == Masks.magmamask.itemID) {
			return "/mods/Masks/textures/armor/MagmaMask_1.png";
		}
		if (stack.itemID == Masks.pigmask.itemID) {
			return "/mods/Masks/textures/armor/PigMask_1.png";
		}
		if (stack.itemID == Masks.sheepmask.itemID) {
			return "/mods/Masks/textures/armor/SheepMask_1.png";
		}
		if (stack.itemID == Masks.shroommask.itemID) {
			return "/mods/Masks/textures/armor/ShroomMask_1.png";
		}
		if (stack.itemID == Masks.skelemask.itemID) {
			return "/mods/Masks/textures/armor/SkeletonMask_1.png";
		}
		if (stack.itemID == Masks.slimemask.itemID) {
			return "/mods/Masks/textures/armor/SlimeMask_1.png";
		}
		if (stack.itemID == Masks.spidermask.itemID) {
			return "/mods/Masks/textures/armor/SpiderMask_1.png";
		}
		if (stack.itemID == Masks.squidmask.itemID) {
			return "/mods/Masks/textures/armor/SquidMask_1.png";
		}
		if (stack.itemID == Masks.villmask.itemID) {
			return "/mods/Masks/textures/armor/VillagerrMask_1.png";
		}
		if (stack.itemID == Masks.wolfmask.itemID) {
			return "/mods/Masks/textures/armor/WolfMask_1.png";
		}
		if (stack.itemID == Masks.zombmask.itemID) {
			return "/mods/Masks/textures/armor/ZombieMask_1.png";
		}
		if (stack.itemID == Masks.zombpigmask.itemID) {
			return "/mods/Masks/textures/armor/ZombiePigMask_1.png";
		}
		return "/mods/Masks/textures/armor/BlazeMask_1.png";
	}

	public void updateIcons(IconRegister par1IconRegister) {
		if (itemID == Masks.blazemask.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Masks:" + "blaze");
		}
		if (itemID == Masks.cavemask.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Masks:" + "cave_spider");
		}
		if (itemID == Masks.chickmask.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Masks:" + "chicken");
		}
		if (itemID == Masks.cowmask.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Masks:" + "cow");
		}
		if (itemID == Masks.creepermask.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Masks:" + "creeper");
		}
		if (itemID == Masks.emptymask.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Masks:" + "empty");
		}
		if (itemID == Masks.endermask.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Masks:" + "enderman");
		}
		if (itemID == Masks.ghastmask.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Masks:" + "ghast");
		}
		if (itemID == Masks.magmamask.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Masks:" + "magmacube");
		}
		if (itemID == Masks.pigmask.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Masks:" + "pig");
		}
		if (itemID == Masks.sheepmask.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Masks:" + "sheep");
		}
		if (itemID == Masks.shroommask.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Masks:" + "mooshroom");
		}
		if (itemID == Masks.skelemask.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Masks:" + "skeleton");
		}
		if (itemID == Masks.slimemask.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Masks:" + "slime");
		}
		if (itemID == Masks.spidermask.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Masks:" + "spider");
		}
		if (itemID == Masks.squidmask.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Masks:" + "squid");
		}
		if (itemID == Masks.villmask.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Masks:" + "villager");
		}
		if (itemID == Masks.wolfmask.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Masks:" + "wolf");
		}
		if (itemID == Masks.zombmask.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Masks:" + "zombie");
		}
		if (itemID == Masks.zombpigmask.itemID) {
			this.iconIndex = par1IconRegister.registerIcon("Masks:" + "zombie_pigman");
		}
	}

}