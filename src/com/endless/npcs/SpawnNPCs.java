package com.endless.npcs;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;

import com.Endless.utilities.ServerUtilities;

public class SpawnNPCs implements Listener {

	static String[] gameNPCs = new String[] { "LifeSteal" };

	public static void spawn() {

		ArrayList<String> npcNotFound = new ArrayList<>();

		for (String game : gameNPCs) {
			if (GetLocations.map.get(game) != null) {
				EntityTypes.spawnEntity(
						new CustomZombie(ChatColor.RED.toString() + ChatColor.BOLD.toString() + "LifeSteal",
								Bukkit.getWorld("world")),
						GetLocations.map.get("LifeSteal"));
				spawnArmorStand(game, GetLocations.map.get(game));
			} else {
				npcNotFound.add(game);
			}
		}
//		if (GetLocations.map.get("LifeSteal") != null) {
//			EntityTypes.spawnEntity(new CustomZombie(ChatColor.RED.toString() + ChatColor.BOLD.toString() + "LifeSteal", Bukkit.getWorld("world")), GetLocations.map.get("LifeSteal"));
//			spawnArmorStand("LifeSteal", GetLocations.map.get("LifeSteal"));
//		} else {
//			npcNotFound.add("LifeSteal");
//		}
//		
//		if(GetLocations.map.get("Factions") != null) {
//				EntityTypes.spawnEntity(new CustomZombie(ChatColor.RED.toString() + ChatColor.BOLD.toString() + "Factions", Bukkit.getWorld("world")), GetLocations.map.get("Factions"));
//			} else {
//				npcNotFound.add("Factions");
//			}

		if (npcNotFound.size() >= 1) {
			for (int i = 0; i < 10; i++) {
				Bukkit.getServer().getConsoleSender().sendMessage(ServerUtilities.format("Lobby Error",
						ChatColor.RED + "Unable to spawn NPCS: " + npcNotFound.toString()));
			}
		}
	}

	public static void spawnArmorStand(String game, Location loc) {
		ArmorStand as = (ArmorStand) Bukkit.getWorld("world").spawnEntity(
				new Location(loc.getWorld(), loc.getX(), (loc.getY() + .249999), loc.getZ()), EntityType.ARMOR_STAND);
		as.setVisible(false);
		as.setGravity(false);
		as.setCustomName(ChatColor.RED + ChatColor.BOLD.toString() + game);
		as.setCustomNameVisible(true);
		Location loc2 = as.getLocation();
		ArmorStand as2 = (ArmorStand) Bukkit.getWorld("world").spawnEntity(
				new Location(loc2.getWorld(), loc2.getX(), (loc.getY() + 0.01), loc2.getZ()), EntityType.ARMOR_STAND);
		as2.setVisible(false);
		as2.setGravity(false);
		as2.setCustomName(ChatColor.YELLOW + ChatColor.BOLD.toString() + "Click to Play!");
		as2.setCustomNameVisible(true);
	}

}
