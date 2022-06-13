package com.endless;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.endless.listeners.JoinListener;
import com.endless.listeners.PlayerHandler;
import com.endless.listeners.WeatherHandler;
import com.endless.npcs.GetLocations;

public class Lobby extends JavaPlugin {

	public void onEnable() {
		initClasses();
		timeFreeze();
		
	}
	
	//Initializes all listeners. 
	public void initClasses() {
		getServer().getPluginManager().registerEvents((Listener)new JoinListener(), (Plugin)this);
		getServer().getPluginManager().registerEvents((Listener)new WeatherHandler(), (Plugin)this);
		getServer().getPluginManager().registerEvents((Listener)new PlayerHandler(), (Plugin)this);
		new GetLocations().getLocation();
	}
	
	
	// Prevents time from changing. I'm not sure why I had to put it in this class but it made me so idk?
	public void timeFreeze() {
		   Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)this, new Runnable() {
		          public void run() {
		            for (World w : Bukkit.getServer().getWorlds())
		              w.setTime(0L); 
		          }
		        },  0L, 0L);
	}
	
	public void onDisable() {
		Bukkit.unloadWorld(Bukkit.getWorld("world"), false);
		Bukkit.getWorld("world").setAutoSave(false);
	}
	
}
