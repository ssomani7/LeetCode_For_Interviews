package leetcode_easy_questions;

import java.util.PriorityQueue;

/*
 * Time Complexity = O(N log N). Converting an array into a Heap takes O(N) time (it isn't actually sorting; it's
 * putting them into an order that allows us to get the maximums, each in O(log N ) time).
 * 
 * Like before, the main loop iterates up to N - 1 times. This time however, it's doing up to three O(logN) 
 * operation each time; two removes, and an optional add. Like always, the three is an ignored constant. This 
 * means that we're doing N ⋅ O(logN) = O(N log N) operations.
 * 
 * Space Complexity = O(N) to create the PriorityQueue.
 */

/*
 * We have a collection of stones, each stone has a positive integer weight. Each turn, we choose the two heaviest
 * stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash
 * is:
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 * 
 * Example 1:
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation: 
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 */

public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        //edge case
        if(stones == null || stones.length == 0)
            return 0;
        
        if(stones.length == 1)
            return stones[0];
        
        //Using Max Heap. See the lambda return value for Max Heap implementation via PriorityQueue. By default
        //PriorityQueue is minHeap in Java.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((stone1, stone2) -> stone2 - stone1);
         
        for(int stone : stones)
            maxHeap.add(stone);
        
        while(maxHeap.size() > 1){            
            int heavy = maxHeap.poll();
            int secondHeavy = maxHeap.poll();
            
            if(heavy != secondHeavy)
                maxHeap.add(heavy - secondHeavy);
        }
        
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
    
	public static void main(String[] args) {
		int[] stones = {2,7,4,1,8,1};
		
		System.out.println("Weight of Last Stone = " + lastStoneWeight(stones));
	}

}
