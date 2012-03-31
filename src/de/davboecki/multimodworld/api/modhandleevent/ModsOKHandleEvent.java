package de.davboecki.multimodworld.api.modhandleevent;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class ModsOKHandleEvent extends Event{

	private static final HandlerList handlers = new HandlerList();

	public ModsOKHandleEvent() {}

	private Player player;
	
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
