package de.davboecki.multimodworld.server;

import java.io.UnsupportedEncodingException;
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
	
	private static HashMap<String,ForgeLoginHooksSettings> settingsMap = new HashMap<String,ForgeLoginHooksSettings>();
	
	public static void LogintoMod(Player player) {
		if(!settingsMap.containsKey(player.getName())){
			return;
		}
		ForgeLoginHooksSettings settings = settingsMap.get(player.getName());
		ForgeHooksServer.init();

        ForgeHooks.onLogin(settings.netloginhandler.networkManager, settings.packet1login);

        String[] localObject1 = MessageManager.getInstance().getRegisteredChannels(settings.netloginhandler.networkManager);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Forge");
        for (String str : localObject1)
        {
          localStringBuilder.append("");
          localStringBuilder.append(str);
        }
        Packet250CustomPayload packet = new Packet250CustomPayload();
        packet.tag = "REGISTER";
        try {
      	  packet.data = localStringBuilder.toString().getBytes("UTF8");
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
          localUnsupportedEncodingException.printStackTrace();
        }
        packet.length = packet.data.length;
        ((CraftPlayer)player).getHandle().netServerHandler.sendPacket(packet);

        ModLoaderMp.HandleAllLogins(((CraftPlayer)player).getHandle());
	}
	
	public static void registerLogin(CraftPlayer player, ForgeLoginHooksSettings settings){
		if(settingsMap.containsKey(player.getName())) {
			HashMap<String,ForgeLoginHooksSettings> newsettingsMap = new HashMap<String,ForgeLoginHooksSettings>();
			for(Object part: settingsMap.keySet()) {
				if(!part.equals(player.getName())){
					newsettingsMap.put(player.getName(), settingsMap.get(part));
				}
			}
			settingsMap = newsettingsMap;
		}
		settingsMap.put(player.getName(), settings);
	}
	
	public static class ForgeLoginHooksSettings {
		NetLoginHandler netloginhandler;
		Packet1Login packet1login;
		boolean ForgeClientInsatlled;
		public ForgeLoginHooksSettings(boolean ForgeClientInsatlled, NetLoginHandler netloginhandler, Packet1Login packet1login) {
			this.ForgeClientInsatlled = ForgeClientInsatlled;
			this.netloginhandler = netloginhandler;
			this.packet1login = packet1login;
		}
	}
}
