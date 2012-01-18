package de.davboecki.multimodworld.server;

import net.minecraft.server.BaseMod;

class ModBlockAddList{
	private BaseMod Mod;
	private int[] Ids;
	ModBlockAddList(BaseMod Mod, int[] Ids){this.Mod = Mod;this.Ids = Ids;}
	public BaseMod getMod(){return Mod;}
	public int[] getIds(){return Ids;}
}