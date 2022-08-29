package binarySearch;

//Time Complexity = O(logn)
//Space Complexity = O(1)

public class MinimumNumberInRotatedSortedArray {

	public static int binarySearch(int[] arr) {
		//edge case
		if(arr == null || arr.length == 0)
			return -1;
		
		//Array is rotated at a pivot. So there are 2 sections of array, 1 starting with the minimum obtained
		//after rotation and the other sub array that starts with the original minimum element.
		
		//Since we don't know how much times the array is rotated, we will see if the elements to the right of
		//midpoint are greater than the midpoint itself. If so, our minimum element lies on the right hand side
		//of mid-point.
		//If the 'mid' itself is less than the elements to its right, than the mimimum element lies to the "left"
		//of midpoint.
		
		int start = 0;
		int end = arr.length - 1;
		
		while(start < end) {
			//to avoid integer overflow, calculate mid in the below fashion.
			int mid  = start + (end - start) / 2;
			
			if(arr[mid] > arr[end])
				start = mid + 1;
			else
				end = mid;
		}
		
		//"start" marks the index of the minimum element in the rotated sorted array.
		return arr[start];
	}
	
	public static void main(String[] args) {
//		int[] arr = {4,5,6,7,0,1,2};
		int[] arr = {2,3,4,5,6,1};
		
		int result = binarySearch(arr);
		System.out.println("Minimum Element in Rotated Sorted Array = " + result);
	}

}
