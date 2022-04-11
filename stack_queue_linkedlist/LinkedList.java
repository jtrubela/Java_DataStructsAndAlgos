/*****************************************************************
 * 
 * CSIT212 - LinkedList.java		Justin Trubela		10/12/21
 * 
 * Purpose: LinkedList
 * 
 * Task 3 (40 pts).  Implement the search(int k), insert(int x),
 * 		 delete() function in LinkedList.java as discussed in Lecture 6.
 * 
 *****************************************************************/

package stack_queue_linkedlist;

public class LinkedList {
	
	public ListNode head;
	
	public LinkedList () {
		head = null;
	}
	
	/*
	 * Implement the LIST-SEARCH(L, k) function
	 */
	public ListNode search (int k) {
		
		ListNode node = head;
		
		while (node!=null && node.key != k) {
			node = node.next;
		}
		return node;
		
	}
	
	/*
	 * Implement the LIST-INSERT(L, x) function
	 * Note that x is a integer value, not a ListNode
	 */
	public void insert (int key) {
		
		ListNode node = new ListNode(key);
		
		node.next = head;
		
		if (head != null) {
			head.prev = node;
		}
		
		head = node;
		node.prev = null; 
		
	}
	
	
	/*
	 * Implement the LIST-DELETE(L, x) function
	 */
	public void delete (ListNode node) {
		
		if (node.prev != null) {
			node.prev.next = node.next;
			}
		
		else {
			head = node.next;
			}
		
		if(node.next != null) {node.next.prev = node.prev;}
		
	}
	
	/*
	 * Convert a LinkedList to a string in the format of [#elements]
	 */
	public String toString () {
		String str;
		ListNode node;
		
		str = "[";
		node = this.head;
		while (node != null) {
			str += node.key + ",";
			node = node.next;
		}
		
		str += "]";
		return str;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list;
		
		list = new LinkedList();
		for (int i = 0; i < 5; i++)
			list.insert(i);
		System.out.println(list.toString());
		for (int i = 0; i < 2; i++) 
			list.delete(list.head.next);
		System.out.println(list.toString());		
	}

}
