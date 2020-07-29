package BST;

/*
 * Time Complexity: O(N) since we still have to process each of the nodes in the linked list once and form 
 * corresponding BST nodes.
 * Space Complexity: O(logN) since now the only extra space is used by the recursion stack and since we are 
 * building a height balanced BST, the height is bounded by NlogN.
 */

/*
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two 
 * subtrees of every node never differ by more than 1.
 * 
 * Given the sorted linked list: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 
 */

class ListNode{
	ListNode next;
	int val;
	
	ListNode(int val){
		this.val = val;
	}
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class SortedLinkedListToBST {
	private ListNode node; //making it a class variable to keep scope available to all the methods in the class
    //at the same state.
    
    public TreeNode sortedListToBST(ListNode head) {
        //Since array is sorted, we will use Binary search approach.
        //But if we observe carefully the tree built after this problem has been solved on its Inorder traversal
        //we will get the sorted linked list as given in the input.
        //so we will reverse engineer this and build the tree from leaf to root.
        
        //In LinkedList we need to first find the length of the list
        int counter = 0;
        
        //For iterating over the Sorted LinkedList and creating the treenode objects from bottom to up.
        node = head;
        
        //for linked list length calculation.
        ListNode current = head;
        
        while(current != null){
            counter++;
            current = current.next;  
        }
        
        return leafToRootBST(0, counter - 1);
    }
    
    public TreeNode leafToRootBST(int start, int end){
        //recursive method.
        if(start > end)
            return null;
        
        /*
         * Since we are using In-order trversal => left, root, right.
         * The sorted linkedlist represents left most child as the first node. But programmatically the left most child
         * is 'null'. Since sorted linked list, using binary search along with inorder traversal, we first go to the
         * left most child, store that in a TreeNode object (we don't create one, we store what is already there). By
         * this approach, we then create a TreeNode object from the value that is being pointed by the 'node' in the
         * sorted linked list.
         * 
         * We now connect the 'left' treenode object we stored to the new treenode object we created.
         * Now increment the 'node' in the sorted linked list, as we only create a node after the left most leaf value
         * is discovered in the in-order traversal.
         * Now recurse for the right side with binary search technique. When you get the right side object, store it in
         * 'right' and then link it to the 'parent' treenode object we created.
         * 
         * If we look closely, the leaf node is also a 'root' node as its left and right child nodes are null.
         * Hence we only create the 'treenode' object once we come across the left most child.
         * After linking the right most child to the treenode created, return the treenode.
         * In this fashion, the treenode object we returned will act as a left or right child for the upcoming nodes
         * from the sorted linked list.
         * 
         * And we get our height balanced bst from leaf to root.
         */
   
        //to avoid integer overflow, calculate mid in this way
        int mid = (start) + (end - start) / 2;
        
        //binary search for left side
        TreeNode left = leafToRootBST(start, mid - 1);
        
        //create a TreeNode of the exisiting node value
        TreeNode tnode = new TreeNode(node.val);
        
       //link the left most treenode for the treenode we created.
        tnode.left = left;
        
        //now increment the node pointer in the sorted linked list, as we create a new treenode only after finding
        //the left most child.
        node = node.next;
        
        //recurse for the right side of binary search
        TreeNode right = leafToRootBST(mid + 1, end);
        
        tnode.right = right;
        return tnode;
    }
}
