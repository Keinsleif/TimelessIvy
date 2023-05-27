package keinsleif.timeless_ivy.item;

import keinsleif.timeless_ivy.TimelessIvy;
import keinsleif.timeless_ivy.gui.TimelessIvyCreativeTab;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TimelessIvy.MOD_ID)
public class ItemRegenIvy extends Item {
    public static final String TAG_REGEN = "Botania_regenIvy";
    public ItemRegenIvy() {
        setCreativeTab(TimelessIvyCreativeTab.INSTANCE);
        setRegistryName(TimelessIvy.MOD_ID,"regenIvy");
        setUnlocalizedName("regenIvy");
    }
}
