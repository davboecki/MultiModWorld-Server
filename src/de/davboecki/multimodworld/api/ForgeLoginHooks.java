package de.davboecki.multimodworld.api;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.EntityPlayer;
import net.minecraft.server.ModLoaderMp;
import net.minecraft.server.NetLoginHandler;
import net.minecraft.server.Packet1Login;
import net.minecraft.server.Packet250CustomPayload;
import forge.ForgeHooks;
import forge.ForgeHooksServer;
import forge.MessageManager;

public class ForgeLoginHooks {

	private static ArrayList<String> ConfirmedPlayers = new ArrayList<String>();
	private static ArrayList<String> PackedSendedPlayers = new ArrayList<String>();
	
	public static void confirmPlayer(Player player) {
		ConfirmedPlayers.add(player.getName());
	}
	
	public static void removePlayer(Player player) {
		Object remove = "empty";
		while(remove != null) {
			remove = null;
			for(Object part:ConfirmedPlayers.toArray()) {
				if(player.getName().equalsIgnoreCase((String)part)) {
					remove = part;
					break;
				}
			}
			ConfirmedPlayers.remove(remove);
		}
	}
	
	public static boolean isPlayerConfirmed(Player player) {
		for(Object part:ConfirmedPlayers.toArray()) {
			if(player.getName().equalsIgnoreCase((String)part)) {
				return true;
			}
		}
		return false;
	}

	public static void packetSended(Player player) {
		PackedSendedPlayers.add(player.getName());
	}

	public static void removeSended(Player player) {
		Object remove = "empty";
		while(remove != null) {
			remove = null;
			for(Object part:PackedSendedPlayers.toArray()) {
				if(player.getName().equalsIgnoreCase((String)part)) {
					remove = part;
					break;
				}
			}
			PackedSendedPlayers.remove(remove);
		}
	}
	
	public static boolean isPlayerSended(Player player) {
		for(Object part:PackedSendedPlayers.toArray()) {
			if(player.getName().equalsIgnoreCase((String)part)) {
				return true;
			}
		}
		return false;
	}
}
