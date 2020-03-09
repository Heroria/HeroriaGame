package net.haiwa.smash.cmd;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.haiwa.smash.Main;
import net.haiwa.smash.utils.LocationUtils;

public class CmdSetPlayerSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("setplayerspawn")) {
			
			if(sender instanceof Player) {
				
				Player p = (Player) sender;
				
				if(args.length == 0) {
					
					World world = p.getWorld();
					Location loc = p.getLocation();
					LocationUtils lUtils = new LocationUtils();
					int count = Main.test;
					
					lUtils.addSpawnLocation(loc);
					lUtils.toFile(world);
					
					p.sendMessage("§aVous avez rajouté le spawn " + count);
					
					return true;
					
				}else {
					return true;
				}
				
			}else {
				return true; 
			}
			
		}
		
		return false;
	}
}
