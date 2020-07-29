package heap_questions;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * Time Complexity = O(nlog(k)), where n is the total number of elements and k is the number of Lists.
 * It takes O(log(k)) to insert an element to the heap and it takes O(log(k)) to delete the minimum element.
 * Space Complexity = O(k), at maximum our PriorityQueue (minHeap) will contain 1 element (smallest 
 * in the list) from each respective list and NOT the entire elements of any individual list. 
 * so 1 element each from 'k' lists makes the elements in our Priority Queue to be O(k).  
 */

/*
 * Note = PriorityQueue is an Abstract Data Type (ADT). It is a tree based data structures
 * PriorityQueue can only compare similar elements. Ex int to int, string to string.
 * PriorityQueue are frequently used to implement minHeap in Java.
 * Insertion and deletion in PriorityQueue is O(log(k)), 'k' being the height of the tree.
 * Peeking is O(1).
 */

/*
 * In MinHeap = Tree goes from Minimum element to maximum element.
 * Heaps whether be MinHeap or MaxHeap, must be Trees. And Trees don't contain cycles.
 * Binary Heap Construction = O(n)
 *  
 */

class ListContainer implements Comparable<ListContainer>{
	List<Integer> individualList;
	int indexOfIndividualList;
	
	//constructor to intialize the list
	public ListContainer(List<Integer> individualList, int indexOfIndividualList) {
		this.individualList = individualList;
		this.indexOfIndividualList = indexOfIndividualList;
	}
	
	@Override
	public int compareTo(ListContainer anotherObject) {
		return this.individualList.get(this.indexOfIndividualList) -
				anotherObject.individualList.get(anotherObject.indexOfIndividualList);
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.individualList.get(this.indexOfIndividualList));
	}
}

public class MergeKSortedArrayLists {

	public static List<Integer> mergeKSortedArrayLists(List<List<Integer>> inputList){
		List<Integer> resultList = new ArrayList<>();
		
		//Using PriorityQueue as a minHeap. Node will be the ListContainer class object.
		//So we will access individual lists through this object.
		PriorityQueue<ListContainer> minHeap = new PriorityQueue<>();
		
		//add the starting element of each list into the minHeap
		for(int i = 0; i < inputList.size(); i++) {
			minHeap.add(new ListContainer(inputList.get(i), 0));
		}
		
		//now the minHeap contains the smallest element from each list. We have added the entire
		//list as an object. We will traverse through each of them by using the indexOfIndividualList.
		
		while(!minHeap.isEmpty()) {
			//retrieve the root of minHeap which is the smallest element present.
			ListContainer lc = minHeap.poll();
			//After removing the root element, the heap reorders itself to form the minHeap.
			
			//now extract the value from the list through the index and add it to the resultList.
			//we are having the class object, inside that there is the list and we will use the
			//indexOfIndividualList to walk over that particular list.
			int lowestValueToBeInsertedIntoResultList = lc.individualList.get(lc.indexOfIndividualList);
			resultList.add(lowestValueToBeInsertedIntoResultList);
			
			//now increment the pointer in the current list we have removed from the root and add the
			//next element to the minHeap. And continue the process.
			if(lc.indexOfIndividualList < lc.individualList.size() - 1) {
				minHeap.add(new ListContainer(lc.individualList, lc.indexOfIndividualList + 1));
				//need to add next index in the current list, hence did "+1"
			}
		}
		
		return resultList;
	}
	
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(13);
		l1.add(15);
		l1.add(17);
		
		List<Integer> l2 = new ArrayList<>();
		l2.add(2);
		l2.add(4);
		
		List<Integer> l3 = new ArrayList<>();
		l3.add(3);
		l3.add(6);
		l3.add(20);
		
		List<List<Integer>> inputList = new ArrayList<>();
		inputList.add(l1);
		inputList.add(l2);
		inputList.add(l3);
		
		List<Integer> resultList = mergeKSortedArrayLists(inputList);
		
		for(Integer itr : resultList)
			System.out.print(itr + " ");
	}

}
