package heap_questions;

import java.util.PriorityQueue;

/*
 * Time Complexity = O(nlogn), O(n) for building the heap and heap calls are log(n)
 * Space Complexity = O(n), for the result array.
 */

/*
 * You have an array of logs.  Each log is a space delimited string of words.
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at 
 * least one word after its identifier.
 * 
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered 
 * lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be 
 * put in their original order.
 * 
 * Return the final order of the logs.
 * Example 1:
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * 
 * Constraints:
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */

public class ReorderDataInLogFiles {

	public static String[] reorderLogFiles(String[] logs) {
        //edge case
        if(logs.length == 0 || logs == null)
            return logs;
        
        String[] result = new String[logs.length];
        
        //Min Heap for lowercase letters
        PriorityQueue<String> minHeap = new PriorityQueue<>((str1, str2) -> {
            //Important split condition here
        	//split(" ", 2) splits the String into 2 parts. "dig1 8 1 5 1" becomes "dig1" & "8151"
        	String[] temp1 = str1.split(" ", 2); 
            String[] temp2 = str2.split(" ", 2);
                       
            if(temp1[1].equals(temp2[1])) //We have a Tie
                return temp1[0].compareTo(temp2[0]); //Break Tie with identifier
            
            return temp1[1].compareTo(temp2[1]); 
        });
        
        //build up min heap
        for(String log : logs){
            String[] temp = log.split(" ");
            
            //Numbers ASCII 48 to 57
            if(temp[1].charAt(0) >= 48 && temp[1].charAt(0) <= 57)
                continue;
            else
                minHeap.add(log);
        }
        
        int index = 0;
        
        while(!minHeap.isEmpty()){
            result[index] = minHeap.poll();
            index++;
        }
        
        //All logs are letter cased
        if(index == result.length)
            return result;
        
        for(String log : logs){
            String[] temp = log.split(" ");
            
            //Numbers ASCII 48 to 57
            if(temp[1].charAt(0) >= 48 && temp[1].charAt(0) <= 57){
                result[index] = log;
                index++;
            } 
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
		
		String[] result = reorderLogFiles(logs);
		
		for(String log : result)
			System.out.print(log + ", ");
	}

}
