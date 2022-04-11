package minimumSpanningTree;
import java.util.*;

/*****************************************************************
 * 
 * CSIT212 - Graph2.java		Justin Trubela		11/24/21
 * 
 * Purpose: Minimum Spanning Tree
 * 
 *Task 1 (100 pts). Implement the prim(int r) function as discussed in
 * Lecture 18.
 * – Note: You should return an integer that indicates the total weight
 * of the minimum spanning tree.
 * – Hint 1: We use an adjacent matrix to represent the graph. If
 *  A[i][j] = 0, it means there is no edge between the i-th and j-th node.
 * If A[i][j] > 0, then it means the weight of the edge between the i-th
 * and j-th node.
 * – Hint 2: To learn how to use Priority Queue in Java, google
 * Java PriorityQueue API. Also find some tutorials on Java Pri-
 * orityQueue to understand it better.
 * – Hint 3: In order to associate each node with a weight and place it
 * into the queue, you may need to create another class. Check ListN-
 * ode.java and LinkedList.java in HW3 to get an example of auxiliary
 * class.
 *
 * 
 *****************************************************************/


public class Graph2 {
	
	public int n;	//number of vertice
	public int[][] A;	//the adjacency matrix
	
	public Graph2 () {
		n = 0;
		A = null;
	}
	
	public Graph2 (int _n, int[][] _A) {
		this.n = _n;
		this.A = _A;
	}
	
	public int prim (int r) {
		//queue retrieval operations poll, remove, peek, and element access the element at the head of the queue.
		
		PriorityQueue<PrimNode> pQ = new PriorityQueue<PrimNode>(n);	// initialize a new priority queue of primnodes
		
		int weight = r; //weight = 0

		for (int i = 0; i < n; i++) {		// for each primnode set each of its values to max value except for source node
			
			PrimNode u;
			
			if(i==r) {
				
				u = new PrimNode(i,0);
			}
			
			else {
				
				u = new PrimNode(i, Integer.MAX_VALUE);
			}
			
			pQ.add(u);						// add each node to the priority queue
		}
		
		while(pQ.isEmpty() == false) {	// while the priority queue of primnodes is not empty
			
			PrimNode u = pQ.remove();		// remove the head of the queue and assign it to u

			weight += u.key;
			
			Iterator<PrimNode> it = pQ.iterator();	//assign an iterator to check to see if there are elements after the current
			
			PriorityQueue<PrimNode> pq_copy = new PriorityQueue<PrimNode>(n);
			
			while (it.hasNext()==true) {
				
				PrimNode v = it.next();
				
				if (A[u.id][v.id] != 0 && A[u.id][v.id] < v.key) {	// if the nodes are connected and the weight is less than its key
					
					PrimNode v_copy = new PrimNode(v.id, A[u.id][v.id]); 	//assign a copy of the node with its weight  
					
					pq_copy.add(v_copy);									// add that copy to the priority queue copy
					
				}
				else {
					pq_copy.add(v);
				}
			}
			pQ = pq_copy;					// make the copy of the priority queue the actual priority queue
		}
		
		return weight;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9;
		int A[][] = {
				{0, 4 , 0, 0 , 0 , 0 , 0, 8 , 0}, 
				{4, 0 , 8, 0 , 0 , 0 , 0, 11, 0}, 
				{0, 8 , 0, 7 , 0 , 4 , 0, 0 , 2}, 
				{0, 0 , 7, 0 , 9 , 14, 0, 0 , 0}, 
				{0, 0 , 0, 9 , 0 , 10, 0, 0 , 0}, 
				{0, 0 , 4, 14, 10, 0 , 2, 0 , 0}, 
				{0, 0 , 0, 0 , 0 , 2 , 0, 1 , 6}, 
				{8, 11, 0, 0 , 0 , 0 , 1, 0 , 7}, 
				{0, 0 , 2, 0 , 0 , 0 , 6, 7 , 0} 
		};

		Graph2 g = new Graph2(n, A);
		System.out.println(g.prim(0));
	}

}
