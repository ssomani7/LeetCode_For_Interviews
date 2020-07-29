package bitwise_operator;

//Time Complexity = O(n)
//Space Complexity = O(1)

/*
 * Given a non-empty array of integers, every element appears three times except for one, which appears 
 * exactly once. Find that single one.
 * Your algorithm should have a linear runtime complexity. 
 * Implement it without using extra memory.
 * 
 * Input: [5,5,2,5]
 * Output: 2
 */

public class ThriceOccurringAndSingleElement {

	public static int getSingleAmongThriceOccuringElements(int[] nums) {
		//Each Integer can be represented by 32 bit in binary form.
        //Ex: Decimal = 5, Binary = 101
        //32 bit binary = 00000000000000000000000000000101
        //Assume that every integer is seen in the 32 bit binary form by the compiler
        
        //Now we have to find the single number amongst the group of 3.
        //Ex: 5,3,5,5, Below is their binary form
        // 1  0  1
        // 0  1  1
        // 1  0  1
        // 1  0  1
        
        //Now we will sum up the count of 1's in each column and mod it by 3, and write the remainder
        //in the result's bit
        // % (mod) 3, because the repeating 3 elements.
        
        // 1  0  1
        // 0  1  1
        // 1  0  1
        // 1  0  1
        //---------
        // 0  1  1   ==> Single Number.
        
        //To achieve this programtically, we will use bitwise operators.
        //We will use a decimal number 1 and left shift this number 0 to 31 times.
        // 1 in 32 bit binary will look like 00000000000000000000000000000001
        // 00000000000000000000000000000001 when we left shift this by 1, the binary representation
        //will look like 00000000000000000000000000000010.
        // if we left shift it by 7, it will look like 00000000000000000000000010000000
        
        //If we observe carefully, no matter how much we shift this '1' left from 0 to 31, the
        //32 bits will always have a single 1 and 31 zeros. We will use this number as "bitIndex"
        
        //Now imagine the 32 bit binary representation as an special array whose indexing is from
        //right to left, opposite than the normal arrays. 31 to 0
        
        //We will use this bitIndex to bitwise '&' (AND) with the given numbers in the array.
        //We know that in '&' operation 1 & 1 = 1, if there is a 0, then result is zero.
        
        //So with the bitwise '&' with the help of bitIndex, we are basically determining if
        //the particular bit which is '1' in the bitIndex is also '1' in the number
        
        //Ex: Decimal 2, Binary 00000000000000000000000000000010. Assume our bitIndex is left
        //shifted by 3, so bitIndex will be 00000000000000000000000000000100.
        //Now if we 'AND' the above two 32 bit binary result will be 00000000000000000000000000000000
        
        //The outcome of this operation was to detect whether the 3rd bit in Decimal 2 is 1 or not.
        //Had it been '1' the result would have been non-zero.
        //Ex: Decimal 5, Binary 00000000000000000000000000000101 and assume our bitIndex is 
        //left shifted by 3, so 00000000000000000000000000000100. So their 'AND' will be
        //00000000000000000000000000000100. Which tells us that the 3rd bit in '5' is 1
        
        //Now since it is guranteed that the array will have only 1 single occuring number and all
        //others as group of 3, we will try to collect 1's in a group of 3, i.e, mod 3 == 0.
        
        //In this scenario, there are 2 possibilites, Consider 4 numbers (5,5,3,5)
        // Possibility 1 = All the 4 bits (column wise consideration as shown above) are 1's or 0's,
        // which means mod 3 is not zero, here we don't 'OR' the bitIndex state with the result.
        
        // Possibility 2 = 3 bit's are 1's or 0's and 1 bit is '0' or '1'. Here group of 1's mod 3
        // will be zero. If Three 1's then 3 % 3 = 0, if three bits are 0's then 0 % 3 = 0.
        
        //We 'OR' the bitwiseIndex state with result. We do 'OR' because we need to record each '1'
        //that was detected at every bit in the result.
        
        //Please DRY RUN the code on paper after reading this explanation, it will become more clear.
        
        final int INT_SIZE = 32; //32-bit array representation of integer
        int result = 0; //final answer
        
        for(int i = 0; i < INT_SIZE; i++){
            int sumOfOnesColumnWise = 0;
            int bitIndex = (1 << i); //important left shifting here
            
            for(int num : nums)
                if((num & bitIndex) == 0)
                    sumOfOnesColumnWise++;
            
            if(sumOfOnesColumnWise % 3 == 0)
                result = result | bitIndex;
        }
        return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {5,7,5,5};
		
		System.out.println("Single Element amongst thrice occuring elements = " + 
		getSingleAmongThriceOccuringElements(nums));
	}

}
