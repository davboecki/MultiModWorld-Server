package de.davboecki.multimodworld.server.plugin;

public interface IModWorldHandlePlugin{
	public abstract boolean isIdAllowed(String WorldName,int id);
	
	public abstract boolean isCraftingAllowed(String WorldName,int id);
	
	public abstract boolean isEntityAllowed(String WorldName,net.minecraft.server.Entity entity);

	public abstract boolean hasWorldSetting(String WorldName,String Setting);
}