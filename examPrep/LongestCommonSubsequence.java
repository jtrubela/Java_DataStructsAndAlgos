package examPrep;

import longestCommonSubsequence.LCS;

public class LongestCommonSubsequence {


	public static int lcs_length (String X, String Y) {

		int m = X.length();
		int n = Y.length();
		int [][] B = new int [m][m];
		int [][] C = new int [m+1][m+1];

		for (int i = 1; i < X.length(); i++) {
			for (int j = 1; j < Y.length(); j++) {
				if(X.charAt(i-1)==Y.charAt(j-1)) {
					C[i][j] = C[i-1][j-1]+1;
					B[i-1][j-1] = C[i-1][j-1];
				}
				else if(C[i-1][j]>= C[i][j-1]) {
					C[i][j] = C[i-1][j];
					B[i-1][j-1] = C[i-1][j];
				}
				else {
					C[i][j] = C[i][j-1];
					B[i-1][j-1] = C[i][j-1];
				}
			}
		}

		return C[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LCS.lcs_length("GCCCTAGCG","GCGCAATG"));
		System.out.println(LCS.lcs_length("ACCGGTCGAGTGCGCGGAAGCCGGCCGAA", 
				"GTCGTTCGGAATGCCGTTGCTCTGTAAA"));
	}
}



