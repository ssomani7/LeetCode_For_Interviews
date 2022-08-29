package array_questions;

/*
 * Time Complexity = O(N)
 * Space Complexity = O(1)
 */

/*
 * Given an array containing positive and negative numbers. The array represents checkpoints from one end 
 * to other end of street. Positive and negative values represent amount of energy at that checkpoint. 
 * Positive numbers increase the energy and negative numbers decrease. Find the minimum initial energy 
 * required to cross the street such that Energy level never becomes 0 or less than 0.
 * 
 * Note : The value of minimum initial energy required will be 1 even if we cross street successfully 
 * without loosing energy to less than and equal to 0 at any checkpoint. The 1 is required for initial 
 * check point.
 * 
 * Examples : Input : arr[] = {4, -10, 4, 4, 4}
 * Output: 7
 * 
 * Suppose initially we have energy = 0, now at 1st checkpoint, we get 4. At 2nd checkpoint, energy gets
 * reduced by -10 so we have 4 + (-10) = -6 but at any checkpoint value of energy can not less than equals 
 * to 0. So initial energy must be at least 7 because having 7 as initial energy value at 1st checkpoint
 * our energy will be = 7+4 = 11 and then we can cross 2nd checkpoint successfully. Now after 2nd checkpoint,
 * all checkpoint have positive value so we can cross street successfully with 7 initial energy.
 * 
 * Input : arr[] = {3, 5, 2, 6, 1}
 * Output: 1
 * We need at least 1 initial energy to reach first checkpoint
 * 
 * Input : arr[] = {-1, -5, -9}
 * Output: 16
 */

public class MinimumInitialEnergyToCrossStreet {

	// Function to calculate minimum initial energy arr[] stores energy at each checkpoints on street 
	public static int minInitialEnergy(int arr[]){ 
	    // initMinEnergy is variable to store minimum initial energy required. 
	    int initMinEnergy = 0; 
	  
	    // currEnergy is variable to store current value of energy at i'th checkpoint on street 
	    int currEnergy = 0; 
	  
	    // flag to check if we have successfully crossed the street without any energy loss <= o at any 
	    // checkpoint 
	    boolean flag = false; 
	  
	    // Traverse each check point lineraly 
	    for (int i = 0; i < arr.length; i++) { 
	    	currEnergy += arr[i]; 
	  
	    // If current energy, becomes negative or 0, increment initial minimum energy by the negative value
	    //plus 1. to keep current energy positive (at least 1). Also update current energy and flag. 
		    if (currEnergy <= 0) { 
		        initMinEnergy += Math.abs(currEnergy) + 1; 
		        currEnergy = 1; 
		        flag = true; 
		    } 
	    } 
	  
	    // If energy never became negative or 0, then return 1. Else return computed initMinEnergy 
	    return (flag == false) ? 1 : initMinEnergy; 
	}
	
	public static void main(String[] args) {
		int[] arr1 = {4, -10, 4, 4, 1};
		System.out.println(minInitialEnergy(arr1));
		
		int[] arr2 = {19, 4, 7};
		System.out.println(minInitialEnergy(arr2));
		
		int[] arr3 = {-1, -5, -9};
		System.out.println(minInitialEnergy(arr3));
	}

}
