package grim3212.pokeball;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityPokeball extends Entity {

   private Pokeball instance;
   private int field_22027_b;
   private int field_22026_c;
   private int isRepeaterPowered;
   private int field_22024_a;
   private boolean field_22023_b;
   public int field_22028_a;
   private EntityLiving field_22022_g;
   private int redstoneRepeaterIdle;
   private int redstoneRepeaterActive;
   private int mob;
   private boolean bed;
   private boolean setted;
   public EntityPlayer entityplayer;


   public EntityPokeball(World var1) {
      super(var1);
      this.field_22027_b = -1;
      this.field_22026_c = -1;
      this.isRepeaterPowered = -1;
      this.field_22024_a = 0;
      this.field_22023_b = false;
      this.field_22028_a = 0;
      this.redstoneRepeaterActive = 0;
      this.setSize(0.25F, 0.25F);
   }

   public EntityPokeball(World var1, EntityLiving var2, int var3) {
      this(var1, var2);
      if(var3 == 0) {
         this.bed = true;
      } else {
         this.bed = false;
      }

      this.setted = false;
      this.mob = var3;
      this.instance = this.instance;
   }

   public EntityPokeball(World var1, EntityLiving var2) {
      super(var1);
      this.field_22027_b = -1;
      this.field_22026_c = -1;
      this.isRepeaterPowered = -1;
      this.field_22024_a = 0;
      this.field_22023_b = false;
      this.field_22028_a = 0;
      this.redstoneRepeaterActive = 0;
      this.field_22022_g = var2;
      this.setSize(0.25F, 0.25F);
      this.setLocationAndAngles(var2.posX, var2.posY + (double)var2.getEyeHeight(), var2.posZ, var2.rotationYaw, var2.rotationPitch);
      this.posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0F * 3.141593F) * 0.16F);
      this.posY -= 0.10000000149011612D;
      this.posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0F * 3.141593F) * 0.16F);
      this.setPosition(this.posX, this.posY, this.posZ);
      this.yOffset = 0.0F;
      float var3 = 0.4F;
      this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * 3.141593F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.141593F) * var3);
      this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * 3.141593F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.141593F) * var3);
      this.motionY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * 3.141593F) * var3);
      this.func_22018_a(this.motionX, this.motionY, this.motionZ, 1.5F, 1.0F);
   }

   protected void entityInit() {}

   public boolean isInRangeToRenderDist(double var1) {
      double var3 = this.boundingBox.getAverageEdgeLength() * 4.0D;
      var3 *= 64.0D;
      return var1 < var3 * var3;
   }

   public void func_22018_a(double var1, double var3, double var5, float var7, float var8) {
      float var9 = MathHelper.sqrt_double(var1 * var1 + var3 * var3 + var5 * var5);
      var1 /= (double)var9;
      var3 /= (double)var9;
      var5 /= (double)var9;
      var1 += this.rand.nextGaussian() * 0.007499999832361937D * (double)var8;
      var3 += this.rand.nextGaussian() * 0.007499999832361937D * (double)var8;
      var5 += this.rand.nextGaussian() * 0.007499999832361937D * (double)var8;
      var1 *= (double)var7;
      var3 *= (double)var7;
      var5 *= (double)var7;
      this.motionX = var1;
      this.motionY = var3;
      this.motionZ = var5;
      float var10 = MathHelper.sqrt_double(var1 * var1 + var5 * var5);
      this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(var1, var5) * 180.0D / 3.1415927410125732D);
      this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(var3, (double)var10) * 180.0D / 3.1415927410125732D);
      this.redstoneRepeaterIdle = 0;
   }

   public void setVelocity(double var1, double var3, double var5) {
      this.motionX = var1;
      this.motionY = var3;
      this.motionZ = var5;
      if(this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
         float var7 = MathHelper.sqrt_double(var1 * var1 + var5 * var5);
         this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(var1, var5) * 180.0D / 3.1415927410125732D);
         this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(var3, (double)var7) * 180.0D / 3.1415927410125732D);
      }

   }

   public void onUpdate() {
      this.lastTickPosX = this.posX;
      this.lastTickPosY = this.posY;
      this.lastTickPosZ = this.posZ;
      super.onUpdate();
      if(this.field_22028_a > 0) {
         --this.field_22028_a;
      }

      if(this.field_22023_b) {
         int var1 = this.worldObj.getBlockId(this.field_22027_b, this.field_22026_c, this.isRepeaterPowered);
         if(var1 == this.field_22024_a) {
            ++this.redstoneRepeaterIdle;
            if(this.redstoneRepeaterIdle == 1200) {
               this.setDead();
            }

            return;
         }

         this.field_22023_b = false;
         this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
         this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
         this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
         this.redstoneRepeaterIdle = 0;
         this.redstoneRepeaterActive = 0;
      } else {
         ++this.redstoneRepeaterActive;
      }

      Vec3 var16 = Vec3.fakePool.getVecFromPool(this.posX, this.posY, this.posZ);
      Vec3 var2 = Vec3.fakePool.getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
      MovingObjectPosition var3 = this.worldObj.rayTraceBlocks(var16, var2);
      var16 = Vec3.fakePool.getVecFromPool(this.posX, this.posY, this.posZ);
      var2 = Vec3.fakePool.getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
      if(var3 != null) {
         var2 = Vec3.fakePool.getVecFromPool(var3.hitVec.xCoord, var3.hitVec.yCoord, var3.hitVec.zCoord);
      }

      Entity var4;
      if(!this.worldObj.isRemote) {
         var4 = null;
         List var5 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
         double var6 = 0.0D;

         for(int var8 = 0; var8 < var5.size(); ++var8) {
            Entity var9 = (Entity)var5.get(var8);
            if(var9.canBeCollidedWith() && (var9 != this.field_22022_g || this.redstoneRepeaterActive >= 5)) {
               float var10 = 0.3F;
               AxisAlignedBB var11 = var9.boundingBox.expand((double)var10, (double)var10, (double)var10);
               MovingObjectPosition var12 = var11.calculateIntercept(var16, var2);
               if(var12 != null) {
                  double var13 = var16.distanceTo(var12.hitVec);
                  if(var13 < var6 || var6 == 0.0D) {
                     var4 = var9;
                     var6 = var13;
                  }
               }
            }
         }

         if(var4 != null) {
            var3 = new MovingObjectPosition(var4);
         }
      }

      if(var3 != null) {
         if(var3.entityHit != null && this.bed && var3.entityHit instanceof EntityLiving && !(var3.entityHit instanceof EntityPlayer)) {
            this.setted = true;
            this.mob = EntityList.getEntityID(var3.entityHit);
            ItemStack var17 = new ItemStack(Pokeball.pokeball);
            var17.damageItem(this.mob, field_22022_g);
            var3.entityHit.entityDropItem(var17, 0.0F);
            var3.entityHit.setDead();
         }

         for(int var19 = 0; var19 < 8; ++var19) {
            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
         }

         if(!this.bed) {
            this.setted = true;

            try {
               var4 = EntityList.createEntityByID(this.mob, this.worldObj);
               var4.setLocationAndAngles(this.posX, this.posY + 1.0D, this.posZ, rotationYaw, 0.0F);
               this.worldObj.spawnEntityInWorld(var4);
               this.entityDropItem(new ItemStack(Pokeball.pokeball), 0.0F);
            } catch (Exception var15) {
               var15.printStackTrace();
            }
         }

         if(var3.entityHit == null && this.bed) {
            this.entityDropItem(new ItemStack(Pokeball.pokeball), 0.0F);
         }

         this.setDead();
      }

      this.posX += this.motionX;
      this.posY += this.motionY;
      this.posZ += this.motionZ;
      float var20 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
      this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / 3.1415927410125732D);

      for(this.rotationPitch = (float)(Math.atan2(this.motionY, (double)var20) * 180.0D / 3.1415927410125732D); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F) {
         ;
      }

      while(this.rotationPitch - this.prevRotationPitch >= 180.0F) {
         this.prevRotationPitch += 360.0F;
      }

      while(this.rotationYaw - this.prevRotationYaw < -180.0F) {
         this.prevRotationYaw -= 360.0F;
      }

      while(this.rotationYaw - this.prevRotationYaw >= 180.0F) {
         this.prevRotationYaw += 360.0F;
      }

      this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
      this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
      float var18 = 0.99F;
      float var21 = 0.03F;
      if(this.handleWaterMovement()) {
         for(int var7 = 0; var7 < 4; ++var7) {
            float var22 = 0.25F;
            this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)var22, this.posY - this.motionY * (double)var22, this.posZ - this.motionZ * (double)var22, this.motionX, this.motionY, this.motionZ);
         }

         var18 = 0.8F;
      }

      this.motionX *= (double)var18;
      this.motionY *= (double)var18;
      this.motionZ *= (double)var18;
      this.motionY -= (double)var21;
      this.setPosition(this.posX, this.posY, this.posZ);
   }

   public void writeEntityToNBT(NBTTagCompound var1) {
      var1.setShort("xTile", (short)this.field_22027_b);
      var1.setShort("yTile", (short)this.field_22026_c);
      var1.setShort("zTile", (short)this.isRepeaterPowered);
      var1.setByte("inTile", (byte)this.field_22024_a);
      var1.setByte("shake", (byte)this.field_22028_a);
      var1.setByte("inGround", (byte)(this.field_22023_b?1:0));
   }

   public void readEntityFromNBT(NBTTagCompound var1) {
      this.field_22027_b = var1.getShort("xTile");
      this.field_22026_c = var1.getShort("yTile");
      this.isRepeaterPowered = var1.getShort("zTile");
      this.field_22024_a = var1.getByte("inTile") & 255;
      this.field_22028_a = var1.getByte("shake") & 255;
      this.field_22023_b = var1.getByte("inGround") == 1;
   }

   public float getShadowSize() {
      return 0.0F;
   }
}
