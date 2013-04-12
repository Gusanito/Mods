package grim3212.machetes;

import grim3212.healthpack.HealthPack;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemMachete extends ItemTool {

	public static final Block[] blocksEffectiveAgainst = new Block[] {};
	public static Material[] material = new Material[] { Material.leaves, Material.cloth, Material.cactus, Material.vine, Material.web};
	private Random random;

	protected ItemMachete(int var1, EnumToolMaterial var2) {
		super(var1, 4, var2, blocksEffectiveAgainst);
		this.maxStackSize = 1;
		this.random = new Random();
		setCreativeTab(CreativeTabs.tabTools);
	}

	public float getStrVsBlock(ItemStack var1, Block var2) {
		for (int var3 = 0; var3 < material.length; ++var3) {
			if (material[var3] == var2.blockMaterial) {
				return this.efficiencyOnProperMaterial;
			}
		}

		return super.getStrVsBlock(var1, var2);
	}

	public boolean hitEntity(ItemStack var1, EntityLiving var2, EntityLiving var3) {
		if (var1.getItem() != Machetes.macheteSlime) {
			return true;
		} else {
			var1.damageItem(2, var3);
			byte var4 = 1;
			double var5 = var3.posX - var3.posX;

			double var7;
			for (var7 = var3.posZ - var3.posZ; var5 * var5 + var7 * var7 < 1.0E-4D; var7 = (Math.random() - Math.random()) * 0.01D) {
				var5 = (Math.random() - Math.random()) * 0.01D;
			}

			var2.knockBack(var3, var4, -var5, -var7);
			if (var2 instanceof EntitySlime && this.random.nextInt(10) == 0) {
				for (int var11 = 0; var11 < 3; ++var11) {
					ItemStack var10 = new ItemStack(Item.slimeBall, 1, 0);
					var2.entityDropItem(var10, 0.5F);
				}

				return true;
			} else if (this.random.nextInt(12) == 0 && var2 instanceof EntityMob) {
				ItemStack var9 = new ItemStack(Item.slimeBall, 1, 0);
				var2.entityDropItem(var9, 0.5F);
				return true;
			} else {
				return true;
			}
		}
	}

	public boolean isFull3D() {
		return true;
	}
	
	public void updateIcons(IconRegister par1IconRegister)
    {
    	if(itemID == Machetes.macheteWood.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("Machetes:" + "macheteWood");
    	}
    	if(itemID == Machetes.macheteStone.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("Machetes:" + "macheteStone");
    	}
    	if(itemID == Machetes.macheteIron.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("Machetes:" + "macheteIron");
    	}
    	if(itemID == Machetes.macheteGold.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("Machetes:" + "macheteGold");
    	}
    	if(itemID == Machetes.macheteDiamond.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("Machetes:" + "macheteDiamond");
    	}
    	if(itemID == Machetes.macheteSlime.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("Machetes:" + "macheteSlime");
    	}
    }

}
