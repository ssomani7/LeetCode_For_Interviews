package trick_questions;

import java.util.Random;

/*
 * Let N be the length of the input list.
 * 
 * Time Complexity:
 * For the constructor function, the time complexity would be O(N), which is due to the construction of the 
 * prefix sums.
 * For the pickIndex() function, this time its time complexity would be O(logN), since we did a binary search 
 * on the prefix sums.
 * 
 * Space Complexity:
 * For the constructor function, the space complexity remains O(N), which is again due to the construction of 
 * the prefix sums.
 * For the pickIndex() function, its space complexity would be O(1), since it uses constant memory. Note, here
 * we consider the prefix sums that it operates on, as the input of the function.
 */

/*
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function 
 * pickIndex which randomly picks an index in proportion to its weight.
 * For example, given an input list of values [1, 9], when we pick up a number out of it, the chance is that 
 * 9 times out of 10 we should pick the number 9 as the answer.
 * 
 * Example 1:
 * Input: 
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 * 
 * Example 2:
 * Input: 
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 * 
 * Explanation of Input Syntax:
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has one 
 * argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there 
 * aren't any.
 * 
 * Constraints:
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 */

/**
 * Your RandomPickWithWeight object will be instantiated and called as such:
 * RandomPickWithWeight obj = new RandomPickWithWeight(w);
 * int param_1 = obj.pickIndex();
 */

public class RandomPickWithWeight {

	 	Random rand;
	    int[] bucket;
	    
	    public RandomPickWithWeight(int[] w) {
	        this.rand = new Random();
	        
	        this.bucket = new int[w.length];
	        
	        //Bucket array will define the range in which the random number generated should be found
	        //The bucket array will have single values which will define the rightmost side of range
	        //with the leftmost number denoted by it previous value.
	        //for index 0, the previous number will be zero '0'. So the range will be 0 to w[0].
	        //now for the next element at index 1 the leftmost side will be bucket[0] + w[1].
	        
	        int leftBoundary = 0;
	        
	        for(int i = 0; i < w.length; i++){
	            this.bucket[i] = leftBoundary + w[i];
	            leftBoundary = this.bucket[i];
	        }
	        
	        //For the random number to be searched and determine if it lies in which bucket, we will only
	        //use the rightmost side of the range, i.e, the value in the bucket array.
	        //if the random number generated is less than the righmost side of range, we choose that bucket
	        //by returning its index. Here the index corresponds to same position in 'w' array & in
	        //'bucket' array.
	    }
	    
	    public int pickIndex() {
	        int randomNumber = rand.nextInt(bucket[bucket.length - 1]) + 1; //very important step
	        // '+1' is extremely crucial because in our range we exclude the leftSide number in it and only
	        //account for the rightSide number.
	        //Ex: our first range will be from 0 to w[0], but we don't want to take into consideration '0'
	        //the 'rand.nextInt' generates a number between 0 (inclusive) and the cumulative sum (exclusive) 
	        //which can be obtained from the last element in the bucket array.
	        //The catch here is that we need the cumulative sum and need to exclude zero. Hence we do '+ 1'
	        //So when the minimum number is produced, i.e, '0' the '+ 1' will neglect it and the maximum number
	        //that is produced which is 'cumulative sum - 1', the '+ 1' will include the cumulative sum.
	        
	        //since the bucket array is a cumulative sum, it is in sorted order. So do a binary search
	        int start = 0;
	        int end = bucket.length - 1;
	        
	        while(start < end){
	            int mid = start + (end - start) / 2;
	            
	            if(bucket[mid] == randomNumber)
	                return mid;
	            else if (bucket[mid] < randomNumber)
	                start = mid + 1;
	            else
	                end = mid;
	        }
	        return start;
	    }
}
