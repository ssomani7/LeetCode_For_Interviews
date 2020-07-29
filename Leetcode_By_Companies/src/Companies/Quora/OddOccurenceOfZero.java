package Companies.Quora;

public class OddOccurenceOfZero {

	public static int oddOccurencesOfZeros(int[] a) {
		int result = 0;
		
		//first loop over the integer array
		//'a' is the int array of elements
		for(int num : a) {
			//check if the number is 0 itself. We are only interested in the zero's that occur to the right
			//side of the left most non significant bit.
			//Ex: 1000, here we should count 3 zeros.
			//Ex: 00100, is interpreted as 100 by the compiler. So we don't care about the left most zero.
			
			//The only case where the left most zero is taken into consideration when the number is zero
			//itself.
			//Ex: 0 and 00000000000 are both considered as a single digit zero.
			if(num == 0) {
				result++;
				continue; //go to the next element in the array
			}
			
			int oddZeroCount = 0;
			
			while(num > 0) {
				int lastDigit = num % 10; //extracting the last digit of number
				
				if(lastDigit == 0)
					oddZeroCount++;
				
				num = num / 10; //shortening the number
			}//end while loop
			
			//chech if the oddZeroCount is in fact odd
			if(oddZeroCount % 2 != 0)
				result++;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = {0, 0, 4, 50, 100, 65, 2000, 700, 1, 10};
		System.out.println(oddOccurencesOfZeros(a));
    }

}
