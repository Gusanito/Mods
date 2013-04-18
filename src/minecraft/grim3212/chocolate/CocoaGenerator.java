package grim3212.chocolate;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class CocoaGenerator implements IWorldGenerator {

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

		for (int k = 0; k < 10; k++) {
			int l = random.nextInt(66) + 63;
			int i1 = blockX + random.nextInt(16);
			int j1 = blockZ + random.nextInt(16);
			if ((world.getBlockId(i1, l - 1, j1) == 2 || world.getBlockId(i1, l - 1, j1) == 3) && random.nextInt(10) < 1) {
				(new WorldGenCocoaTrees()).generate(world, random, i1, l, j1);
			}
		}
	}

	private void generateNether(World world, Random random, int blockX, int blockZ) {

	}

}