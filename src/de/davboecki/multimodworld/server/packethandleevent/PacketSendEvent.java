package de.davboecki.multimodworld.server.packethandleevent;

import net.minecraft.server.Packet;

import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PacketSendEvent extends Event implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private boolean Cancelled = false;
	
	public PacketSendEvent(CraftPlayer player) {
		super("PacketSendEvent");
		this.player = player;
	}

	@Override
	public boolean isCancelled() {
		return Cancelled;
	}

	@Override
	public void setCancelled(boolean flag) {
		Cancelled = flag;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public Packet packet;
	private CraftPlayer player;

	// Handlers
    public HandlerList getHandlers() {
        return handlers;
    }
 
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
