package net.haiwa.smash.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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
		
		if((!LobbyRunnable.start) && (GameStatus.isStatus(GameStatus.LOBBY))) {
			new LobbyRunnable().runTaskTimer(Main.INSTANCE, 0L, 20L);
			LobbyRunnable.setStart(true);
			e.setJoinMessage(Main.INSTANCE.getPrefix() + " a rejoint la partie §b" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getServer().getMaxPlayers());
			p.setGameMode(GameMode.ADVENTURE);
			TitleManager.sendTitle(p, "§5Smash", "§bBienvenue sur le mode Smash", 20 * 3);
			return;
		}
		
		if(!ScoreboardManager.scoreboardGame.containsKey(p)) {
			new ScoreboardManager(p).loadScoreboard();
			return;
		}
		
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage(null);
	}
	
}
