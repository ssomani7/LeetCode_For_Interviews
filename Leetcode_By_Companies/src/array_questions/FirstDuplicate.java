package array_questions;

//Time Complexity = O(n)
//Space Complexity = O(1)

//Constraints = All the array elements are between 1 and 'n' (inclusive). Where 'n' being the size of the array

public class FirstDuplicate {

	public static int findFirstDuplicate(int[] arr) {
		//edge case
		if(arr == null || arr.length == 0)
			return -1;
		
		if(arr.length == 1)
			return -1;
		/*
		 * Since all the elements in the array are between 1 and 'n' (inclusive), 'n' being the size of the array.
		 * We will access all the indices by value of element - 1.
		 * 
		 * We will first take value of the element and then subtract 1 from it.
		 * Now we go to this particular index, and check if it is a negative number (-1).
		 * If yes, we record the index and return the array value at that index.
		 * If we don't encounter a negative value at the index we got by 'value - 1', we make it -1.
		 * We then iterate over the array, and get the absoulte value at the index and continue the above steps.
		 * 
		 * Trick: Only return when you encounter a negative value when jumping through 'value - 1'. Don't return
		 *        while iterating.
		 */
				
		for(int i = 0; i < arr.length; i++) {
			int indexToBeChecked = Math.abs(arr[i]) - 1;
			
			if(arr[indexToBeChecked] == -1)
				return arr[i];
			
			//mark that index as -1 and move on
			arr[indexToBeChecked] = -1;
		}//end for loop
			
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,1,3,4,3,5,2}; //output = 3
//		int[] arr = {1,2,3,4}; //output = -1
//		int[] arr = {1,2,1,2,3,3}; //output = 1
		
		int result = findFirstDuplicate(arr);
		System.out.println("First Duplicate Number = " + result);
	}

}
