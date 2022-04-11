package quick_count_Sort;

import java.util.*;

public class Quick_Count_Sort {

	
public static int[] quick_sort (int[] A, int p, int r) {
		
	if (p < r) {
		
		int q = partition(A,p,r);
		quick_sort(A,p,q-1);
		quick_sort(A,q+1,r);
	}
	return A;
	
	}
	
public static int partition(int A[], int p, int r) {		
	
	//set x to pivot
	int x = A[r];
	//set i to lowest index - 1
	int i = p-1;											
	
	//for each iteration through sub array
	//swap values less than or equal to pivot
	for (int j=p; j<r; j++) {								
		if (A[j]<=x) {
			i++;
			
			//exchange smaller values to subarray
			int temp = A[i];								 
			A[i] = A[j];
			A[j] = temp;
		}
	}
	//exchange pivot into correct place between subarrays
	int temp = A[i+1];
	A[i+1] = A[r];
	A[r] = temp;
	
	return i+1;
}

	
	public static int[] counting_sort (int[] A, int k) {
		
		int [] B = new int[A.length];
		int [] C = new int[k+1];			

		//initial loop not needed, C[i] starts out as 0
		
		//loop to count how many times a number appears
		for (int j = 0; j < A.length; j++) {
			C[A[j]]++;
		}
		//loop to count how many input elements are less than or equal to i via a running sum
		for (int i = 1; i <= k; i++) {
			C[i]=C[i]+C[i-1];
		}
		
		//loop that inserts each duplicate before its initial placement in array
		for (int j = A.length-1; j >= 0; j--) {

			B[C[A[j]]-1] = A[j];
			C[A[j]] = C[A[j]]-1;
		}
		return B;
		
	}
	
	
	
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
	 * Output: true if the array is acsendingly sorted, otherwise return false
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
		int k = 10000;
		
		System.out.println("Quick sort starts ------------------");
		for (int n = 100000; n <= 1000000; n=n+100000) {
			int[] array = Quick_Count_Sort.generate_random_array(n);
			long t1 = System.currentTimeMillis();
			array = Quick_Count_Sort.quick_sort(array, 0, n-1);
			long t2 = System.currentTimeMillis();
			long t = t2 - t1;
			boolean flag = Quick_Count_Sort.check_sorted(array);
			System.out.println(n + "," + t + "," + flag);
		}
		System.out.println("Quick sort ends ------------------");
		
		System.out.println("Counting sort starts ------------------");
		for (int n = 100000; n <= 1000000; n=n+100000) {
			int[] array = Quick_Count_Sort.generate_random_array(n, k);
			long t1 = System.currentTimeMillis();
			array = Quick_Count_Sort.counting_sort(array, k);
			long t2 = System.currentTimeMillis();
			long t = t2 - t1;
			boolean flag = Quick_Count_Sort.check_sorted(array);
			System.out.println(n + "," + t + "," + flag);
		}
		System.out.println("Counting sort ends ------------------");
	}
}

		

