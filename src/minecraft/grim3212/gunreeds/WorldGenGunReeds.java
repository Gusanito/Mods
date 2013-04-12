package grim3212.gunreeds;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenGunReeds extends WorldGenerator{

	public boolean generate(World world, Random random, int i, int j, int k)
    {
		for (int var6 = 0; var6 < 20; ++var6)
        {
            int var7 = i + random.nextInt(4) - random.nextInt(4);
            int var8 = j;
            int var9 = k + random.nextInt(4) - random.nextInt(4);

            if (world.isAirBlock(var7, j, var9) && (world.getBlockMaterial(var7 - 1, j - 1, var9) == Material.water || world.getBlockMaterial(var7 + 1, j - 1, var9) == Material.water || world.getBlockMaterial(var7, j - 1, var9 - 1) == Material.water || world.getBlockMaterial(var7, j - 1, var9 + 1) == Material.water))
            {
                int var10 = 2 + random.nextInt(random.nextInt(3) + 1);

                for (int var11 = 0; var11 < var10; ++var11)
                {
                    if (GunpowderReed.greedBlock.canBlockStay(world, var7, var8 + var11, var9))
                    {
                        world.setBlock(var7, var8 + var11, var9, GunpowderReed.greedBlock.blockID);
                    }
                }
            }
        }
    	return true;
    }
	
}
