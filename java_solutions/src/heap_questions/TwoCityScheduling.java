package heap_questions;

import java.util.PriorityQueue;

/*
 * Time Complexity : O(nlogn), O(n) to build max heap and log(n) for the insertion in the max heap (bubbling 
 * up and down to balance heap)
 * Space Complexity : O(n), Heap maintained for the entire input.
 */

/*
 * Algorithm
 * Total people we have = 'costs.length', which is 2N. Given that N should reach City A and N should reach 
 * City B and we need to minimize the cost while doing this. Also we should utilize each int[] while doing 
 * this. This is important to understand.
 * 
 * Logic used below:
 * Maintain a Max Heap of 'int[]' on the basis of absolute difference between City A cost and City B cost in 
 * an int[]
 * Now remove the top int[] element of Max Heap. Here you will have 3 possibile scenarios.
 * Scenario 1: You have capacity to place in either City A and City B. So select the minimum cost for that 
 * int[] and decrease the count for that particular city.
 * Scenario 2: You have only capacity in City A, so directly use the cost for City A from int[], i.e, first 
 * element.
 * Scenario 3: You have only capacity in City B, so directly use the cost for City B from int[], i.e, second 
 * element.
 */

/*
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is 
 * costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
 * 
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 * 
 * Example 1:
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation: 
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 * 
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 * 
 * Note:
 * 1 <= costs.length <= 100
 * It is guaranteed that costs.length is even.
 * 1 <= costs[i][0], costs[i][1] <= 1000
 */

public class TwoCityScheduling {

	public static int twoCitySchedCost(int[][] costs) {
        //edge case
        if(costs == null || costs.length == 0)
            return 0;
        
        int totalCost = 0;
         
        //Because each city should reach 'N' person. And we are given '2N' persons. So basically
        //half.
        int left = costs.length / 2; //represents City A
        int right = costs.length / 2; //represents City B
        
        //MaxHeap
        PriorityQueue<int[]> differenceMaxHeap = new PriorityQueue<>((arr1, arr2) -> {
            int diff1 = Math.abs(arr1[0] - arr1[1]);
            int diff2 = Math.abs(arr2[0] - arr2[1]);
            
            return diff2 - diff1;
        });
        
        //Building max heap
        for(int[] cost : costs)
            differenceMaxHeap.add(cost);
        
        while(!differenceMaxHeap.isEmpty()){
            int[] cost = differenceMaxHeap.poll();
            
            //We have option to send to either City A or City B
            if(left > 0 && right > 0){
                //Assumed condition for 'equal' when cost to travel is same for both the cities.
                //I am picking 'left' (City A) in this case. It worked. Just a random instinct.
                if(cost[0] <= cost[1]){ 
                    totalCost += cost[0];
                    left--;
                } else {
                    totalCost += cost[1];
                    right--;
                }
            } else if (left > 0){ //City B is full, so we can only send to City A
                totalCost += cost[0];
                left--;
            } else if (right > 0){ //City A is full, so we can only send to city B
                totalCost += cost[1];
                right--;
            }
        }
        
        return totalCost;
    }
	
	public static void main(String[] args) {
		int[][] costs = {
				{259,770},
				{448,54},
				{926,667},
				{184,139},
				{840,118},
				{577,469}
		};
		
		System.out.println("Minimum Cost = " + twoCitySchedCost(costs));
	}

}
