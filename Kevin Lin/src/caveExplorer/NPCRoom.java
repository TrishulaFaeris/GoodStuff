package caveExplorer;

public class NPCRoom extends CaveRoom {
	
	private NPC presentNPC;
	
	public NPCRoom(String description) {
		super(description);
		presentNPC = null;
	}

	
	public boolean canEnter() {
		return presentNPC == null;
	}
	public void enterNPC(NPC m) {
		presentNPC = m;
	}
	public void leaveNPC() {
		presentNPC = null;
	}
	/**
	 * there is already a method like this, but to me it is helpful
	 * to have this other way of referring it, especially if 
	 * I decide to change the rule of "canEnter"
	 * @return
	 */
	public boolean containsNPC() {
		return presentNPC != null;
	}
	// The above methods are New features to a CaveRoom,
	// the methods below replace CaveRoom methods (override)
	
	public String validKeys() {
		return "wdsae";
	}
	public void printAllowedEntry() {
		CaveExplorer.print("You can only enter 'w', 'a', 's' or 'd' or"
				+ " you can type 'e' to interact.");
	}
	public void performAction(int direction) {
		if(direction == 4) {
			if(containsNPC() && presentNPC.isActive()) {
				presentNPC.interact();
			}else{
				CaveExplorer.print("There is nothing to interact with.");
			}
		}else {
			CaveExplorer.print("They key does nothing.");
		}
	}
	public String getContents(){
		if(containsNPC()&&presentNPC.isActive()) {
			return "M";
		}else {
			//return what whould be returned otherwise
			return super.getContents();
			}
		}
	public String getDescription() {
		if(containsNPC() && !presentNPC.isActive()) {
			return super.getDescription() + "\n" + presentNPC.getInactiveDescription();
		}else
	}
	
	
	
	
}
