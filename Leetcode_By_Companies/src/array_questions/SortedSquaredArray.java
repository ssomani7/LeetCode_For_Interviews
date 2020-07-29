package array_questions;

//Time Complexity = O(n)
//Space Complexity = O(n)

public class SortedSquaredArray {

	public static int[] sortedSquaredArray(int[] arr) {
		/*
		 * Using 2 pointers approach. Given array is sorted. Keep left pointer at the beginning and right at the
		 * end. Now check if right pointer value is greater, if yes, fill that in the output array from the end.
		 * In this fashion, keep checking the left and right values and fill the output array from end to start.
		 */
		int[] result = new int[arr.length];
		int left = 0;
		int right = arr.length - 1;
		int outputPtr = right;
		
		while(left < right) {
			if(Math.abs(arr[left]) > Math.abs(arr[right])) {
				result[outputPtr] = arr[left] * arr[left];
				left++;
			} else {
				result[outputPtr] = arr[right] * arr[right];
				right--;
			}
				
			outputPtr--;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {-7, -3, -1, 4, 8 ,12};
		
		int[] result = sortedSquaredArray(arr);
		
		for(int i : result)
			System.out.print(i + " ");
	}

}
