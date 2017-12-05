package recursionExcerise;

public class Fibonacci {
	public Fibonacci(){
	}
	public static void main(String[] args) {
		System.out.println(getFibonacci(1));
	}
	
	public static  int getFibonacci(int base) {
		if(base < 0) {
			return -1;
		}else{
			if(base < 2 ) {
				return 1;
			}else {
				return getFibonacci(base-1) + getFibonacci(base-2); 
			}
		}
	}
	
}
