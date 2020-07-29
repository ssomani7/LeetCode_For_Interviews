package binarySearch;

//Time Complexity = O(logn)
//Space Complexity = O(1)

public class RotatedSortedArraySearch {
	
	public static int binarySearch(int[] arr, int target) {
		//edge case
		if(arr == null || arr.length == 0)
			return -1;
		
		/*
		 * Since the array is rotated at some pivot, we have 2 sections of sorted array. One with the starting
		 * point (minimum) after rotation and the second will have the original (minimum) starting point of the 
		 * array as its starting point.
		 * 
		 * So first we will find the index of the original starting point of the array a.k.a the minimum number
		 * by running a binary search.
		 * 
		 * Since the array is rotated, if the numbers to the right of "mid" are smaller than mid, it indicates that
		 * the original minimum is on the right hand side of "mid".
		 * If the "mid" is less than the numbers to its right, it means the smallest number should be to the left of
		 * "mid" 
		 */
		int left = 0;
		int right = arr.length - 1;
		
		while(left < right) {
			//to avoid integer overflow, calculate midpoint in below fashion.
			int mid = left + (right - left) / 2;
			
			if(arr[mid] > arr[right])
				left = mid + 1;
			else
				right = mid;
		}
		
		//now "left" represents the index with the original minimum of the sorted array before it was rotated.
		int start = left;
		left = 0;
		right = arr.length - 1;
		
		//Now we need to decide out of the 2 sorted arrays we have, on which one should we run our binary search.
		if(target >= arr[start] && target <= arr[right])
			left = start;
		else 
			right = start;
		
		//now do normal binary search. We have our window set properly
		while(left <= right) {
			//to avoid integer overflow
			int midpoint = left + (right - left)/2;
			
			if(arr[midpoint] == target)
				return midpoint;
			else if(arr[midpoint] < target)
				left = midpoint + 1;
			else
				right = midpoint - 1;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {2,3,4,5,6,1};
		int target = 1;
		
//		int[] arr = {4,5,6,7,0,1,2};
//		int target = 0;
		
//		int[] arr = {4,5,6,7,0,1,2};
//		int target = 3;
		
//		int[] arr = {1,3};
//		int target = 2;
		
		int result = binarySearch(arr, target);
		System.out.println("Result = " + result);
	}

}

