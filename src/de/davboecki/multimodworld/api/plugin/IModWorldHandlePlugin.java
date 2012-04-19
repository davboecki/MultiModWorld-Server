package de.davboecki.multimodworld.api.plugin;

import java.util.List;

import org.bukkit.entity.Player;

import forge.packets.PacketModList;

import net.minecraft.server.EntityPlayer;
import net.minecraft.server.Packet;

public interface IModWorldHandlePlugin{
	public abstract boolean isIdAllowed(String WorldName,int id);
	
	public abstract boolean isCraftingAllowed(String WorldName,int id);
	
	public abstract boolean isEntityAllowed(String WorldName,net.minecraft.server.Entity entity);

	public abstract boolean hasWorldSetting(String WorldName,String Setting);

	public abstract boolean PacketSend(Packet packet, Player player);
	
	public abstract net.minecraft.server.Entity ReplaceEntity(String WorldName,net.minecraft.server.Entity entity);
	
	public abstract boolean handleModPacketResponse(EntityPlayer eplayer, PacketModList pkt);

	public abstract List replaceRecipies(List recipies);
}