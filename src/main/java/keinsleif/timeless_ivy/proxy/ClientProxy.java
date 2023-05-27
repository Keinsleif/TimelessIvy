package keinsleif.timeless_ivy.proxy;

import keinsleif.timeless_ivy.TimelessIvy;
import keinsleif.timeless_ivy.config.ConfigLoader;
import keinsleif.timeless_ivy.helper.ItemNBTHelper;
import keinsleif.timeless_ivy.item.InitItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import vazkii.botania.api.mana.ManaItemHandler;

import static keinsleif.timeless_ivy.item.ItemRegenIvy.TAG_REGEN;

public class ClientProxy extends CommonProxy {
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        TimelessIvy.logger.info("TimelessIvy registerModels");
        InitItem.registerModels(event);
    }
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onTooltipEvent(ItemTooltipEvent event) {
        if(event.getItemStack().hasTagCompound() && ItemNBTHelper.getBoolean(event.getItemStack(), TAG_REGEN, false))
            event.getToolTip().add(I18n.format("timeless_ivy.hasRegenIvy"));
    }
}
