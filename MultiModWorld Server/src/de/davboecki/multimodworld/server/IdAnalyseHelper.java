package de.davboecki.multimodworld.server;

import java.util.ArrayList;

import net.minecraft.server.Block;
import net.minecraft.server.Item;

public class IdAnalyseHelper {
	
	public static ArrayList<Integer> getIdArrayList(){
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
	
	public static ArrayList<Integer> getDifference(ArrayList<Integer> List1 ,ArrayList<Integer> List2){
		ArrayList<Integer> List = new ArrayList<Integer>();
		for(int id:List1){
			if(!List2.contains(id)){
				if(!List.contains(id)){
					List.add(id);
				}
			}
		}
		for(int id:List2){
			if(!List1.contains(id)){
				if(!List.contains(id)){
					List.add(id);
				}
			}
		}
		return List;
	}
	
	public static int[] getIntArray(ArrayList<Integer> List){
		int[] Array = new int[List.size()];
		int i=0;
		for(Integer value:List){
			Array[i++] = value;
		}
		return Array;
	}
	
}
