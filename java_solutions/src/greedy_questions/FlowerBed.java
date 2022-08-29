package greedy_questions;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */

/*
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers
 * cannot be planted in adjacent plots - they would compete for water and both would die.
 * 
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), 
 * and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 * 
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * 
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * 
 * Note:
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 */

public class FlowerBed {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        //Greedy Solution
        int count = 0;
        
        for(int i = 0; i < flowerbed.length && count < n; i++){
            //only check for empty places, which are zero
            if(flowerbed[i] == 0){
                //get the next location value
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                //get the previous value
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                
                //only place flower if adjacents are zero
                if(next == 0 && prev == 0){
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        
        return count == n;
    }
	
	public static void main(String[] args) {
		int[] flowerbed = {1,0,0,0,1};
		int n = 2;
		
		System.out.println(canPlaceFlowers(flowerbed, n));
	}

}
