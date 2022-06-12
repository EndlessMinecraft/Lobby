package com.endless.npcs;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;


public class GetLocations {

	Map<String, Location> map = new HashMap<>();

	public void getLocation() {
		int radius = 7;
		Location loc = new Location(Bukkit.getWorld("world"), 234.537, 65.00, 225.531);
		World world = loc.getWorld();
		for (int x = -radius; x < radius; x++) {
			for (int y = -radius; y < radius; y++) {
				for (int z = -radius; z < radius; z++) {
					Block block = world.getBlockAt(loc.getBlockX() + x, loc.getBlockY() + y, loc.getBlockZ() + z);
					if (block.getType() == Material.SIGN_POST) {
						Sign s = (Sign) block.getState();
						String[] lines = s.getLines();
						block.setType(Material.AIR);
						Block below = block.getRelative(BlockFace.DOWN);
						below.setType(Material.AIR);
						for (String line : lines) {
							map.put(line, below.getLocation());
						}
//						EntityTypes.spawnEntity(new LifestealZombie(Bukkit.getWorld("world")), below.getLocation());
					}
				}
			}
		}
	}
}
