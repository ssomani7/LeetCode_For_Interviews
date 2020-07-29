package linkedList_questions;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
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

public class CopyListWithRandomPointerNoExtraSpace {

	public Node copyRandomList(Node head) {
        //edge case
        if(head == null)
            return head;
        
        Node originalHead = head;
        
        //Step 1: Make copyNode and insert the copyNode between originalNode and its next originalNode.
        //In this step Head will be always placed on original nodes.
        while(head != null){
            Node nextOriginalNode = head.next;
            Node copyNode = new Node(head.val);
            head.next = copyNode;
            copyNode.next = nextOriginalNode;
            head = nextOriginalNode;
        }
        
        //Step 2: Make wiring of random references of copyNodes. In this step Head will be always placed on
        //original nodes.
        head = originalHead;
        while(head != null){
            //if the head's random is pointing to null, we don't need to do anything. It is there by deafult
            if(head.random != null){
                //Whatever node is pointed by the original node's random, we assign the next of that node
                //to our copyNode's random. This is because the node pointed by the original node's random
                //further points to its copyNode. And we need to wire copyNode's random.
                
                //So head.next gives us the copyNode whose random needs to be wired. Head is at our original
                //node. Now if you look at the node pointed by the head.random, you will observe that it is
                //also an original node.
                
                //But we want to wire copyNode with copyNode. So if you look carefully the original node we
                //obtained after head.random, is pointing to is copied version via next. And this is what we
                //want.
                //So head.random.next ==> gives us the target copyNode to be wired.
                //And we need to wire it with head.next.random.
                //Hence the code will be head.next.random = head.random.next;
                head.next.random = head.random.next;
                
                //Simplified version 
                //Node copyNode = head.next;
                //copyNode.random = head.random.next;
            }
            head = head.next.next; //Since we want to move on original Nodes only.
        }
        
        //Step 3: Separate original list with the copied list and return copied head
        head = originalHead;
        Node copyNodeHead = head.next;
        Node copyNodePtr = copyNodeHead;
        
        while(copyNodePtr.next != null){
            head.next = head.next.next;
            head = head.next;
            
            copyNodePtr.next = copyNodePtr.next.next;
            copyNodePtr = copyNodePtr.next;
        }
        head.next = copyNodePtr.next; //Important step. Because copyNode's list last node is connected to
        //null. Whereas the last node of the original list is connected to the last node of copyNode list.
        //To fully separate these two lists we need to connect the original list's last node to null.
        //Hence we do head.next = head.next.next which is similar to head.next = copyNodePtr.next
        
        return copyNodeHead;
    }
}
