package keinsleif.timeless_ivy;

import keinsleif.timeless_ivy.config.ConfigLoader;
import keinsleif.timeless_ivy.lexicon.LexiconData;
import keinsleif.timeless_ivy.proxy.CommonProxy;
import keinsleif.timeless_ivy.recipe.InitRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = TimelessIvy.MOD_ID, name = TimelessIvy.NAME, version = TimelessIvy.VERSION, guiFactory = "keinsleif.timeless_ivy.gui.GuiFactory")
public class TimelessIvy {
    public static final String MOD_ID = "timeless_ivy";
    public static final String NAME = "TimelessIvy";
    public static final String VERSION = "0.0.1";

    public static final String CLIENT_PROXY = "keinsleif.timeless_ivy.proxy.ClientProxy";
    public static final String SERVER_PROXY = "keinsleif.timeless_ivy.proxy.ServerProxy";

    public static Logger logger;

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void construct(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(proxy);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("TimelessIvy preInit");
        ConfigLoader.loadConfig(event.getSuggestedConfigurationFile());
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("TimelessIvy init");
        InitRecipe.init();
        LexiconData.init();
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info("TimelessIvy postInit");
        proxy.postInit(event);
    }
}
