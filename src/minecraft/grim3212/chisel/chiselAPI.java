package grim3212.chisel;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;

public class chiselAPI
{
    public static List chiselBlocks = new ArrayList();
    public static List chiselItem = new ArrayList();
    public static List chiselItemQuantity = new ArrayList();
    public static List chiselItemDamage = new ArrayList();
    public static List chiselReturnb = new ArrayList();

    public chiselAPI()
    {
    }

    public static void RegisterBlock(int i, int j, Item item, int k, int l)
    {
        chiselBlocks.add(Integer.valueOf(i));
        chiselReturnb.add(Integer.valueOf(j));
        chiselItem.add(item);
        chiselItemQuantity.add(Integer.valueOf(k));
        chiselItemDamage.add(Integer.valueOf(l));
    }
}
