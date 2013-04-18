package grim3212.chocolate;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockChocolateCake extends Block
{
    @SideOnly(Side.CLIENT)
    private Icon field_94383_a;
    @SideOnly(Side.CLIENT)
    private Icon field_94381_b;
    @SideOnly(Side.CLIENT)
    private Icon field_94382_c;

    protected BlockChocolateCake(int i, int j)
    {
        super(i, Material.cake);
        setTickRandomly(true);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.getBlockMetadata(i, j, k);
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16F;
        float f2 = 0.5F;
        setBlockBounds(f1, 0.0F, f, 1.0F - f, f2, 1.0F - f);
    }

    public void setBlockBoundsForItemRender()
    {
        float f = 0.0625F;
        float f1 = 0.5F;
        setBlockBounds(f, 0.0F, f, 1.0F - f, f1, 1.0F - f);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k);
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16F;
        float f2 = 0.5F;
        return AxisAlignedBB.getAABBPool().getAABB((float)i + f1, j, (float)k + f, (float)(i + 1) - f, ((float)j + f2) - f, (float)(k + 1) - f);
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k);
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16F;
        float f2 = 0.5F;
        return AxisAlignedBB.getAABBPool().getAABB((float)i + f1, j, (float)k + f, (float)(i + 1) - f, (float)j + f2, (float)(k + 1) - f);
    }

    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
    	return par1 == 1 ? this.field_94383_a : (par1 == 0 ? this.field_94381_b : (par2 > 0 && par1 == 4 ? this.field_94382_c : this.blockIcon));
    }
    
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("Chocolate:chocolatecake_side");
        this.field_94382_c = par1IconRegister.registerIcon("Chocolate:chocolatecake_sidecut");
        this.field_94383_a = par1IconRegister.registerIcon("Chocolate:chocolatecake_top");
        this.field_94381_b = par1IconRegister.registerIcon("Chocolate:chocolatecake_bottom");
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean blockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	this.eatCakeSlice(par1World, par2, par3, par4, par5EntityPlayer);
        return true;
    }

    public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        eatCakeSlice(world, i, j, k, entityplayer);
    }

    private void eatCakeSlice(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
    {
    	if (par5EntityPlayer.canEat(false))
        {
            par5EntityPlayer.getFoodStats().addStats(2, 0.1F);
            int l = par1World.getBlockMetadata(par2, par3, par4) + 1;

            if (l >= 6)
            {
                par1World.setBlockToAir(par2, par3, par4);
            }
            else
            {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
            }
        }
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        if (!super.canPlaceBlockAt(world, i, j, k))
        {
            return false;
        }
        else
        {
            return canBlockStay(world, i, j, k);
        }
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        if (!canBlockStay(world, i, j, k))
        {
            dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), 0);
            world.setBlock(i, j, k, 0);
        }
    }

    public boolean canBlockStay(World world, int i, int j, int k)
    {
        return world.getBlockMaterial(i, j - 1, k).isSolid();
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }

    public int idDropped(int i, Random random, int j)
    {
        return 0;
    }
}
