package grim3212.corruption;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class CorruptionBlock extends Block {

   public int newBlock;


   protected CorruptionBlock(int var1, int var2) {
      super(var1, Material.wood);
      this.setTickRandomly(true);
   }
   
   public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("Corruption:" + "corruption");
	}

   public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
      boolean var6 = Corruption.corruption;
      super.updateTick(var1, var2, var3, var4, var5);
      if(var6) {
         int var7 = var5.nextInt(3);
         int var8 = var5.nextInt(24);
         int var9 = var5.nextInt(24);
         int var10 = var5.nextInt(24);
         if(var7 == 0) {
            this.newBlock = 87;
         } else if(var7 == 1) {
            this.newBlock = 88;
         } else if(var7 == 2) {
            this.newBlock = Corruption.CorruptionBlock.blockID;
         }

         this.setNewBlock(var1, var2, var3, var4, this.newBlock, var5, var8 + 1);
         this.setNewBlock(var1, var2, var3, var4, this.newBlock, var5, var9 + 1);
         this.setNewBlock(var1, var2, var3, var4, this.newBlock, var5, var10 + 1);
      }

   }

   public void setNewBlock(World var1, int var2, int var3, int var4, int var5, Random var6, int var7) {
      boolean var8 = Corruption.fire;
      if(var7 == 1) {
         ++var2;
         var3 = var3;
         var4 = var4;
      }

      if(var7 == 2) {
         var2 = var2;
         var3 = var3;
         ++var4;
      }

      if(var7 == 3) {
         --var2;
         var3 = var3;
         var4 = var4;
      }

      if(var7 == 4) {
         var2 = var2;
         var3 = var3;
         --var4;
      }

      if(var7 == 5) {
         ++var2;
         var3 = var3;
         ++var4;
      }

      if(var7 == 6) {
         --var2;
         var3 = var3;
         --var4;
      }

      if(var7 == 7) {
         ++var2;
         var3 = var3;
         --var4;
      }

      if(var7 == 8) {
         --var2;
         var3 = var3;
         ++var4;
      }

      if(var7 == 9) {
         ++var2;
         --var3;
         var4 = var4;
      }

      if(var7 == 10) {
         var2 = var2;
         --var3;
         ++var4;
      }

      if(var7 == 11) {
         --var2;
         --var3;
         var4 = var4;
      }

      if(var7 == 12) {
         var2 = var2;
         --var3;
         --var4;
      }

      if(var7 == 13) {
         ++var2;
         --var3;
         ++var4;
      }

      if(var7 == 14) {
         --var2;
         --var3;
         --var4;
      }

      if(var7 == 15) {
         ++var2;
         --var3;
         --var4;
      }

      if(var7 == 16) {
         --var2;
         --var3;
         ++var4;
      }

      if(var7 == 17) {
         ++var2;
         ++var3;
         var4 = var4;
      }

      if(var7 == 18) {
         var2 = var2;
         ++var3;
         ++var4;
      }

      if(var7 == 19) {
         --var2;
         ++var3;
         var4 = var4;
      }

      if(var7 == 20) {
         var2 = var2;
         ++var3;
         --var4;
      }

      if(var7 == 21) {
         ++var2;
         ++var3;
         ++var4;
      }

      if(var7 == 22) {
         --var2;
         ++var3;
         --var4;
      }

      if(var7 == 23) {
         ++var2;
         ++var3;
         --var4;
      }

      if(var7 == 24) {
         --var2;
         ++var3;
         ++var4;
      }

      if(var1.getBlockId(var2, var3, var4) != 8 && var1.getBlockId(var2, var3, var4) != 9) {
         if(var1.getBlockId(var2, var3, var4) != 37 && var1.getBlockId(var2, var3, var4) != 38) {
            if(var1.getBlockId(var2, var3, var4) != 59 && var1.getBlockId(var2, var3, var4) != 83) {
               if(var1.getBlockId(var2, var3, var4) != 87 && var1.getBlockId(var2, var3, var4) != 89 && var1.getBlockId(var2, var3, var4) != 88 && var1.getBlockId(var2, var3, var4) != Corruption.CorruptionBlock.blockID && var1.getBlockId(var2, var3, var4) != 0 && var1.getBlockId(var2, var3, var4) != 90 && var1.getBlockId(var2, var3, var4) != 49 && var1.getBlockId(var2, var3, var4) != 10 && var1.getBlockId(var2, var3, var4) != 11 && var1.getBlockId(var2, var3, var4) != 10 && var1.getBlockId(var2, var3, var4) != 50 && var1.getBlockId(var2, var3, var4) != 51 && var1.getBlockId(var2, var3, var4) != 39 && var1.getBlockId(var2, var3, var4) != 40 && var1.getBlockId(var2, var3, var4) != 53 && var1.getBlockId(var2, var3, var4) != 54 && var1.getBlockId(var2, var3, var4) != 55 && var1.getBlockId(var2, var3, var4) != 61 && var1.getBlockId(var2, var3, var4) != 62 && var1.getBlockId(var2, var3, var4) != 63 && var1.getBlockId(var2, var3, var4) != 64 && var1.getBlockId(var2, var3, var4) != 65 && var1.getBlockId(var2, var3, var4) != 66 && var1.getBlockId(var2, var3, var4) != 67 && var1.getBlockId(var2, var3, var4) != 68 && var1.getBlockId(var2, var3, var4) != 69 && var1.getBlockId(var2, var3, var4) != 70 && var1.getBlockId(var2, var3, var4) != 71 && var1.getBlockId(var2, var3, var4) != 72 && var1.getBlockId(var2, var3, var4) != 75 && var1.getBlockId(var2, var3, var4) != 76 && var1.getBlockId(var2, var3, var4) != 20 && var1.getBlockId(var2, var3, var4) != 77 && var1.getBlockId(var2, var3, var4) != 84 && var1.getBlockId(var2, var3, var4) != 86 && var1.getBlockId(var2, var3, var4) != 91 && var1.getBlockId(var2, var3, var4) != 92 && var1.getBlockId(var2, var3, var4) != 23 && var1.getBlockId(var2, var3, var4) != 58) {
                  int var9 = var6.nextInt(20);
                  if(var8 && var9 < 2 && var1.getBlockId(var2, var3 + 1, var4) == 0) {
                     var1.setBlock(var2, var3 + 1, var4, 51);
                  }

                  var1.setBlock(var2, var3, var4, var5);
               }
            } else {
               var1.setBlock(var2, var3, var4, 40);
            }
         } else {
            var1.setBlock(var2, var3, var4, 39);
         }
      } else {
         var1.setBlock(var2, var3, var4, 11);
      }

   }
}
