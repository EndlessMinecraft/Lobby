package com.endless.listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerHandler implements Listener {
	
	// Disables hunger depletion
	@EventHandler
	public void foodDep(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}

	// Disables damaging entities/players
	@EventHandler
	public void entityDmg(EntityDamageEvent event) {
		event.setCancelled(true);
	}
	
	//Disables block breaking
	@EventHandler
	public void blockBreak(BlockBreakEvent event) {
		if(event.getPlayer().getGameMode() != GameMode.CREATIVE) {
			event.setCancelled(true);
		}
	}
	
}
