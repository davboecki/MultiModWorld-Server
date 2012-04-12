package de.davboecki.multimodworld.api.plugin;

import net.minecraft.server.BaseMod;
import net.minecraft.server.Entity;
import net.minecraft.server.Packet;

public class ModAddList{
	private BaseMod Mod;
	private int[] Ids;
	private Class<Entity>[] Entities;
	private Class<Packet>[] Packets;
	
	public ModAddList(BaseMod Mod, int[] Ids, Class<Entity>[] Entities, Class<Packet>[] Packets) {
		this.Mod = Mod;
		this.Ids = Ids;
		this.Entities = Entities;
	}
	
	public BaseMod getMod() {
		return Mod;
	}
	
	public int[] getIds() {
		return Ids;
	}
	
	public Class<Entity>[] getEntitis(){
		return Entities;
	}
	
	public Class<Packet>[] getPackets() {
		return Packets;
	}
}