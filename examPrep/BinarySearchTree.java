package examPrep;

import binarySearchTree.TreeNode;

public class BinarySearchTree {
	/**/// TREENODE CLASS DATA--------------------------//
	/**/public int key;									//
	/**/public TreeNode parentNode;						//
	/**/public TreeNode leftNode;						//
	/**/public TreeNode rightNode;						//
	/**/												//
	/**/public void TreeNode () {						//
	/**/	parentNode = leftNode = rightNode = null;	//
	/**/}												//
	/**/												//
	/**/public void TreeNode (int k) {					//
	/**/	key = k;									//
	/**/	parentNode = leftNode = rightNode = null;	//
	/**/}												//
	//////////////////////////////////////////////////////
	
	public TreeNode rootNode;
	
	public BinarySearchTree () {
		rootNode = null;
	}

	public static void inorderTreeWalk(TreeNode TreeNode) {		// left, parent, right
		if(TreeNode != null)
			inorderTreeWalk(TreeNode.leftNode);
			printNodeKey(TreeNode.key);
			inorderTreeWalk(TreeNode.rightNode);
	}
	public static void preorderTreeWalk(TreeNode TreeNode) {	// parent, left, right
		if(TreeNode != null)
			printNodeKey(TreeNode.key);
			preorderTreeWalk(TreeNode.leftNode);
			preorderTreeWalk(TreeNode.rightNode);
	}
	public static void postorderTreeWalk(TreeNode TreeNode) {	// left, right, parent
		if(TreeNode != null)
			preorderTreeWalk(TreeNode.leftNode);
			preorderTreeWalk(TreeNode.rightNode);
			printNodeKey(TreeNode.key);
	}
	
	public TreeNode search(TreeNode currentNode, int key) {
		if(currentNode==null || key == currentNode.key)
			return currentNode;
		else if(key < currentNode.key)
			return search(currentNode.leftNode,key);
		else
			return search(currentNode.rightNode,key);
	}
	
	public TreeNode minimum () {
		TreeNode currentNode = rootNode;
		while (currentNode.leftNode != null) 
			currentNode = currentNode.leftNode;
		return currentNode;
	}
	
	public TreeNode maximum () {
		TreeNode currentNode = rootNode;
		while (currentNode.rightNode != null) 
			currentNode = currentNode.rightNode;
		return currentNode;
	}
	
	public TreeNode successor (TreeNode currentNode) {
		if (currentNode.rightNode != null) 
			return minimum();
		TreeNode successor = currentNode.parentNode;
		while (successor != null && currentNode == successor.rightNode) 
			currentNode = successor;
			successor = successor.parentNode;
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
		
		if (previousNode==null)
			rootNode = newNode;
		else if (newNode.key < previousNode.key)
			previousNode.leftNode = newNode;
		else
			previousNode.rightNode = newNode;
		
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
	
	public static void printNodeKey(int num) {
		System.out.println(num + " ");
	}
	
	public static void main(String[] args) {
		int [] tree = {12,5,18,2,9,15,19,13,17};
		BinarySearchTree bst;
		TreeNode node;
		
		bst = new BinarySearchTree();
		for (int i = 0; i < tree.length; i++)
			bst.insert(tree[i]);
		/*
		 * In-order
		 */
		System.out.println("Inorder_tree_walk starts ------------------");
		BinarySearchTree.inorderTreeWalk(bst.rootNode);
		System.out.println("\nInorder_tree_walk ends ------------------");
		System.out.print("\n\n");
		
		/*
		 * Pre-order
		 */
		System.out.println("Preorder_tree_walk starts ------------------");
		BinarySearchTree.preorderTreeWalk(bst.rootNode);
		System.out.println("\nPreorder_tree_walk ends ------------------");
		System.out.print("\n\n");
		
		/*
		 * Post-order
		 */
		System.out.println("Postorder_tree_walk starts ------------------");
		BinarySearchTree.postorderTreeWalk(bst.rootNode);
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
