package com.endless.npcs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;

import com.Endless.utilities.ServerUtilities;

public class SpawnNPCs implements Listener {

	static String[] gameNPCs = new String[] { "Arcade" };

	public static void spawn() {

		ArrayList<String> npcNotFound = new ArrayList<>();

		for (String game : gameNPCs) {
			if (GetLocations.map.get(game) != null) {
				EntityTypes.spawnEntity(
						new CustomZombie(game,
								Bukkit.getWorld("world")),
						GetLocations.map.get(game));
				
				spawnArmorStand(game, GetLocations.map.get(game));
			} else {
				npcNotFound.add(game);
			}
		}

		if (npcNotFound.size() >= 1) {
			for (int i = 0; i < 10; i++) {
				Bukkit.getServer().getConsoleSender().sendMessage(ServerUtilities.format("Lobby Error",
						ChatColor.RED + "Unable to spawn NPCS: " + npcNotFound.toString()));
			}
		}
	}

	static Map<String, String> armorStands = new HashMap<>();
	
	public static void spawnArmorStand(String game, Location loc) {
		ArmorStand as = (ArmorStand) Bukkit.getWorld("world").spawnEntity(
				new Location(loc.getWorld(), loc.getX(), (loc.getY() + .249999), loc.getZ()), EntityType.ARMOR_STAND);
		as.setVisible(false);
		as.setGravity(false);
		as.setCustomName(ChatColor.RED + ChatColor.BOLD.toString() + game);
		as.setCustomNameVisible(true);
		armorStands.put(ChatColor.RED + ChatColor.BOLD.toString() + game, game);
		Location loc2 = as.getLocation();
		ArmorStand as2 = (ArmorStand) Bukkit.getWorld("world").spawnEntity(
				new Location(loc2.getWorld(), loc2.getX(), (loc.getY() + 0.01), loc2.getZ()), EntityType.ARMOR_STAND);
		as2.setVisible(false);
		as2.setGravity(false);
		as2.setCustomName(ChatColor.YELLOW + ChatColor.BOLD.toString() + "Click to Play!");
		as2.setCustomNameVisible(true);
	}

}
