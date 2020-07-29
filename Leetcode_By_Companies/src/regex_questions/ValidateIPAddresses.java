package regex_questions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Time complexity: O(1) because the patterns to match have constant length.
 * Space complexity: O(1). 
 */

/*
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers,
 * each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 * 
 * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. 
 * The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 
 * is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case 
 * characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 
 * address(Omit leading zeros and using upper cases).
 * 
 * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive
 * colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 * 
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 
 * 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 * 
 * Note: You may assume there is no extra space or special characters in the input string.
 * 
 * Example 1:
 * Input: "172.16.254.1"
 * Output: "IPv4"
 * Explanation: This is a valid IPv4 address, return "IPv4".
 * 
 * Example 2:
 * Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * Output: "IPv6"
 * Explanation: This is a valid IPv6 address, return "IPv6".
 * 
 * Example 3:
 * Input: "256.256.256.256"
 * Output: "Neither"
 * Explanation: This is neither a IPv4 address nor a IPv6 address.
 */

public class ValidateIPAddresses {

    public static String validIPAddressRegex(String IP) {
        //IPV4 has 3 dots, so the pattern can be generalizd for the 3 cells left of dot. For the last cell
    	//we need to have the pattern in the standalone mode. Similarly for the IPv6
        //0-9, 10-99, 100-199, 200-249, 250-255.
    	//While writing Regex, don't give any spaces in middle.
        String ipv4Pattern = "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$";
        
        Pattern patternObjForIPV4 = Pattern.compile(ipv4Pattern);
        Matcher m = patternObjForIPV4.matcher(IP);
        
        if(m.matches())
            return "IPv4";
        
        String ipv6Pattern = "((([0-9a-fA-F]){1,4})\\:){7}(([0-9a-fA-F]){1,4})$";
        
        Pattern patternObjForIPV6 = Pattern.compile(ipv6Pattern);
        m = patternObjForIPV6.matcher(IP);
        
        if(m.matches())
            return "IPv6";
        
        return "Neither";
    }
	
    //String Method
    //Time Complexity = O(n)
    public static String validIPAddress(String IP) {
        String[] ipv4 = IP.split("\\.",-1);
        String[] ipv6 = IP.split("\\:",-1);
        
        if(IP.chars().filter(ch -> ch == '.').count() == 3){
            for(String s : ipv4) 
            	if(isIPv4(s)) 
            		continue;
            	else 
            		return "Neither"; 
            return "IPv4";
        }
        
        if(IP.chars().filter(ch -> ch == ':').count() == 7){
            for(String s : ipv6) 
            	if(isIPv6(s)) 
            		continue;
            	else 
            		return "Neither";
            return "IPv6";
        }
        
        return "Neither";
    }
    
    public static boolean isIPv4 (String s){
         try{ 
        	 return String.valueOf(Integer.valueOf(s)).equals(s) && Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 255;
        	 }
         catch (NumberFormatException e){
        	 return false;
        	 }
    }
    
    public static boolean isIPv6 (String s){
        if (s.length() > 4) 
        	return false;
        try {
        	return Integer.parseInt(s, 16) >= 0  && s.charAt(0) != '-';
        	}
        catch (NumberFormatException e){
        	return false;
        	}
    }
    
	public static void main(String[] args) {
		String IP = "172.16.254.1";
		
		System.out.println(validIPAddressRegex(IP));
	}
	
	/*
	 * Regex Notes:
	 * 1) [a-c] = Single character from a to c (inclusive).
	 * 2) [ab] = Single block of 'ab'. In that order.
	 * 3) [a-c]* = Single character from a to c (inclusive) occuring 'any' number of times.
	 * 4) [ab]+ = Single block of 'ab'. In that order occuring 'any' number of times.
	 * 5) [0-9] = 1 digit from range 0 to 9.
	 * 6) [0-9]* = 1 digit from range 0 to 9 occuring 'any' number of times.
	 * 7) [10]+ = '10' occuring any number of times, in that order.
	 * 8) [0-9a-b] = Single character can be either from 0 to 9 or a to b (inclusive)
	 * 9) [0-9a-b]* = Single character can be either from 0 to 9 or a to b (inclusive) occuring 'any' number of times.
	 * 10) [2a]+ = block '2a' occuring any number of times.
	 * 11) [1-9][0-9] = 2 digit number. 1st digit from 1 to 9. 2nd digit from 0 to 9.
	 * 12) 2[0-4][0-9] = 3 digit number. 200 to 249.
	 * 13) 25[0-5] = 3 digit number. 250 to 255.
	 * 
	 * Repeating Expressions:
	 * 1) [0-9]{2} = 2 digit number. Each digit from 0 to 9.
	 * 2) [1-9][0-9]{2} = 4 digit number in block of 2. 1st digit of that block from 1 to 9. 2nd digit of that
	 *                    block from 0 to 9.
	 * 3) 2[0-4][0-9]{2} = 6 digit number in block of 3. 1st digit is 2. 2nd digit is from 0 to 4. 3rd digit
	 *                     is from 0 to 9.
	 * 
	 * Repeating in Range:
	 * 1) [1-9][0-9]{2-4} = Can form 4 digit or 6 digit or 8 digit number in the blocks of 2. 1st digit of that
	 *                      block is from 1 to 9 and 2nd digit is from 0 to 9.
	 * 2) [0-9a-fA-F]{2-4} = Can form 2 digit, 3 digit and 4 digit with a block of 1 character which can be
	 *                       from 0 to 9 or a to f or A to F.
	 *                       
	 * Escape Sequences:
	 * for special character, use double backslash before them. Ex: 1) \\. 2) \\:
	 */

}
