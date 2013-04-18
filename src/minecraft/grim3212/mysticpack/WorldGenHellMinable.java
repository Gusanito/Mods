package grim3212.mysticpack;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenHellMinable extends WorldGenerator
{
    private int field_27677_a;
    private int field_27676_b;

    public WorldGenHellMinable(int i, int j)
    {
        field_27677_a = i;
        field_27676_b = j;
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        float f = random.nextFloat() * (float)Math.PI;
        double d = (float)(i + 8) + (MathHelper.sin(f) * (float)field_27676_b) / 8F;
        double d1 = (float)(i + 8) - (MathHelper.sin(f) * (float)field_27676_b) / 8F;
        double d2 = (float)(k + 8) + (MathHelper.cos(f) * (float)field_27676_b) / 8F;
        double d3 = (float)(k + 8) - (MathHelper.cos(f) * (float)field_27676_b) / 8F;
        double d4 = j + random.nextInt(3) + 2;
        double d5 = j + random.nextInt(3) + 2;

        for (int l = 0; l <= field_27676_b; l++)
        {
            double d6 = d + ((d1 - d) * (double)l) / (double)field_27676_b;
            double d7 = d4 + ((d5 - d4) * (double)l) / (double)field_27676_b;
            double d8 = d2 + ((d3 - d2) * (double)l) / (double)field_27676_b;
            double d9 = (random.nextDouble() * (double)field_27676_b) / 16D;
            double d10 = (double)(MathHelper.sin(((float)l * (float)Math.PI) / (float)field_27676_b) + 1.0F) * d9 + 1.0D;
            double d11 = (double)(MathHelper.sin(((float)l * (float)Math.PI) / (float)field_27676_b) + 1.0F) * d9 + 1.0D;
            int i1 = (int)(d6 - d10 / 2D);
            int j1 = (int)(d7 - d11 / 2D);
            int k1 = (int)(d8 - d10 / 2D);
            int l1 = (int)(d6 + d10 / 2D);
            int i2 = (int)(d7 + d11 / 2D);
            int j2 = (int)(d8 + d10 / 2D);

            for (int k2 = i1; k2 <= l1; k2++)
            {
                double d12 = (((double)k2 + 0.5D) - d6) / (d10 / 2D);

                if (d12 * d12 >= 1.0D)
                {
                    continue;
                }

                for (int l2 = j1; l2 <= i2; l2++)
                {
                    double d13 = (((double)l2 + 0.5D) - d7) / (d11 / 2D);

                    if (d12 * d12 + d13 * d13 >= 1.0D)
                    {
                        continue;
                    }

                    for (int i3 = k1; i3 <= j2; i3++)
                    {
                        double d14 = (((double)i3 + 0.5D) - d8) / (d10 / 2D);

                        if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D && world.getBlockId(k2, l2, i3) == Block.netherrack.blockID)
                        {
                            world.setBlock(k2, l2, i3, field_27677_a);
                        }
                    }
                }
            }
        }

        return true;
    }
}
