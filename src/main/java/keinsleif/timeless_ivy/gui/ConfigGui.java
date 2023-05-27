package keinsleif.timeless_ivy.gui;

import keinsleif.timeless_ivy.TimelessIvy;
import keinsleif.timeless_ivy.config.ConfigLoader;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;


public class ConfigGui extends GuiConfig {
    public ConfigGui(GuiScreen parentScreen) {
        super(parentScreen, new ConfigElement(ConfigLoader.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), TimelessIvy.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigLoader.config.toString()));
    }

}