package grim3212.blackdiamond;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class BlackGenerator implements IWorldGenerator {

	@Override
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
		
		for(int k = 0; k < 1; k++)
        {
            int l = blockX + random.nextInt(16);
            int i1 = random.nextInt(16);
            int j1 = blockZ + random.nextInt(16);
            (new WorldGenMinable(grim3212.blackdiamond.BlackDiamond.BlackOre.blockID, 5)).generate(world, random, l, i1, j1);
        }
	}

	private void generateNether(World world, Random random, int blockX,
			int blockZ) {

	}

}
