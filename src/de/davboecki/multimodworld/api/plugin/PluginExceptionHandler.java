package de.davboecki.multimodworld.api.plugin;

import java.util.logging.Logger;

import org.bukkit.Bukkit;

public class PluginExceptionHandler {
	private static Logger log = Logger.getLogger("MultiModWorld");
	public static void HandleException(Exception e,ExceptionType type) {
		log.severe("Could not Handle MultiModWorld-API Event.");
		log.severe(type.Message+" ("+type.toString()+")");
		e.printStackTrace();
		//Bukkit.getLogger().severe(e.getMessage());
	}
}
