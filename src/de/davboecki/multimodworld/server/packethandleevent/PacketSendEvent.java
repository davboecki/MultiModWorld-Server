package de.davboecki.multimodworld.server.packethandleevent;

import net.minecraft.server.Packet;

import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

public class PacketSendEvent extends Event implements Cancellable{
	
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
	
	public Packet packet;
	private CraftPlayer player;
	
}
