package grim3212.raygun;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityAdvRayw extends Entity {

	private int xTileRayw = -1;
	   private int yTileRayw = -1;
	   private int zTileRayw = -1;
	   private int inTileRayw = 0;
	   private boolean inGroundRayw = false;
	   public int shakeRayw = 0;
	   private EntityLiving shootingEntity;
	   private int field_810_h;
	   private int field_809_i = 0;


	   public EntityAdvRayw(World var1) {
	      super(var1);
	      this.setSize(0.2F, 0.2F);
	   }

	   protected void entityInit() {}

	   public boolean isInRangeToRenderDist(double var1) {
	      return true;
	   }

	   public EntityAdvRayw(World var1, EntityLiving var2) {
	      super(var1);
	      this.shootingEntity = var2;
	      this.setSize(0.2F, 0.2F);
	      this.setLocationAndAngles(var2.posX, var2.posY + (double)var2.getEyeHeight(), var2.posZ, var2.rotationYaw, var2.rotationPitch);
	      this.posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0F * 3.141593F) * 0.16F);
	      this.posY -= 0.10000000149011612D;
	      this.posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0F * 3.141593F) * 0.16F);
	      this.setPosition(this.posX, this.posY, this.posZ);
	      this.yOffset = 0.0F;
	      float var3 = 12.0F;
	      this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * 3.141593F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.141593F) * var3);
	      this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * 3.141593F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.141593F) * var3);
	      this.motionY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * 3.141593F) * var3);
	      this.func_467_a(this.motionX, this.motionY, this.motionZ, 1.5F, 1.0F);
	   }

	   public EntityAdvRayw(World var1, double var2, double var4, double var6) {
	      super(var1);
	      this.field_810_h = 0;
	      this.setSize(0.2F, 0.2F);
	      this.setPosition(var2, var4, var6);
	      this.yOffset = 0.0F;
	   }

	   public void func_467_a(double var1, double var3, double var5, float var7, float var8) {
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
	      this.field_810_h = 0;
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
	      if(this.shakeRayw > 5) {
	         --this.shakeRayw;
	      }

	      if(this.inGroundRayw) {
	         int var1 = this.worldObj.getBlockId(this.xTileRayw, this.yTileRayw, this.zTileRayw);
	         if(var1 == this.inTileRayw) {
	            ++this.field_810_h;
	            if(this.field_810_h == 1200) {
	               this.setDead();
	            }

	            return;
	         }

	         this.inGroundRayw = false;
	         this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
	         this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
	         this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
	         this.field_810_h = 0;
	         this.field_809_i = 0;
	      } else {
	         ++this.field_809_i;
	      }

	      Vec3 var16 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
	      Vec3 var2 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
	      MovingObjectPosition var3 = this.worldObj.rayTraceBlocks(var16, var2);
	      var16 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
	      var2 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
	      if(var3 != null) {
	         var2 = this.worldObj.getWorldVec3Pool().getVecFromPool(var3.hitVec.xCoord, var3.hitVec.yCoord, var3.hitVec.zCoord);
	      }

	      if(!this.worldObj.isRemote) {
	         Entity var4 = null;
	         List var5 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
	         double var6 = 0.0D;

	         for(int var8 = 0; var8 < var5.size(); ++var8) {
	            Entity var9 = (Entity)var5.get(var8);
	            if(var9.canBeCollidedWith() && (var9 != this.shootingEntity || this.field_809_i >= 5)) {
	               float var10 = 0.2F;
	               float var11 = 0.2F;
	               AxisAlignedBB var12 = var9.boundingBox.expand((double)var10, (double)var10, (double)var11);
	               MovingObjectPosition var13 = var12.calculateIntercept(var16, var2);
	               if(var13 != null) {
	                  double var14 = var16.distanceTo(var13.hitVec);
	                  if(var14 < var6 || var6 == 0.0D) {
	                     var4 = var9;
	                     var6 = var14;
	                  }
	               }
	            }
	         }

	         if(var4 != null) {
	            var3 = new MovingObjectPosition(var4);
	         }
	      }

	      if(var3 != null) {
	         if(var3.entityHit != null) {
	            DamageSource var17;
	            if(this.shootingEntity == null) {
	               var17 = DamageSource.causeThrownDamage(this, this);
	               if(!var3.entityHit.attackEntityFrom(var17, 20)) {
	                  ;
	               }
	            } else {
	               var17 = DamageSource.causeThrownDamage(this, this.shootingEntity);
	               if(!var3.entityHit.attackEntityFrom(var17, 20)) {
	                  ;
	               }
	            }
	         }

	         for(int var19 = 0; var19 < 8; ++var19) {
	            this.worldObj.spawnParticle("largesmoke", this.posX + 0.15D, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
	            this.worldObj.spawnParticle("largesmoke", this.posX, this.posY + 0.15D, this.posZ, 0.0D, 0.0D, 0.0D);
	            this.worldObj.spawnParticle("largesmoke", this.posX, this.posY, this.posZ + 0.15D, 0.0D, 0.0D, 0.0D);
	            this.worldObj.spawnParticle("largesmoke", this.posX - 0.15D, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
	            this.worldObj.spawnParticle("largesmoke", this.posX, this.posY, this.posZ - 0.15D, 0.0D, 0.0D, 0.0D);
	            this.worldObj.spawnParticle("largesmoke", this.posX, this.posY - 0.15D, this.posZ, 0.0D, 0.0D, 0.0D);
	            this.worldObj.spawnParticle("largesmoke", this.posX + 0.05D, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
	            this.worldObj.spawnParticle("largesmoke", this.posX, this.posY + 0.05D, this.posZ, 0.0D, 0.0D, 0.0D);
	            this.worldObj.spawnParticle("largesmoke", this.posX, this.posY, this.posZ + 0.05D, 0.0D, 0.0D, 0.0D);
	            this.worldObj.spawnParticle("largesmoke", this.posX - 0.05D, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
	            this.worldObj.spawnParticle("largesmoke", this.posX, this.posY, this.posZ - 0.05D, 0.0D, 0.0D, 0.0D);
	            this.worldObj.spawnParticle("largesmoke", this.posX, this.posY - 0.05D, this.posZ, 0.0D, 0.0D, 0.0D);
	         }

	         this.worldObj.playSoundAtEntity(this, "rayexp", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
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
	      float var18 = 1.0F;
	      float var21 = 0.0F;
	      if(this.handleWaterMovement()) {
	         for(int var7 = 0; var7 < 4; ++var7) {
	            float var22 = 1.0F;
	            this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)var22, this.posY - this.motionY * (double)var22, this.posZ - this.motionZ * (double)var22, this.motionX, this.motionY, this.motionZ);
	         }

	         var18 = 1.0F;
	      }

	      this.motionX *= (double)var18;
	      this.motionY *= (double)var18;
	      this.motionZ *= (double)var18;
	      this.motionY -= (double)var21;
	      this.setPosition(this.posX, this.posY, this.posZ);
	   }

	   public void writeEntityToNBT(NBTTagCompound var1) {
	      var1.setShort("xTile", (short)this.xTileRayw);
	      var1.setShort("yTile", (short)this.yTileRayw);
	      var1.setShort("zTile", (short)this.zTileRayw);
	      var1.setByte("inTile", (byte)this.inTileRayw);
	      var1.setByte("shake", (byte)this.shakeRayw);
	      var1.setByte("inGround", (byte)(this.inGroundRayw?1:0));
	   }

	   public void readEntityFromNBT(NBTTagCompound var1) {
	      this.xTileRayw = var1.getShort("xTile");
	      this.yTileRayw = var1.getShort("yTile");
	      this.zTileRayw = var1.getShort("zTile");
	      this.inTileRayw = var1.getByte("inTile") & 255;
	      this.shakeRayw = var1.getByte("shake") & 255;
	      this.inGroundRayw = var1.getByte("inGround") == 1;
	   }

	   public void onCollideWithPlayer(EntityPlayer var1) {
	      if(this.inGroundRayw && this.shootingEntity == var1 && this.shakeRayw <= 0 && var1.inventory.addItemStackToInventory(new ItemStack(Item.arrow, 1))) {
	         this.worldObj.playSoundAtEntity(this, "random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
	         var1.onItemPickup(this, 1);
	         this.setDead();
	      }

	   }

	   public float getShadowSize() {
	      return 0.0F;
	   }
}
