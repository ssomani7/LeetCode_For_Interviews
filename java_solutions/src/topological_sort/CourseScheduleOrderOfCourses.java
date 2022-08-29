package topological_sort;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Time Complexity: O(∣E∣+∣V∣) where ∣V∣ is the number of courses, and ∣E∣ is the number of dependencies.
 * 
 * As in the previous algorithm, it would take us |E|∣E∣ time complexity to build a graph in the first step.
 * Similar with the above postorder DFS traversal, we would visit each vertex and each edge once and only once 
 * in the worst case, i.e. |E| + |V|∣E∣+∣V∣.
 * As a result, the overall time complexity of the algorithm would be O(2⋅∣E∣+∣V∣) = O(∣E∣+∣V∣).
 * 
 * Space Complexity: O(∣E∣+∣V∣), with the same denotation as in the above time complexity.
 * We built a graph data structure in the algorithm, which would consume |E| + |V|∣E∣+ ∣V∣ space.
 * In addition, we use a container to keep track of the courses that have no prerequisite, and the size of the 
 * container would be bounded by ∣V∣.
 * As a result, the overall space complexity of the algorithm would be O(∣E∣+2⋅∣V∣) = O(∣E∣+∣V∣).
 */

/*
 * There are a total of n courses you have to take, labeled from 0 to n-1. Some courses may have prerequisites,
 * for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you 
 * should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all
 * courses, return an empty array.
 * 
 * Example 1:
 * Input: 2, [[1,0]] 
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So 
 * the correct course order is [0,1] .
 * 
 * Example 2:
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses
 * 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is 
 * [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 * 
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about 
 * how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */

public class CourseScheduleOrderOfCourses {

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] incomingEdges = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++){
            int course_you_want = prerequisites[i][0];
            int prerequisite_course = prerequisites[i][1];
            
            if(matrix[prerequisite_course][course_you_want] == 0)
                incomingEdges[course_you_want]++;
            
            matrix[prerequisite_course][course_you_want] = 1;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < incomingEdges.length; i++)
            if(incomingEdges[i] == 0)
                queue.offer(i);
        
        int count = 0;
        int[] courseOrder = new int[numCourses];
        int index = 0;
        
        while(!queue.isEmpty()){
            int course = queue.poll();
            count++;
            courseOrder[index] = course;
            index++;
            
            for(int i = 0; i < numCourses; i++){
                if(matrix[course][i] != 0){
                    incomingEdges[i]--;
                    if(incomingEdges[i] == 0)
                        queue.offer(i);
                }
            }
        }
        
        return count == numCourses ? courseOrder : new int[0];
    }
	
	public static void main(String[] args) {
		int numCourses = 4;
		int[][] prerequisites = {
				{1, 0},
				{2, 0},
				{3, 1},
				{3, 2}
		};
		
		int[] result = findOrder(numCourses, prerequisites);
		
		for(int i : result)
			System.out.print(i + " ");
	}

}
