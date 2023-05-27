package keinsleif.timeless_ivy.helper;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemNBTHelper {
    public static NBTTagCompound getNBT(ItemStack stack) {
        if(!stack.hasTagCompound())
            stack.setTagCompound(new NBTTagCompound());
        return stack.getTagCompound();
    }

    public static void setBoolean(ItemStack stack, String tag, boolean b) {
        getNBT(stack).setBoolean(tag, b);
    }

    public static boolean getBoolean(ItemStack stack, String tag, boolean defaultExpected) {
        return verifyExistance(stack, tag) ? getNBT(stack).getBoolean(tag) : defaultExpected;
    }

    public static boolean verifyExistance(ItemStack stack, String tag) {
        return !stack.isEmpty() && getNBT(stack).hasKey(tag);
    }
}
