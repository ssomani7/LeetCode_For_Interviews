package sorting;

//Time Complexity = O(nlogn)
//Space Complexity = O(n)

public class MergeSort {

	public static void merge(int[] arr, int start, int mid, int end) {
		//calculate the sizes of left and right sub arrays.
		int leftSubArraySize = mid - start + 1; // "+1" because of 0th index as start of an array
		int rightSubArraySize = end - mid;
		
		int[] leftSubArray = new int[leftSubArraySize];
		int[] rightSubArray = new int[rightSubArraySize];
		
		//for left sub array the starting point will be from the left most side of array and will increase
		//towards right.
		for(int i = 0; i < leftSubArraySize; i++)
			leftSubArray[i] = arr[start + i];
		
		//for right sub array it will be elements from the right of the mid
		for(int i = 0; i < rightSubArraySize; i++)
			rightSubArray[i] = arr[mid + 1 + i];
		
		//now 3 indexes to track left, right sub arrays and the main array.
		//for the main array the index should always begin at the start given to us dynamically.
		int leftIndex = 0;
		int rightIndex = 0;
		int mainArrayIndex = start;
		
		//compare between left and right sub arrays and update the main array accordingly.
		//left and right sub arrays will act as the temporary variables for value swapping.
		while(leftIndex < leftSubArraySize && rightIndex < rightSubArraySize) {
			if(leftSubArray[leftIndex] <= rightSubArray[rightIndex]) {
				arr[mainArrayIndex] = leftSubArray[leftIndex];
				leftIndex++;
			} else {
				arr[mainArrayIndex] = rightSubArray[rightIndex];
				rightIndex++;
			}
			mainArrayIndex++;
		}
		
		//now check for both the left and right sub arrays for remaining elements. If they have any,
		//simply replace those in the main array without any comparision. Only one sub array will run out of
		//index in the above while loop.
		while(leftIndex < leftSubArraySize) {
			arr[mainArrayIndex] = leftSubArray[leftIndex];
			leftIndex++;
			mainArrayIndex++;
		}
		
		while(rightIndex < rightSubArraySize) {
			arr[mainArrayIndex] = rightSubArray[rightIndex];
			rightIndex++;
			mainArrayIndex++;
		}
		
	}//end merge
	
	public static void divide(int[] arr, int start, int end) {
		if(start < end) {
			//calculate mid. Below formula avoids overflow in case of higher 'start' and 'end'
			//it is same as (start + end) / 2;
			int mid = start + (end - start)/2;
			
			//2 sub arrays recurisve calls. Left most will be start to mid.
			//Right most will be mid+1 to end
			divide(arr, start, mid);
			divide(arr, mid + 1, end);
			
			//merge the array now as it is now in its base case of sorted
			merge(arr, start, mid, end);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {6,5,12,10,9,1};
		
		divide(arr, 0, arr.length-1);
		
		System.out.print("Sorted Array = ");
		for(int i : arr)
			System.out.print(i + " ");
	}

}
