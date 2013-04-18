package grim3212.mysticpack;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenMysticRuinsVines extends WorldGenerator
{
    public WorldGenMysticRuinsVines()
    {
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        for (int l = 0; l < 110; l++)
        {
            int i1 = (i + random.nextInt(8)) - random.nextInt(8);
            int j1 = (j + random.nextInt(4)) - random.nextInt(4);
            int k1 = (k + random.nextInt(8)) - random.nextInt(8);

            for (int l1 = 0; l1 < 1; l1++)
            {
                if ((world.getBlockId(i1, j1 + 1, k1) != Block.dirt.blockID || !world.isAirBlock(i1, j1, k1) || !world.isAirBlock(i1, j1 - 1, k1) || !world.isAirBlock(i1, j1 - 2, k1) || !world.isAirBlock(i1, j1 - 3, k1) || !world.isAirBlock(i1, j1 - 4, k1)) && (world.getBlockId(i1, j1 + 1, k1) != Block.leaves.blockID || !world.isAirBlock(i1, j1, k1) || !world.isAirBlock(i1, j1 - 1, k1) || !world.isAirBlock(i1, j1 - 2, k1) || !world.isAirBlock(i1, j1 - 3, k1) || !world.isAirBlock(i1, j1 - 4, k1)) && (world.getBlockId(i1, j1 + 1, k1) != Block.stone.blockID || !world.isAirBlock(i1, j1, k1) || !world.isAirBlock(i1, j1 - 1, k1) || !world.isAirBlock(i1, j1 - 2, k1) || !world.isAirBlock(i1, j1 - 3, k1) || !world.isAirBlock(i1, j1 - 4, k1)))
                {
                    continue;
                }

                int i2 = random.nextInt(3);

                if (i2 == 0)
                {
                    world.setBlock(i1, j1, k1, MysticRuins.vines.blockID);
                    world.setBlock(i1, j1 - 1, k1, MysticRuins.vines.blockID);
                }

                if (i2 == 1)
                {
                    world.setBlock(i1, j1, k1, MysticRuins.vines.blockID);
                    world.setBlock(i1, j1 - 1, k1, MysticRuins.vines.blockID);
                    world.setBlock(i1, j1 - 2, k1, MysticRuins.vines.blockID);
                }

                if (i2 == 2)
                {
                    world.setBlock(i1, j1, k1, MysticRuins.vines.blockID);
                    world.setBlock(i1, j1 - 1, k1, MysticRuins.vines.blockID);
                    world.setBlock(i1, j1 - 2, k1, MysticRuins.vines.blockID);
                    world.setBlock(i1, j1 - 3, k1, MysticRuins.vines.blockID);
                }
            }
        }

        return true;
    }
}
