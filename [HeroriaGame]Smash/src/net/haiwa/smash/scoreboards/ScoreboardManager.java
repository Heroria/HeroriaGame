package net.haiwa.smash.scoreboards;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ScoreboardManager {

	public Player p;
	public ScoreboardSign sign;
	public static Map<Player, ScoreboardSign> scoreboardGame = new HashMap<Player, ScoreboardSign>();
	
	public ScoreboardManager(Player p) {
		this.p = p;
		this.sign = new ScoreboardSign(p, p.getName());
		scoreboardGame.put(this.p, this.sign);
	}
	
	public void loadScoreboard() {
		this.sign.setObjectiveName("§5§lSmash");
		this.sign.create();
		
		((ScoreboardSign) scoreboardGame.get(p)).setLine(8, "§5");
		((ScoreboardSign) scoreboardGame.get(p)).setLine(6, "§5");
		((ScoreboardSign) scoreboardGame.get(p)).setLine(5, "§5Joueurs: §f" + Bukkit.getOnlinePlayers() + "/" + Bukkit.getServer().getMaxPlayers());
		((ScoreboardSign) scoreboardGame.get(p)).setLine(4, "§5");
		((ScoreboardSign) scoreboardGame.get(p)).setLine(3, "§cEn attente de");
		((ScoreboardSign) scoreboardGame.get(p)).setLine(2, "§cJoueurs...");
		((ScoreboardSign) scoreboardGame.get(p)).setLine(1, "§5");
		((ScoreboardSign) scoreboardGame.get(p)).setLine(0, "§5www.heroria.eu");
		
	}
}
