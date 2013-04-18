package grim3212.mysticpack;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class MysticRuinsGenerator implements IWorldGenerator {

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
			int j1 = blockX + random.nextInt(16) + 8;
			int i2 = random.nextInt(11) + 60;
			int l2 = blockZ + random.nextInt(16) + 8;
			(new WorldGenMysticRuins()).generate(world, random, j1, i2, l2);
		}

		for (int l = 0; l < 4; l++) {
			int k1 = blockX + random.nextInt(16) + 8;
			int j2 = random.nextInt(100) + 20;
			int i3 = blockZ + random.nextInt(16) + 8;
			(new WorldGenMysticRuinsVines()).generate(world, random, k1, j2, i3);
		}

		for (int i1 = 0; i1 < 1; i1++) {
			int l1 = blockX + random.nextInt(16) + 8;
			int k2 = random.nextInt(9) + 28;
			int j3 = blockZ + random.nextInt(16) + 8;
			(new WorldGenMysticDungeons()).generate(world, random, l1, k2, j3);
		}
	}
	
	private void generateNether(World world, Random random, int blockX, int blockZ) {

	}

}
