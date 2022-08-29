package array_questions;

//Time Complexity = O(n)
//Space Complexity = O(1)

/*
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation: 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 */

public class RightArrayRotation {

	public static void rotateArrayToTheRight(int[] arr, int k) {
		//first update the 'k' as pattern will be repeated.
        //Ex: Rotating once and eight times for an array of length 7, gives one and the same answer.
        //Only changing factor is 'k', array length is constant. So k % array length.
		k %= arr.length; //k = k % arr.length;
		
		//using the 3 reverse approach.
		
		//first reverse the whole array
		reverseArray(arr, 0, arr.length - 1);
		//Now reverse the elements upto 'k-1'
		reverseArray(arr, 0, k-1);
		//Now reverse the elements from 'k' to end of array
		reverseArray(arr, k, arr.length - 1);
		
		System.out.print("Array after rotating " + k + " times = ");
		for(int i : arr)
			System.out.print(i + " ");
	}
	
	public static void reverseArray(int[] arr, int left, int right) {
		while(left < right) {
			int temp = arr[right];
			arr[right] = arr[left];
			arr[left] = temp;
			left++;
			right--;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int k = 3; //number of times array needs to be rotated.
		rotateArrayToTheRight(arr, k);
	}

}
