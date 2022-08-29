package array_questions;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Time Complexity = O(NlogN)
 * Space Complexity = O(N)
 */

/*
 * Input a = [21,5,6,56,88,52], output = [5,5,5,4,-1,-1] . Output array values is made up of indices of the 
 * element with value greater than the current element but with largest index. So 21 < 56 (index 3), 21 < 88 
 * (index 4) but also 21 < 52 (index 5) so we choose index 5 (value 52). Same applies for 5,6 and for 56 its 
 * 88 (index 4). If there is no greater element then use -1 and last element of the array will always have 
 * value of -1 in output array since there is no other elment after it. Follow up to consider the input as a 
 * stream, how can we only update smaller element (use specific Data structure), running time and space 
 * complexity discussion.
 */

public class NextGreaterIndexValue {

	public static int[] nextLargerElement(int[] nums) {
		int[] result = new int[nums.length];
		Arrays.fill(result, -1); //important step
		
		//make a max heap consiting of nums value and its index. It should be arranged by the grater value.
		//If values are tied then the one with the larger index should go on top.
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>((arr1, arr2) -> {
			return arr2[0] == arr1[0] ? arr2[1] - arr1[1] : arr2[0] - arr1[0];
		});
		
		for(int i = 0; i < nums.length; i++) {
			maxHeap.offer(new int[] {nums[i], i});
		}
		
		int maxIndex = -1;
		
		while(!maxHeap.isEmpty()) {
			int[] currArr = maxHeap.poll();
			int currIndex = currArr[1];
			
			//the top element of the heap has the maximum value in the array. So its index will be -1.
			//We need to initialize our maxIndex to this array's index as the starting point.
			//Since the result array should hold -1 for the largest value in nums, which we have done already
			//in the beginning with the Arrays.fill, we don't need to do anything else.
			if(maxIndex == -1) {
				maxIndex = currIndex;
			} else {
				//Initially maxIndex shows the position of the greatest element in the nums array.
				//But the problem statement say to look for the next greatest element. As our heap is made in
				//Decreasing order, if we see the next greater element on the right hand side of the maxIndex
				//we need to update the maxIndex to that value.
				if(currIndex > maxIndex)
					maxIndex = currIndex;
				else 
					result[currIndex] = maxIndex; //we replace the smaller element position in result array with maxIndex
			}
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {21,5,6,56,88,52};
		int[] result = nextLargerElement(nums);
		
		for(int i : result)
			System.out.print(i + ", ");
	}

}
