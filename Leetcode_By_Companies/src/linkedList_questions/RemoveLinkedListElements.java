package linkedList_questions;

/*
 * Time Complexity = O(N), N being the linkedlist size
 * Space Complexity = O(1)
 */

/*
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example:
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */

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

public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
        //edge case
        if(head == null)
            return null;
        
        if(head.next == null && head.val == val)
            return null;
        
        ListNode dummy = new ListNode(-1);
        ListNode previous = dummy;
        ListNode current = head;
        
        //set our dummy.next to the first non deleting value, as it wil be our return pointer
        while(current != null && current.val == val)
            current = current.next;
        
        if(current != null) {
            dummy.next = current;
            previous = current;
            current = current.next;
        } else //there can be a linkedlist of all the elements with value of deletion
            return null;
        
        while(current != null){
            ListNode temp = current.next;
            
            if(current.val == val){
                previous.next = temp;
            } else {
                previous = previous.next;
            }
            
            current = temp;
        }
        
        return dummy.next;
    }
}
