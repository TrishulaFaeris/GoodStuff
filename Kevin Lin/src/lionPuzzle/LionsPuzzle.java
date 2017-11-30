package lionPuzzle;

public class LionsPuzzle {
	
	public static void main(String[] args) {
		int lions = 101;
		System.out.println(lions + " lions decide to eat the sheep? "+eatSheepOrNot(lions));
	}

	private static boolean eatSheepOrNot(int lions) {
		if(lions == 1) {
			return true;
			//there are no lions to eat your if you eat a sheep!
		}else {
			//you would eat the sheep knowing the other lion won't eat the sheep
			return !eatSheepOrNot(lions-1);
		}
	}
}
