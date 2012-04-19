package de.davboecki.multimodworld.api.plugin;

public enum ExceptionType {
	isIdAllowed("Could not check if an id is allowed."),
	isCraftingAllowed("Could not check if an crafting is allowed."),
	isEntityAllowed("Could not check if an entity is allowed."),
	hasWorldSetting("Could not check world settings."),
	SendPacket("Could not handle a sended packet."),
	replaceEntity("Could not replace an entity."),
	handleModResponse("Could not handle the mod response."),
	replaceRecipies("Could not replace the recipies.");
	
	String Message = null;
	
	ExceptionType() {
		this("Undefined");
	}
	
	ExceptionType(String Message) {
		this.Message = Message;
	}
}
