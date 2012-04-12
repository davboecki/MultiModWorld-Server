package de.davboecki.multimodworld.api.plugin;

import java.util.List;

import org.bukkit.entity.Player;

import net.minecraft.server.EntityPlayer;
import net.minecraft.server.Packet;
import net.minecraft.server.Packet230ModLoader;

public interface IModWorldHandlePlugin{
	public abstract boolean isIdAllowed(String WorldName,int id);
	
	public abstract boolean isCraftingAllowed(String WorldName,int id);
	
	public abstract boolean isEntityAllowed(String WorldName,net.minecraft.server.Entity entity);

	public abstract boolean hasWorldSetting(String WorldName,String Setting);

	public abstract boolean PacketSend(Packet packet, Player player);
	
	public abstract net.minecraft.server.Entity ReplaceEntity(String WorldName,net.minecraft.server.Entity entity);
	
	public abstract boolean handleModPacketResponse(Packet230ModLoader var0, EntityPlayer var1, List bannedMods);
}