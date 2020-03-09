package net.haiwa.smash;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.haiwa.smash.cmd.CmdSetLobby;
import net.haiwa.smash.cmd.CmdSetPlayerSpawn;
import net.haiwa.smash.listeners.ListenerManager;
import net.haiwa.smash.runnables.LobbyRunnable;

public class Main extends JavaPlugin{
	
	public static Main INSTANCE;
	public static int test = 1;
	
	@Override
	public void onEnable() {
		INSTANCE = this;
		saveDefaultConfig();
		
		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		pm.registerEvents(new ListenerManager(), this);
		getCommand("setplayerspawn").setExecutor(new CmdSetPlayerSpawn());
		getCommand("setlobby").setExecutor(new CmdSetLobby());
		
		GameStatus.setStatus(GameStatus.LOBBY);
		new LobbyRunnable().runTaskTimer(INSTANCE, 0L, 20L);
	}
	
	@Override
	public void onDisable() {
		
	}

	public String getPrefix() {
		return "§5[Smash]§r";
	}
}
