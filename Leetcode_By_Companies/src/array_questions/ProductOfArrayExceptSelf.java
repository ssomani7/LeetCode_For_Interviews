package array_questions;

/*
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the 
 * product of all the elements of nums except nums[i].
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the
 * whole array) fits in a 32 bit integer.
 */

/*
 * Time Complexity = O(n)
 * Space Complexity = O(n)
 */
public class ProductOfArrayExceptSelf {

	//prefer this method
	public static int[] leftAndRightProductTechnique(int[] nums) {
		//edge case
		if(nums.length == 1)
			return nums;
		
		
		/*
		 * Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array except 4 is 2*3*5 which 
		 * consists of two parts: left 2*3 and right 5. The product is left*right. We can get lefts and rights:
		 * Numbers:     2    3    4     5
		 * Lefts:       1    2  2*3 2*3*4
		 * Rights:  3*4*5  4*5    5     1 
		 * 
		 * Let’s fill the empty with 1:
		 * Numbers:     2    3    4     5
		 * Lefts:       1    2  2*3 2*3*4
		 * Rights:  3*4*5  4*5    5     1
		 */
		int[] result = new int[nums.length];
		result[0] = 1;//nothing left to the first array element.
		
		for(int i = 1; i < nums.length; i++) {
			result[i] = nums[i - 1] * result[i - 1];
			//result[i - 1] acts as the left product aggregate
		}
		
		int rightProductAggregate = 1;
		
		//nothing right to the last element in the array.
		for(int i = nums.length - 2; i >= 0; i--) {
			rightProductAggregate *= nums[i + 1];
			result[i] *= rightProductAggregate;
			//result[i] will hold the left aggregate product, thus we just mulitply the right aggregate product
			//with the left aggregate and update the value at the same index.
		}
		
		return result;
	}
	
	public static int[] divisionTechnique(int[] nums) {
		//edge case
		if(nums.length == 1)
			return nums;
				
		int[] result = new int[nums.length];
		int totalProduct = 1;
		
		for(int i : nums)
			totalProduct *= i;
		
		for(int i = 0; i < nums.length; i++) {
			result[i] = totalProduct / nums[i];
		}
		
		return result;
	}
	
	public static void printArray(int[] result) {
		for(int i : result)
			System.out.print(i + " ");
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		
		int[] result = leftAndRightProductTechnique(nums);
		System.out.println("Product of array using left and right product technique = ");
		printArray(result);
		
		int[] divisionResult = divisionTechnique(nums);
		System.out.println();
		System.out.println("Result after using Division Technique = ");
		printArray(divisionResult);
	}

}
