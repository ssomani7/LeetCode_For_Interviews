package leetcode_easy_questions;

/*
 * Time Complexity = O(M + N)
 * Space Complexity = O(Max (M, N)) + 1
 * 
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * 
 * Note:
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * */

public class AddStrings {

	 public static String addStrings(String num1, String num2) {
	        int carry = 0;
	        
	        int index1 = num1.length() - 1;
	        int index2 = num2.length() - 1;
	        
	        StringBuilder sb = new StringBuilder();
	        
	        while(index1 >= 0 && index2 >= 0){
	            int sum = num1.charAt(index1) - '0' + num2.charAt(index2) - '0';
	            String temp = Integer.toString((sum + carry) % 10);
	            sb.append(temp);
	            
	            carry = (sum + carry) / 10;
	            index1--;
	            index2--;
	        }
	        
	        while(index1 >= 0){
	            int sum = num1.charAt(index1) - '0';      
	            String temp = Integer.toString((sum + carry) % 10);
	            sb.append(temp);
	            carry = (sum + carry) / 10;
	            index1--;
	        }
	            
	        while(index2 >= 0){
	            int sum = num2.charAt(index2) - '0';
	            String temp = Integer.toString((sum + carry) % 10);
	            sb.append(temp);
	            carry = (sum + carry) / 10;
	            index2--;
	        }
	       
	        if(carry == 1)
	            sb.append(Integer.toString(carry));
	        
	        //reverse string
	        sb = sb.reverse();
	        String str = sb.toString();
	        
	        return str;
	    }
	
	public static void main(String[] args) {
		String num1 = "9";
		String num2 = "999";
		
		System.out.println("String after addition = " + addStrings(num1, num2));
	}

}
