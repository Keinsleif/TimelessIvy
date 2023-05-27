package keinsleif.timeless_ivy.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

public class ConfigLoader {
    public static Configuration config;

    public static int manaPerDamage = 1000;

    public static void loadConfig(File configFile){
        config = new Configuration(configFile);
        config.load();
        load();
    }

    public static void load() {
        String desc;

        desc = "The amount of mana used for repairing";
        manaPerDamage = loadPropInt("manaPerDamage",desc,manaPerDamage);

        if(config.hasChanged()){
            config.save();
        }
    }

    public static void loadPostInit(){
        if(config.hasChanged()){
            config.save();
        }
    }

    public static int loadPropInt(String propName, String desc, int default_) {
        Property prop = config.get(Configuration.CATEGORY_GENERAL, propName, default_);
        prop.setComment(desc);

        return prop.getInt(default_);
    }
}
