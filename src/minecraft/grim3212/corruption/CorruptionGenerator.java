package grim3212.corruption;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class CorruptionGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}

	}

	private void generateSurface(World world, Random random, int blockX, int blockZ) {

		
	}

	private void generateNether(World world, Random random, int blockX, int blockZ) {
		for (int var5 = 0; var5 < 39; ++var5) {
			int var6 = blockX + random.nextInt(16);
			int var7 = random.nextInt(128);
			int var8 = blockZ + random.nextInt(16);
			(new GenCorruption(10, Corruption.CorruptionBlock.blockID)).generate(world, random, var6, var7, var8);
		}
	}

}
