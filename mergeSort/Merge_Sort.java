package mergeSort;

import java.util.*;

public class Merge_Sort {
		public static int[] merge_sort (int[] array, int p, int r) {
		
		if (p < r) {
			int q = (int) Math.floor((p+r)/2);
			Merge_Sort.merge_sort(array,p,q);
			Merge_Sort.merge_sort(array,q+1,r);
			Merge(array,p,q,r);
		}
		
		
		return array;
	}
	
	public static void Merge(int[] array, int p, int q, int r) { 
		int n1 = q-p+1;	
		int n2 = r-q;
		
		int L[] = new int [n1+1];
		int R[] = new int [n2+1];
		
		
		for(int i = 0;i < n1;i++) {			
			L[i] = array[p+i];
		}	
		
		for(int j = 0;j < n2;j++) {
			R[j] = array[q+j+1];
		}					
		
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;

		int i = 0;
		int j = 0;	
		
		for(int k = p; k<=r; k++) {
			if (L[i] <= R[j]) {	
				array[k] = L[i];
				i++;			
			}			
			else {	
				array[k] = R[j];
				j++;
			}

		}

	}
					// array = 8
					/*  p        q q+1       r
					 *  1  2  3  4  5  6  7  8  
					 * [ ][ ][ ][ ][ ][ ][ ][ ]	>	n1 = 5 - 1 = 4	>	8 - 4 = 4
					 * 								     q - p + 1	    r - q						// No index issue
					/*  p        q q+1       r	>   n2 = 4 - 0 = 4	>	7 - 3 = 4				
					 *  0  1  2  3  4  5  6  7  				
					 * [ ][ ][ ][ ][ ][ ][ ][ ]
					 */
		
					// 4-1+1 = 4	or	3-0+1 = 4
					//   8-4 = 4	or	  7-3 = 4
		
		
					// need to copy in indexes 1-4+1(Sentinel value)  to a sub array
					// need to copy in indexes 0-3+1(Sentinel value)  to a sub array	// No index issue
					// n1 + 1 = 4 + 1 = 5			
					// n2 + 1 = 4 + 1 = 5
		
					// L[].length = 5
					// R[].length = 5
					// L[].length + R[].length = 10
					
		
		
					
					// for each index in L array from first index to 1 to n1, L[index] = array[p + i - 1]
					// 												 1...4 = 4                 1 + 1 - 1 = 1
					//												 0...3 = 4				   0 + 1 - 1 = 0
					//
					// for each index in R array from first index to 1 to n2, R[index] = array[q + j]
					// 												 1...4 = 4                 4 + 0 = 4
					//												 0...3 = 4				   3 + 1 = 4
					//
					//	p = 1	q = 4	r = 8	n1 = 4	L.length = 5	i = 1	R.length = 5	j = 1
					//	p = 0	q = 3	r = 7	n2 = 4	L.length = 5	i = 0	R.length = 5	j = 0
					
 											// i = 1
				 							// run 4 times 1...4
											//			   0...3		
											// if 1 <= 4 = TRUE 
											// 
											// L[i-1] = array[p + i - 1]
											// L[1-1] = array[0 + 1 - 1]
											// L[0] = array[0]
											// i++ = 2
		
		
											// i = 2
											// if 2 <= 4 = TRUE
											// L[i-1] = array[p + i - 1]
											// L[2-1] = array[0 + 2 - 1]
											// L[1]   = array[1]
											// i++ = 3

		
											// i = 3
											// if 3 <= 4 = TRUE
											// L[3-1] = array[p + i - 1]
											// L[3-1] = array[0 + 3 - 1]
											// L[2]   = array[2]
											// i++ = 4

		
											// i = 4
											// if 4 <= 4 = TRUE
											// L[4-1] = array[p + i - 1]
											// L[4-1] = array[0 + 4 - 1]
											// L[3]   = array[3]
											// i++ = 5
		

											// i = 5
											// if 5 <= 4 = FALSE
											// END LOOP

											/*  p        q   q+1       r	>   n2 = 4 - 0 = 4	>	7 - 3 = 4
											 *  0  1  2  3    4  5  6  7  				
											 * [ ][ ][ ][ ]  [ ][ ][ ][ ]
											 ** Left Array	  Right Array				

											 */
											// j = 1

											// if 1 <= 4 = TRUE
											// R[1-1] = array[q+j]
											// R[1-1] = array[3+1]
											// R[0]   = array[4]
											// j+1 = 2
											
