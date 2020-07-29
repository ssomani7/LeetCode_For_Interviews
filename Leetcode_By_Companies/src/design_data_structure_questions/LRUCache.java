package design_data_structure_questions;

/*
 * Time complexity : O(1) both for put and get.
 * Space complexity : O(capacity) since the space is used only for a hashmap and double linked list with at
 * most capacity + 1 elements.
 */

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise 
 * return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its 
 * capacity, it should invalidate the least recently used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * LRUCache cache = new LRUCache(2); // 2 = Capacity
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */

import java.util.Map;
import java.util.HashMap;

public class LRUCache {

	private class DNode{
		int key;
		int value;
		DNode previous;
		DNode next;
	}
	
	private Map<Integer, DNode> hashtable = new HashMap<Integer, DNode>();
	private DNode head, tail; //dummy head & node to avoid null checks
	private int totalItemsInCache;
	private int capacity;
	
	public LRUCache(int capacity) { //constructor
//		Cache starts empty and capacity is initialized by user
		totalItemsInCache = 0;
		this.capacity = capacity;
		
//		initialize dummy head
		head = new DNode();
		head.previous = null;
		
//		initialize dummy tail
		tail = new DNode();
		tail.next = null;
		
//		Wire head and tail together
		head.next = tail;
		tail.previous = head;
	}
	
//	node will be always added to the beginning of the doubly linked list after dummy head.
	private void addNode(DNode node) {
//		setup next and previous for the new node
		node.previous = head;
		node.next = head.next;
		
//		need to update the previous pointer of the node to which head.next was pointing to the new node.
		head.next.previous = node;
		
//		update head.next to new node
		head.next = node;
	}
	
	private void removeNode(DNode node) {
//		first secure the next and previous references of the node to be deleted
		DNode savedNext = node.next;
		DNode savedPrevious = node.previous;
		
//		Now wire the above 2 together which will cut links for current node and it will be deleted.
		savedNext.previous = savedPrevious;
		savedPrevious.next = savedNext;
	}
	
//	DNode exists in the cache and move it to the beginning by first removing and then adding the same node
//	Update the value in get() and put() method itself
	private void moveToHead(DNode node) {
		removeNode(node);
		addNode(node);
	}
	
	private DNode popTail() {
		DNode itemBeingRemoved = tail.previous;
		removeNode(itemBeingRemoved);
		return itemBeingRemoved;
	}
	
	private void removeUsingLRU() {
//		remove from doubly LinkedList
		DNode itemBeingRemoved = popTail();
//		remove from hashtable
		hashtable.remove(itemBeingRemoved.key);
//		reduced the cache count.
		--totalItemsInCache;
	}
	
	public int get(int key) {
		DNode node = hashtable.get(key);
		boolean itemIsPresentInCache = node != null;
		
//		trying to access empty entry.
		if(!itemIsPresentInCache)
			return -1;
		
//		item has been accessed, move it to the front of the list
		moveToHead(node);
		
		return node.value;
	}//end get method
	
	public void put(int key, int value) {
		DNode node = hashtable.get(key);
//		boolean variable to check if the item is present in the cache.
		boolean itemIsPresentInCache = node != null;
		
//		if item is not present, i.e, node == null, we need to first add the node to doubly LinkedList and
//		hashtable and increment totalItemsInCache and then check if the cache is overflowing, if yes then remove
//		using LRU policy. There is no inner else, as the outer else takes care of it
		
		if(!itemIsPresentInCache) {
//			Create a new DNode and assign key & value to it.
			DNode newNode = new DNode();
			newNode.key = key;
			newNode.value = value;
			
//			now put it in the doubly linkedlist
			addNode(newNode);
			
//			now put it in hashtable
			hashtable.put(key, newNode);
			
//			increase the count of totalItemsInCache
			totalItemsInCache++;
			
//			now check it against the capacity
			if(totalItemsInCache > capacity) {
//				remove the tail element using LRU policy. No need to decrease the count of totalItemsInCache as it
//				is being done in the method removeUsingLRU.
				removeUsingLRU();
			}
			
		} else {
//			if the item is already present in the cache, the cache won't overflow and we need to update the value 
//			of the node and move the node to the head of the cache as it has been accessed.
			node.value = value;
			moveToHead(node);
		}
	}//end put method
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		
		System.out.println(cache.get(1));       // returns 1
		
		cache.put(3, 3);    // evicts key 2
		
		System.out.println(cache.get(2));       // returns -1 (not found)
		
		cache.put(4, 4);    // evicts key 1
		
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4
	}
}//end class LRUCache

