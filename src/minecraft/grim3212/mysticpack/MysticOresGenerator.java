package grim3212.mysticpack;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class MysticOresGenerator implements IWorldGenerator {

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
		for (int k = 0; k < 2; k++) {
			int k2 = blockX + random.nextInt(16);
			int k4 = random.nextInt(64);
			int k6 = blockZ + random.nextInt(16);
			(new WorldGenMinable(MysticOres.mithril.blockID, 6)).generate(world, random, k2, k4, k6);
		}

		for (int l = 0; l < 1; l++) {
			int l2 = blockX + random.nextInt(16);
			int l4 = random.nextInt(16);
			int l6 = blockZ + random.nextInt(16);
			(new WorldGenMinable(MysticOres.adamantine.blockID, 3)).generate(world, random, l2, l4, l6);
		}

		for (int i1 = 0; i1 < 12; i1++) {
			int i3 = blockX + random.nextInt(16);
			int i5 = random.nextInt(64) + 48;
			int i7 = blockZ + random.nextInt(16);
			(new WorldGenMinable(MysticOres.verdite.blockID, 9)).generate(world, random, i3, i5, i7);
		}

		for (int j1 = 0; j1 < 4; j1++) {
			int j3 = blockX + random.nextInt(16);
			int j5 = random.nextInt(30) + 50;
			int j7 = blockZ + random.nextInt(16);
			(new WorldGenMinable(MysticOres.emerald.blockID, 3)).generate(world, random, j3, j5, j7);
		}

		for (int k1 = 0; k1 < 4; k1++) {
			int k3 = blockX + random.nextInt(16);
			int k5 = random.nextInt(30) + 60;
			int k7 = blockZ + random.nextInt(16);
			(new WorldGenMinable(MysticOres.sapphire.blockID, 3)).generate(world, random, k3, k5, k7);
		}

		for (int l1 = 0; l1 < 3; l1++) {
			int l3 = blockX + random.nextInt(16);
			int l5 = random.nextInt(30) + 70;
			int l7 = blockZ + random.nextInt(16);
			(new WorldGenMinable(MysticOres.topaz.blockID, 3)).generate(world, random, l3, l5, l7);
		}

		for (int i2 = 0; i2 < 3; i2++) {
			int i4 = blockX + random.nextInt(16);
			int i6 = random.nextInt(30) + 80;
			int i8 = blockZ + random.nextInt(16);
			(new WorldGenMinable(MysticOres.amethyst.blockID, 3)).generate(world, random, i4, i6, i8);
		}

		for (int j2 = 0; j2 < 1; j2++) {
			int j4 = blockX + random.nextInt(16);
			int j6 = random.nextInt(12);
			int j8 = blockZ + random.nextInt(16);
			(new WorldGenMinable(MysticOres.iridium.blockID, 6)).generate(world, random, j4, j6, j8);
		}
	}
	
	private void generateNether(World world, Random random, int blockX, int blockZ) {

		for (int k = 0; k < 8; k++) {
			int k1 = blockX + random.nextInt(16);
			int k2 = random.nextInt(100);
			int k3 = blockZ + random.nextInt(16);
			(new WorldGenHellMinable(MysticOres.soulstoneBlack.blockID, 8)).generate(world, random, k1, k2, k3);
		}

		for (int l = 0; l < 4; l++) {
			int l1 = blockX + random.nextInt(16);
			int l2 = random.nextInt(100);
			int l3 = blockZ + random.nextInt(16);
			(new WorldGenHellMinable(MysticOres.soulstoneRed.blockID, 6)).generate(world, random, l1, l2, l3);
		}

		for (int i1 = 0; i1 < 2; i1++) {
			int i2 = blockX + random.nextInt(16);
			int i3 = random.nextInt(100);
			int i4 = blockZ + random.nextInt(16);
			(new WorldGenHellMinable(MysticOres.soulstoneBlue.blockID, 4)).generate(world, random, i2, i3, i4);
		}

		for (int j1 = 0; j1 < 2; j1++) {
			int j2 = blockX + random.nextInt(16);
			int j3 = random.nextInt(4) + 28;
			int j4 = blockZ + random.nextInt(16);
			(new WorldGenHellMinable(MysticOres.bloodstone.blockID, 12)).generate(world, random, j2, j3, j4);
		}
	}

}
