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

	static Map<String, Location> map = new HashMap<>();

	//Takes in the line of the sign and the location of the block underneath it, while also deleting both. 
	public void getLocation() {
		int radius = 20;
		Location loc = new Location(Bukkit.getWorld("world"), -24, 66, -4);
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
							map.put(line, new Location(Bukkit.getWorld("world"), (below.getX() + .5), 66, (below.getZ() + .5)));
						}
					}
				}
			}
		}
		
		SpawnNPCs.spawn();
		
	}
}
