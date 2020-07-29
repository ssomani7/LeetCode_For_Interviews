package Companies.Amazon.Array;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */

/*
 * Given an unsorted integer array, find the smallest missing positive integer.
 * 
 * Example 1:
 * Input: [1,2,0]
 * Output: 3
 * 
 * Example 2:
 * Input: [3,4,-1,1]
 * Output: 2
 * 
 * Example 3:
 * Input: [7,8,9,11,12]
 * Output: 1
 */

public class FirstMissingPositive {

	public static int firstMissingPositive(int[] nums) {
        //edge case
        if(nums.length == 0 || nums == null)
            return 1;
        
        //Step 1 : Detect in the array if there is occurence of positive 1. If yes, set a boolean
        //flag true. Now simultaneoulsy replace all the numbers that are 0, -ve and greater than
        //array length by +ve 1.
        boolean containsNaturallyOccurringOne = false;
        int arrayLength = nums.length;
        
        for(int i = 0; i < arrayLength; i++){
            if(nums[i] == 1)
                containsNaturallyOccurringOne = true;
            else if(nums[i] <= 0 || nums[i] > arrayLength)
                nums[i] = 1; //replacing with our '1'
        }
        
        //Step 2 : If the array doesn't contains even a single occurence of +ve 1 (our boolean flag)
        //then just return 1.
        if(!containsNaturallyOccurringOne)
            return 1;
        
        //Step 3 : Our array contains naturally occuring +ve 1 along with the +ve 1's we have
        //introduced. Now pick up the absolute value of the arr[index], subtract 1 from it. This
        //will be the indexToBeJumped. If the value at the indexToBeJumped is not -ve, make it -ve.
        //If it is -ve already, don't do anything, continue;
        for(int i = 0; i < arrayLength; i++){
            int indexToBeJumped = Math.abs(nums[i]) - 1; //'-1' because array index starts from Zero
            
            if(nums[indexToBeJumped] > 0) // '+ve' changed to '-ve'
                nums[indexToBeJumped] *= -1;
        }
        
        //Step 4 : Now again loop over the array and see the first number which you find +ve. Return
        //its index + 1.
        for(int i = 0; i < arrayLength; i++)
            if(nums[i] > 0)
                return i + 1;
        
        //Step 5 : If you didn't return from step 4's for loop then the missing +ve number is array
        //length + 1.
        return arrayLength + 1;
    }
	
	public static void main(String[] args) {
		int[] nums = {3,4,-1,1};
		
		System.out.println("First Missing Positive = " + firstMissingPositive(nums));
	}

}