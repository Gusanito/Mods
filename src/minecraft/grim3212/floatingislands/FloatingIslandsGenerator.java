package grim3212.floatingislands;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class FloatingIslandsGenerator implements IWorldGenerator {

	 public static int spawnrate = 12;
	 public static int sizevariancefrom7 = 5;
	 
	 public static ArrayList myArr = new ArrayList();
	
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateSurface(World world, Random random, int blockX,
			int blockZ) {
		if(random.nextInt(spawnrate) == 0) {
	         int var5 = 128;
	         boolean var6 = true;
	         boolean var7 = true;

	         while(var6) {
	            if(world.isAirBlock(blockX, var5, blockZ)) {
	               --var5;
	            } else {
	               var6 = false;
	            }
	         }

	         int var8 = world.getBlockId(blockX, var5, blockZ);
	         if(!myArr.contains(Integer.valueOf(var8)) && world.isBlockOpaqueCube(blockX, var5, blockZ)) {
	            FI_WGF.Place(world, random, blockX, var5, blockZ);
	         }
	      }
	}

	private void generateNether(World world, Random random, int blockX,
			int blockZ) {

	}

}
