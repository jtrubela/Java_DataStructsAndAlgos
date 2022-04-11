/*****************************************************************
 * 
 * CSIT212 - LCS.java		Justin Trubela		11/2/21
 * 
 * •Task 1 (100 pts). Implement the LCS length() function 
 * 
 ****************************************************************/

package longestCommonSubsequence;

import java.util.Arrays;

public class LCS {
public static int lcs_length (String X, String Y) {
	

	int [][] B = new int [X.length()][Y.length()];
	int [][] C = new int [X.length()+1][Y.length()+1];
	

	for(int i = 1; i <= X.length(); i++) {
		
		for (int j = 1; j <= Y.length(); j++) {
			
			if(X.charAt(i-1)==Y.charAt(j-1)) {
				
				C[i][j] = C[i-1][j-1]+1;		//grab upper left value and add 1
				B[i-1][j-1] = C[i-1][j-1]+1;	
			}
			
			else if(C[i-1][j] >= C[i][j-1]) {
				
				C[i][j] = C[i-1][j];			//grab value above
				B[i-1][j-1] = C[i-1][j];
			}
			
			else {
				C[i][j] = C[i][j-1];			//grab value left
				B[i-1][j-1] = C[i][j-1];
			}
		}
	}

	
	
	
	
	
	
	
	
	
	System.out.println("-----B array-----");
	for(int i = 0; i<X.length(); i++) {
		System.out.print(" " + X.charAt(i) + " ");
		System.out.print("");
	}
	System.out.println();
	int[][] arrayB = B;
	System.out.println(Arrays.deepToString(arrayB).replace("], ", "]\n"));
	System.out.println("------C array------");
	int[][] arrayC = C;
	System.out.println(Arrays.deepToString(arrayC).replace("], ", "]\n"));

	
	System.out.print("Longest common substring of " + X + " and " + Y + " is of length: ");
	
	
	return B[X.length()-1][Y.length()-1]; 
}
/**
 * @param args
 */
public static void main(String[] args) {
// TODO Auto-generated method stub
System.out.println(LCS.lcs_length("GCCCTAGCG","GCGCAATG"));
System.out.println(LCS.lcs_length("ACCGGTCGAGTGCGCGGAAGCCGGCCGAA", 
"GTCGTTCGGAATGCCGTTGCTCTGTAAA"));
}
}