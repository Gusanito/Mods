// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package grim3212.treasuremob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;


// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntityTreasureMob, ModelBase, EntityLiving, 
//            Entity

public class RenderTreasureMob extends RenderLiving
{

    public RenderTreasureMob(ModelBase modelbase, float f)
    {
        super(modelbase, f);
    }

    public void func_177_a(EntityTreasureMob entitytreasuremob, double d, double d1, double d2, 
            float f, float f1)
    {
        super.doRenderLiving(entitytreasuremob, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        func_177_a((EntityTreasureMob)entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_177_a((EntityTreasureMob)entity, d, d1, d2, f, f1);
    }
}
