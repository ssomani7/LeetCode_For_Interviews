package Companies.Amazon.LinkedList_Questions;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */

/*
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * Example 1:
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * 
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * 
 * Example 2:
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * 
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */


//  Definition for singly-linked list.
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { 
    	 this.val = val; 
     }
     ListNode(int val, ListNode next) { 
    	 this.val = val; 
    	 this.next = next; 
     }
 }
 

public class RotateListToRight {

	public ListNode rotateRight(ListNode head, int k) {
        //edge case
        if(head == null)
            return null;
        
        //calculate length of linkedlist
        ListNode itrNode = head;
        int lengthOfListNode = 0;
        
        while(itrNode != null){
            lengthOfListNode++;
            itrNode = itrNode.next;
        }
                
        k = k % lengthOfListNode;
                
        if(k == 0)
            return head;
        
        //Using the delete n'th node from end logic
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        for(int i = 0; i <= k; i++){
            fast = fast.next;
        }
        
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        //now slow is pointing to node before newHead;
        ListNode newHead = slow.next;
        
        //get the last node
        fast = head;
        while(fast.next != null)
            fast = fast.next;
        
        //connect it to head given
        fast.next = head;
        
        //make the slow.next point to null
        slow.next = null;
        
        return newHead;
    }
}
