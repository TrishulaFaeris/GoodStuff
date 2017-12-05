package recursionExcerise;

public class RecursionExercise {
	public static void main(String[] args) {
		int value = 5;
		System.out.println(value+"! is equal to "+factorial(value));
		System.out.println(value+" has "+countPrimeFactors(value,2)+" prime factors.");
	}

	private static int factorial(int value) {
		if(value == 0) {
			return 1;
		}
		else {
			return value * factorial(value-1);
		}
	}

	private static int countPrimeFactors(int value, int i) {
		int test = i;
		if(value == 1) {
			return 0;
		}else if(value%i ==0){
		
		}
	}
}
