package com.LucasRomier.BetterMobAI.Events;

import com.LucasRomier.BetterMobAI.MobAI;
import java.util.Objects;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTeleportEvent;

public class TeleportEvents implements Listener {

  @EventHandler
  public void onEntityTeleport(EntityTeleportEvent event) {
    Entity entity = event.getEntity();
    boolean b = false;
    for (String s : MobAI.settings.configuration.getStringList("BetterMobs")) {
      if (s.equals(entity.getType().toString())) {
        b = true;
        break;
      }
    }
    boolean world = false;
    for (String s : MobAI.settings.configuration.getStringList("Worlds")) {
      if (s.equals(((World) Objects.<World>requireNonNull(entity.getLocation().getWorld())).getName())) {
        world = true;
        break;
      }
    }
    if (b && world && entity
            .getType().equals(EntityType.ENDERMAN)) {
      event.setCancelled(true);
    }
  }
}
