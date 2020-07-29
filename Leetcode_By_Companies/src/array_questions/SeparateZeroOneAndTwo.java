package array_questions;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */

/* Important Argument:
 * The idea is to sweep all 0s to the left and all 2s to the right, then all 1s are left in the middle.
 * It is hard to define what is a "one-pass" solution but this algorithm is bounded by O(2n), meaning that at 
 * most each element will be seen and operated twice (in the case of all 0s). You may be able to write an 
 * algorithm which goes through the list only once, but each step requires multiple operations, leading the 
 * total operations larger than O(2n).
 */

/*
 * In the below code, even though we are doing 1 iteration of the array, the fact that we are using 3 pointers
 * makes our code O(2n).
 */

/*
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same 
 * color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 * 
 * Example:
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 
 * 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */

public class SeparateZeroOneAndTwo {

	//prefer this method in interview
    public static int[] sortColors(int[] nums) {
        int start = 0; //start will mark the index where a zero '0' should be placed
        int end = nums.length - 1; //end will mark the index where a two '2' should be placed
        int index = 0; //used for swapping
        
        //our approach is to separate all the 0's to the left and all the 2's to the right, which will
        //lead to 1's in the middle
        
        while(index <= end && start < end){
            if(nums[index] == 0){
                // swap
                nums[index] = nums[start];
                nums[start] = 0;
                start++;
                index++;
            } else if(nums[index] == 2){
                // swap
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
            } else {
                index++; //nums[index] is 1, we don't need to move it to either start or end. So keep it
                //as it is.
            }
        }
        return nums;
    }
	
    //Saurabh's own logic. Time Complexity = O(n). Explicit two pass O(n) + O(n) = O(2n) which is O(n), ignore
    //constant.
    //Logic: Two pass, first separate zeros and rest, Then separate ones and twos
    
    public static void twoPassSeparate(int[] nums) {
        //edge case
        if(nums.length <= 1)
            return;
        
        //smallest to the left and largest to the right
        int leftPtr = 0;
        int rightPtr = nums.length - 1;
        
        //Two pass, first separate zeros and rest
        //Then separate ones and twos
        
        //zeros and rest separated
        separateNumbers(nums, leftPtr, rightPtr, 0);
        
        //now detect the index where zero ends
        leftPtr = 0;
        
        while(leftPtr < nums.length && nums[leftPtr] == 0)
            leftPtr++;
        
        if(leftPtr == nums.length)
            return;
        
        //now leftPtr points at index which should be the start of one.
        rightPtr = nums.length - 1;
        separateNumbers(nums, leftPtr, rightPtr, 1);
    }
    
    public static void separateNumbers(int[] nums, int leftPtr, int rightPtr, int value){
        while(leftPtr < rightPtr){
            while(leftPtr < rightPtr && nums[leftPtr] == value)
                leftPtr++;
            
            while(leftPtr < rightPtr && nums[rightPtr] != value)
                rightPtr--;
            
            if(leftPtr < rightPtr)
                swap(nums, leftPtr, rightPtr); 
        }
    }
    
    public static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
	public static void main(String[] args) {
		int[] nums = {2,0,2,1,1,0};
		
		nums = sortColors(nums);
		
		for(int num : nums)
			System.out.print(num + " ");
	}
	
}
