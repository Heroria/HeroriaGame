package net.haiwa.smash.cmd;

import java.io.File;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import net.haiwa.smash.Main;

public class CmdSetLobby implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("setlobby")) {
			
			if(sender instanceof Player) {
				Player p = (Player) sender;
				
				if(args.length == 0) {
					
					Location loc = p.getLocation();
					File file = new File(Main.INSTANCE.getDataFolder(), "/lobby.yml");
					YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
					
					String key = "Lobby.";
					
					config.set(key + ".world", loc.getWorld());
					config.set(key + ".x", loc.getX());
					config.set(key + ".y", loc.getY());
					config.set(key + ".z", loc.getZ());
					config.set(key + ".pitch", loc.getPitch());
					config.set(key + ".yaw", loc.getYaw());
					
					try {
						config.save(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					p.sendMessage("§aVous avez set le lobby");
					
					return true;
				}else {
					p.sendMessage("§cLa commande est /setlobby");
					return true;
				}
				
			}else {
				return true;
			}
			
		}
		return false;
	}
}
