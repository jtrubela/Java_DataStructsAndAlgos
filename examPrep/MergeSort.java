package examPrep;


public class MergeSort {
	private static int count = 1;

	public static int[] merge_sort (int[] array, int p, int r) {

		if (p < r) {
			System.out.println(array.length);

			int q = (int) Math.floor((p+r)/2);
			System.out.println(q);
			merge_sort(array,p,q);
			merge_sort(array,q+1,r);
			Merge(array,p,q,r);
		}

		else if (p==r) {
			//print("-------------------------------\n");
			//print("p:" + p + " = " + "r:"+r + ": continuing\n");
			//print("-------------------------------\n");

		}

		return array;
	}

	public static void Merge(int[] array, int p, int q, int r) { 
		//print("***********Split start**************");
		print("Starting Array:   ");
		print_array(array);
		print("***********************************\n");
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
		//print("**********Split finish**************\n");


		
		int i = 0;
		int j = 0;


		for(int k = p; k<=r; k++) {
			if(count <= 9) {
			print("iteration(0"+count+"):    ");
			print_array(array);
			}
			else {
				print("iteration("+count+"):    ");
				print_array(array);
			}
			if (L[i] <= R[j]) {	
//				print("L[i]<=R[j]\nExchange happening\n");
//				print("---------------------------------");
//				print("\nIteration:" + count 
//									+ " ~ p:" +p
//									+";q:"+q
//									+";r:"+r
//									+";i:"+i
//									+";j:"+j+"\n");
//				print("---------------------------------");
				array[k] = L[i];
				i++;
				count++;
			}			
			else {	
//				print("L[i]>R[j]\n");
//				print("---------------------------------");
//				print("\nIteration:" + count 
//									+ " ~ p:" +p
//									+";q:"+q
//									+";r:"+r
//									+";i:"+i
//									+";j:"+j+"\n");
//				print("---------------------------------");
				array[k] = R[j];
				j++;
				count++;
			}
			


//			print("\nA Array: -- ");
//			print_array(array);
//			print("\nL Array: -- ");
//			print_array(L);
//			print("\nR Array: -- ");
//			print_array(R);
		}
		print("***********************************\n");


	}
	public static void print(String string) {
		System.out.print(string);
	}

	public static void print_array (int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + ",");
		System.out.println("");
	}

	public static void main(String[] args) {
		int[] array = {9,6,4,6,8,6,2,9};


		int n = array.length;

		array = merge_sort(array, 0, n-1);
		print("Finish Array:   ");
		print_array(array);
	}
}
