package arrays;

import java.util.Arrays;

public class ArraysMain {

	private int[] testArray;
	private int[] intRay;
	
	public ArraysMain() {
		intRay = new int[100];
		//populuate(intRay);
		//checkOccurences(intRay, 3,18);
		//Arrays is a Utility class included in Java for formatting input
		populuate1toN(intRay);
		shuffle(intRay);
		System.out.println(Arrays.toString(intRay));
	}
	private void shuffle(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			swap(arr, (int)(Math.random()*arr.length), (int)(Math.random()*arr.length));
		}
		
	}
	private void swap(int[] arr, int i, int j) {
		int placeholder = arr[j];
		arr[j] = arr[i];
		arr[i] = placeholder;
		
	}
	private void checkOccurences(int [] arr, int start, int end) {
		int[]counter = new int[end - start +1];
		for(int value: arr) {
			counter[value-start]++;
		}
		for(int i =0; i < counter.length; i++) {
			System.out.println("A "+(start+i)+" was rolled "+counter[i]+" times.");
		}
	}
	private void populuate(int[] intRay) {
		for(int i =0; i < intRay.length; i++) {
			intRay[i] = diceRoll(3);
		}
	}
	public void notes() {
				//1. collection of primitives or objects
		//SPECIAL NOTE: this is the ONLY collection of primitives
		//2. size cannot be modified
		/* 
		 * 3. Elements of an array are references to objects.
		 * In other words, changing an element of an array changes
		 * the reference, not the object.
		 */
		
		//There are two types of constructors, the first we have seen already:
		int[] firstType = {3,14,-9,10};
		//this constructor can only be used at the declaration.
		//Error: firstType = {13,12,11};
		
		// the 2nd type:
		testArray = new int[50];
		//the one above tells the length, no value;
		/* SPECIAL NOTE: for primitive arrays, when they are instantiated,
		 * they are automatically populated with 0s, This is not the case with 
		 * Object arrays, which are populated with 'null'
		 */
		
		//standard 'for' loop
		for(int i = 0; i < testArray.length; i++) {
			System.out.println(testArray[i]);
		}
		
		//for each loop(useful only when you don't need to keep of an index )
		for(int value:testArray) {
			//reads "for each int in testArray..."
			System.out.println(value);
		}
	}
	public static void main(String[] args) {
		ArraysMain arrayPractice = new ArraysMain();

	}
	/*
	 * Returns the result from rolling "numberofDice" dice.
	 * param number of dice
	 * return
	 */
	public int diceRoll(int numberOfDice) {
		int roll = 0;
		for(int i = 0; i < numberOfDice; i ++) {
			roll = roll + 1+(int)(Math.random()*6);
			// Math.random* 6 gives 0-5; we want 1-6, so we + 1
		}
		return roll;
	}
	public void populuate1toN(int [] arr)
	{
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
	}
}
