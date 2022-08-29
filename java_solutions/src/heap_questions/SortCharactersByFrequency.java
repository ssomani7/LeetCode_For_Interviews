package heap_questions;

import java.util.PriorityQueue;

/*
 * Time Complexity = O(n), You are creating an array of all unique characters mapped to their frequency, thats 
 * O(n). Then you put all the unique characters into the heap, sorted by their frequency, that's o(m), which 
 * m = 26, or 128, or 256 depending on what you consider to be the range of the characters. Then you construct 
 * the final string by pulling out the heap top character, each extraction takes logM, so total is MlogM. So 
 * total is O(N) + (M) + MlogM. Since M is a static value, we can consider it to be O(N).
 * 
 * Space Complexity = O(n)
 */

/*
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * Example 1:
 * Input: "tree"
 * Output: "eert"
 * 
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * 
 * Example 2:
 * Input:
 * "cccaaa"
 * Output:
 * "cccaaa"
 * 
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * 
 * Example 3:
 * Input:
 * "Aabb"
 * Output:
 * "bbAa"
 * 
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */

public class SortCharactersByFrequency {

	public static String frequencySort(String s) {
        //edge case
        if(s == null || s.length() == 0)
            return s;
        
        int[] characterFreq = new int[256];
        
        //build frequency array
        for(int i = 0; i < s.length(); i++){
            characterFreq[Integer.valueOf(s.charAt(i))]++;
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((ch1, ch2) -> {
            return characterFreq[Integer.valueOf(ch2)] - characterFreq[Integer.valueOf(ch1)];
        });
        
        //build maxHeap from characterFreq, because all characters need to occur only once in maxHeap
        for(int i = 0; i < characterFreq.length; i++){
            if(characterFreq[i] > 0)
                maxHeap.add((char) i);
        }
            
        StringBuilder sb = new StringBuilder();
        
        while(!maxHeap.isEmpty()){
            char mostFreqChar = maxHeap.poll();
            int count = characterFreq[Integer.valueOf(mostFreqChar)];
            
            while(count > 0){
                sb.append(mostFreqChar);
                count--;
            }
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String s = "AabbbbxC";
		
		System.out.println(frequencySort(s));
	}

}