											/* j = 2
											 * if 2 <= 4 = TRUE
											 * R[2-1] = array[q+j]
											 * R[2-1] = array[3+2]
											 * R[1]   = array[5]
											 * j++ = 3
											 * 
											 * if 3 <= 4 = TRUE
											 * R[3-1] = array[q+j]
											 * R[3-1] = array[3+3]
											 * R[2]   = array[6]
											 * j++ = 4
											 * 
											 * if 4 <= 4 = TRUE
											 * R[4-1] = array[q+j]
											 * R[4-1] = array[3+4]
											 * R[3]   = array[7]
											 * j++ = 5
											 * 
											 * j = 5
											 * if 5 <= 5 = FALSE
											 * END LOOP
											 */
											
											//		   0		1		 2		  3      4			L.length = 5
											// L = [ a[0] ] [ a[1] ] [ a[2] ] [ a[3] ] [ oo ] 
											//		   4		5		 6		  7		 8			R.length = 5
											// R = [ a[4] ] [ a[5] ] [ a[6] ] [ a[7] ] [ oo ] 
		
		
											// Left index comparison with 0 index
											// Right index comparison with 0 index

		
		
		
						//	p = 1	q = 4	r = 8	n1 = 4	L.length = 5	i = 1	R.length = 5	j = 1	k=1
						//	p = 0	q = 3	r = 7	n2 = 4	L.length = 5	i = 0	R.length = 5	j = 0	k=0
		
											/* for each index from p to r		r-p+1 = 7-0+1 = 8
											 * 					   0    7		= 8 numbers
											 * if L[i] <= R[j]
											 * 	  A[k] = L[i]  
											 * 
											 * if not
											 * 	  A[k] = R[j]
											 * 
											 * 
											 * L = [ 2 ] [ 4 ] [ 5 ] [ 7 ] [ oo ]
											 * R = [ 1 ] [ 2 ] [ 3 ] [ 6 ] [ oo ]
											 * A = [ 2 ] [ 4 ] [ 5 ] [ 7 ] [ 1 ] [ 2 ] [ 3 ] [ 6 ]
											 */


											//  k = 0	j=0	   i=0
											//	if L[i] <= R[j]
											//  if  2	<=	1      = FALSE
											//	else	array[0] = R[0]
											//  j++ = 1
											//  k++ = 1



