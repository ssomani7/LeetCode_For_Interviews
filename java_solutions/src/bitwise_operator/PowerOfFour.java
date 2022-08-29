package bitwise_operator;

/*
 * Time Complexity = O(1)
 * Space Complexity = O(1)
 */

/*
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * 
 * Example 1:
 * Input: 16
 * Output: true
 * 
 * Example 2: 
 * Input: 5
 * Output: false
 * 
 * Follow up: Could you solve it without loops/recursion?
 */

/*
 * Intuition:
 * For power of four, in the binary representation of 32 bits, there will be only one bit in the even index
 * with its bit set to '1' and all other bits will be zero
 */

public class PowerOfFour {

    public static boolean isPowerOfFour(int num) {
        if(num <= 0)
            return false;
                
        int oddCount = 0;
        int evenCount = 0;
        
        for(int index = 0; index < 32; index++){
            int x = 1 << index;
            
            if((num & x) != 0){
                if(index % 2 == 0)
                    evenCount++;
                else
                    oddCount++;
            }
        }        
        
        if(evenCount == 1 && oddCount == 0)
            return true;
        else
            return false;
    }
	
	public static void main(String[] args) {
		int num1 = 8;
		System.out.println(isPowerOfFour(num1));
		
		int num2 = 16;
		System.out.println(isPowerOfFour(num2));
	}
		
    public static boolean trickyMethodIsPowerOfFour(int num) {
    	//0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the even position (32 bits, index starts from zero)
    	//So, 0 to 31 from index point of view, therefore, 32 bits.
    	//0x55555555 is a hexametrical number，it is 1010101010101010101010101010101 in binary with a 
    	//length of 32. To make sure the 1 locates in the EVEN location. (EVEN location from index point of view)
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) == num);
    }

}
