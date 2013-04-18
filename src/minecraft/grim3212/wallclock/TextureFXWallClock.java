package grim3212.wallclock;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.Texture;
import net.minecraft.client.renderer.texture.TextureStitched;

@SideOnly(Side.CLIENT)
public class TextureFXWallClock extends TextureStitched
{
    private double field_94239_h;
    private double field_94240_i;
    public static TextureFXWallClock wallClockTexture;

    public TextureFXWallClock()
    {
        super("wallClock");
        wallClockTexture = this;
    }

    public void updateAnimation()
    {
        Minecraft minecraft = Minecraft.getMinecraft();
        double d0 = 0.0D;

        if (minecraft.theWorld != null && minecraft.thePlayer != null)
        {
            float f = minecraft.theWorld.getCelestialAngle(1.0F);
            d0 = (double)f;

            if (!minecraft.theWorld.provider.isSurfaceWorld())
            {
                d0 = Math.random();
            }
        }

        double d1;

        for (d1 = d0 - this.field_94239_h; d1 < -0.5D; ++d1)
        {
            ;
        }

        while (d1 >= 0.5D)
        {
            --d1;
        }

        if (d1 < -1.0D)
        {
            d1 = -1.0D;
        }

        if (d1 > 1.0D)
        {
            d1 = 1.0D;
        }

        this.field_94240_i += d1 * 0.1D;
        this.field_94240_i *= 0.8D;
        this.field_94239_h += this.field_94240_i;
        int i;

        for (i = (int)((this.field_94239_h + 1.0D) * (double)this.textureList.size()) % this.textureList.size(); i < 0; i = (i + this.textureList.size()) % this.textureList.size())
        {
            ;
        }

        if (i != this.frameCounter)
        {
            this.frameCounter = i;
            this.textureSheet.copyFrom(this.originX, this.originY, (Texture)this.textureList.get(this.frameCounter), this.rotated);
        }
    }
}
