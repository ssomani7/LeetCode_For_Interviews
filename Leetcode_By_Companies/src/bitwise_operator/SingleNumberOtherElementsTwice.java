package bitwise_operator;

/*
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one
 */

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */

public class SingleNumberOtherElementsTwice {

	public static int usingXOR(int[] nums) {
		//XOR, same two elements - output ZERO
		//XOR, different two elements - output ONE
		
		 //edge case
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        
        //Using XOR.
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {4,1,2,1,2};
		
		System.out.println("XOR for finding Single among twice elements = " + usingXOR(nums));
	}

}
