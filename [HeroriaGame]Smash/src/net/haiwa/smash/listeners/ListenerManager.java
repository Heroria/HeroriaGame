package net.haiwa.smash.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
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
		
		p.setExp(0f);
		p.setHealth(20);
		p.setFoodLevel(20);
		p.setLevel(0);
		p.getInventory().clear();
		e.setJoinMessage(Main.INSTANCE.getPrefix() + " A rejoint la partie §b" + Bukkit.getServer().getOnlinePlayers().size() + "/" + Bukkit.getServer().getMaxPlayers());
		
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
		
		Player p = e.getPlayer();
		
		if((GameStatus.isStatus(GameStatus.LOBBY))) {
			LobbyRunnable.timer = 121;
			if(ScoreboardManager.scoreboardGame.containsKey(p)){
				ScoreboardManager.scoreboardGame.remove(p);
			}
			
		}
		
		e.setQuitMessage(null);
	}
	
	@EventHandler
	public void onFoodLevel(FoodLevelChangeEvent e) {
		
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
	
		DamageCause cause = e.getCause();
		
		if((!GameStatus.isStatus(GameStatus.LOBBY))) {
			if(cause == null) return;
			
			if(cause != DamageCause.PROJECTILE || cause != DamageCause.ENTITY_ATTACK) {
				return;
			}else {
				e.setCancelled(true);
			}	
		}
	}
	
	@EventHandler
	public void onDamageByEntity(EntityDamageByEntityEvent e) {
		
		if(GameStatus.isStatus(GameStatus.LOBBY)) {
			e.setCancelled(true);
			return;
		}else{
			e.setDamage(0);
			return;
		}
		
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
	
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if((!GameStatus.isStatus(GameStatus.GAME))) {
			e.setCancelled(true);
		}	
	}
}
