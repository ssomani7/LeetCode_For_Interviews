package two_pointers;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */

/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how 
 * much water it is able to trap after raining.
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain 
 * water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * 
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */

public class TrappingRainWater {

	public static int trap(int[] height) {
        //edge case
        if(height.length == 0 || height == null)
            return 0;
        
        int left = 0;
        int right = height.length - 1;
        int totalArea = 0;
        int leftMax = height[left];
        int rightMax = height[right];
        
        while(left < right){
            if(height[left] < height[right]){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                totalArea += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                totalArea += rightMax - height[right];
            }
        }
            
        return totalArea;
	}
	
	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		System.out.println("Trapped Rain Water = " + trap(height));
	}

}
