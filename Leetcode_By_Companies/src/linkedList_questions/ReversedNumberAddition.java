package linkedList_questions;

/*
 * Time complexity : O(max(m,n)). Assume that m and n represents the length of l1 and l2 respectively, the 
 * algorithm above iterates at most max(m,n) times.
 * 
 * Space complexity : O(max(m,n)). The length of the new list is at most max(m,n)+1.
 */

/*
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in 
 * reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked 
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
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

public class ReversedNumberAddition {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //edge case
        if(l1 == null && l2 == null)
            return null;
        
        if(l1 == null)
            return l2;
        
        if(l2 == null)
            return l1;
        
        ListNode head = new ListNode(0);
        ListNode carryNode = head;
        ListNode preCarryNode = head;
        int startPreCarryNode = 0;
       
        while(l1 != null || l2 != null){
            int sum = 0;
            
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
                            
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
                            
            sum += carryNode.val;
            carryNode.val = sum % 10;
            
            ListNode nextNode = new ListNode(sum / 10);
            carryNode.next = nextNode;
            carryNode = nextNode;
            
            if(startPreCarryNode > 0)
                preCarryNode = preCarryNode.next;
            
            startPreCarryNode++;      
        }
        
        if(carryNode.val == 0) //important step.
            preCarryNode.next = null;
        
        return head;
    }
}
