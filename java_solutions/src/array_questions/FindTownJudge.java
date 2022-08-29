package array_questions;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(n)
 */

/*
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly 
 * the town judge.
 * If the town judge exists, then:
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * 
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts 
 * the person labelled b.
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 * 
 * Example 1:
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 * 
 * Example 2:
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * 
 * Example 3:
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * 
 * Example 4:
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 * 
 * Example 5:
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 * 
 * Constraints:
 * 1 <= N <= 1000
 * 0 <= trust.length <= 10^4
 * trust[i].length == 2
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 */

public class FindTownJudge {

	public static int findJudge(int N, int[][] trust) {
        //For a town judge to exist he should be trusted by N - 1 people and he shouldn't trust anyone
        //So lets keep two arrays. One indicates the number of people the person trusts and the other
        //shows the number of people by whom he is being trusted.
        int[] personTrusts = new int[N + 1]; //array index start from 0, so we need N + 1, because there
        //cannot be a person zero.
        int[] personTrustedBy = new int[N + 1];
        
        for(int i = 0; i < trust.length; i++){
            int trusts = trust[i][0];
            int trustedBy = trust[i][1];
            
            personTrusts[trusts]++;
            personTrustedBy[trustedBy]++;
        }
        
        int townJudge = -1;
        
        for(int i = 1; i < N + 1; i++){
            if(personTrusts[i] == 0 && personTrustedBy[i] == N - 1){
                townJudge = i;
                break;
            }
        }
        
        return townJudge;
    }
	
	public static void main(String[] args) {
		int N = 4;
		int[][] trust = {
							{1,3},
							{1,4},
							{2,3},
							{2,4},
							{4,3}
						};
		System.out.println("Town Judge = " + findJudge(N, trust));
	}

}
