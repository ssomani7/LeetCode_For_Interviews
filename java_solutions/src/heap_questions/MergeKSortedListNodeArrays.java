package heap_questions;

import java.util.PriorityQueue;

//Note = Don't run this code locally. Run it in LeetCode platform without pasting in the ListNode class

/*
 * Time Complexity = O(Nlogk), N = number of nodes in the final linked list. 'log k' for the bubbling up and down
 * of the min heap because of insertions and deletions.
 * 
 * Space Complexity = O(logk), 'k' being the number of arrays of ListNode. At any point we will have only 1 element
 * from each listnode array in the min heap. Since there are 'k' such arrays, max height of min heap will be (logk)
 */

/*
 * Input:
[
  1->4->5,
  1->3->4,
  2->6
]

Output: 1->1->2->3->4->4->5->6
 */
 

class ListNode{
	ListNode next;
	int val;
	
	ListNode(int val){
		this.val = val;
	}
}

public class MergeKSortedListNodeArrays {

	public static ListNode mergeKSortedNodeArrays(ListNode[] lists) {
		//edge case
		if(lists == null || lists.length == 0)
			return null;
		
		/*
		 * Since we will need to access minimum element across all the array nodes, min heap data structure is
		 * useful. 
		 * We will declare a lambda expression in PriorityQueue constructor to handle the min heap build from the
		 * node itself.
		 */
		
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
		
		//Now add all the first elements from each node array into the min heap.
		for(ListNode node : lists)
			if(node != null)
				minHeap.add(node);
		
		//Save the head of the heap at this stage. The root here will be the head of the final linkedlist.
		ListNode head = minHeap.peek();
		
		while(!minHeap.isEmpty()) {
			//get the root node which is the minimum node
			ListNode minimumNode = minHeap.poll();
			
			//Now we need to add the next node from the array which is represented by the minimum node. Add the next
			//node to the min heap. Don't add 'null' values.
			if(minimumNode.next != null)
				minHeap.add(minimumNode.next);
			
			//now link the extracted minimum node to the next minimum node which is at the root of the min heap.
			if(minHeap.peek() != null)
				minimumNode.next = minHeap.peek();
		}
			
		return head;
	}
	
}
