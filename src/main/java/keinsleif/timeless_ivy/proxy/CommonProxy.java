package keinsleif.timeless_ivy.proxy;

import keinsleif.timeless_ivy.TimelessIvy;
import keinsleif.timeless_ivy.config.ConfigLoader;
import keinsleif.timeless_ivy.helper.ItemNBTHelper;
import keinsleif.timeless_ivy.item.InitItem;
import keinsleif.timeless_ivy.recipe.InitRecipe;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import vazkii.botania.api.mana.ManaItemHandler;

import java.sql.Time;

import static keinsleif.timeless_ivy.item.ItemRegenIvy.TAG_REGEN;

@Mod.EventBusSubscriber(modid = TimelessIvy.MOD_ID)
public abstract class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {}
    public void init(FMLInitializationEvent event) {}
    public void postInit(FMLPostInitializationEvent event) {}

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        TimelessIvy.logger.info("TimelessIvy registerItems");
        InitItem.registerItems(event);
    }

    @SubscribeEvent
    public void registerRecipes(RegistryEvent.Register<IRecipe> event){
        TimelessIvy.logger.info("TimelessIvy registerRecipes");
        InitRecipe.registerRecipes(event);
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
        if(event.getModID().equals(TimelessIvy.MOD_ID)){
            ConfigLoader.load();
        }
    }
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onTick(TickEvent.PlayerTickEvent event) {
        if(event.phase == TickEvent.Phase.END && !event.player.world.isRemote){
            for(int i = 0; i < event.player.inventory.getSizeInventory(); i++){
                ItemStack stack = event.player.inventory.getStackInSlot(i);
                if(!stack.isEmpty() && stack.hasTagCompound() && ItemNBTHelper.getBoolean(stack, TAG_REGEN,false) && stack.getItemDamage() > 0 && ManaItemHandler.requestManaExact(stack, event.player, ConfigLoader.manaPerDamage, true)){
                    stack.setItemDamage(stack.getItemDamage() - 1);
                }
            }
        }
    }}
