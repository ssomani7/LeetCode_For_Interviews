package linkedList_questions;

//Time Complexity = O(1)
//Space Complexity = O(1)

//Approach:
//Copy the next node value into the current node to be deleted and make current node.next point to next node.next.
//This will make the current node to be marked as deleted.

/*
 * Warning = This solution doesn’t work if the node to be deleted is the last node of the list. Work around is that
 * you mark the last node with some absurd value like Integer.MIN_VALUE, and while traversing if your curr.next.val
 * points to this 'Integer.MIN_VALUE' you do curr.next = curr.next.next, which is pointing to null.
 */
public class DeleteNodeWithoutHeadPointer {

	static Node head; 
	  
    static class Node { 
        int data; 
        Node next; 
  
        Node(int d) { 
            data = d; 
            next = null; 
        } 
    } 
  
    void printList(Node node) { 
        while (node != null) { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
    } 
  
    void deleteNode(Node node) { 
        Node temp = node.next; 
        node.data = temp.data; 
        node.next = temp.next; 
        System.gc(); 
    } 
  
    // Driver program to test above functions 
    public static void main(String[] args) { 
        DeleteNodeWithoutHeadPointer list = new DeleteNodeWithoutHeadPointer(); 
        list.head = new Node(1); 
        list.head.next = new Node(12); 
        list.head.next.next = new Node(1); 
        list.head.next.next.next = new Node(4); 
        list.head.next.next.next.next = new Node(1); 
  
        System.out.println("Before Deleting "); 
        list.printList(head); 
  
        /* I m deleting the head itself. 
         You can check for more cases */
        list.deleteNode(head); 
        System.out.println(""); 
        System.out.println("After deleting "); 
        list.printList(head); 
    } 
}
