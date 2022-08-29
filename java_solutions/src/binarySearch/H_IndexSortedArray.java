package binarySearch;

/*
 * Time Complexity = O(log n)
 * Space Complexity = O(1)
 */

/*
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a 
 * researcher, write a function to compute the researcher's h-index.
 * 
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have 
 * at least h citations each, and the other N − h papers have no more than h citations each."
 * 
 * Example:
 * Input: citations = [0,1,3,5,6]
 * Output: 3 
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had received 
 *               0, 1, 3, 5, 6 citations respectively. Since the researcher has 3 papers with at least 3 
 *               citations each and the remaining two with no more than 3 citations each, her h-index is 3.
 *               
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */

public class H_IndexSortedArray {

    public static int hIndex(int[] citations) {
        //'h' index is an array value not array index.
        //'h' index needs to be choosen such a way that whatever is the value of our candidate 'h' index
        //that many number of elements which are >= to our candidate 'h' index are on the right hand
        //side of our candidate 'h' index. Because array is in ascending order. And ascending order does
        //not have duplicates. If it has, then it is not an ascending order.
        
        //Now here are 2 cases that are possible.
        //Case 1: the optimal H index is present in our array. 
        //So here there can be multiple such answers.
        //So we need to choose a max among them, that is which satisfies the 'h' index condition and
        //be to the right most side possible in the array.
        //Optimal solution here would be when the value of our candidate 'h' index would be equal to the
        //number of elements to its right. So in array terms that translates to as follows:
        //value of 'h' index = Array Length - index of 'h' index
        
        //Case 2: the optimal H index is not present in our array.
        //In this case we keep doing the binary search. And once our binary search ends, we just return
        //the count of elements to the right of our 'low' pointer.
        //So that is Array Length - lowPtr
        int arrLength = citations.length;
        int low = 0;
        int high = citations.length - 1;
        
        //Returning from binary search is case 1
        while(low <= high){
            int mid = low + (high - low) / 2; //to avoid overflow
            
            if(citations[mid] == (arrLength - mid))
                return citations[mid];
            else if(citations[mid] > (arrLength - mid))
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        //returning from outside binary search is case 2
        return arrLength - low;
    }
	
	public static void main(String[] args) {
		int[] citations = {0,1,2,3,7,8};
		System.out.println("H Index = " + hIndex(citations));
	}

}
