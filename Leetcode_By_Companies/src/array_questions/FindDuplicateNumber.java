package array_questions;

//Time Complexity = O(n)
//Space Complexity = O(1)

/*
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that 
 * at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Input: [1,3,4,2,2] 
 * Output: 2
 * 
 * Input: [3,1,3,4,2]
 * Output: 3
 * 
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */

public class FindDuplicateNumber {

	public static int floydHareTortoiseAlgorithm(int[] nums) {
		/*
		 * Algorithm similar to detecting loop in a LinkedList with fast and slow pointers. Since, all the array
		 * elements are indexed in the range, there is a cycle present if we jump through indices using values
		 * with fast and slow pointer.
		 * 
		 * First we will detect if there exists a cycle in the array. Similar to LinkedList's fast ptr which
		 * advances fast.next.next, in our array we will jump two indexes arr[value at[value at index]].
		 * For slow ptr which goes slow.next, in array it will go arr[value at index]
		 */
		//edge case
        if(nums == null || nums.length == 0)
            return -1;
        
        if(nums.length == 1)
            return nums[0];
        
        //using Floyd's Hare and Tortoise algorithm.
        //tortoise goes nums[value at index]
        int tortoise = nums[0];
        //hare goes twice the speed of tortoise. two index jumps.
        //nums[value at [value at index]]
        int hare = nums[nums[0]];
        
        //first detect if there is cycle and where do hare and tortoise meet.
        while(tortoise != hare){
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }
        
        //now make hare 'zero' and advance each of animals one at a time. Keep tortoise where we proved
        //cycle exists.
        //their meeting point is duplicate entry and the entrance point to the cycle.
        hare = 0;
        
        while(hare != tortoise){
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        
        return tortoise;
	}
	
	
	public static void main(String[] args) {
//		int[] nums = {1,3,4,2,2};
		int[] nums = {3,1,3,4,2};
		
		int result = floydHareTortoiseAlgorithm(nums);
		System.out.println("Duplicate Number via Floyd's Hare and Tortoise = " + result);
		
	}

}
