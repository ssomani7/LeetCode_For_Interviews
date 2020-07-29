package leetcode_medium_questions;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */

/*
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one 
 * celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does 
 * not know any of them.
 * 
 * Now you want to find out who the celebrity is or verify that there is not one. The only thing you are 
 * allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. 
 * You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in 
 * the asymptotic sense).
 * 
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function 
 * int findCelebrity(n). There will be exactly one celebrity if he/she is in the party. Return the celebrity's 
 * label if there is a celebrity in the party. If there is no celebrity, return -1.
 */

/*
 * Note:
 * The directed graph is represented as an adjacency matrix, which is an n x n matrix where a[i][j] = 1 means 
 * person i knows person j while a[i][j] = 0 means the contrary.
 * Remember that you won't have direct access to the adjacency matrix.
 * 
 * Example 1:
 * Input: graph = [
 *                  [1,1,0], means Zero knows One but doesn't know Two
 *                  [0,1,0], means One doesn't know Zero and Two
 *                  [1,1,1]  means Two knows both Zero and One
 *                ]
 * Output: 1
 * Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j,
 * otherwise graph[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 
 * because both 0 and 2 know him but 1 does not know anybody.
 * 
 * Example 2:
 * Input: graph = [
 *                  [1,0,1], means Zero knows Two but not One
 *                  [1,1,0], means One knows Zero but not Two
 *                  [0,1,1]  means Two know One but not Zero
 *                ]
 * Output: -1
 * Explanation: There is no celebrity. As everyone knows everyone indirectly.
 */

public class FindTheCelebrity {
	
}

//****Below is the Main Working Code****

//public class FindTheCelebrity extends Relation {
//	
//		/* The knows API is defined in the parent class Relation.
//    	boolean knows(int a, int b); */
//		public int findCelebrity(int n) {
//			//Logic: if A knows B, B is a possible celebrity candidate
//			//if A doesn't know B then A is a possible celebrity candidate
//      
//			int celebrityCandidate = 0; //mark the first person as a candidate to start the process
//      
//			for(int person = 1; person < n; person++){
//				if(knows(celebrityCandidate, person)){
//					//means our celebrityCandidate is not celebrity and we need to update our candidate
//					celebrityCandidate = person;
//				}
//			}
//      
//			//Now again check among the whole crowd for celebrity. So we have 3 conditions
//			//Condition 1 = We don't need to check the celebrityCandidate with himself.
//			//Condition 2 = If celebrityCandidate knows somebody else, than there is no celebrity, return -1
//			//Condition 3 = If other people in the party don't know our celebrityCandidate, then there is no
//			//celebrity, return -1.
//      
//			//If we don't return from the above 3 conditions, the candidate we have is a correct person.
//			//So we return him as our celebrity
//			
//			for(int otherPeople = 0; otherPeople < n; otherPeople++)
//				if(celebrityCandidate != otherPeople && knows(celebrityCandidate, otherPeople) || 
//					!knows(otherPeople, celebrityCandidate))
//						return -1;
//      
//			return celebrityCandidate;
//		}
//}