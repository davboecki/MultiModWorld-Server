package de.davboecki.multimodworld.api.plugin;

import net.minecraft.server.Entity;

public class EntitySetting {
	public Class<Entity> entityclass;
	public String entityName;
	
	public boolean equals(Object object) {
		if(object instanceof EntitySetting){
			return ((EntitySetting)object).entityclass.equals(this.entityclass) && ((EntitySetting)object).entityName.equals(this.entityName);
		} else {
			return false;
		}
	}
}
