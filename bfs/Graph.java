package bfs;

public class Graph {
	public int n;	//number of vertice
	public int[][] A;	//the adjacency matrix
	private final int WHITE = 2; //denotes an unvisited node
	private final int GRAY = 3; //denotes a visited node but has not entirely explored all of its adjacent nodes
	private final int BLACK = 4; //denotes the node and all of its adjacent nodes have been visted

	public Graph () {
		n = 0;
		A = null;
	}

	public Graph (int _n, int[][] _A) {
		this.n = _n;
		this.A = _A;
	}

	/*
	 * Input: s denotes the index of the source node
	 * Output: the array dist, where dist[i] is the distance between the i-th node to s
	 */
	public int[] bfs (int s) {
		int [] color = new int[n];			//creates an array to store the corresponding color of the node
		int [] distance =  new int[n];	    //creates an array to store the corresponding distance of the node to its source node
		Queue Q = new Queue(n);		//creates a queue to store the nodes that need to be visited

		for(int i=0; i<n; i++) {
			if(i!=s) {
				color[i]=WHITE;					//Initializes each array color index to white except source
				distance[i]=Integer.MAX_VALUE;	//Initializes each array distance to the largest known value except source
			}
			else{
				color[s] = GRAY;
			}
		}
		printStatus(color, distance);

		Q.enqueue(s);				//add source node to the queue to begin finding each nearest nodes distance
		print("added to the Queue\n");
		
		while (Q.head != Q.tail) {
			print("Dequeueing " + Q.head + "\n");
			int u = Q.dequeue();

			for(int v=0;v<n;v++) {
				if (color[v]==WHITE && A[u][v]==1) { //	if current node being visited is white and it is adjacent to its parent node
					color[v]=GRAY;						//visit the node and color it gray
					print("Updating distance from source node");
					distance[v] = distance[u]+1;		//make the visited node equal to its parent nodes distance from the source node +1
					Q.enqueue(v);					//as we visit each node, add newly visited nodes to queue to determine its distance
					print("Enqueueing node: " + v + "\n Head of the queue is now:" + Q.head + "\n");
					printStatus(color, distance);
				}
			}
			color[u] = BLACK;						// upon reviewing all of current nodes adjacent nodes, mark node visited as Black
		}
		return distance;
	}

	public void print_array (int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.println(i + ": " + array[i]);
	}
	public void print(String string) {
		System.out.println(string);
	}
	public void print() {
		System.out.println();
	}
	public void printStatus(int[] color, int[] distance) {
		for(int i=0; i<n; i++) {
			if (color[i]==WHITE) {
				print("Node("+ i + "), color = White");
				print("Node distance from source:" + distance[i]);
			}
			else if (color[i]==GRAY && distance[i]!= 0) {
				print("----------VISITING NEIGHBOR----------");
				print("Node("+ i + "), color = Gray");
				print("Node distance from source:" + distance[i]);
			}
			else {
				print("Node("+ i + "), color = Black");
				print("Node distance from source:" + distance[i]);
			}
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		int[][] A = 
			{
					{0, 1, 0, 0, 1, 0, 0, 0},
					{1, 0, 0, 0, 0, 1, 0, 0},
					{0, 0, 0, 1, 0, 1, 1, 0},
					{0, 0, 1, 0, 0, 0, 1, 1},
					{1, 0, 0, 0, 0, 0, 0, 0},
					{0, 1, 1, 0, 0, 0, 1, 0},
					{0, 0, 1, 1, 0, 1, 0, 1},
					{0, 0, 0, 1, 0, 0, 1, 0}
			};
		Graph g = new Graph(n, A);
		g.print_array(g.bfs(1));
	}

}