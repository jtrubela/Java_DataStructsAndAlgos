package allPairsShortestPath;

public class Floyd_Warshall {
	final static int INF = 9999;
	int n=5;    // here nV specifies the number of vertices in the graph
	static int [][] matrix;
	
	public int[][] initialize_Graph(int [][]A) {
		for(int i=0; i< A.length;i++) {
			for(int j=0; j<A.length;j++) {
			matrix[i][j] = A[i][j];
			}
		}
		return matrix;
	}
	
	// Implementing floyd warshall algorithm
	public void floyd_warshall(int graph[][]) {
		matrix = new int[n][n];
		initialize_Graph(graph);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (matrix[j][i] + matrix[i][k] < matrix[j][k]) {
						matrix[j][k] = matrix[j][i] + matrix[i][k];
					}
				}
			}
		}
		printMatrix(matrix);
	}


	void printMatrix(int matrix[][]) {
		System.out.println("Matrix to show the shortest "+ 
				"distances between every pair of vertices is given below");
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (matrix[i][j] == INF) {
					System.out.print("INF ");
				}
				else {
					System.out.print(matrix[i][j] + "  ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int graph[][] ={ 
				{0 , 3 , 8 , INF , -4}, 
				{INF , 0 , INF , 1 , 7}, 
				{INF, 4 , 0 , INF , INF}, 
				{2 , INF , -5 , 0 , INF} ,
				{INF , INF , INF , 6 , 0}
		};
		Floyd_Warshall a = new Floyd_Warshall();
		a.floyd_warshall(graph);
	}
}