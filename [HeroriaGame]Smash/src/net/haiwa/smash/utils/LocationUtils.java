package net.haiwa.smash.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

import net.haiwa.smash.Main;

public class LocationUtils {
	
	private List<Location> spawnlocation = new ArrayList<Location>();
	File file = new File(Main.INSTANCE.getDataFolder(), "/spawnlocation.yml");
	YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
	String key = "server." + Main.test;
	
	public LocationUtils() {
		
	}
	
	public void addSpawnLocation(Location loc) {
		spawnlocation.add(loc);
	}
	
	public Location getSpawnLocationByNumbers(int args) {
		return spawnlocation.get(args);
	}
	
	public List<Location> getArraySpawnLocation(){
		return spawnlocation;
	}
	
	public void removeSpawnLocation(Location loc) {
	
		if(spawnlocation.contains(loc)) {
			spawnlocation.remove(loc);
			return;
		}else {
			return;
		}
	}
	
	public void toFile(World world) {
		config.set(key + "." + spawnlocation.size() + ".world", world.getName());
		config.set(key + "." + spawnlocation.size() + ".x", spawnlocation.get(spawnlocation.size() - 1).getX());
		config.set(key + "." + spawnlocation.size() + ".y", spawnlocation.get(spawnlocation.size() - 1).getY());
		config.set(key + "." + spawnlocation.size() + ".z", spawnlocation.get(spawnlocation.size() - 1).getZ());
		config.set(key + "." + spawnlocation.size() + ".pitch", spawnlocation.get(spawnlocation.size() - 1).getPitch());
		config.set(key + "." + spawnlocation.size() + ".yaw", spawnlocation.get(spawnlocation.size() - 1).getYaw());
		Main.test++;
		try {
			config.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
}
