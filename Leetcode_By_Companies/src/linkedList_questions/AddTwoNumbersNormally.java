package linkedList_questions;

/*
 * Time Complexity = O(M + N), M & N are the length of LinkedLists
 * Space Complexity = O(Max (M, N)), which ever LinkedList is the largest, its length will be the new result
 * List or + 1. 
 */

/*
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit
 * comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked 
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * 
 * Example:
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */

import java.util.Stack;

public class AddTwoNumbersNormally {
	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        //edge case
		 	if(l1 == null && l2 == null)
	            return null;
		 
	        if(l1 == null)
	            return l2;
	        if(l2 == null)
	            return l1;
	        
	        Stack<Integer> stack1 = new Stack<>();
	        Stack<Integer> stack2 = new Stack<>();
	        
	        while(l1 != null){
	            stack1.push(l1.val);
	            l1 = l1.next;
	        }
	        
	        while(l2 != null){
	            stack2.push(l2.val);
	            l2 = l2.next;
	        }
	        
	        ListNode carryNode = new ListNode(0);
	        //trick: backward node pointing by new node and move towards left from right
	        
	        while(!stack1.isEmpty() || !stack2.isEmpty()){
	            int sum = 0;
	            
	            if(!stack1.isEmpty())
	                sum += stack1.pop();
	            if(!stack2.isEmpty())
	                sum += stack2.pop();
	            
	            sum += carryNode.val; //exisitng carry value
	            
	            carryNode.val = sum % 10; //last digit only.
	            
	            //create new node
	            ListNode nextNode = new ListNode(sum / 10); //sum's left most digit. Can be 0 or 1
	            //point backwards to old node
	            nextNode.next = carryNode;
	            //bring carryNode forward
	            carryNode = nextNode;
	        }
	        
	        return carryNode.val == 0 ? carryNode.next : carryNode;
	    }
}
