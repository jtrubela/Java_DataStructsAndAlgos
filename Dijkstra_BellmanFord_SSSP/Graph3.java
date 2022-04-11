package singleSourceShortestPath;

/*****************************************************************
 * 
 * CSIT212 - Graph3.java		Justin Trubela		10/12/21
 * 
 * Purpose: Single Source Shortest Path
 * 
 * • Task 1 (50 pts). Implement the bellman ford(int s) function as discussed in Lecture 19.
 * Note: You should return an boolean value.
 * 
 * • Task 2 (50 pts). Implement the dijkstra(int s) function as discussed in Lecture 20.
 * – Hint 1: We use an adjacent matrix to represent the graph. 
 * 	If A[i][j] = 0, it means there is no edge between the i-th and j-th node.
 * 	If A[i][j] != 0, then it means the weight of the edge between the i-th and j-th node.
 * – Hint 2: You do not need to do any operation for the π variable in the pseudocode in Task 1 and Task 2.
 * 
 * • Task 3 (50 pts (Extra Credit)). Implement a function to organize the
 * 	shortest path for each node as a string. For example, if a node 4’s shortest
 * 	path is 0 → 2 → 1 → 4, you can generate a string variable s =“0 →
 * 	2 →1 →4”. Modify the display distance() function to show the shortest
 * 	distance and the shortest path for each node.
 * – Hint 1: You definitely need to do operation for the π variable in
 * 	this task. Feel free to add any class member data based on your need.
 * 
 *****************************************************************/



public class Graph3 {
	int n;
	int[][] A;
	int[] d;	//shortest distance
	/**
	 * @param args
	 */
	
	public Graph3 () {
		
	}
	
	public Graph3 (int _n, int[][] _A) {
		n = _n;
		A = _A;
		d = new int[n];
	}
	
	public void initialize_single_source(int s) {
		for (int i = 0; i < n; i++)
			d[i] = Integer.MAX_VALUE;
		d[s] = 0;
	}
	
	public void relax (int u, int v) {
		if (d[v] > (d[u] + A[u][v])) 
			d[v] = d[u] + A[u][v];
	}
	
	public boolean bellman_ford (int s) {		
		boolean flag = true;
		
		initialize_single_source(s);
		for(int i=1; i<n; i++) {
			
			for(int j=0; j<A.length; j++) {
				
				for(int k=0; k<A.length; k++) {
					
					if(A[j][k]!=s) {
						
						relax(j,k);
					
					}
				}
			}
		}
		
		for(int i=0; i<=n-1;i++) {
			for(int j=0; j<n; j++) {
				if (d[j]>d[i]+A[i][j]) {
					return flag=false;
				}
			}

		}
		
		return flag;
	}
	
	public void dijkstra (int s) {		
		initialize_single_source(s);
		int visit[] = new int[A.length];
		for(int i=0; i<A.length-1;i++) {
			int min = Integer.MAX_VALUE;
			int u = 0;

			for(int v=0; v < A.length; v++) {
				if (visit[v] == 0 && d[v] <= min) {
					min=d[v];
					u = v;
				}
			}
			visit[u] = 1;

			for(int v=0; v<A.length;v++) {
				if (visit[v]==0 && A[u][v]>0) {
					relax(u,v);
				}
			}
		}

	}
	
	public void display_distance () {
		for (int i = 0; i < n; i++)
			System.out.println(i + ": " + d[i]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[][] A = {
		{0, 6, 0, 7, 0},
		{0, 0, 5, 8, -4},
		{0, -2, 0, 0, 0},
		{0, 0, -3, 0, 9},
		{2, 0, 7, 0, 0}
		};
		Graph3 g1 = new Graph3(n, A);
		g1.bellman_ford(0);
		g1.display_distance();
		
		System.out.println("-----------------------");
		
		int[][] B = {
		{0, 10, 0, 5, 0},
		{0, 0, 1, 2, 0},
		{0, 0, 0, 0, 4}, 
		{0, 3, 9, 0, 2},
		{7, 0, 6, 0, 0}
		};
		Graph3 g2 = new Graph3(n, B);
		g2.dijkstra(0);
		g2.display_distance();
	}

}
