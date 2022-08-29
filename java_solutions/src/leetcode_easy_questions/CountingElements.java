package leetcode_easy_questions;

import java.util.HashSet;
import java.util.Set;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(n)
 */

/*
 * Given an integer array arr, count element x such that x + 1 is also in arr. 
 * If there're duplicates in arr, count them seperately.
 * 
 * Example 1:
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 * 
 * Example 2:
 * Input: arr = [1,1,3,3,5,5,7,7]
 * Output: 0
 * Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
 * 
 * Example 3:
 * Input: arr = [1,3,2,3,5,0]
 * Output: 3
 * Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
 * 
 * Example 4:
 * Input: arr = [1,1,2,2]
 * Output: 2
 * Explanation: Two 1s are counted cause 2 is in arr.
 */
public class CountingElements {

    public static int countElements(int[] arr) {
        //edge case
        if(arr.length == 0 || arr == null)
            return 0;
        
        Set<Integer> targetSet = new HashSet<>();
        int counter = 0;
        
        for(int i : arr)
            targetSet.add(i);
        
        for(int i : arr){
            if (targetSet.contains(i + 1)){
                counter++;
            }
        }
        return counter;
    }
    
	public static void main(String[] args) {
		int[] arr = {1,1,2,2,7};
		
		System.out.println("Element Count = " + countElements(arr));
	}

}
