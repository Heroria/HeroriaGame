package net.haiwa.smash.manager;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

import net.haiwa.smash.GameStatus;
import net.haiwa.smash.utils.TitleManager;

public class GameManager {

	public GameManager() {
		// TODO Auto-generated constructor stub
	}
	
	public void loadGame(Player p) {
		GameStatus.setStatus(GameStatus.GAME);
		
		if(GameStatus.isStatus(GameStatus.GAME)) {
		
			TitleManager.sendTitle(p, "§5Smash", "§bLa partie à commencé", 20 * 2);
			p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 1f, 1f);
			
		}
	}
}
