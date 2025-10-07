package de.scholle.potionBrewingDisabler.listeners;

import de.scholle.potionBrewingDisabler.PotionBrewingDisabler;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.List;

public class PotionBrewListener implements Listener {

    @EventHandler
    public void onBrew(BrewEvent event) {
        List<String> disabledPotions = PotionBrewingDisabler.getInstance().getDisabledPotions();

        for (ItemStack result : event.getResults()) {
            if (result == null || result.getType() != Material.POTION) continue;
            if (!(result.getItemMeta() instanceof PotionMeta meta)) continue;

            try {
                PotionData potionData = meta.getBasePotionData();
                PotionType baseType = potionData.getType();
                if (disabledPotions.contains(baseType.name())) {
                    event.setCancelled(true);
                    return;
                }
            } catch (Exception ignored) {}

            for (PotionEffect effect : meta.getCustomEffects()) {
                PotionEffectType type = effect.getType();
                if (disabledPotions.contains(type.getName())) {
                    event.setCancelled(true);
                    return;
                }
            }
        }
    }
}
