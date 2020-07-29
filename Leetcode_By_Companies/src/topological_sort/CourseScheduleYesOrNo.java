package topological_sort;

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
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1. Some courses may 
 * have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a 
 * pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all 
 * courses?
 * 
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. 
 * So it is possible.
 * 
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0, 
 * and to take course 0 you should also have finished course 1. So it is impossible.
 */

import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleYesOrNo {

	//Using BFS
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //BFS approach
        int[][] matrix = new int[numCourses][numCourses];
        int[] incomingEdges = new int[numCourses];
        
        //Fill the matrix in such a way that there is a connection represented between a course and its
        //prerequisite
        for(int i = 0; i < prerequisites.length; i++){
            int course_you_want = prerequisites[i][0];
            int prerequisite_course = prerequisites[i][1];
            
            if(matrix[prerequisite_course][course_you_want] == 0)
                incomingEdges[course_you_want]++;
            
            matrix[prerequisite_course][course_you_want] = 1;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        //add all the courses to the queue which has no dependency
        for(int i = 0; i < incomingEdges.length; i++)
            if(incomingEdges[i] == 0)
                queue.offer(i);
        
        int count = 0;
        
        while(!queue.isEmpty()){
            int course = queue.poll(); //represents the course whose dependencies have been resolved
            count++;
            
            for(int i = 0; i < numCourses; i++){
                //check in the matrix if there is any connection
                if(matrix[course][i] != 0){
                    //reduce one incoming edge count
                    incomingEdges[i]--;
                    //check if all the dependencies for the particular 'ith' course has been resolved
                    if(incomingEdges[i] == 0)
                        queue.offer(i);
                }
            }
        }
        
        return count == numCourses;
	}
	
	
	public static void main(String[] args) {
		int numCourses = 4;
		int[][] prerequisites = {
				{1, 0},
				{2, 0},
				{3, 1},
				{3, 2}
		};
		
		System.out.println(canFinish(numCourses, prerequisites));
	}

}
