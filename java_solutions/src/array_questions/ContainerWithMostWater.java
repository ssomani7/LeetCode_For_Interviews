package array_questions;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */

/*
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n 
 * vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
 * which together with x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water 
 * (blue section) the container can contain is 49.
 * 
 * Example:
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        //edge case
        if(height.length <= 1 || height == null)
            return 0;
        
        int area = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        
        while(leftIndex < rightIndex){
            int leftMax = height[leftIndex];
            int rightMax = height[rightIndex];
            
            int difference = Math.min(leftMax, rightMax);
            
            area = Math.max(area, difference * (rightIndex - leftIndex));
            
            if(leftMax > rightMax)
                rightIndex--;
            else
                leftIndex++;
        }
        
        return area;
    }
	
	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		
		System.out.println("Max Area = " + maxArea(height));
	}

}
