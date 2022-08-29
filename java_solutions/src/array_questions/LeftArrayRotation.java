package array_questions;
//Time Complexity = O(n)
//Space Complexity = O(1)

public class LeftArrayRotation {

	public static void rotateArrayToTheLeft(int[] arr, int k) {
		//First update k, as the pattern will be repeated. Rotating an array of size 5, 1 time and 6 times will
		//yield the same result. 'k' changes, array length remains the same, so k % array length
		k %= arr.length; //k = k % arr.length;
		
		//3 reverse technique. 0 to k-1, k to array end, whole array.
		
		//first, reverse from 0 to 'k-1'
		reverseArray(arr, 0, k-1);
		//then, reverse from 'k' to array end 
		reverseArray(arr, k, arr.length - 1);
		//finally reverse the entire array
		reverseArray(arr, 0, arr.length - 1);
		
		System.out.print("Left Rotated Array = ");
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
		int[] arr = {1,2,3,4,5}; //output = [3,4,5,1,2]
		int k = 2;
		
		rotateArrayToTheLeft(arr, k);
	}

}
