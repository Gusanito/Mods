package grim3212.mysticpack;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class MysticStonesGenerator implements IWorldGenerator {

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
		for (int k = 0; k < 1; k++) {
			int i2 = blockX + random.nextInt(16);
			int k3 = random.nextInt(40) + 20;
			int i5 = blockZ + random.nextInt(16);
			(new WorldGenMinable(MysticStones.anorthositeSmooth.blockID, 12)).generate(world, random, i2, k3, i5);
		}

		for (int l = 0; l < 3; l++) {
			int j2 = blockX + random.nextInt(16);
			int l3 = random.nextInt(80) + 40;
			int j5 = blockZ + random.nextInt(16);
			(new WorldGenMinable(MysticStones.limestoneSmooth.blockID, 24)).generate(world, random, j2, l3, j5);
		}

		for (int i1 = 0; i1 < 2; i1++) {
			int k2 = blockX + random.nextInt(16);
			int i4 = random.nextInt(80) + 40;
			int k5 = blockZ + random.nextInt(16);
			(new WorldGenMinable(MysticStones.migmatiteSmooth.blockID, 24)).generate(world, random, k2, i4, k5);
		}

		for (int j1 = 0; j1 < 2; j1++) {
			int l2 = blockX + random.nextInt(16);
			int j4 = random.nextInt(80);
			int l5 = blockZ + random.nextInt(16);
			(new WorldGenMinable(MysticStones.orthogneissSmooth.blockID, 24)).generate(world, random, l2, j4, l5);
		}

		for (int k1 = 0; k1 < 1; k1++) {
			int i3 = blockX + random.nextInt(16);
			int k4 = random.nextInt(40);
			int i6 = blockZ + random.nextInt(16);
			(new WorldGenMinable(MysticStones.marbleSmooth.blockID, 12)).generate(world, random, i3, k4, i6);
		}

		for (int l1 = 0; l1 < 1; l1++) {
			int j3 = blockX + random.nextInt(16);
			int l4 = random.nextInt(40) + 20;
			int j6 = blockZ + random.nextInt(16);
			(new WorldGenMinable(MysticStones.slateSmooth.blockID, 12)).generate(world, random, j3, l4, j6);
		}
	}
	
	private void generateNether(World world, Random random, int blockX, int blockZ) {

	}

}
