package grim3212.displaycases;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

import org.lwjgl.opengl.GL11;

public class TileEntityDisplayRenderer extends TileEntitySpecialRenderer
{
	private RenderBlocks renderBlocks;
	private RenderItem   renderItems;

    public TileEntityDisplayRenderer()
    {
        renderBlocks = new RenderBlocks();
    }

    public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2,
            float f)
    {
        a((TileEntityDisplay)tileentity, d, d1, d2, f);
    }

    public void a(TileEntityDisplay tileentitydisplay, double d, double d1, double d2,
            float f)
    {
        Tessellator tessellator = Tessellator.instance;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.8F, (float)d2 + 0.5F);
        int i = tileentitydisplay.worldObj.getBlockMetadata(tileentitydisplay.xCoord, tileentitydisplay.yCoord, tileentitydisplay.zCoord) & 3;
        float f1 = tileentitydisplay.getBlockType().getBlockBrightness(tileentitydisplay.worldObj, tileentitydisplay.xCoord, tileentitydisplay.yCoord, tileentitydisplay.zCoord);
        switch (i)
        {
            case 0:
                GL11.glRotatef(270F, 0.0F, 1.0F, 0.0F);
                break;

            case 1:
                GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
                break;

            case 2:
                GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
                break;

            case 3:
                GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
                break;
        }
        GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        for (int j = 0; j < tileentitydisplay.getSizeInventory(); j++)
        {
            if (j == 0)
            {
                GL11.glTranslatef(-0.6666666F, -0.3333333F, 0.0F);
            }
            else if (j % 3 != 0)
            {
                GL11.glTranslatef(0.3333333F, 0.0F, 0.0F);
            }
            else
            {
                GL11.glTranslatef(-0.6666667F, -0.3333333F, 0.3333333F);
            }
            ItemStack itemstack = tileentitydisplay.getStackInSlot(j);
            if (itemstack == null || Item.itemsList[itemstack.itemID] == null)
            {
                continue;
            }
            if (itemstack.itemID < 156 && RenderBlocks.renderItemIn3d(Block.blocksList[itemstack.itemID].getRenderType()))
            {
                bindTextureByName("/terrain.png");
                float f2 = 0.5F;
                if (!Block.blocksList[itemstack.itemID].renderAsNormalBlock() && itemstack.itemID != Block.stairsWoodJungle.blockID)
                {
                    f2 = 0.5F;
                }
                GL11.glTranslatef(0.0F, 0.09F, 0.0F);
                GL11.glScalef(f2, f2, f2);
                GL11.glPushMatrix();
                renderBlocks.renderBlockAsItem(Block.blocksList[itemstack.itemID], itemstack.getItemDamage(), 1.0F);
                GL11.glPopMatrix();
                GL11.glScalef(1.0F / f2, 1.0F / f2, 1.0F / f2);
                GL11.glTranslatef(0.0F, -0.09F, 0.0F);
                continue;
            }
            GL11.glScalef(0.6666666F, 0.6666666F, 0.6666666F);
            int k = itemstack.animationsToGo;
            if (itemstack.itemID < 256)
            {
                bindTextureByName("/terrain.png");
            }
            else
            {
                bindTextureByName("/gui/items.png");
            }
            float f3 = (float)((k % 16) * 16) / 256F;
            float f4 = (float)((k % 16) * 16 + 16) / 256F;
            float f5 = (float)((k / 16) * 16) / 256F;
            float f6 = (float)((k / 16) * 16 + 16) / 256F;
            float f7 = 1.0F;
            float f8 = 0.5F;
            float f9 = 0.25F;
            GL11.glPushMatrix();
            tessellator.startDrawingQuads();
            tessellator.setColorOpaque_F(f1, f1, f1);
            tessellator.setNormal(0.0F, 1.0F, 0.0F);
            tessellator.addVertexWithUV(0.0F - f8, 0.0F - f9, 0.0D, f3, f6);
            tessellator.addVertexWithUV(f7 - f8, 0.0F - f9, 0.0D, f4, f6);
            tessellator.addVertexWithUV(f7 - f8, 1.0F - f9, 0.0D, f4, f5);
            tessellator.addVertexWithUV(0.0F - f8, 1.0F - f9, 0.0D, f3, f5);
            tessellator.addVertexWithUV(0.0F - f8, 1.0F - f9, 0.0D, f3, f5);
            tessellator.addVertexWithUV(f7 - f8, 1.0F - f9, 0.0D, f4, f5);
            tessellator.addVertexWithUV(f7 - f8, 0.0F - f9, 0.0D, f4, f6);
            tessellator.addVertexWithUV(0.0F - f8, 0.0F - f9, 0.0D, f3, f6);
            tessellator.draw();
            GL11.glPopMatrix();
            GL11.glScalef(3F, 3F, 3F);
            GL11.glRotatef(0, 0.0F, 1.0F, 0.0F);
        }

        GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glPopMatrix();
    }
    
    public void updateEntity()
    {
    }
}
