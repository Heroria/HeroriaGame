package net.haiwa.smash;

public enum GameStatus {

	LOBBY(), GAME() , END();
	
	public static GameStatus status;
	
	public static void setStatus(GameStatus status) {
		GameStatus.status = status;
	}
	
	public static boolean isStatus(GameStatus status) {
		return GameStatus.status == status;
	}
	
}
