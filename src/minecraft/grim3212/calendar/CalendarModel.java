package grim3212.calendar;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class CalendarModel extends ModelBase
{
    public ModelRenderer calBoard;

    public CalendarModel()
    {
        calBoard = new ModelRenderer(this, "CalenderModel");
        calBoard.addBox(-6F, -18F, -1F, 12, 20, 2, 0.0F);
    }

    public void renderSign()
    {
        calBoard.render(0.0625F);
    }
}
