package com.endless.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerHandler implements Listener {
	
	// Disables hunger depletion
	@EventHandler
	public void foodDep(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}

	// Disables damaging entities/players
	@EventHandler
	public void entityDmg(EntityDamageByEntityEvent event) {
		if(event.getDamager() instanceof Player) {
		event.setCancelled(true);
		}
	}
	
	//Disables block breaking
	@EventHandler
	public void blockBreak(BlockBreakEvent event) {
		if(event.getPlayer().getGameMode() != GameMode.CREATIVE) {
			event.setCancelled(true);
		}
	}
	
}
