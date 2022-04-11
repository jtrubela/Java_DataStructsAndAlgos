package allPairsShortestPath;
 
public class Graph4_ {
	int n;
	int[][] A;
	int[] d;
 
	public Graph4_ () {
 
	}
 
	public Graph4_ (int _n, int[][] _A) {
		n = _n;
		A = _A;
		d = new int[n];
	}
 
	public int floyd_warshall (int p) {
		return p;
 
	}
 
	public void display_distance () {
		for (int i = 0; i < n; i++)
			System.out.println(i + ": " + d[i]);
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int F = Integer.MAX_VALUE;
		int n = 5;
		int[][] A = {
		{0, 3, 8, F, -4},
		{F, 0, F, 1, 7},
		{F, 4, 0, F, F},
		{2, F, -5, 0, F},
		{F, F, F, 6, 0}
		};
		Graph4_ g1 = new Graph4_(n, A);
		g1.floyd_warshall(0);
		g1.display_distance();
	}
 
}