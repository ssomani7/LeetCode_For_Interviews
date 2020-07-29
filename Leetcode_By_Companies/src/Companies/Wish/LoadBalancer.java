package Companies.Wish;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/*
 * Question Description:
 * 
 * A developer created a web application that solves a very difficult mathematical equation. As the 
 * computational load of the incoming requests to the application server may be very heavy, it was decided to 
 * scale the application using multiple servers to that multiple requests can be handled simultaneously. No 
 * two requests come at the exact same time, and they are assigned to the next server that is not busy. 
 * Servers are allocated to requests in round robin fashion starting from the first server. If a server is 
 * busy, it is skipped. If no server is free, then the request is dropped, i.e, not handled at all. The 
 * servers have infinite computational capacity, so each server can serve any incoming request.
 * 
 * At the end of the day, the developer takes down the busiest server that day for maintenance. Determine 
 * which server did the most computational work during the day. If there is a tie for the most work, return 
 * the list of servers sorted in ascending order of server id.
 * 
 * Example:
 * There are k = 3 servers and n = 5 incoming requests. The arrival times, arrivals = [1, 2, 3, 4, 5], and 
 * the load for each request, the duration that the server will be occupied with the request, are load = 
 * [6, 3, 4, 4, 4]
 * 
 * Request  Arrival  Load  Finish  Server
 * 1          1        6      6       1
 * 2          2        3      4       2
 * 3          3        4      6       3
 * 4          4        4      7       2
 * 5          5        4      8       dropped
 * 
 * All of the servers start out available. The first 3 requests are handled by the 3 servers in order. When 
 * request 4 comes in, server 1 is busy, but server 2 is available and serves the request. request 5 cannot 
 * be served so it is dropped. Server 1 handles a load of 6, and server 2 handles a load of 3 + 4 = 7. Server 
 * 2 was the busiest server.
 * 
 * Function Description:
 * Complete the the function loadBalancing. The function must return an array of integers that denotes the id
 * numbers of the servers that did the most work in ascending order.
 * 
 * loadBalancing has the following parameter(s):
 * k = an integer, the number of web servers
 * arrival = an array of integers, the arrival times of each request.
 * load = an array of n integers, the load of each request, i.e, the time to serve each request.
 * 
 * Constraints:
 * • 1 <= n <= 10 ^ 5
 * • 1 <= k <= 10 ^ 5
 * • 1 <= arrival[i] <= 10 ^ 9
 * • 1 <= load[i] <= 10 ^ 9
 * 
 * Example 2:
 * k = 3
 * Request   Arrival  Load  Finish  Server
 * 1           1       15     15       1
 * 2           2       10     11       2
 * 3           12      10     21       2
 * 4           5       10     14       3
 * 5           6       10     15      dropped
 * 6           30      15     44       3
 * 7           32      10     41       1
 * 
 * The requests are handled in order of time received, not request id in this case, requests are received in 
 * the id order 1, 2, 4, 5, 3, 6, 7
 * 
 * Server Requests Load
 * 1 2 15 + 10 = 25
 * 2 2 10 + 10 = 20
 * 3 2 10 + 15 = 25
 * 
 * Server 1 & 3 are the busiest. Return [1, 3]
 */

public class LoadBalancer {
	
