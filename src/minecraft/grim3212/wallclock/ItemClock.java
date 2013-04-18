package grim3212.wallclock;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemReed;

public class ItemClock extends ItemReed{

	public ItemClock(int par1, Block par2Block) {
		super(par1, par2Block);
	}
	
	public void updateIcons(IconRegister par1IconRegister) {
		this.iconIndex = par1IconRegister.registerIcon("WallClock:" + "wallclockItem");
	}

}
