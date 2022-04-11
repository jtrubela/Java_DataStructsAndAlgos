/*****************************************************************
 * 
 * CSIT212 - BinarySearchTree.java		Justin Trubela		10/12/21
 * 
 * Purpose: implement all the parts to a BinarySearchTree
 * 
 * Task 1 (10 pts). Implement the in-order tree walk() function 
 * Task 2 (20 pts). Implement the search() function
 * Task 3 (10 pts). Implement the iterative search() function
 * Task 4 (10 pts). Implement the minimum() function
 * Task 5 (10 pts). Implement the maximum() function 
 * Task 6 (20 pts). Implement the successor() function
 * Task 7 (20 pts). Implement the insert() function 
 * Task 8 (10 pts Extra Credit). Implement the pre-order tree walk() 
 * 		and post-order tree walk() functions
 * 
 *****************************************************************/


package binarySearchTree;


public class BinarySearchTree {
	public TreeNode rootNode;
	
	public BinarySearchTree () {
		rootNode = null;
	}
	
	public void inorder_tree_walk (TreeNode currentNode) {
		
		if (currentNode != null) {							// if root node is not empty
			inorder_tree_walk(currentNode.leftNode);		// iterate through left node and its children until you reach an empty node
			System.out.print(currentNode.key + " ");		// print the parent of the empty node
			inorder_tree_walk(currentNode.rightNode);		// try to see if there are any numbers smaller than the parent nodes parent
		}
		
	}
	
	public void preorder_tree_walk (TreeNode currentNode) { // pre-order is parent left right
		if (currentNode != null) {			
			System.out.print(currentNode.key + " ");
			preorder_tree_walk(currentNode.leftNode);
			preorder_tree_walk(currentNode.rightNode);
		}
	}
	
	public void postorder_tree_walk (TreeNode currentNode) { // post-order is left right parent
		if (currentNode != null) {			
			postorder_tree_walk(currentNode.leftNode);
			postorder_tree_walk(currentNode.rightNode);
			System.out.print(currentNode.key + " ");

		}
	}
	
	public TreeNode search (TreeNode currentNode, int searchKey) {
		if (currentNode == null || searchKey == currentNode.key) {
			return currentNode;
		}
		else if (searchKey<currentNode.key) {
			return search(currentNode.leftNode, searchKey);
		}
		else {
			return search(currentNode.rightNode, searchKey);
		}
		
	}
	
	public TreeNode iterative_search (int searchKey) {
		TreeNode currentNode = new TreeNode(searchKey);
		while (currentNode != null && searchKey != currentNode.key) {
			if (searchKey<currentNode.key) {
				currentNode = currentNode.leftNode;
			}
			else {
				currentNode = currentNode.rightNode;
			}
		}
		return currentNode;
	}
	
	public TreeNode minimum () {
		TreeNode currentNode = rootNode;
		while (currentNode.leftNode != null) {
			currentNode = currentNode.leftNode;
		}
		return currentNode;
	}
	
	public TreeNode maximum () {
		TreeNode currentNode = rootNode;
		while (currentNode.rightNode != null) {
			currentNode = currentNode.rightNode;
		}
		return currentNode;
	}
	
	public TreeNode successor (TreeNode currentNode) {
		if (currentNode.rightNode != null) {
			return minimum();
		}
		TreeNode successor = currentNode.parentNode;
		while (successor != null && currentNode == successor.rightNode) {
			currentNode = successor;
			successor = successor.parentNode;
		}
		return successor;
	}

	public void insert (int key) {
		TreeNode currentNode = rootNode;  // placeholder current root node
		TreeNode previousNode = null;  // placeholder previous root node
		TreeNode newNode = new TreeNode(key); // new node to insert


		while(currentNode != null) {
			previousNode = currentNode;
			
			if(newNode.key < currentNode.key) {
				currentNode = currentNode.leftNode;
			}
			else {
				currentNode = currentNode.rightNode;
			}	
		}
		newNode.parentNode = previousNode;
		
		if (previousNode==null) {
			rootNode = newNode;
		}

		else if (newNode.key < previousNode.key) {
			previousNode.leftNode = newNode;
		}
		else {
			previousNode.rightNode = newNode;
		}
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
		BinarySearchTree bst;
		TreeNode node;
		
		bst = new BinarySearchTree();
		for (int i = 0; i < array.length; i++)
			bst.insert(array[i]);
		
		/*
		 * In-order
		 */
		System.out.println("Inorder_tree_walk starts ------------------");
		bst.inorder_tree_walk(bst.rootNode);
		System.out.println("\nInorder_tree_walk ends ------------------");
		System.out.print("\n\n");
		
		/*
		 * Pre-order
		 */
		System.out.println("Preorder_tree_walk starts ------------------");
		bst.preorder_tree_walk(bst.rootNode);
		System.out.println("\nPreorder_tree_walk ends ------------------");
		System.out.print("\n\n");
		
		/*
		 * Post-order
		 */
		System.out.println("Postorder_tree_walk starts ------------------");
		bst.postorder_tree_walk(bst.rootNode);
		System.out.println("\nPostorder_tree_walk ends ------------------");
		System.out.print("\n\n");
		
		/*
		 * Search
		 */
		System.out.println("Search starts ------------------");
		node = bst.search(bst.rootNode, 13);
		System.out.println("found: " + node.key);
		System.out.println("Search ends ------------------");
		System.out.print("\n\n");

		/*
		 * Iterative Search
		 */
		System.out.println("Iterative search starts ------------------");
		node = bst.iterative_search(4);
		System.out.println("found: " + node.key);
		System.out.println("Iterative search ends ------------------");
		System.out.print("\n\n"); 
		
		/*
		 * Minimum Search
		 */
		System.out.println("Minimum starts ------------------");
		node = bst.minimum();
		System.out.println("Minimum key is " + node.key);
		System.out.println("Minimum ends ------------------");
		System.out.print("\n\n");
		
		/*
		 * Maximum Search
		 */
		System.out.println("Maximum starts ------------------");
		node = bst.maximum();
		System.out.println("Maximum key is " + node.key);
		System.out.println("Maximum ends ------------------");
		System.out.print("\n\n");

		/*
		 * Successor Search
		 */
		System.out.println("Successor starts ------------------");
		node = bst.successor(bst.rootNode.leftNode.rightNode.rightNode);
		System.out.println("Successor key is " + node.key);
		System.out.println("Successor ends ------------------");
		System.out.print("\n\n");
		
	}

}