	public static List<Integer> loadBalancing(int k, List<Integer> arrival, List<Integer> load){
		//Store the arrival and its corresponding load in a pair in an ascending order.
		PriorityQueue<int[]> arrivalAndLoadMinHeap = new PriorityQueue<>((arr1, arr2) -> {
			return arr1[0] - arr2[0]; //sorting ascending on basis of arrival
		}) ;
		
		//Populate the arrivalAndLoad heap. Arrival and Load size are the same
		for(int i = 0; i < arrival.size(); i++) {
			int[] arr = new int[2];
			arr[0] = arrival.get(i);
			arr[1] = load.get(i);
			
			arrivalAndLoadMinHeap.add(arr);
		}
				
		//Most Important formula: finish = arrival + load - 1
		
		//This heap will help with the round robin effect needed.
		PriorityQueue<int[]> finishTimeAndServerMinHeap = new PriorityQueue<>((arr1, arr2) -> {
			return arr1[0] - arr2[0]; //sorted based on earliest finish time.
		});
		
		//first allocate the 'k' servers
		for(int i = 0; i < k; i++) {
			int[] arr = arrivalAndLoadMinHeap.poll();
			int server = i + 1; //just for better understanding, could have directly used 'i + 1' as well
			int finishTime = arr[0] + arr[1] - 1; //arrival + load - 1
			int loadTime = arr[1];//for better understanding
			
			//This heap will hold the [lastest finish time, server, load handled by the server]
			finishTimeAndServerMinHeap.add(new int[] {finishTime, server, loadTime});
		}
		
		//Server availability will be maintained in such a fashion that which ever server gets free first
		//will be allocated to the incoming arrival. Server availability will be of size 'k' provided.
		//Server availability is an array of = [finish time, server].
		//Comparison made with the arrival time.
		
		while(!arrivalAndLoadMinHeap.isEmpty()) {
			int[] arr = arrivalAndLoadMinHeap.poll();
			int arrivalTime = arr[0]; //just for better understanding, could have directly used 'arr[0]' on the
			//polled array object from the arrivalAndLoadMinHeap.
			int loadTime = arr[1]; //for better understanding
			
			if(arrivalTime < finishTimeAndServerMinHeap.peek()[0])
				continue; //arrival time dropped
			else {
				int[] earliestAvailability = finishTimeAndServerMinHeap.poll();
				int updatedFinishTime = arrivalTime + loadTime - 1;
				//replace the old finish time with the new one
				earliestAvailability[0] = updatedFinishTime;
				//update the load handled by the server
				earliestAvailability[2] += loadTime;
				//put the modified array object into finishTimeAndServerMinHeap
				finishTimeAndServerMinHeap.add(earliestAvailability);
			}
		}
		
		//find out the heaviest server from the finishTimeAndServerMinHeap.
		//Using Hashmap because we cannot loop over the Min Heap in a guaranteed order.
		//key = load, value = list of servers
		Map<Integer, List<Integer>> hmap = new HashMap<>();
		
		while(!finishTimeAndServerMinHeap.isEmpty()) {
			int[] arr = finishTimeAndServerMinHeap.poll();
			
			List<Integer> valueList = hmap.getOrDefault(arr[2], new ArrayList<>());
			valueList.add(arr[1]);
			hmap.put(arr[2], valueList);
		}
		
		//Now get the max out of the hashmap.
		int maxLoad = 0;
		
		for(Map.Entry<Integer, List<Integer>> entry : hmap.entrySet())
			maxLoad = Math.max(maxLoad, entry.getKey());
		
		List<Integer> resultList = hmap.get(maxLoad);
		Collections.sort(resultList);
		return resultList;
	}
	
	public static void main(String[] args) {
		//test case - 1
		int k = 3;
		Integer[] arrivalArr = {1, 2, 12, 5, 6, 30, 32};
		Integer[] loadArr = {15, 10, 10, 10, 10, 15, 10};
				
		//test case - 2
//		int k = 3;
//		Integer[] arrivalArr = {1, 2, 3, 4, 5};
//		Integer[] loadArr = {6, 3, 4, 4, 4};
		
		//test case - 3
//		int k = 3;
//		Integer[] arrivalArr = {1, 10, 100};
//		Integer[] loadArr = {5, 5, 5};
		
		List<Integer> arrival = Arrays.asList(arrivalArr);
		List<Integer> load = Arrays.asList(loadArr);
		
		List<Integer> resultList = loadBalancing(k, arrival, load);
		
		for(Integer i : resultList)
			System.out.println(i);
	}

}
