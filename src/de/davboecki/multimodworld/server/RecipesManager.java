package de.davboecki.multimodworld.server;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import java.util.*;

import net.minecraft.server.CraftingManager;

public class RecipesManager {
	
	private static CraftingManager VanillaCraftingManager = null;
	
	public static CraftingManager getCraftingManager(String WorldName) {
		if(ModChecker.getModWorldHandlePlugin() == null) {
			return CraftingManager.getInstance();
		}
		if(ModChecker.getModWorldHandlePlugin().hasWorldSetting(WorldName, "UseVanillaRecipes")) {
			try {
				return (VanillaCraftingManager == null) ? VanillaCraftingManager = new CraftingManager() : VanillaCraftingManager;
			} catch (Exception e) {
				e.printStackTrace();
				return CraftingManager.getInstance();
			}
		} else {
			return CraftingManager.getInstance();
		}
	}
}
