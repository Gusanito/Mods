package grim3212.displaycases;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemDisplay3 extends ItemBlock
{
    public ItemDisplay3(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }

    public Icon getIconFromDamage(int i)
    {
        return DisplayCases.display.getBlockTextureFromSideAndMetadata(2, i);
    }

    public int getPlacedBlockMetadata(int i)
    {
        return i;
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        return (new StringBuilder(String.valueOf(super.getUnlocalizedName()))).toString();
    }
}
