package grim3212.togglerack;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class BlockToggleRack extends Block
{
    public BlockToggleRack(int var1, int var2)
    {
        super(var1, Material.rock);
    }

    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5)
    {
        if (var1.isBlockIndirectlyGettingPowered(var2, var3, var4))
        {
            var1.setBlock(var2, var3 + 1, var4, Block.fire.blockID);
        }
        else
        {
            var1.setBlock(var2, var3 + 1, var4, 0);
        }
    }
    
    public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("ToggleRack:togglerack");
	}
}