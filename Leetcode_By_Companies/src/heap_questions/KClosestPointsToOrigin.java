package heap_questions;

/*
 * Time Complexity = O(NlogK)
 * Space Complexity = O(K), our maxHeap contains only 'K' int [] for the output
 */

/*
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0). (Here, the distance
 * between two points on a plane is the Euclidean distance.)
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that 
 * it is in.)
 * 
 * Example 1:
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation: 
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * 
 * Example 2:
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 */

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((arr1, arr2) -> {
           return (arr2[0] * arr2[0] +  arr2[1] * arr2[1]) - (arr1[0] * arr1[0] +  arr1[1] * arr1[1]);
        });
        
        for(int[] point : points){
            maxHeap.add(point);
            
            if(maxHeap.size() > K)
                maxHeap.poll();
        }
                
        int[][] output = new int[K][2];
        
        while(K-- > 0){
            output[K] = maxHeap.poll();
        }
        
        return output;
    }
	
	public static void main(String[] args) {
		int[][] points = {
				{3,3},
				{5,-1},
				{-2,4}
		};
		int K = 2;
		
		int[][] result = kClosest(points, K);
		
		for(int[] itr : result)
			System.out.println("[" + itr[0] + ", " + itr[1] + "]");
	}

}
