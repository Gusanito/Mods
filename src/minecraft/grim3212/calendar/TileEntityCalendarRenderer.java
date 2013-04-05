package grim3212.calendar;

import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

public class TileEntityCalendarRenderer extends TileEntitySpecialRenderer
{
    private CalendarModel calModel;
    private DateHandler dh;

    public TileEntityCalendarRenderer()
    {
        calModel = new CalendarModel();
    }

    public void renderTileEntityCalendarAt(TileEntity tileentity, double d, double d1, double d2,
            float f)
    {
        Block block = tileentity.getBlockType();
        GL11.glPushMatrix();
        float f1 = 0.6666667F;
        int i = tileentity.getBlockMetadata();
        float f2 = 0.0F;
        if (i == 2)
        {
            f2 = 180F;
        }
        if (i == 4)
        {
            f2 = 90F;
        }
        if (i == 5)
        {
            f2 = -90F;
        }
        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.75F * f1, (float)d2 + 0.5F);
        GL11.glRotatef(-f2, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(0.0F, -0.3125F, -0.4375F);
        bindTextureByName("/mods/Calendar/textures/blocks/calendarBlock.png");
        GL11.glPushMatrix();
        GL11.glScalef(f1, -f1, -f1);
        calModel.renderSign();
        GL11.glPopMatrix();
        FontRenderer fontrenderer = getFontRenderer();
        float f3 = 0.01666667F * f1;
        GL11.glTranslatef(0.0F, 0.2F * f1, 0.07F * f1);
        GL11.glScalef(f3, -f3, f3);
        GL11.glNormal3f(0.0F, 0.0F, -1F * f3);
        GL11.glDepthMask(false);
        int j = 0;
        DateHandler datehandler = dh;
        String s = DateHandler.CalculateDate(Long.valueOf(MinecraftServer.getServer().worldServers[0].getWorldInfo().getWorldTime()), 1);
        String as[] = s.split(",");
        for (int k = 0; k < as.length; k++)
        {
            String s1 = as[k];
            fontrenderer.drawString(s1, -fontrenderer.getStringWidth(s1) / 2, k * 10 - as.length * 5, j);
        }

        GL11.glDepthMask(true);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2,
            float f)
    {
        renderTileEntityCalendarAt(tileentity, d, d1, d2, f);
    }
}
