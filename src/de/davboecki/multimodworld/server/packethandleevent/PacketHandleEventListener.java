package de.davboecki.multimodworld.server.packethandleevent;

import org.bukkit.event.CustomEventListener;
import org.bukkit.event.Event;

public class PacketHandleEventListener extends CustomEventListener {
	
	@Override
	public void onCustomEvent(Event event){
		if(event instanceof PacketSendEvent){
			this.onPacketSendEvent((PacketSendEvent)event);
		}
	}

	public void onPacketSendEvent(PacketSendEvent event){}

}
