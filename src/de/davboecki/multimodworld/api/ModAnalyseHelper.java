package de.davboecki.multimodworld.api;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.davboecki.multimodworld.api.plugin.EntitySetting;

import net.minecraft.server.BaseMod;
import net.minecraft.server.Block;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityTypes;
import net.minecraft.server.Item;
import net.minecraft.server.Packet;

public class ModAnalyseHelper {
	
	private static int key = 0;
	private static final HashMap<Integer,Information> InfotmationList = new HashMap<Integer,Information>();
	
	private static class Information {
		ArrayList<Integer> preIds;
		ArrayList<EntitySetting> preEntities;
		ArrayList<Class<Packet>> prePackets;
	}
	
	public static int preMod() {
		try {
			Information info = new Information();
			info.preIds = getIdArrayList();
			info.preEntities = getEntitySettingList();
			info.prePackets = getPacketList();
			InfotmationList.put(++key,info);
			return key;
		} catch(Exception e) {
			return -1;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void postMod(int id, BaseMod mod) {
		if(id == -1) return;
		try {
			Information info = InfotmationList.get(id);
			InfotmationList.remove(id);
			ArrayList<Integer> postIds = getIdArrayList();
			ArrayList<Object> difIds = getDifference(info.preIds, postIds);
			ArrayList<EntitySetting> postEntities = getEntitySettingList();
			ArrayList<Object> difEntities = getDifference(info.preEntities, postEntities);
			ArrayList<Class<Packet>> postPackets = getPacketList();
			ArrayList<Object> difPackets = getDifference(info.prePackets, postPackets);
			if(difIds.size() > 0 || difEntities.size() > 0 || difPackets.size() > 0){
		    	ModChecker.ModAddedBlockofEntity(mod, getIntArray(difIds),(Class<Entity>[]) getClassArray(difEntities), (Class<Packet>[]) getClassArray(difPackets));
		    }
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private static ArrayList<Class<Packet>> getPacketList() {
		ArrayList<Class<Packet>> List = new ArrayList<Class<Packet>>();
		try {
			Field a = Packet.class.getDeclaredField("a");
			a.setAccessible(true);
			HashMap<Class<Packet>,Integer> Packets = (HashMap<Class<Packet>,Integer>)a.get(null);
			for(Class<Packet> Packet:Packets.keySet()){
				List.add(Packet);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return List;
	}
	
	@SuppressWarnings("unchecked")
	private static ArrayList<EntitySetting> getEntitySettingList() {
		ArrayList<EntitySetting> List = new ArrayList<EntitySetting>();
		try {
			Field b = EntityTypes.class.getDeclaredField("b");
			b.setAccessible(true);
			HashMap<String,Class<Entity>> Mapb = (HashMap<String,Class<Entity>>)b.get(new EntityTypes());
			for(String Name:Mapb.keySet()){
				EntitySetting setting = new EntitySetting();
				setting.entityclass = Mapb.get(Name);
				setting.entityName = Name;
				List.add(setting);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return List;
	}
	
	private static ArrayList<Integer> getIdArrayList(){
		ArrayList<Integer> List = new ArrayList<Integer>();
		for(Block block:Block.byId.clone()){
			if(block != null){
				if(!List.contains(block.id)){
					List.add(block.id);
				}
			}
		}
		for(Item item:Item.byId.clone()){
			if(item != null){
				if(!List.contains(item.id)){
					List.add(item.id);
				}
			}
		}
		return List;
	}
	
	private static ArrayList<Object> getDifference(ArrayList<?> List1 ,ArrayList<?> List2){
		ArrayList<Object> List = new ArrayList<Object>();
		for(Object id:List1){
			if(!List2.contains(id)){
				if(!List.contains(id)){
					List.add(id);
				}
			}
		}
		for(Object id:List2){
			if(!List1.contains(id)){
				if(!List.contains(id)){
					List.add(id);
				}
			}
		}
		return List;
	}

	private static int[] getIntArray(ArrayList<Object> List){
		int[] Array = new int[List.size()];
		int i=0;
		for(Object value:List){
			if(value instanceof Integer){
				Array[i++] = (Integer)value;
			}
		}
		return Array;
	}
	
	private static Class<?>[] getClassArray(ArrayList<Object> List){
		Class<?>[] Array = new Class[List.size()];
		int i=0;
		for(Object value:List){
			if(value instanceof Class){
				Array[i++] = (Class<?>)value;
			}
		}
		return Array;
	}
	
}
