package net.haiwa.smash.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import net.haiwa.smash.Main;
import net.haiwa.smash.cmd.CmdSetPlayerSpawn;

public class LocationUtils {
	
	public static List<Location> spawnlocation = new ArrayList<Location>();
	
	
	public static void teleportSpawnLocation(Player p) {
		final File file = new File(Main.INSTANCE.getDataFolder(), "/spawnlocation.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		for(int i = 0; i < config.getInt("server." + ".spawnNumbers"); i++) {
			String key = "server." + (i + 1);
			World world = Bukkit.getWorld(config.getString(key) + ".world");
			double x = config.getDouble(key + ".x");
			double y = config.getDouble(key + ".y");
			double z = config.getDouble(key + ".z");
			float pitch = (float) config.getDouble(key + ".pitch");
			float yaw = (float) config.getDouble(key + ".yaw");
			p.teleport(new Location(world, x, y, z, yaw, pitch));
			p.sendMessage("vous etes tp a " + x + y + z);
			
		}
	}
}
