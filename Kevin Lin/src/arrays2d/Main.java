package arrays2d;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * This idea is another major topic in Ap CSA.
	 * It is an idea of avoiding an ArrayIndextOutofBonds
	 * you will see it on quizzes, tests, and projects
	 * So always  be mindful.
	 */
	public static void changeNeighbors(int[] arr, int psn) {
		if(psn >= arr.length) {
			arr = arr; 
		}
		else
		{
			if(psn-1 == 0) {
				arr[psn] = arr[psn]+1;
				arr[psn+1] = arr[psn+1]-1;
			}else if(psn == arr.length-1) {
				arr[psn] = arr[psn]+1;
				arr[psn-1] = arr[psn-1]-1;
			}
			else {
				arr[psn] = arr[psn]+1;
				arr[psn-1] = arr[psn-1]-1;
				arr[psn+1] = arr[psn+1]-1;
			}
		}
	}
}
