package de.davboecki.multimodworld.server.modhandleevent;

import org.bukkit.event.CustomEventListener;
import org.bukkit.event.Event;

public abstract class ModHandleEventListener extends CustomEventListener{

	@Override
	public void onCustomEvent(Event event){
		if(event instanceof ModsMissingHandleEvent){
			this.onModsMissingHandle((ModsMissingHandleEvent)event);
		}
		if(event instanceof ModsOKHandleEvent){
			this.onModsOKHandle((ModsOKHandleEvent)event);
		}
	}

	public void onModsMissingHandle(ModsMissingHandleEvent event){};

	public void onModsOKHandle(ModsOKHandleEvent event){};
	
}
