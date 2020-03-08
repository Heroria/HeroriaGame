package net.haiwa.smash.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.haiwa.smash.GameStatus;
import net.haiwa.smash.Main;
import net.haiwa.smash.runnables.LobbyRunnable;
import net.haiwa.smash.scoreboards.ScoreboardManager;
import net.haiwa.smash.utils.TitleManager;

public class ListenerManager implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		p.setHealth(20);
		p.setFoodLevel(20);
		p.setLevel(20);
		p.getInventory().clear();
		
		if(!ScoreboardManager.scoreboardGame.containsKey(p)) {
			new ScoreboardManager(p).loadScoreboard();
		}
		
		if((LobbyRunnable.start) == false && (GameStatus.isStatus(GameStatus.LOBBY))) {
			new LobbyRunnable().runTaskTimer(Main.INSTANCE, 0L, 20L);
			LobbyRunnable.setStart(true);
			TitleManager.sendTitle(p, "§5Smash", "§bEn attente de joueurs...", 20 * 3);
			return;
		}
		
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage(null);
	}
	
}
