package allPairsShortestPath;

public class Graph4 {
	int n=5;
	static int[][] matrix;
	int[][] A;
	int[] d;
	
	public Graph4 () { 
	}
	
	public Graph4 (int _n, int[][] _A) {
		n = _n;
		A = _A;
	}

	public void floyd_warshall (int graph[][]) {
		matrix = new int[n][n];
		initialize_Graph(graph);
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					min(k, i, j);
				}
			}
		}
		display_matrix(matrix);
	}
	
	public int[][] initialize_Graph(int [][]A) {
		for(int i=0; i < n;i++) {
			// for each edge weight in the given graph
			for(int j=0; j< n;j++) 
			{
			//update the adjacency matrix weight
			matrix[i][j] = A[i][j];
			}
		}
		return matrix;
	}
	
	public void min (int i, int j, int k) {
		//if current edge weight + alternate edge weight is < the initial weight
		if(matrix[j][i] + matrix[i][k] < matrix[j][k]) {
			//update initial weight with lesser weight
			matrix[j][k] = matrix[j][i] + matrix[i][k];
		}
	}
 
	public void display_matrix(int[][] matrix) {		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(" " + matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int F = 1_072_999_999;	//not sure why Int.MAX wasn't working so if you(professor/TA) could elaborate on that we'd appreciate it
					
		int[][] A = {
		{0, 3, 8, F, -4},
		{F, 0, F, 1, 7},
		{F, 4, 0, F, F},
		{2, F, -5, 0, F},
		{F, F, F, 6, 0}
		};
		
		System.out.println("The pairwise shortest distance as a matrix for the given graph is:");
		Graph4 g1 = new Graph4();
		g1.floyd_warshall(A);

	}
 
}