package caveExplorer;

public class TwoDArrayPractice {
	

	public static void main(String[] args) {
		String[][] pic = new String[6][10];
		for(int row = 0; row < pic.length; row++) {
			for(int col = 0; col < pic[row].length; col++) {
				pic[row][col] = " ";
			}
		}
		drawHorizontalLine(pic,1);
		drawVerticalLine(pic,1);
		//drawSlot(pic,4,5);
		drawBox(pic,4,5);
		print(pic);
	}

	private static void drawBox(String[][] pic, int row, int col) {
		drawSlot(pic,row,col);
		drawSlot(pic,row+1,col);
		drawIfInBounds("_",pic,row+1,col);
		pic[row][col] = "*";
		for(int j = col-1; )

	}

	private static void drawIfInBounds(String string, String[][] pic, int row, int col) {
		//SPECIAL NOTE, ALWAYS CHECK ROW BEFORE COL
		//check row exists before checking if column exist in the row
		if(row >= 0 && row <pic.length && col >=0 && col<pic[row].length) {
			pic[row][col] = string;
		}
		
	}

	private static void drawSlot(String[][] pic, int row, int col ) {
		if(row >=0 && row < pic.length) {
			if(col > 0) {
				pic[row][col-1] = "|"; 
			}
			if(col < pic[row].length-1) {
				pic[row][col+1] = "|";
			}
		}	
	}

	private static void drawVerticalLine(String[][] pic, int col) {
		for(int row = 0; row < pic.length; row ++) {
			pic[row][col] = "|";
		}
		
	}

	private static void drawHorizontalLine(String[][] pic, int row) {
		for(int col = 0; col < pic[row].length; col++) {
			pic[row][col] = "-";
		}
		
	}

	private static void print(String[][] pic) {
	String line = "";
	for(int row = 0; row < pic.length; row++) {
		for(int col = 0; col < pic[row].length; col++) {
			line+= pic[row][col];
			}
			line+= "\n";
		}
		System.out.println(line);
	}

}
