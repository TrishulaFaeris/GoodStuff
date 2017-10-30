package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {
	public static CaveRoom[][] caves;//every room in cave
	public static Scanner in;//for user input
	public static CaveRoom currentRoom;// changes based on how the user navigated
	public static Inventory inventory; //where all the objects in the cave are found and kept
	public static boolean playing = true;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		CaveRoom.setUpCaves();
		
		inventory = new Inventory();
		startExploring();
	}

	private static void startExploring() {
		while(playing) {
			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print(currentRoom.getDirections());
			print("What would you like to do?");
			String input = in.nextLine();
			currentRoom.interpretInput(input);
		}
		
	}

	private static void print(String s) {
		// TODO Auto-generated method stub
		System.out.println(s);
	}
	
}
