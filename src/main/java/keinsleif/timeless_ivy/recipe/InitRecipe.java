package keinsleif.timeless_ivy.recipe;

import keinsleif.timeless_ivy.TimelessIvy;
import keinsleif.timeless_ivy.item.InitItem;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class InitRecipe {
    public static ResourceLocation recipeRegenIvy;
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event){
        IForgeRegistry<IRecipe> r = event.getRegistry();
        r.register(new RecipeRegenIvy().setRegistryName(new ResourceLocation(TimelessIvy.MOD_ID,"regen_ivy_attach")));
    }

    public static void init() {
        recipeRegenIvy = InitItem.regenIvy.getRegistryName();
    }
}
