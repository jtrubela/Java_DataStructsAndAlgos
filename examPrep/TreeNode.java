package examPrep;

public class TreeNode {
	public int key;
	public TreeNode parentNode;
	public TreeNode leftNode;
	public TreeNode rightNode;
	
	public TreeNode () {
		parentNode = leftNode = rightNode = null;
	}
	
	public TreeNode (int k) {
		key = k;
		parentNode = leftNode = rightNode = null;
	}
}