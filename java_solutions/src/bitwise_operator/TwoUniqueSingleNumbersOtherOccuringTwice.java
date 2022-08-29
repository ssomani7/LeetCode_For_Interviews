package bitwise_operator;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */

/*
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements 
 * appear exactly twice. Find the two elements that appear only once.
 * 
 * Example:
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * 
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space 
 * complexity?
 */

public class TwoUniqueSingleNumbersOtherOccuringTwice {

	public static int[] singleNumber(int[] nums) {
        int[] result = {0, 0};
        
        //Since the numbers in the result are 2 unique numbers, if we take XOR of all the numbers in
        //the array, the result we get will be same to that if we XOR the resulting 2 elements
        int diff = 0;
        
        // Step 1 = XORing all numbers gets you (a xor b)
        for(int num : nums)
            diff ^= num;
        
        // (a xor b) diff must be non-zero otherwise they are equal
        
        // If bit_i in (a xor b) is 1, bit_i at a and b are different. Try to imagine from XOR property
        
        //Step 2 = Find bit_i using the low bit formula m & -m
        diff &= -diff; //Ex: diff = 6 (110), then -diff = -6 (010) the bits left to the left most 0 in
        //-6, i.e 010 are all '1', which indicates the negative magnitude
        
        // Partition the numbers into two groups: one group with bit_i == 1 and the other group with 
        //bit_i == 0. result[0] for bit_i == 0 and result[1] for bit_i != 0        
        // a is in one group and b is in the other.
        // a is the only single number in its group.
        // b is also the only single number in its group.
        
        // XORing all numbers in a's group to get a
        // XORing all numbers in b's group to get b
        // Alternatively, XOR (a xor b) with a gets you b.
        for(int num : nums)
            if((num & diff) == 0)
                result[0] ^= num;
            else
                result[1] ^= num;
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 1, 3, 2, 5};
		int[] result = singleNumber(nums);
		
		System.out.println(result[0] + ", " + result[1]);
	}

}
