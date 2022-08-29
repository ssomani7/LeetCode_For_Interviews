package array_questions;

//Asked in EA sports Hyderabad
//Time Complexity = O(n). Using 2 pointers we sort array in place in one pass
//Space Complexity = O(1)

public class SortZerosAndOnes {
	
	public static void separateZerosAndOnesInPlace(int[] arr) {
		int arrSize = arr.length;
		int leftPtr = 0; //will be used to detect Zeros
		int rightPtr = arrSize - 1; //will be used to detect ones
		
		while(leftPtr < rightPtr) {
			while(arr[leftPtr] == 0 && leftPtr < rightPtr) {
				leftPtr++;
			}
			while(arr[rightPtr] == 1 && leftPtr < rightPtr) {
				rightPtr--;
			}
			
			//If we reach here, we need to check if the leftPtr is still smaller than the
			//rightPtr. If that's true, it means we have a 1 at the leftPtr position and 0 at
			//rightPtr position. Simply swap them and increase the leftPtr and decrement the rightPtr
			if(leftPtr < rightPtr) {
				//swap
				arr[leftPtr] = 0;
				arr[rightPtr] = 1;
				leftPtr++;
				rightPtr--;
			}
		}
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		int[] arr = {1,0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
		separateZerosAndOnesInPlace(arr);
	}

}
