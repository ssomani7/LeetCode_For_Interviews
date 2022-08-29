package doubly_linkedlist_questions;

/*
 * Time Complexity = O(N)
 * Space Complexity = O(1)
 */

/*
 * You are given a doubly linked list which in addition to the next and previous pointers, it could have a 
 * child pointer, which may or may not point to a separate doubly linked list. These child lists may have one
 * or more children of their own, and so on, to produce a multilevel data structure, as shown in the example 
 * below.
 * 
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head
 * of the first level of the list.
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 * 
 * Explanation: 
 * The multilevel linked list in the input is as follows: See LeetCode Problem 430
 * After flattening the multilevel linked list it becomes: See LeetCode Problem 430
 * 
 * Example 2:
 * Input: head = [1,2,null,3]
 * Output: [1,3,2]
 * 
 * Explanation:
 * The input multilevel linked list is as follows:
 * 
 * 1---2---NULL
 * |
 * 3---NULL
 * 
 * Example 3:
 * Input: head = []
 * Output: []
 * 
 * How multilevel linked list is represented in test case:
 * We use the multilevel linked list from Example 1 above:
 * 
 * 1---2---3---4---5---6--NULL
 *         |
 *         7---8---9---10--NULL
 *             |
 *             11--12--NULL
 *             
 * The serialization of each level is as follows:
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * 
 * To serialize all levels together we will add nulls in each level to signify no node connects to the upper 
 * node of the previous level. The serialization becomes:
 * 
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * 
 * Merging the serialization of each level and removing trailing nulls we obtain:
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 
 * Constraints:
 * Number of Nodes will not exceed 1000.
 * 1 <= Node.val <= 10^5
 */


//Definition for a Node.

class Node {
	 public int val;
	 public Node prev;
	 public Node next;
	 public Node child;
}

public class FlattenMultilevelDoublyLinkedList {

    public Node flatten(Node head) {
        if(head == null)
            return null;
        
        Node ptr = head;
        
        while(ptr != null){
            if(ptr.child == null){
                ptr = ptr.next;
                continue;
            }
            
            //secure the link to child from current ptr
            Node temp = ptr.child;
            
            //go to the end of this child chain
            while(temp.next != null)
                temp = temp.next;
            
            //now connect the end to the next node of the current ptr
            temp.next = ptr.next;
            
            //check if the next node of the current ptr is not null. If so, connect its previous to the
            //end of the child node which is pointed by temp
            if(ptr.next != null)
                ptr.next.prev = temp;
            
            //now point the current pointer's next to its child
            ptr.next = ptr.child;
            //link back the child to. its parent by the previous pointer of child
            ptr.child.prev = ptr;
            //remove the child link, thus flattening the doubly linked list
            ptr.child = null;
        }
        
        return head;
    }
}
