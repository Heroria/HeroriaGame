package net.haiwa.smash.runnables;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.haiwa.smash.GameStatus;
import net.haiwa.smash.Main;
import net.haiwa.smash.manager.GameManager;
import net.haiwa.smash.scoreboards.ScoreboardManager;

public class LobbyRunnable extends BukkitRunnable{
	
	public static int timer = 121;
	public static boolean start = false;

	@Override
	public void run() {
		
		timer--;
		
		if(Bukkit.getServer().getOnlinePlayers().size() > 4 || GameStatus.isStatus(GameStatus.LOBBY) == true) {
			Bukkit.broadcastMessage(Main.INSTANCE.getPrefix() + " Il n'y a pas assé de joueurs pour lancer la partie");
			timer = 121;
			this.cancel();
			return;
		}
		
		if((timer == 120) || (timer == 90) || (timer == 60) || (timer == 30) || (timer == 15) || (timer == 10) || (timer == 5) || (timer == 4) || (timer == 3) || (timer == 2) || (timer == 1)) {
			Bukkit.broadcastMessage(Main.INSTANCE.getPrefix() + " §La partie commence dans §b" + timer + " §f" + getSeconds(timer));
			for(Player players : Bukkit.getOnlinePlayers()) {
				players.playSound(players.getLocation(), Sound.LEVEL_UP, 1f, 1f);
			}
			setLevel();
			return;
		}
		
		if(timer == 0) {
			timer = 121;
			this.cancel();
			for(Player players : Bukkit.getOnlinePlayers()) {
				new GameManager().loadGame(players);
			}
			new GameRunnable().runTaskTimer(Main.INSTANCE, 0L, 20L);
			return;
		}
		setLevel();
	}

	private void setLevel() {
		
		for(Player players : Bukkit.getOnlinePlayers()) {
			players.setLevel(timer);
			
			if(GameStatus.isStatus(GameStatus.LOBBY)) {
				if(ScoreboardManager.scoreboardGame.containsKey(players)) {
					ScoreboardManager.scoreboardGame.get(players).setLine(7, "§5Début dans: §f" + new SimpleDateFormat("mm:ss").format(new Date(LobbyRunnable.timer * 1000)));
				}
			}
		}
	}

	private String getSeconds(int timer) {
		if(timer == 1) return "seconde.";
		return "secondes.";
	}

	public static void setStart(boolean start) {
		LobbyRunnable.start = start;
	}
	
}
