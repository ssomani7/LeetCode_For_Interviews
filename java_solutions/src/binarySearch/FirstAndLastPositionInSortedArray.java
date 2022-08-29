package binarySearch;

//Time Complexity = O(log n), 2 binary searches, still O(log n)
//Space Complexity = O(1)

public class FirstAndLastPositionInSortedArray {

	public static int[] getFirstAndLastElementFromSortedArray(int[] nums, int target) {
		//edge case
		if(nums == null)
			return new int[] {-1,-1};
		
		//First Pass of binarySearch, we will get the target element from its left most occurrence
		int firstPosition = binarySearch(nums, target);
		//searching for left most immediate greater element than target and subtracting 1 from it to get the 
		//right most occurence of target.
		int lastPosition = binarySearch(nums, target + 1) - 1;
		
		if(firstPosition <= lastPosition) {
			//consider corner case [5,6] & target = 6. So the firstPosition and lastPosition are the same.
			return new int[] {firstPosition, lastPosition};
		}
		
		//if the target number never occurs in the array, automatically the firstPositon becomes greater than
		//lastPosition and it violates our requirements. So input itself is wrong.
		return new int[] {-1,-1};
	}
	
	public static int binarySearch(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		
		//firstPosition to be declared to the size of array, i.e, out of index because in our second
		//binary search, we look for the left most immediate greater element to the target. Since the 
		//array is sorted, the binary search will give us the position of the left most immediate greater
		//element. We can then subtract 1 from the answer and it will yeild us the right most position of
		//the target.
		//Edge case is when our target element is the last element of the array and there doesn't exits an
		//immediate greater element in the array. Since our firstPosition is initialized at 'nums.length', 
		//which is out of index, we subtract 1 from it yielding our right most location of the target.
		 
		int firstPosition = nums.length;
		
		while(start <= end) {
			int mid = (start + end) >> 1; //divide by 2
			
			if(nums[mid] >= target) {
				//search on the left hand side of mid for first occurence of the target & mark the
				//mid as the running first occurence.
				firstPosition = mid;
				end = mid - 1;
			} else {
				//search on the right hand side of mid.
				start = mid + 1;
			}
		}
		return firstPosition;
	}
	
	public static void main(String[] args) {
		int[] nums = {5,7,7,7,7,7};
		int target = 7;
		
		int[] result = getFirstAndLastElementFromSortedArray(nums, target);
		System.out.println("First Position of target = " + result[0] + " , Last Position of target = " + result[1]);
	}
}
