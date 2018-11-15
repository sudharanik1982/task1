package Random;

import java.util.Arrays;
import java.util.Random;

public class RandomNumber {
	// method to return given Nth number
	public static int findNthSmallestElement(int[] array, int n) {
		Arrays.sort(array);
		System.out.println("Final priority-queue ");
		printArray(array);
		return array[n-1];
	}
	//Display Array
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		Random random = new Random();
		int reqSmallestNumber = 5;
		
		//Get 500 random numbers into an array
		int[] num_array = new int[500];
		for (int i = 0; i < 500; i++)
			num_array[i] = Math.abs(random.nextInt(500));
		
		//Display Random array
		System.out.println("Random array : ");
		printArray(num_array);
		
		//Display Nth smallest number
		System.out.println(
				"Smallest " + reqSmallestNumber + " number is " + findNthSmallestElement(num_array, reqSmallestNumber));
	}

}
