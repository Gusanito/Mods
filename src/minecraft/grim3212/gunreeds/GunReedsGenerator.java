package grim3212.gunreeds;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class GunReedsGenerator implements IWorldGenerator {

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

		int Xcoord1 = blockX + random.nextInt(16);
		int Ycoord1 = random.nextInt(80);
		int Zcoord1 = blockZ + random.nextInt(16);

		(new WorldGenGunReeds()).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
	}

	private void generateNether(World world, Random random, int blockX, int blockZ) {

	}

}
