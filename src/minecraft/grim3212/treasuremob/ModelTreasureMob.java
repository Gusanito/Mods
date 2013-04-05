// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package grim3212.treasuremob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer

public class ModelTreasureMob extends ModelBase
{

    public ModelTreasureMob()
    {
        box1 = new ModelRenderer(this, 0, 17);
        box0 = new ModelRenderer(this, 0, 0);
        box1.addBox(0.0F, 0.0F, 0.0F, 11, 4, 11);
        box1.setRotationPoint(-6F, 13F, -7.5F);
        box0.addBox(0.0F, 0.0F, 0.0F, 11, 6, 11);
        box0.setRotationPoint(-6F, 16F, -6F);
    }

    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        setRotationAngles(par2, par3, par4, par5, par6, par7);
        box1.render(par7);
        box0.render(par7);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        box1.rotateAngleX = 0.5934119F;
    }

    public ModelRenderer box1;
    public ModelRenderer box0;
}
