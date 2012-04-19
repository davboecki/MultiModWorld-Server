package de.davboecki.multimodworld.api.plugin;

import cpw.mods.fml.common.ModContainer;
import net.minecraft.server.BaseMod;
import net.minecraft.server.CraftingRecipe;
import net.minecraft.server.Entity;
import net.minecraft.server.Packet;

public class ModAddList{
	private ModContainer Mod;
	private int[] Ids;
	private Class<Entity>[] Entities;
	private Class<Packet>[] Packets;
	private CraftingRecipe[] addedRecipies;
	private CraftingRecipe[] removedRecipies;
	
	public ModAddList(ModContainer Mod, int[] Ids, Class<Entity>[] Entities, Class<Packet>[] Packets, CraftingRecipe[] addedRecipies, CraftingRecipe[] removedRecipies) {
		this.Mod = Mod;
		this.Ids = Ids;
		this.Entities = Entities;
		this.Packets = Packets;
		this.addedRecipies = addedRecipies;
		this.removedRecipies = removedRecipies;
	}
	
	public ModContainer getMod() {
		return Mod;
	}
	
	public int[] getIds() {
		return Ids.clone();
	}
	
	public Class<Entity>[] getEntitis(){
		return Entities.clone();
	}

	public Class<Packet>[] getPackets() {
		return Packets.clone();
	}
	
	public CraftingRecipe[] getAddedRecipies() {
		return addedRecipies.clone();
	}
	
	public CraftingRecipe[] getRemovedRecipies() {
		return removedRecipies.clone();
	}
}