package linkedList_questions;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */

/*
 * Same as Reverse K Nodes in 'K' groups. In this case, k = 2, fix, you have to declare it.
 * Rest all the code is same.
 */

/*
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * 
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */

public class SwapNodesInPairs {

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	    public ListNode swapPairs(ListNode head) {
	        int k = 2; //since swapping is in pairs
	        
	        //edge case
	        if(head == null)
	            return null;
	        
	        if(head.next == null)
	            return head;
	        
	        //Calculate size of listnode
	        int sizeOfListNode = 0;
	        ListNode itr = head;
	        
	        while(itr != null){
	            sizeOfListNode++;
	            itr = itr.next;
	        }
	        
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        
	        
	        for(ListNode previous = dummy, tail = head; sizeOfListNode >= k; sizeOfListNode -= k){
	            for(int i = 1; i < k; i++){
	                ListNode tempNode = tail.next.next;
	                tail.next.next = previous.next;
	                previous.next = tail.next;
	                tail.next = tempNode;
	            }
	            
	            previous = tail;
	            tail = tail.next;
	        }
	        
	        return dummy.next; //first time when the node is swapped, dummy.next points to the new head.
	        //Thereafter, previous keeps changing, NOT dummy.next.
	    }
	
}
