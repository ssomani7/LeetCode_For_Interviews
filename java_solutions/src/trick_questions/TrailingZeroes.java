package trick_questions;

/*
 * Time complexity : O(logn). 
 * In this approach, we divide nn by each power of 5. By definition, there are log n powers of 5
                                                                                  5
  less-than-or-equal-to n. Because the multiplications and divisions are within the 32-bit integer range, we 
  treat these calculations as O(1). 
  Therefore, we are doing log n
                             5
​  O(1)=logn operations (keeping in mind that log bases are insignificant in big-oh notation).

  Space complexity : O(1).
  We use only a fixed number of integer variables, therefore the space complexity is O(1).
 */

public class TrailingZeroes {

    public static int trailingZeroes(int n) {
        int zeroCount = 0;
        long currentMultiple = 5;
        
        while(n > 0){
            n = n / 5;
            zeroCount += n;
        }
        return zeroCount;
    }
	
	public static void main(String[] args) {
		int n = 5;
		
		System.out.println("Trailing Zeroes in factorial = " + trailingZeroes(n));
	}

}
