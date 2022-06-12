package com.endless;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.endless.listeners.JoinListener;
import com.endless.npcs.GetLocations;

public class Lobby extends JavaPlugin {

	public void onEnable() {
		initClasses();
	}
	
	public void initClasses() {
		getServer().getPluginManager().registerEvents((Listener)new JoinListener(), (Plugin)this);
		new GetLocations().getLocation();
	}
	
}
