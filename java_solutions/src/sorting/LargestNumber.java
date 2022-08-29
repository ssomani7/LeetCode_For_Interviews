package sorting;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Time Complexity = O(nklogn)
 * Let's assume: 
 * the length of input array is n,
 * average length of Strings in String Array is k,
 * Then, compare 2 strings will take O(k).
 * Sorting will take O(nlgn)
 * Appending to StringBuilder takes O(n).
 * 
 * Updates: according to how merge sort time complexity is calculated from this post
 * We still need lg(n) times of operations, but the comparison at the leaf node takes O(k) instead of O(1)
 * Thus, the total will be O(n*k*lgn) + O(n) = O(nklgn).
 * 
 * Space Complexity = O(n)
 */

/*
 * Intuition = We need custom sorting here, not the usual one.
 * Example = ["3","30","34","9"],   Output = "934303"
 * We are doing Merge Sort for better performance. Lets see under the hood how the n^2 sorting will look like.
 * 
 * 2 pointers, 'i' and 'j'. 'i' is outer for loop, 'j' is inner, starts from 'i + 1'
 * ["3","30","34","9"]
 *   i   j
 *  ij = "330" & ji = "303". Here 'ji' is smaller than 'ij', so we move 'j' forward without any swapping
 *  ["3","30","34","9"]
 *    i         j
 *  ij = "334" & ji = "343". Here 'ji' is greater than 'ij', so we swap string at j & string at i & move j ahead.
 *  After swapping String array looks like:
 *  ["34","30","3","9"]
 *    i             j
 *  ij = "349" & ji = "934". Again 'ji' > 'ij', swap and move j ahead.
 *  After swapping String Array looks like:
 *  ["9","30","3","34"]
 *    i                 j
 *   
 *  Now we increment 'i' and repeat the process again
 *  ["9","30","3","34"]
 *         i   j
 *         
 *  Finally we will have an array like
 *  ["9","34","30","3"]
 *  
 *  This is our result. Just for better performance we use Merge Sort instead of n^2 sort as shown above.
 *  
 *  We only need to swap when 'ji' is 'ij', so this is what we will return into our comparator
 */

public class LargestNumber {

	public static String largestNumber(int[] nums) {
        //edge case
        if(nums.length == 0 || nums == null)
            return "";
        
        String[] strArr = new String[nums.length];
        
        //transferring elements
        for(int i = 0; i < nums.length; i++){
            String str = Integer.toString(nums[i]);
            strArr[i] = str;
        }
        
        Comparator<String> myComparator = new Comparator<String>() {
        	@Override
        	public int compare(String str1, String str2) {
        		String s1 = str1 + str2;
        		String s2 = str2 + str1;
        		return s2.compareTo(s1); //swapping when 'ji' > 'ij'
        	}
		};
		
		//Merge Sort
		Arrays.sort(strArr, myComparator);
		
		// An extreme edge case by lc, say you have only a bunch of 0 in your int array
		if(strArr[0].charAt(0) == '0')
			return "0";
		
		StringBuilder sb = new StringBuilder();
		for(String s: strArr)
	        sb.append(s);
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		int[] nums = {3,30,34,5,9};
		
		System.out.println("Largest Number = " + largestNumber(nums));
	}

}
