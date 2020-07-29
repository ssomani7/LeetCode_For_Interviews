package heap_questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/* Using MinHeap
 * Time Complexity: O(Nlogk), where NN is the length of words. We count the frequency of each word in O(N) 
 * time, then we add N words to the heap, each in O(logk) time. Finally, we pop from the heap up to kk times.
 * As k ≤ N, this is O(Nlogk) in total.
 * 
 * Space Complexity: O(N), the space used to store our count.
 */

/*
 * Using MaxHeap:
 * Time Complexity will be O(NlogN), as we need to insert all the keys into our heap and then get the top
 * 'k' elements. So prefer Min Heap implementation.
 */

/*
 * Given a non-empty list of words, return the k most frequent elements. Your answer should be sorted by 
 * frequency from highest to lowest. If two words have the same frequency, then the word with the lower 
 * alphabetical order comes first.
 * 
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * 
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence
 * being 4, 3, 2 and 1 respectively.
 * 
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 */

public class TopKFrequentWords {

	public static List<String> topKFrequent(String[] words, int k) {
		List<String> frequentList = new ArrayList<>();
		
		//edge case
		if(words == null || words.length == 0)
			return frequentList;
		
		//Using MinHeap and HashMap
		Map<String, Integer> frequencyMap = new HashMap<>();
		
		//HashMap populated
		for(String word : words)
			frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
		
		PriorityQueue<String> minHeap = new PriorityQueue<>((word1, word2) -> {
			if(frequencyMap.get(word1) == frequencyMap.get(word2))
				return word2.compareTo(word1);
			else
				return frequencyMap.get(word1) - frequencyMap.get(word2);
		});

		for(Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
			minHeap.add(entry.getKey());
			
			if(minHeap.size() > k)
				minHeap.poll();
		}
		
		while(!minHeap.isEmpty())
			frequentList.add(0, minHeap.poll());//Comment here : We should reverse and return right?
		/*
		 * because the words with tied count values are stored in minHeap in the opposite manner. Ex: the word
		 * 'i' and 'love' have frequency of 2 each. Since our minHeap stores the worst candidates at the top
		 * most, for tie breakers we will store our result in reverse order, i.e, "love" will be stored above
		 * "i" in the minHeap. As "i" comparatively is more better candidate than "love" as per the problem
		 * statement. So "i" is stored at the bottom of the min heap.
		 * 
		 * But the result we want is from the minHeap bottom to top. So for achieving this, we will pop the
		 * minHeap top element and push it to the right of the ArrayList. So whatever element that is popped
		 * last from the minHeap will be at the head of the list.
		 * 
		 * Hence we do list.add(0, String), which will simulate the above list insertion order.
		 */
		return frequentList;
	}
	
	public static void main(String[] args) {
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		int k = 2;
		
		List<String> resultList = topKFrequent(words, k);
		
		for(String str : resultList)
			System.out.print(str + " ");
	}

}
