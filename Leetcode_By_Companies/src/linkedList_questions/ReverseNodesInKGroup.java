package linkedList_questions;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */

/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes 
 * is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */

public class ReverseNodesInKGroup {

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
	    public ListNode reverseKGroup(ListNode head, int k) {
	        //edge case
	        if(head == null)
	            return null;
	        
	        //Single node linked list
	        if(head.next == null || k < 1)
	            return head;
	        
	        //Calculate the length of the ListNode
	        ListNode itr = head;
	        int sizeOfListNode = 0;
	        
	        while(itr != null){
	            sizeOfListNode++;
	            itr = itr.next;
	        }
	        
	        //Reversal process is a bit different from normal linked list reversal.
	        //We will swap two nodes in each inner 'for' loop iteration, update the 'head' & connect the
	        //end of the reversed linked list to the normal next element of original listnode.
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        
	        for(ListNode previous = dummy, tail = head; sizeOfListNode >= k; sizeOfListNode -= k){
	            for(int i = 1; i < k; i++){
	                ListNode temp = tail.next.next;
	                tail.next.next = previous.next;
	                previous.next = tail.next; //new head for this iteration
	                tail.next = temp;
	            }
	            
	            previous = tail;
	            tail = tail.next;
	        }
	        return dummy.next;
	    }
}
