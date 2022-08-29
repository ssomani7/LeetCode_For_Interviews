package heap_questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * Time Complexity = O(Nlogk)
 * Space Complexity = O(keywords) for hashMap + O(k) for heap size.
 */

/* Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of 
 * most to least frequently mentioned.
 * Constraints:
 * The comparison of strings is case-insensitive.
 * Multiple occurances of a keyword in a review should be considred as a single mention.
 * If keywords are mentioned an equal number of times in reviews, sort alphabetically.
 */

/*
 * Example 1:
 * Input: k = 2
 * keywords = ["anacell", "cetracular", "betacellular"]
 * reviews = ["Anacell provides the best services in the city",
 * "betacellular has awesome services",
 * "Best services provided by anacell, everyone should use anacell",
 * ]
 * 
 * Output:
 * ["anacell", "betacellular"]
 * 
 * Explanation:
 * "anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.
 * 
 * Example 2:
 * Input:
 * k = 2
 * keywords = ["anacell", "betacellular", "cetracular", "deltacellular", "eurocell"]
 * reviews = [
 * "I love anacell Best services; Best services provided by anacell",
 * "betacellular has great services",
 * "deltacellular provides much better services than betacellular",
 * "cetracular is worse than anacell",
 * "Betacellular is better than deltacellular.",
 * ]
 * 
 * Output:
 * ["betacellular", "anacell"]
 * 
 * Explanation:
 * "betacellular" is occuring in 3 different reviews. "anacell" and "deltacellular" are occuring in 2 
 * reviews, but "anacell" is lexicographically smaller.
 */

public class TopKFrequentlyMentionedKeywords {
	
	public static List<String> topKFrequentlyMentionedWords(String[] keywords, String[] reviews, int k){
		List<String> result = new ArrayList<>();
		Map<String, Integer> keywordCountMap = new HashMap<>();
		
		for(String review : reviews) {
			review = review.replaceAll("\\W+", " "); //replaces any non alphanumeric character with whitespace
			review = review.toLowerCase(); //making all the words lowercase
			String[] reviewArr = review.split(" ");
			Set<String> wordSet = new HashSet<>();
			
			for(String str : reviewArr) 
				wordSet.add(str); //keyword occurence in a review counted once irrespective of no. of occurences 
			
			for(String keyword : keywords) {
				if(wordSet.contains(keyword)) {
					Integer count = keywordCountMap.getOrDefault(keyword, 0);
					count++;
					keywordCountMap.put(keyword, count);
				}
			}
		}
				
		//worst candidates should be placed at the top of the min heap, to achieve results of max heap.
		PriorityQueue<String> minHeap = new PriorityQueue<>((str1, str2) -> {
			if(keywordCountMap.get(str1) == keywordCountMap.get(str2))
				return str2.compareTo(str1); //when count tied, send lexiographically smaller element down the heap.
			
			return keywordCountMap.get(str1) - keywordCountMap.get(str2); //large count should be down the heap.
		}) ;
		
		//Max Heap being populated
		for(Map.Entry<String, Integer> entry : keywordCountMap.entrySet()) {
			minHeap.add(entry.getKey());
			
			if(minHeap.size() > k)
				minHeap.poll();
		}
			
		//max heap result desired from minheap. Most ideal candidate is at the botton of the minheap.
		//basically in reverse order.
		while(!minHeap.isEmpty())
			result.add(0, minHeap.poll());
			
		return result;
	}
	
	public static void main(String[] args) {
		String[] keywords = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
		
		String[] reviews = {  "I love anacell Best services; Best services provided by anacell",
				  "betacellular has great services",
				  "deltacellular provides much better services than betacellular",
				  "cetracular is worse than anacell",
				  "Betacellular is better than deltacellular."};
		int k = 2;
		
		List<String> result = topKFrequentlyMentionedWords(keywords, reviews, k);
		
		for(String str : result)
			System.out.println(str);
	}
}