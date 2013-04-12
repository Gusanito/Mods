package grim3212.raygun;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class ElementGenerator implements IWorldGenerator {

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
		for (int var5 = 0; var5 < 7; ++var5) {
			int var6 = blockX + random.nextInt(16);
			int var7 = random.nextInt(32);
			int var8 = blockZ + random.nextInt(16);
			(new WorldGenMinable(Raygun.element.blockID, 4)).generate(world, random, var6, var7, var8);
		}
	}

	private void generateNether(World world, Random random, int blockX,
			int blockZ) {

	}

}
