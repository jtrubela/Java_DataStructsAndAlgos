package examPrep;

public class QuickSort {

	
public static int[] quick_sort (int[] array, int startIndex, int endIndex) {
		
	if (startIndex < endIndex) {
		print("Starting array:",array);
		//print_array(array);
		print("\nGathering smaller number partition");
		int q = partition(array,startIndex,endIndex);
		quick_sort(array,startIndex,q-1);
		quick_sort(array,q+1,endIndex);
	}

	return array;
	
	}
	
public static int partition(int array[], int startIndex, int endIndex) {		
	int pivot = array[endIndex];	//set pivot
	int i = startIndex-1;			//set i to lowest index - 1
								
	System.out.print("Partition array considered:");
	int tempArray[] = new int[endIndex];
	for (int i1=startIndex; i1<endIndex; i1++) {
		tempArray[i1] = array[i1];
	}
	
	print_array(tempArray);
	
	print(array[endIndex]);
	
	print("\nChoosing Pivot("+pivot+")");

	print_array(array);
	//*************************************************************
	//
	//for each iteration through sub array
	//swap values less than or equal to pivot
	//
	//*************************************************************

	for (int j=startIndex; j<endIndex; j++) {
		print("\n---------------------------------------"
				+"\n\nfinding values <= to current pivot");

		if (array[j]<=pivot) {
			print("value(" + array[j] + ") <= pivot(" + pivot + ") was found "
					+ "\n~adding to smaller partition~\nBefore:");
			print_array(array);

			i++;
			//*************************************************************
			//
			//exchange smaller values to subarray
			//
			//*************************************************************
			
			System.out.print("(exchanging "+array[i]+ "->" +array[j]+")");
			int temp = array[i];		
			array[i] = array[j];
			array[j] = temp;
			
			print("\nAfter:");
			print_array(array);
		}

	}
	//*************************************************************
	
	//exchange pivot into correct place between subarrays
	
	//*************************************************************

	print("\n\n***************************************"
		 +"\nPartition complete\nExchanging/Placing Pivot("+pivot+")->" + array[i+1]
		 +"\n***************************************");

	
	int temp = array[i+1];
	array[i+1] = array[endIndex];
	array[endIndex] = temp;
	
	return i+1;
}
	

	public static void print_array (int[] array) {
		System.out.print("A: ");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + ", ");
	}
	public static void print(String string) {
		System.out.print(string+ "\n");
	}
	public static void print(int integer) {
		System.out.println("" + integer);
	}
	public static void print(String string, int[] array) {
		string = "A: ";
		System.out.println(string);
		for (int i=0; i<array.length;i++) {
			System.out.print(array[i] + ", ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2,8,7,1,3,5,6,4};
		array = quick_sort(array, 0, array.length-1);
		print_array(array);
		print("\n\nArray is sorted\n");

	}
}