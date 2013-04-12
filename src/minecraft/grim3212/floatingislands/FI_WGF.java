package grim3212.floatingislands;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;

public class FI_WGF {

   public static ArrayList al = new ArrayList();
   private static WorldGenBigTree obj;


   public static boolean Place(World var0, Random var1, int var2, int var3, int var4) {
      int var5 = 7 + var1.nextInt(FloatingIslandsGenerator.sizevariancefrom7);
      int var6 = var1.nextInt(25) + 20;
      if(128 - var3 < 45) {
         return false;
      } else {
         int var7;
         int var8;
         int var9;
         int var10;
         for(var7 = -var5; var7 <= var5; ++var7) {
            for(var8 = -var5; var8 <= var5; ++var8) {
               if(Math.pow((double)var7, 2.0D) + Math.pow((double)var8, 2.0D) <= Math.pow((double)var5, 2.0D)) {
                  for(var9 = 1; var9 < 17; ++var9) {
                     var10 = var0.getBlockId(var2 + var7, var3 + var9, var4 + var8);
                     if(var10 != 8 && var10 != 9 && var10 != 10 && var10 != 11 && var10 != 12 && var10 != 13) {
                        var0.setBlock(var2 + var7, var3 + var9 + var6, var4 + var8, var10, var0.getBlockMetadata(var2 + var7, var3 + var9, var4 + var8), 0);
                        var0.setBlock(var2 + var7, var3 + var9, var4 + var8, 0);
                     } else {
                        var0.setBlockMetadataWithNotify(var2 + var7, var3 + var9 + var6, var4 + var8, var10, var0.getBlockMetadata(var2 + var7, var3 + var9, var4 + var8));
                        var0.setBlock(var2 + var7, var3 + var9, var4 + var8, 0);
                     }
                  }
               }
            }
         }

         for(var7 = -var5; var7 <= var5; ++var7) {
            for(var8 = -var5; var8 <= var5; ++var8) {
               for(var9 = -var5; var9 <= var5; ++var9) {
                  if(Math.pow((double)var7, 2.0D) + Math.pow((double)var8, 2.0D) + Math.pow((double)var9, 2.0D) <= Math.pow((double)var5, 2.0D) && var3 + var9 <= var3) {
                     var10 = var0.getBlockId(var2 + var7, var3 + var9, var4 + var8);
                     if(var10 != 8 && var10 != 9 && var10 != 10 && var10 != 11 && var10 != 12 && var10 != 13) {
                        var0.setBlock(var2 + var7, var3 + var9 + var6, var4 + var8, var10, var0.getBlockMetadata(var2 + var7, var3 + var9, var4 + var8), 0);
                        var0.setBlock(var2 + var7, var3 + var9, var4 + var8, 0);
                     } else {
                        var0.setBlockMetadataWithNotify(var2 + var7, var3 + var9 + var6, var4 + var8, var10, var0.getBlockMetadata(var2 + var7, var3 + var9, var4 + var8));
                        var0.setBlock(var2 + var7, var3 + var9, var4 + var8, 0);
                     }
                  }
               }
            }
         }

         return true;
      }
   }

   private static String b(Random var0) {
      int var1 = var0.nextInt(4);
      return var1 == 0?"Skeleton":(var1 == 1?"Zombie":(var1 == 2?"Zombie":(var1 == 3?"Spider":"")));
   }

   private static ItemStack a(Random var0) {
      int var1 = var0.nextInt(al.size());
      int var2 = (new ItemStack((Item)al.get(var1))).getMaxStackSize();
      if(var2 > 10) {
         var2 = var0.nextInt(10);
      }

      return new ItemStack((Item)al.get(var1), var2);
   }

   static {
      al.add(Item.appleRed);
      al.add(Item.arrow);
      al.add(Item.coal);
      al.add(Item.stick);
      al.add(Item.silk);
      al.add(Item.feather);
      al.add(Item.wheat);
      al.add(Item.painting);
      al.add(Item.clay);
      al.add(Item.paper);
      al.add(Item.slimeBall);
      al.add(Item.sugar);
   }
}
