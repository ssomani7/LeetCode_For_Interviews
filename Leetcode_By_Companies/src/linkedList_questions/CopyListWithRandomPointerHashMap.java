package linkedList_questions;

import java.util.HashMap;
import java.util.Map;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(n) with the HashMap method. Prefer this in interview first.
 * There is also an O(1) solution, but make sure you memorize the steps and reference rewiring correctly. It's
 * a 3 step process which results in O(3n) which is still O(n).
 */

/*
 * A linked list is given such that each node contains an additional random pointer which could point to any 
 * node in the list or null.
 * Return a deep copy of the list.
 * The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair 
 * of [val, random_index] where:
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it 
 * does not point to any node.
 */


//Definition for a Node.
class Node {
	 int val;
	 Node next;
	 Node random;
	
	 public Node(int val) {
	     this.val = val;
	     this.next = null;
	     this.random = null;
	 }
}

public class CopyListWithRandomPointerHashMap {
    public Node copyRandomList(Node head) {
        //edge case
        if(head == null)
            return head;
        
        Map<Node, Node> originalMirrorMap = new HashMap<>();
        //store head
        Node dummy = new Node(-1);
        dummy.next = head;
        
        //make the hashmap with node and its mirror nodes. The mirror nodes are just lying there in memory
        //in the next iteration will we do wiring of next and random
        while(head != null){
            Node mirrorNode = new Node(head.val);
            originalMirrorMap.put(head, mirrorNode);
            head = head.next;
        }
        
        //restore head
        head = dummy.next;
        
        while(head != null){
            Node mirrorNode = originalMirrorMap.get(head);
            mirrorNode.next = originalMirrorMap.get(head.next);
            mirrorNode.random = originalMirrorMap.get(head.random);
            head = head.next;
        }
        
        return originalMirrorMap.get(dummy.next);
    }
}
