package string_questions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Time Complexity = O(nlogn), where 'n' are the number of characters in a string. We build a map and max heap
 * both in O(n) time each, but we are removing and inserting elements back into the maxHeap in the 'while'
 * loop, hence O(nlogn)
 * 
 * Space Complexity = O(n), HashMap & result string.
 */

/*
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each 
 * other are not the same.
 * If possible, output any possible result.  If not possible, return the empty string.
 * 
 * Example 1:
 * Input: S = "aab"
 * Output: "aba"
 * 
 * Example 2:
 * Input: S = "aaab"
 * Output: ""
 */

public class ReorganizeString {

    public static String reorganizeString(String S) {
        //edge case
        if(S == null || S.length() == 0)
            return "";
        
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        for(int i = 0; i < S.length(); i++)
            frequencyMap.put(S.charAt(i), frequencyMap.getOrDefault(S.charAt(i), 0) + 1);
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((ch1, ch2) -> {
           return frequencyMap.get(ch2) - frequencyMap.get(ch1);
        });
        
        //populate the maxHeap on basis of HashMap
        for(Map.Entry<Character, Integer> entry : frequencyMap.entrySet())
            maxHeap.add(entry.getKey());
        
        //Greedy Approach
        //Place all the most occuring character and next to it the second most.
        //Keep updating the max heap.
        //finally check when if the last character in the heap has a count > 1.
        //if yes, return empty string
        //else return the stringbuilder's string version
        
        StringBuilder sb = new StringBuilder();
        
        while(maxHeap.size() > 1){
            char mostOccurringChar = maxHeap.poll();
            char secondMostOccurringChar = maxHeap.poll();
            
            int mostOccurringCount = frequencyMap.get(mostOccurringChar);
            int secondMostOccurringCount = frequencyMap.get(secondMostOccurringChar);
            
            sb.append(mostOccurringChar);
            sb.append(secondMostOccurringChar);
            
            //update the map
            frequencyMap.put(mostOccurringChar, mostOccurringCount - 1);
            frequencyMap.put(secondMostOccurringChar, secondMostOccurringCount - 1);
            
            //update heap
            if(frequencyMap.get(mostOccurringChar) > 0)
                maxHeap.add(mostOccurringChar);
            
            if(frequencyMap.get(secondMostOccurringChar) > 0)
                maxHeap.add(secondMostOccurringChar);
        }
        
        //check the last element of the heap
        if(!maxHeap.isEmpty()){
            char lastChar = maxHeap.poll();
            
            if(frequencyMap.get(lastChar) > 1)
                return "";
            
            sb.append(lastChar); //lastChar had only 1 count as our heap only allows characters with
            //a count of 1 and more.
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String S = "aabc";
		
		System.out.println(reorganizeString(S));
	}

}
