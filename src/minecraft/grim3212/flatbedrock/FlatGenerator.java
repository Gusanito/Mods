package grim3212.flatbedrock;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class FlatGenerator implements IWorldGenerator {

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
		for (int k = 1; k <= 5; k++) {
			for (int i1 = blockX; i1 < blockX + 16; i1++) {
				for (int k1 = blockZ; k1 < blockZ + 16; k1++) {
					if (world.getBlockId(i1, k, k1) == Block.bedrock.blockID) {
						world.setBlock(i1, k, k1, Block.stone.blockID, 0, 2);
					}
				}

			}

		}

		for (int l = blockX; l < blockX + 16; l++) {
			for (int j1 = blockZ; j1 < blockZ + 16; j1++) {
				if (world.getBlockId(l, 0, j1) != Block.bedrock.blockID) {
					world.setBlock(l, 0, j1, Block.bedrock.blockID, 0, 2);
				}
			}

		}
	}

	private void generateNether(World world, Random random, int blockX,
			int blockZ) {

	}

}
