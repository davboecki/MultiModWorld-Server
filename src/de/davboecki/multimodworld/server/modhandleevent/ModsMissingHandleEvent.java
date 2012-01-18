package de.davboecki.multimodworld.server.modhandleevent;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerEvent;

public class ModsMissingHandleEvent extends Event{

	public ModsMissingHandleEvent(String name) {
		super(name);
	}

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
	
}
