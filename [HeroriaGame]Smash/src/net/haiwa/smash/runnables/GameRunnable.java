package net.haiwa.smash.runnables;

import org.bukkit.scheduler.BukkitRunnable;

public class GameRunnable extends BukkitRunnable{
	
	public int timer = 121;
	public static boolean start = false;

	@Override
	public void run() {
		timer++;
	}	
}
