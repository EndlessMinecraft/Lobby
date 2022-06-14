package com.endless.npcs;

import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import com.Endless.utilities.PluginMessaging;

public class NPCInteract implements Listener {
	
	PluginMessaging pluginMessaging = new PluginMessaging();
	@EventHandler
	public void hitEntity(EntityDamageByEntityEvent event) {
		Entity attacker = event.getDamager();
		Entity entity = event.getEntity();
		List<Entity> as = entity.getNearbyEntities(0, .249999, 0);
		if (attacker instanceof Player && entity instanceof Zombie) {
			String game = as.get(0).getName();
			pluginMessaging.connect((Player) attacker, SpawnNPCs.armorStands.get(game));
		}
	}
	
	@EventHandler
	public void hitEntity(PlayerInteractEntityEvent event) {
		Player attacker = event.getPlayer();
		Entity entity = event.getRightClicked();
		List<Entity> as = entity.getNearbyEntities(0, .249999, 0);
		if (attacker instanceof Player && entity instanceof Zombie) {
			String game = as.get(0).getName();
			pluginMessaging.connect(attacker, SpawnNPCs.armorStands.get(game));
		}
	}

	
}
