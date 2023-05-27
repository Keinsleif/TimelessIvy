package keinsleif.timeless_ivy.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class InitItem {
    public static final Item regenIvy = new ItemRegenIvy();
    public static void registerItems(RegistryEvent.Register<Item> event){
        IForgeRegistry<Item> r = event.getRegistry();
        r.register(regenIvy);
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(regenIvy, 0, new ModelResourceLocation(regenIvy.getRegistryName(), "inventory"));
    }
}
