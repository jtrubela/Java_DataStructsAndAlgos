/*****************************************************************
 * 
 * CSIT212 - RodCut.java		Justin Trubela		10/25/21
 * 
 * Purpose: Implement all the parts of RodCutting algorithm
 * 
 * •Task 1 (40 pts). Implement the memoized cut rod() 
 * and memoized cut rod aux() function as discussed in Lecture 9.
 * •Task 2 (40 pts). Implement the bottom up cut rod() 
 * function as discussed in Lecture 9.
 * •Task 3 (20 pts). Implement the extended bottom up cut rod 
 * function as discussed in Lecture 9.
 * 
 *****************************************************************/


package rodCutting;

public class RodCut {
	int rodSize;
	int[] price;
	int[] revenue;
	int[] s;
	
	public RodCut () {
		rodSize = 10;
		price = new int[11];
		price[0] = 0;
		price[1] = 1;
		price[2] = 5;
		price[3] = 8;
		price[4] = 9;
		price[5] = 10;
		price[6] = 17;
		price[7] = 17;
		price[8] = 20;
		price[9] = 24;
		price[10] = 30;
	}
	
	public int memoized_cut_rod () {
		// create a temporary array of size n+1 to store the information 
		//							needed for the memoized cut rod aux method
		int [] revenue = new int [rodSize+1];

		// for 11 times, set each value in array to the minimum value possible
		for(int i = 0; i <= rodSize; i++) {
			revenue[i] = Integer.MIN_VALUE;
		}
		
		return memoized_cut_rod_aux (price, rodSize, revenue);
	}
	
	public int memoized_cut_rod_aux (int price[], int rodSize, int revenue[]) {
		int q = 0;
		
		if( revenue[rodSize] >= 0 ) {
			return revenue[rodSize];
		}
		if (rodSize == 0) {
			q = 0;
		}
		else {
			for (int i=1; i<=rodSize; i++) {
				q = Math.max(q, price[i]+memoized_cut_rod_aux (price, rodSize-i, revenue));
			}
		}
		revenue[rodSize] = q;
		return q;
		
		
	}
	
	public int bottom_up_cut_rod () {
		revenue = new int [rodSize+1];
		
		revenue[0] = 0;

		for (int j=1; j<=rodSize; j++) {
			
			int q = Integer.MIN_VALUE;
			
			for (int i=1; i<=j; i++) {
				q = Math.max(q, price[i]+revenue[j-i]);
			}
			revenue[j] = q;
			
		}
		return revenue[rodSize];
	}
	
	public void extended_bottom_up_cut_rod () {
		revenue = new int [rodSize+1];
		s = new int [rodSize+1];
		
		revenue[0] = 0;
		
		for (int j = 1; j<=rodSize; j++) {
			int q = Integer.MIN_VALUE;
			
			for (int i = 1; i <= j ; i++) {
				if (q < price[i] + revenue[j-i]){
					q = price[i] + revenue[j-i];
					s[j] = i;
				}
			}
			revenue[j] = q;
		}	
	}
	
	public void print_cut_rod_solution () {
		for (int i = 0; i <= rodSize; i++) {
			System.out.print(i + "\t");
		}
		System.out.print("\n");
		for (int i = 0; i <= rodSize; i++) {
			System.out.print(revenue[i] + "\t");
		}
		System.out.print("\n");
		for (int i = 0; i <= rodSize; i++) {
			System.out.print(s[i] + "\t");
		}
		System.out.print("\n");
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RodCut rc;
		
		rc = new RodCut();
		System.out.println("memoized_cut_rod starts ------------------");
		System.out.println(rc.memoized_cut_rod());
		System.out.println("memoized_cut_rod ends ------------------");
		System.out.print("\n\n");
		
		System.out.println("bottom_up_cut_rod starts ------------------");
		System.out.println(rc.bottom_up_cut_rod());
		System.out.println("bottom_up_cut_rod ends ------------------");
		System.out.print("\n\n");

		System.out.println("extended_bottom_up_cut_rod starts ------------------");
		rc.extended_bottom_up_cut_rod();
		rc.print_cut_rod_solution();
		System.out.println("extended_bottom_up_cut_rod ends ------------------");
		System.out.print("\n\n");
	}

}