/*
   Two Sum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

package Companies.Amazon;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
/*
 * Approach 3: One-pass Hash Table It turns out we can do it in one-pass. While
 * we iterate and inserting elements into the table, we also look back to check
 * if current element's complement already exists in the table. If it exists, we
 * have found a solution and return immediately.
 * 
 * 
 * public int[] twoSum(int[] nums, int target) { Map<Integer, Integer> map = new
 * HashMap<>(); for (int i = 0; i < nums.length; i++) { int complement = target
 * - nums[i]; if (map.containsKey(complement)) { return new int[] {
 * map.get(complement), i }; } map.put(nums[i], i); } throw new
 * IllegalArgumentException("No two sum solution"); } Complexity Analysis:
 * 
 * Time complexity : O(n)O(n). We traverse the list containing nn elements only
 * once. Each look up in the table costs only O(1)O(1) time.
 * 
 * Space complexity : O(n)O(n). The extra space required depends on the number
 * of items stored in the hash table, which stores at most nn elements.
 */