package de.scholle.potionBrewingDisabler;

import de.scholle.potionBrewingDisabler.listeners.PotionBrewListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class PotionBrewingDisabler extends JavaPlugin {

    private static PotionBrewingDisabler instance;
    private List<String> disabledPotions;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        disabledPotions = getConfig().getStringList("disabled-potions");
        getServer().getPluginManager().registerEvents(new PotionBrewListener(), this);
        getLogger().info("PotionBrewingDisabler enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("PotionBrewingDisabler disabled!");
    }

    public static PotionBrewingDisabler getInstance() {
        return instance;
    }

    public List<String> getDisabledPotions() {
        return disabledPotions;
    }
}
