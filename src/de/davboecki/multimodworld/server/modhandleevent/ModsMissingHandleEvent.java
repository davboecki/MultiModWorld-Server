package de.davboecki.multimodworld.server.modhandleevent;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class ModsMissingHandleEvent extends Event{

	private static final HandlerList handlers = new HandlerList();

	public ModsMissingHandleEvent() {}

	private ArrayList<String> MissingModList;
	private Player player;

	public ArrayList getMissingModList(){
		return MissingModList;
	}
	
	public void setMissingModList(ArrayList<String> MissingMods){
		MissingModList = MissingMods;
	}

	public Player getPlayer(){
		return player;
	}
	
	public void setPlayer(Player pplayer){
		player = pplayer;
	}
	
	// Handlers
    public HandlerList getHandlers() {
        return handlers;
    }
 
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
