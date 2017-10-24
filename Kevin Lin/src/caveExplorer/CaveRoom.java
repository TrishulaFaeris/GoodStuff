package caveExplorer;

public class CaveRoom {
	
	private String description; //tells what the room looks like;
	private String directions; //tells what you can do
	private String contents; // a symbol representing what is in the room
	private String defaultContents;
	//the rooms are organized by direction, 'null' signifies no room in that direction
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	//constants
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		//difference between defaultContents and contents is "contents" becomes an 'x' when you are 
		//inside this room, when you leave, it goes back to defaultContents.
	
		//note: by default; arrays will populate with 'null' meaning there is no connections
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}
	
	public void setDirections() {
		directions = "";
		boolean doorFound = false;
		for(int i = 0; i < doors.length; i++) {
			if(doors[i] != null) {
				doorFound = true;
				directions += "/n    There is a"+doors[i].getDescription()+ "to "+
				toDirection(i)+". "+doors[i].getDetails();
			}
		}
		if(!doorFound) {
			directions += "There is no way out. You are trapped in here.";
		}
	}
	
	public static String toDirection(int dir) {
		String[] direction = {"the North", "the East", "the South", "the West"};
		return direction[dir];
		
	}
	public void enter() {
		contents = "X";
	}
	public void leave() {
		contents = defaultContents;
	}
	/**
	 * Gives this room access to another room
	 * and sets a door between them, updating the directions
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction,anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}
	public static int oppositeDirection(int direction) {
		int[] newDirections = {2, 3, 0, 1};
		return newDirections[direction];
	}

	public void addRoom(int direction, CaveRoom cave, Door door) {
		borderingRooms[direction] = cave;
		doors[direction] = door;
		setDirections();
	}
	public void interpretInput(String input) {
		while(isValid(input)) {
			System.out.println("You can only enter 'w','a','s' or 'd'.");
			input = CaveExplorer.in.nextLine();
		}
		String dirs = "wdsa";
		goToRoom(dirs.indexOf(input));
	}
	private boolean isValid(String input) {
		String validEntries = "wdsa";
		return validEntries.indexOf(input)>-1 && input.length() ==1;
	}

	private void goToRoom(int direction) {
		if(borderingRooms[direction] != null && doors[direction] != null) {
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
		}
	}
	/**
	 * This will be where your group sets up all the caves
	 * and the connections
	 */
	public static void setUpCaves() {
		
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}

	
	
}
