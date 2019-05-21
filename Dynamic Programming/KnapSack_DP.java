import java.util.*;

public class Knapsack_DP {
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	static int knapSack(int W, int wt[], int val[], int n) {
		int i, w;
		int [][]K = new int[n+1][W+1];

		/*
		Subproblem - For a given weight, how much max value can we get.
		Brute force - Subsets - complete search - all of the subset - would take 2^n time.
		At each stage, each of the cell represents a subproblem. We start from bottom and work
		our way upwards.
		At each stage, we have 2 choices - either to not use the item (take the value from row above it) or 
	    use the ith item - (v[i-1][W - wi] + Vi)
		*/

		for (i=0;i<=n;i++){
			for (w=0; w<=W;w++){
				if (i==0 || w==0) {
					K[i][w] = 0;
				} else if (w - wt[i-1] >= 0) {
					K[i][w] = max(val[i-1] + K[i-1][w- wt[i-1]], K[i-1][w]);
				} else {
					K[i][w] = K[i-1][w];
				}
			}
		}
		return K[n][W];
	}

	public static void main(String args[]) {
 		Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        int n = sc.nextInt();
        System.out.println("Enter the items weights: ");
        int []wt = new int[n];
        for(int i=0; i<n; i++)
            wt[i] = sc.nextInt();
 
        System.out.println("Enter the items values: ");
        int []val = new int[n];
        for(int i=0; i<n; i++)
            val[i] = sc.nextInt();
 
        System.out.println("Enter the maximum capacity: ");
        int W = sc.nextInt();
 
        System.out.println("The maximum value that can be put in a knapsack of capacity W is: " + knapSack(W, wt, val, n));
        sc.close();
	}
}