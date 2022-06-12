package com.endless.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerHandler implements Listener {
	
	// Disables hunger depletion
	@EventHandler
	public void FoodDep(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}

}
