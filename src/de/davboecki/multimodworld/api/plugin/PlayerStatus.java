package de.davboecki.multimodworld.api.plugin;

import java.util.HashMap;
import java.util.logging.Logger;

public class PlayerStatus {
	private static HashMap<String,String> Players = new HashMap<String,String>();

	public static void setPlayerVanilla(String name) {
		if(Players.containsKey(name)) {
			Players.remove(name);
		}
		Players.put(name, "vanilla");
	}
	
	public static void setPlayerForge(String name) {
		if(Players.containsKey(name)) {
			Players.remove(name);
		}
		Players.put(name, "forge");
	}
	
	public static boolean isVanilla(String name) {
		if(!Players.containsKey(name)) {
			Logger.getLogger("MultiModWorld").severe("Lockup for non-exsisting player.");
			return true;
		}
		return Players.get(name).equals("vanilla");
	}
}
