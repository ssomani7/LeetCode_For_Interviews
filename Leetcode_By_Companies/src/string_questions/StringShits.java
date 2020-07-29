package string_questions;

/*
 * Time Complexity = O(N + L), 'N' length of the String 's' for the reverse process. String reversal is O(n), so
 * even if we do it multiple times here, it is still O(N). O(L) is the the length of 'shift' matrix we had to 
 * traverse.
 * 
 * Space Complexity = O(N), new string is returned. 
 */

/*
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = 
 * [direction, amount]: 
 * direction can be 0 (for left shift) or 1 (for right shift). 
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 * 
 * Example 1:
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation: 
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 * 
 * Example 2:
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:  
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 * 
 * Constraints:
 * 1 <= s.length <= 100
 * s only contains lower case English letters.
 * 1 <= shift.length <= 100
 * shift[i].length == 2
 * 0 <= shift[i][0] <= 1
 * 0 <= shift[i][1] <= 100
 */

public class StringShits {

	public static String stringShift(String s, int[][] shift) {
        //edge case
        if(s == null || s.length() == 0)
            return "";
        
        //shift[i][0] = direction
        //shift[i][i] = amount
        
        int leftRotation = 0;
        int rightRotation = 0;
        
        //each inner array is of length 2.
        for(int row = 0; row < shift.length; row++){
            if(shift[row][0] == 0)
                leftRotation += shift[row][1];
            else
                rightRotation += shift[row][1];
        }
                
        if(leftRotation == rightRotation)
            return s;
        else if(leftRotation > rightRotation){
        	return rotateLeft(s, leftRotation - rightRotation);
        }else {
        	return rotateRight(s, rightRotation - leftRotation);
        }
    }
    
    public static String rotateLeft(String str, int leftRotation){
        char[] strArr = str.toCharArray();
        leftRotation %= strArr.length;
        
        //0 to k-1
        reverseCharArray(strArr, 0, leftRotation - 1);
        //k to end
        reverseCharArray(strArr, leftRotation, strArr.length - 1);
        //full reverse
        reverseCharArray(strArr, 0, strArr.length - 1);
        
        return new String(strArr);
    }
    
    public static String rotateRight(String str, int rightRotation){
        char[] strArr = str.toCharArray();
        rightRotation %= strArr.length;
        
        //full reverse
        reverseCharArray(strArr, 0, strArr.length - 1);
        //0 to k-1
        reverseCharArray(strArr, 0, rightRotation - 1);
        //k to end
        reverseCharArray(strArr, rightRotation, strArr.length - 1);
      
        return new String(strArr);
    }
    
    public static void reverseCharArray(char[] strArr, int left, int right){
        while(left < right){
            char temp = strArr[left];
            strArr[left] = strArr[right];
            strArr[right] = temp;
            left++;
            right--;
        }
    }
	
	public static void main(String[] args) {
		String s = "abc";
		int[][] shift = {
				{0,1},
				{1,2}
		};
		
		System.out.println("Rotated String = " + stringShift(s, shift));
	}

}
