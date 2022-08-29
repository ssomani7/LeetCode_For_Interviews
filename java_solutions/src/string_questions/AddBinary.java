package string_questions;

/*
 * Time Complexity = O(M + N), M & N are the lengths of String "a", and "b"
 * Space Complexity = O(L), where L is the larger length among M & N
 */

/*
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * Example 1: Input: a = "11", b = "1"
 * Output: "100"
 * 
 * Example 2: Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 * Constraints: Each string consists only of '0' or '1' characters.
 * 1 <= a.length, b.length <= 10^4
 * Each string is either "0" or doesn't contain any leading zero.
 */

public class AddBinary {

	public static String addBinary(String a, String b) {		
        int carry = 0;
        
        //addition from right to left
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        
        StringBuilder sb = new StringBuilder();
        
        while(aIndex >= 0 || bIndex >= 0){
            int sum = 0; //in binary, 1 + 1 = 10, so carry 1. 1+1+1 = 11 in binary,  so carry = 1
            
            if(aIndex >= 0){
                char ch = a.charAt(aIndex);
                sum += ch - '0';
                aIndex--;
            }
            
            if(bIndex >= 0){
                char ch = b.charAt(bIndex);
                sum += ch - '0';
                bIndex--;
            }
            
            sum += carry;
                
            if(sum == 3){
                sb.append(1);
                carry = 1;
            } else if(sum == 2){
                sb.append(0);
                carry = 1;
            } else { //sum will be zero or one
                sb.append(sum);
                carry = 0;
            }
        }
        
        if(carry == 1)
            sb.append(1);
               
        //reverse the string        
        char[] resultArr = sb.toString().toCharArray();
        int left = 0;
        int right = resultArr.length - 1;
        
        while(left < right){
            char temp = resultArr[left];
            resultArr[left] = resultArr[right];
            resultArr[right] = temp;
            left++;
            right--;
        }
        
        String result = new String(resultArr);
        
        return result;
    }  
	
	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		
		System.out.println(addBinary(a, b));
	}

}
