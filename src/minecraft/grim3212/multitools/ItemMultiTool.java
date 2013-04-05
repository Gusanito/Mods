// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package grim3212.multitools;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.UseHoeEvent;



public class ItemMultiTool extends ItemTool
{
	protected EnumToolMaterial theToolMaterial;
	
	protected ItemMultiTool(int par1, EnumToolMaterial par3EnumToolMaterial) {
		super(par1, 2, par3EnumToolMaterial, blocksEffectiveAgainst);
		this.setCreativeTab(CreativeTabs.tabTools);
	}

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        if(block.blockID == Block.web.blockID || block.blockID == Block.leaves.blockID)
        {
            return 15F;
        }
        if(block.blockID == Block.cloth.blockID)
        {
            return 5F;
        } else
        {
            return super.getStrVsBlock(itemstack, block);
        }
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        itemstack.damageItem(1, entityliving1);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        if(i == Block.leaves.blockID || i == Block.web.blockID)
        {
            itemstack.damageItem(1, entityliving);
        }
        itemstack.damageItem(1, entityliving);
        return true;
    }

    public boolean canHarvestBlock(Block block)
    {
        if(block.blockID == Block.web.blockID)
        {
            return true;
        }
        if(block == Block.snow)
        {
            return true;
        }
        if(block == Block.obsidian)
        {
            return toolMaterial.getHarvestLevel() == 3;
        }
        if(block == Block.blockDiamond || block == Block.oreDiamond)
        {
            return toolMaterial.getHarvestLevel() >= 2;
        }
        if(block == Block.blockGold || block == Block.oreGold)
        {
            return toolMaterial.getHarvestLevel() >= 2;
        }
        if(block == Block.blockSteel || block == Block.oreIron)
        {
            return toolMaterial.getHarvestLevel() >= 1;
        }
        if(block == Block.blockLapis || block == Block.oreLapis)
        {
            return toolMaterial.getHarvestLevel() >= 1;
        }
        if(block == Block.oreRedstone || block == Block.oreRedstoneGlowing)
        {
            return toolMaterial.getHarvestLevel() >= 2;
        }
        if(block.blockMaterial == Material.rock)
        {
            return true;
        } else
        {
            return block.blockMaterial == Material.iron;
        }
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else
        {
            UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return false;
            }

            if (event.getResult() == Result.ALLOW)
            {
                par1ItemStack.damageItem(1, par2EntityPlayer);
                return true;
            }

            int i1 = par3World.getBlockId(par4, par5, par6);
            int j1 = par3World.getBlockId(par4, par5 + 1, par6);

            if ((par7 == 0 || j1 != 0 || i1 != Block.grass.blockID) && i1 != Block.dirt.blockID)
            {
                return false;
            }
            else
            {
                Block block = Block.tilledField;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote)
                {
                    return true;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, block.blockID);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return true;
                }
            }
        }
    }
    
    public EnumAction getItemUseAction(ItemStack itemstack)
    {
        return EnumAction.block;
    }
    
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        entityplayer.setItemInUse(itemstack, getMaxItemUseDuration(itemstack));
        return itemstack;
    }
    
    public int getItemEnchantability()
    {
        return toolMaterial.getEnchantability();
    }
    
    public void updateIcons(IconRegister par1IconRegister)
    {
    	if(itemID == MultiTools.DMultiTool.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("MultiTools:" + "DMultiTool");
    	}
    	if(itemID == MultiTools.SMultiTool.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("MultiTools:" + "SMultiTool");
    	}
    	if(itemID == MultiTools.IMultiTool.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("MultiTools:" + "IMultiTool");
    	}
    	if(itemID == MultiTools.WMultiTool.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("MultiTools:" + "WMultiTool");
    	}
    	if(itemID == MultiTools.GMultiTool.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("MultiTools:" + "GMultiTool");
    	}
    	if(itemID == MultiTools.OMultiTool.itemID){
    		this.iconIndex = par1IconRegister.registerIcon("MultiTools:" + "OMultiTool");
    	}
    	
    }
    
    public String getToolMaterialName()
    {
        return this.theToolMaterial.toString();
    }

    private static Block blocksEffectiveAgainst[];

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.planks, Block.bookShelf, 
            Block.wood, Block.chest, Block.cobblestone, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, 
            Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.stairsBrick, Block.stairsNetherBrick, Block.stairsSandStone, Block.stairsWoodBirch,
            Block.stairsWoodJungle, Block.stairsWoodSpruce, Block.stoneDoubleSlab, Block.obsidian, Block.stairsCobblestone, Block.stairCompactNetherQuartz
        });
    }
}
