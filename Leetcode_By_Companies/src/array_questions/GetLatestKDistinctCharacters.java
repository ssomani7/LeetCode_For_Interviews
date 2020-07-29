package array_questions;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * Time Complexity = O(M + NlogK). M = total number of elements in the stream. We need to iterate over them to
 * build the hashmap. N = number of elements in the hashmap to be put in the priority queue. Since our min heap
 * will be only 'k' elements long, adding the elements to the minHeap will be of 'logk' complexity
 * 
 * Space Complexity = O(M + k). M = total number of elements in the stream. Since our min heap will have only 
 * 'k' elements in it, additional 'k' space required, which eventually turns to be O(M) amortized way. 
 */

public class GetLatestKDistinctCharacters {

	public static char[] getKLatestDistinctCharacters(char[] streamOfCharacters, int k) {
		//For any number of characters in the stream, the hashmap won't exceed the size of 26 characters
		//So the space is constant.
		Map<Character, Integer> charAndItsLatestOccurenceMap = new HashMap<>();
		int counter = 0;
		
		//If we see a duplicate character in the stream, our hashmap gets updated with its latest occurence
		//position
		for(int i = 0; i < streamOfCharacters.length; i++) {
			counter += 1;
			charAndItsLatestOccurenceMap.put(streamOfCharacters[i], counter);
		}
		
		//Using minHeap for the functionality of max heap, thus making the heap only 'k' characters long
		PriorityQueue<Character> minHeap = new PriorityQueue<>((ch1, ch2) -> { 
			return charAndItsLatestOccurenceMap.get(ch1) - charAndItsLatestOccurenceMap.get(ch2);
		});
		
		//Candidates in the minheap are in the reverse order
		for(Map.Entry<Character, Integer> entry : charAndItsLatestOccurenceMap.entrySet()) {
			minHeap.add(entry.getKey());
			
			if(minHeap.size() > k)
				minHeap.poll();
		}
		
		char[] resultArr = new char[minHeap.size()];
		int index = resultArr.length - 1;
		
		while(!minHeap.isEmpty()) {
			resultArr[index] = minHeap.poll();
			index--;
		}
		
		return resultArr;
	}
	
	public static void main(String[] args) {
		char[] streamOfCharacters = {'a', 'a', 'b', 'b', 'a', 't', 't', 't', 't', 'y', 'p', 'y', 'o'};
		int k = 5;
		char[] resultArr = getKLatestDistinctCharacters(streamOfCharacters, k);
		
		for(char ch : resultArr)
			System.out.print(ch + " ");
	}

}
