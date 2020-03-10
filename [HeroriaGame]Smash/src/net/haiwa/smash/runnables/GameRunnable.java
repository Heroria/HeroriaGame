package net.haiwa.smash.runnables;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.haiwa.smash.GameStatus;
import net.haiwa.smash.utils.LocationUtils;

public class GameRunnable extends BukkitRunnable{
	
	public int timer = 0;
	public static boolean start = false;

	@Override
	public void run() {
		timer++;
		
		if(timer == 1 && GameStatus.isStatus(GameStatus.GAME)) {
			for(Player players : Bukkit.getOnlinePlayers()) {
				LocationUtils.teleportSpawnLocation(players);
				players.sendMessage("§cLa partie a commencé");
			}
		}
		
	}	
}
