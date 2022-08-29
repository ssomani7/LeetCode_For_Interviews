package graph_questions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Let E represent the number of flights and V represent the number of cities. 
 * Time Complexity = O(K * (E + V) * log(V * K)).
 * since K is at most V that log(VK) becomes log(V^2) which is 2 * log(V). Since 2 is a constant we can 
 * consider the time complexity as O(V^3 * logV) worst case. A more precise time complexity is as you said 
 * O(K * (E + V) * log(V * K)).
 * 
 * Space Complexity = O(V), for the Graph. Worst Case Priority Queue goes upto O(KE), so that could be an
 * additional space complexity constraint.
 */

/*
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
 * Now given all the cities and flights, together with starting city src and the destination dst, your task is
 * to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 * 
 * Example 1:
 * Input: 
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation: 
 * The graph looks like this:
 *            0
 *           / \
 *       100/   \500
 *         -     -
 *         1-----|2
 *           100
 *           
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 * 
 * Example 2:
 * Input: 
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation: 
 * The graph looks like this:
 *            0
 *           / \
 *       100/   \500
 *         -     -
 *         1-----|2
 *           100
 *           
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 * 
 * Constraints:
 * The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
 * The size of flights will be in range [0, n * (n - 1) / 2].
 * The format of each flight will be (src, dst, price).
 * The price of each flight will be in the range [1, 10000].
 * k is in the range of [0, n - 1].
 * There will not be any duplicated flights or self cycles.
 */

class Pair {
    int destinationCity;
    int cost;
    
    Pair(int destinationCity, int cost){
        this.destinationCity = destinationCity;
        this.cost = cost;
    }
}

class City {
    int destinationCity;
    int distanceFromSrc;
    int costFromSrc;
    
    City(int destinationCity, int distanceFromSrc, int costFromSrc){
        this.destinationCity = destinationCity;
        this.distanceFromSrc = distanceFromSrc;
        this.costFromSrc = costFromSrc;
    }
}

public class CheapestFlightsWithinKStops {

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //edge case
        if(n <= 0 || flights.length == 0 || flights == null || K < 0)
            return -1;
        
        //Build the graph
        List<List<Pair>> graph = new ArrayList<>();
        buildGraph(graph, n, flights);
        
        //Now we build the Min Heap using Dijkstra's algorithm. The heap will comprise of the City object.
        //As soon as we find the destination city, we return the cost of that object which was at the top.
        //Since we are building the min heap, it is possible that our answer may lie at the bottom of the
        //heap if the 'K' is less than the distance of the object at the top of the heap.
        //So in this case we just continue with popping the heap top
        PriorityQueue<City> minHeap = new PriorityQueue<>((city1, city2) -> {
           return city1.costFromSrc - city2.costFromSrc; 
        });
        minHeap.offer(new City(src, 0 , 0)); //initial starting point for Dijkstra's algorithm
        
        while(!minHeap.isEmpty()){
            City topHeapCityObject = minHeap.poll();
            
            if(topHeapCityObject.destinationCity == dst)
                return topHeapCityObject.costFromSrc;
            
            if(topHeapCityObject.distanceFromSrc > K) //when our K is lying at the lower part of heap
                continue;
            
            //This means we didn't reach our destination city yet. So use the current city object which we
            //have from the top of the heap as a source for the graph, and get the next possible destination
            //from there and add it to the heap.
            List<Pair> neighbors = graph.get(topHeapCityObject.destinationCity);
            
            for(Pair neighbor : neighbors){
                minHeap.offer(new City(neighbor.destinationCity, topHeapCityObject.distanceFromSrc + 1, 
                                      topHeapCityObject.costFromSrc + neighbor.cost));
                //topHeapCityObject.distanceFromSrc + 1 is to indicate the number of jumps we made. Helps
                //us to determine the upto 'K' constraint.
            }
        }
        
        return -1; //default case
    }
    
    public static void buildGraph(List<List<Pair>> graph, int n, int[][] flights){
        //the index of the outer list will act as the source and the list of pairs on that index will act
        //as the destinations that can be directly reached from that source.
        //So lets first initialize the outer list with all the different sources possible. We initialize
        //them with an empty inner list of pair. This we will populate in the next iteration because, we
        //first need to have all the possible source to do so.
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        //Now lets fill up all the possible destinations for the given source.
        //flight structure looks like [src, dest, cost]
        for(int[] flight : flights){
            //flight[0] gives us the source. This source is the index on our outer list of graph. We need to
            //add destinations & their cost as a pair to this index.
            //The inner list comprises of structure Pair which is destination city and its cost from source
            graph.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
    }
	
	public static void main(String[] args) {
		int n = 3;
		int[][] flights = {
				{0, 1, 100},
				{1, 2, 100},
				{0, 2, 500}
		};
		int src = 0;
		int dst = 2;
		int K = 1;
//		int K = 0;
		
		System.out.println("Cheapest Flight = " + findCheapestPrice(n, flights, src, dst, K));
	}

}
