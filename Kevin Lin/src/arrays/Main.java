package arrays;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ObjectArrays oA = new ObjectArrays();
		Person s = new Person("Ben", "Nockles", Borough.NY_BOROUGHS[0]);
		int x = 10;
		int[] a = {5,6,7};
		test(s,x,a);
		System.out.println(s+", "+x+","+Arrays.toString(a));
	}
	/**
	 * PASS-BY-Value Examples
	 * Dose not change name;
	public static void test(Person s, int x, int[] arr) {
		String name = s.getFirstName();
		name = "Ilona";
		x= 5;
		arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
	}
	*/
	//This will change the name
	public static void test(Person s, int x, int[] arr) {
		String name = s.setFirstName("Ilona");
		x= 5;
		arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
}