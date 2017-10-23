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
