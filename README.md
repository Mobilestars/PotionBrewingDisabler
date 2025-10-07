# PotionBrewingDisabler

**Version:** 1.0.0  
**Minecraft Version:** 1.18+  
**Website:** [Modrinth](https://modrinth.com/project/potionbrewingdisabler)  

---

## Description
**PotionBrewingDisabler** allows server owners to disable specific potions in the brewing stand. The plugin is fully configurable via `config.yml`, letting you decide which potions cannot be brewed. This is useful to increase the value of certain potions or to prevent Instant Damage potions.

---

## Installation
1. Place the `PotionBrewingDisabler.jar` into your server's `plugins` folder.
2. Start the server to generate the default configuration.
3. Edit `config.yml` to disable the potions you want.
4. Restart the server for the changes to take effect.

---

## Configuration

```yaml
# List of disabled potions
# Use PotionType names from the Bukkit API
disabled-potions:
  - HARMING
  - STRONG_HARMING
