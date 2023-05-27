package keinsleif.timeless_ivy.gui;

import keinsleif.timeless_ivy.TimelessIvy;
import keinsleif.timeless_ivy.item.InitItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;

public final class TimelessIvyCreativeTab extends CreativeTabs {
    public static final TimelessIvyCreativeTab INSTANCE = new TimelessIvyCreativeTab();
    NonNullList<ItemStack> list;

    public TimelessIvyCreativeTab() {
        super(TimelessIvy.MOD_ID);
        setNoTitle();
    }

    @Nonnull
    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(InitItem.regenIvy);
    }
}
