package dynammic_programming;

/*
 * Time Complexity = O(N ^ 2)
 * Space Complexity = O(N)
 */

/*
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 
 * Example:
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
 * 
 * Note:
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 */

public class LongestIncreasingSubsequence {

	public static int lengthOfLIS(int[] nums) {
        //edge case
        if(nums.length == 0 || nums == null)
            return 0;
        
        //each array element on its own is a sequence of length 1.
        //make a dp array of the same size and initialize it with 1.
        int[] lisArr = new int[nums.length];
        
        for(int i = 0; i < lisArr.length; i++)
            lisArr[i] = 1;
        
        //We will keep an 'i' ptr on nums which will start from 1.
        //We will have an 'j' pts on nums, which will run till 'i - 1', once the 'j' ptr has run its course
        //we will increment 'i' after that.
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i] && (lisArr[i] <= lisArr[j])) //important condition
                    lisArr[i] = lisArr[j] + 1;
            }
        }
        
        //now find the max value from the lisArr. That is our answer
        int maxSubsequence = 1;
        
        for(int i : lisArr)
            maxSubsequence = Math.max(maxSubsequence, i);
        
        for(int i : lisArr)
        	System.out.print(i + ", ");
        
        System.out.println();
        System.out.print("Longest Increasing Subsequence = ");
        //printing the subsequence as well
        printLongestIncreasingSubsequence(nums, lisArr, maxSubsequence);
        
        return maxSubsequence;
    }
	
	public static void printLongestIncreasingSubsequence(int[] nums, int[] lisArr, int maxSubsequence) {
		//edge case
		if(maxSubsequence == 1) {
			System.out.println(nums[0]);
			return;
		}
		
		//get the last element value from the lisArr
        int count = lisArr[lisArr.length - 1];
        //use the index of this lisArr to look up values from the nums array
        int subsequenceNumber = nums[lisArr.length - 1];
        //We know the longest subsequence size. So initialize the array accordingly
        int[] result = new int[maxSubsequence];
        //place the subsequence number at the end of the result array
        result[result.length - 1] = subsequenceNumber;
        //Now reduce the count number by 1, as it will be our next searching number
        count = count - 1;
        //now iterate over the lisArr from last second position. As soon as you find the a value in that array
        //which is equal to the count, you get the index of that value, use it to look up the
        //actual subsequence number in the nums array. Store that result in the result array. Decrement the
        //count by 1, and keep the search going.
        int lisArrIndex = lisArr.length - 2;
        int resultArrayIndex = result.length - 2;
        
        while(count != 0) {
        	if(lisArr[lisArrIndex] == count) {
        		result[resultArrayIndex] = nums[lisArrIndex];
        		resultArrayIndex--;
        		count = count - 1;
        	}
        	lisArrIndex--;
        }
        
        for(int i : result)
        	System.out.print(i + ", ");
        System.out.println();
	}
	
	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		
		System.out.println("Max Subsequence Length = " + lengthOfLIS(nums));
	}

}
