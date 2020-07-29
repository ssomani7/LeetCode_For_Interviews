package linkedList_questions;

/*
 * Time Complexity = O(M + N)
 * Space Complexity = O(1)
 */

/*
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * Example 1:
 * 4 -> 1  
 *       \____
 *            \
 *             7 -> 4 -> 5 -> null
 *            /
 * 5 -> 0 -> 1 
 * 
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists 
 * intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. 
 * There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.           
 *            
 */

/* Example 2:
 * 2 -> 6 -> 4 -> null
 * 1 -> 5 -> null
 * 
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the
 * two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 */

/*
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //edge case
        if(headA == null || headB == null)
            return null;
        
        //keep two pointers on LinkedList's heads. Keep them running until both the node's are same
        //not by value but by reference.
        //If they are not same, one of the lists will reach null. In this case you exchange the heads
        //and run again.
        //If there is any intersection, the while loop will break and you can return either node ptr.
        //If there isn't any intersection, both the node ptr will reach null at the same time and they
        //will come out of the while loop and return null.
        
        ListNode a = headA;
        ListNode b = headB;
        
        while(a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        
        return a;
    }
}
