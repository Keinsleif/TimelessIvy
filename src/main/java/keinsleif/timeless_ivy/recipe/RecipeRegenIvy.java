package keinsleif.timeless_ivy.recipe;

import keinsleif.timeless_ivy.helper.ItemNBTHelper;
import keinsleif.timeless_ivy.item.InitItem;
import keinsleif.timeless_ivy.item.ItemRegenIvy;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nonnull;

public class RecipeRegenIvy extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    @Override
    public boolean isDynamic() {
        return true;
    }

    @Override
    public boolean matches(InventoryCrafting inv, @Nonnull World var2) {
        ItemStack tool = ItemStack.EMPTY;
        boolean foundIvy = false;
        int materialsFound = 0;
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty()) {
                Item item = stack.getItem();
                if (item.isRepairable() && !(stack.hasTagCompound() && ItemNBTHelper.getBoolean(stack, ItemRegenIvy.TAG_REGEN, false)))
                    tool = stack;
                else if (item == InitItem.regenIvy)
                    foundIvy = true;
            }
        }
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty()) {
                Item item = stack.getItem();

                if (!tool.isEmpty() && tool.getItem().getIsRepairable(tool, stack))
                    materialsFound++;

                else if (stack != tool && item != InitItem.regenIvy)
                    return false;
            }
        }

        return !tool.isEmpty() && foundIvy && materialsFound == 3;
    }

    @Nonnull
    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        ItemStack tool = ItemStack.EMPTY;

        for(int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if(!stack.isEmpty() && stack.getItem().isDamageable())
                tool = stack;
        }

        ItemStack copy = tool.copy();
        ItemNBTHelper.setBoolean(copy, ItemRegenIvy.TAG_REGEN, true);
        copy.setCount(1);
        return copy;
    }

    @Override
    public boolean canFit(int width, int height) {
        return width*height >= 2;
    }

    @Nonnull
    @Override
    public ItemStack getRecipeOutput() {
        return ItemStack.EMPTY;
    }
}

