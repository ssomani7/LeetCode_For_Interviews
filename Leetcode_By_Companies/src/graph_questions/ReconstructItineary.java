package graph_questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/*
 * Time Complexity = O(ElogE) where E is number of edges. Because we offer each edge into queue once and then
 * poll it out once.
 * Space Complexity = O(E)
 */

/*
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], 
 * reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the 
 * itinerary must begin with JFK.
 * 
 * Note:
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical 
 * order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order 
 * than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * One must use all the tickets once and only once.
 * 
 * Example 1:
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 
 * Example 2:
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in 
 * lexical order.
 */

public class ReconstructItineary {

	public static List<String> findItinerary(List<List<String>> tickets) {
        List<String> resultList = new ArrayList<>();
        
        //edge case
        if(tickets.size() == 0 || tickets == null)
            return resultList;
                
        Map<String, PriorityQueue<String>> srcToDestMap = new HashMap<>();
        
        //populate the hashmap
        for(List<String> ticket : tickets){
            String src = ticket.get(0);
            String dest = ticket.get(1);
            
            PriorityQueue<String> minHeap = srcToDestMap.getOrDefault(src, 
                                                                      new PriorityQueue<String>((str1, str2) -> {
                                                                         return str1.compareTo(str2); 
                                                                      }));
            minHeap.add(dest);
            srcToDestMap.put(src, minHeap);
        }
                
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        
        while(!stack.isEmpty()){
            PriorityQueue<String> valueList = srcToDestMap.get(stack.peek());
            
            if(valueList == null){ //There is no entry in the hashmap of src to destination.
                resultList.add(0, stack.pop());
            } else if(!valueList.isEmpty()){ //check if there are any possible destinations left.
                //get the top most string from min heap and push it to the stack.
                stack.push(valueList.poll());
            } else { //we have exhausted all possible destinations
                //remove the element from stack top and it to the list in a reverse manner.
                resultList.add(0, stack.pop());
            }
        }
        
        return resultList;
    }
	
	public static void main(String[] args) {
		List<List<String>> tickets = new ArrayList<>();
		
		List<String> ticket1 = new ArrayList<>();
		ticket1.add("JFK");
		ticket1.add("KUL");
		
		List<String> ticket2 = new ArrayList<>();
		ticket2.add("JFK");
		ticket2.add("NRT");
		
		List<String> ticket3 = new ArrayList<>();
		ticket3.add("NRT");
		ticket3.add("JFK");
		
		tickets.add(ticket1);
		tickets.add(ticket2);
		tickets.add(ticket3);
		
		List<String> resultList = findItinerary(tickets);
		for(String str : resultList)
			System.out.print(str + " -> ");
	}

}
