package net.haiwa.smash.utils;

import org.bukkit.Location;

public class LobbyUtils {
	
	private Location loc;
	
	public LobbyUtils() {
		
	}

	public void setLobby(Location loc) {
		this.loc = loc;
	}
	
	public Location getLobby() {
		return this.loc;
	}
}