												/*		  0		1	  2		3
												 *  L = [ x ] [ 4 ] [ 5 ] [ 7 ] [ oo ]
												 *  	  4		5	  6		7
			 									 *	R = [ x ] [ 2 ] [ 3 ] [ 6 ] [ oo ]
			 									 *		  0		1	  2		3	  4		5	  6		7
												 *  A = [ 1 ] [ 4 ] [ 5 ] [ 7 ] [ 1 ] [ 2 ] [ 3 ] [ 6 ]
												 *  
												 *  k = 1   i = 0	j = 1	 
												 *  if L[i] <= R[j]
												 *  if  2	<=	2      =  TRUE
												 *  array[1] = L[0]
												 *  i++ = 1
												 *  k++ = 2
												 *  
												 *	L = [ x ] [ 4 ] [ 5 ] [ 7 ] [ oo ]
			 									 *	R = [ x ] [ 2 ] [ 3 ] [ 6 ] [ oo ]
												 *  A = [ 1 ] [ 2 ] [ 5 ] [ 7 ] [ 1 ] [ 2 ] [ 3 ] [ 6 ]
												 *  
												 *  k = 2	 i = 1   j = 1
												 *  if L[i] <= R[j]
												 *  if  4	<=  2		= FALSE
												 *  else	array[2] = R[1]
												 *  j++ = 2
												 *  k++ = 3
												 *   
												 *  L = [ x ] [ 4 ] [ 5 ] [ 7 ] [ oo ]
			 									 *	R = [ x ] [ x ] [ 3 ] [ 6 ] [ oo ]
												 *  A = [ 1 ] [ 2 ] [ 2 ] [ 7 ] [ 1 ] [ 2 ] [ 3 ] [ 6 ]
												 *  												   
												 *  k = 3	 i = 1   j = 2
												 *  if L[i] <= R[j]
												 *  if   4	<=	3      =  FALSE
												 *  else	array[3] = R[2]
												 *  j++ = 3
												 *  k++ = 4
												 *  
												 *	L = [ x ] [ x ] [ 5 ] [ 7 ] [ oo ]
			 									 *	R = [ x ] [ x ] [ x ] [ 6 ] [ oo ]
												 *  A = [ 1 ] [ 2 ] [ 2 ] [ 3 ] [ 4 ] [ 2 ] [ 3 ] [ 6 ]
												 *  
												 *    												   
												 *  k = 4	 i = 1   j = 3
												 *  if L[i] <= R[j]
												 *  if  4	<=	6      =  TRUE
												 *  array[4] = L[1]
												 *  i++ = 2
												 *  k++ = 5
												 *  
												 *  L = [ x ] [ x ] [ x ] [ 7 ] [ oo ]
			 									 *	R = [ x ] [ x ] [ x ] [ 6 ] [ oo ]
												 *  A = [ 1 ] [ 2 ] [ 2 ] [ 3 ] [ 4 ] [ 5 ] [ 3 ] [ 6 ]
												 *  
												 *  k = 5	 i = 2   j = 3
												 *  if L[i] <= R[j]
												 *  if  5	<=	6      =  TRUE
												 *  array[5] = L[2]
												 *  i++ = 3
												 *  k++ = 6
												 *  
												 *  L = [ x ] [ x ] [ x ] [ x ] [ oo ]
			 									 *	R = [ x ] [ x ] [ x ] [ 6 ] [ oo ]
												 *  A = [ 1 ] [ 2 ] [ 2 ] [ 3 ] [ 4 ] [ 5 ] [ 7 ] [ 6 ]
												 *  
												 *  k = 6	 i = 3   j = 3
												 *  if L[i] <= R[j]
												 *  if  7	<=	6      =  FALSE
												 *  else	array[6] = R[3]
												 *  j++ = 4
												 *  k++ = 7
												 *  
												 *  L = [ x ] [ x ] [ x ] [ 7 ] [ oo ]
			 									 *	R = [ x ] [ x ] [ x ] [ x ] [ oo ]
												 *  A = [ 1 ] [ 2 ] [ 2 ] [ 3 ] [ 4 ] [ 5 ] [ 6 ] [ 6 ]
												 *  
												 *  k = 7	 i = 3   j = 4
												 *  if L[i] <= R[j]
												 *  if  7	<=	oo      =  TRUE
												 *  array[7] = R[4]
												 *  i++ = 4
												 *  k++ = 8
												 *  
												 *  L = [ x ] [ x ] [ x ] [ x ] [ oo ]
			 									 *	R = [ x ] [ x ] [ x ] [ x ] [ oo ]
												 *  A = [ 1 ] [ 2 ] [ 2 ] [ 3 ] [ 4 ] [ 5 ] [ 6 ] [ 7 ]
												 *  
												 *  k = 8	 i = 4   j = 4
												 *  if L[i] <= R[j]
												 *  if  6	<=	oo      =  TRUE
												 *  else	array[7] = R[3]
												 *  i++ = 5
												 *  k++ = 9
												 *  
												 *  k=9
												 *  END LOOP
												 */
			
			
			
			
			

	
	/*
	 * n: the size of the output array
	 * k: the maximum value in the array
	 */
	@SuppressWarnings("deprecation")
	public static int[] generate_random_array (int n, int k) {
		List<Integer> list;
		int[] array;
		Random rnd;
		
		rnd = new Random(System.currentTimeMillis());
		
		list = new ArrayList<Integer> ();
		for (int i = 1; i <= n; i++) 
			list.add(new Integer(rnd.nextInt(k+1)));
		
		Collections.shuffle(list, rnd);
		
		array = new int[n];
		for (int i = 0; i < n; i++) 
			array[i] = list.get(i).intValue();
		
		return array;
	}
	
	/*
	 * n: the size of the output array
	 */
	@SuppressWarnings("deprecation")
	public static int[] generate_random_array (int n) {
		List<Integer> list;
		int[] array;
		
		list = new ArrayList<Integer> ();
		for (int i = 1; i <= n; i++) 
			list.add(new Integer(i));
		
		Collections.shuffle(list, new Random(System.currentTimeMillis()));
		
		array = new int[n];
		for (int i = 0; i < n; i++) 
			array[i] = list.get(i).intValue();
		
		return array;
	}
	
	/*
	 * Input: an integer array
	 * Output: true if the array is ascending sorted, otherwise return false
	 */
	public static boolean check_sorted (int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i-1] > array[i])
				return false;
		}
		return true;
	}
	
	public static void print_array (int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + ", ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i = 1; i<170; i++) {
			System.out.print(i+",");
		}
		System.out.println("Merge sort starts ------------------");
		for (int n = 100000; n <= 1000000; n=n+100000) {
			int[] array = Merge_Sort.generate_random_array(n);
			//Sort.print_array(array);
			long t1 = System.currentTimeMillis();
			array = Merge_Sort.merge_sort(array, 0, n-1);
			long t2 = System.currentTimeMillis();
			long t = t2 - t1;
			//Sort.print_array(array);
			boolean flag = Merge_Sort.check_sorted(array);
			System.out.println(n + "," + t + "," + flag);
			//Merge_Sort.print_array(array);
			//Merge_Sort.print_array(array);

		}
		System.out.println("Merge sort ends ------------------");
		
	}

}

/*
 * 
 */


