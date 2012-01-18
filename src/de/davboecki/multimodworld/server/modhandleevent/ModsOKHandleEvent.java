package de.davboecki.multimodworld.server.modhandleevent;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerEvent;

public class ModsOKHandleEvent extends Event{

	public ModsOKHandleEvent(String name) {
		super(name);
	}

	private Player player;
	
	public Player getPlayer(){
		return player;
	}
	
	public void setPlayer(Player pplayer){
		player = pplayer;
	}
	
}
