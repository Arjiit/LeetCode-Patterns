class subSquareSum {
	/*
	Brute force - O(N^2K^2)

	Below code TC - O(N^2)
	*/
	public int subSquareSum(int[][] matrix, int k) {
		int max = 0;

		for(int i=0; i< matrix.length - k + 1; i++) {
			for(int j=0; j<matrix[0].length - k +1; j++) {
				int sum  = 0;

				for (int p=i; p<i+k;p++){
					for(int q=j; q<j+k;q++){
						sum = sum + matrix[p][q];
					}
				}
				System.out.println(sum);
				max = Math.max(sum, max);
			}
		}
		return max;

	}
	public static void main(String[] args) {
		int mat[n][n] = {{1, 1, 1, 1, 1},
						  {2, 2, 2, 2, 2},
						{3, 3, 3, 3, 3},
						{4, 4, 4, 4, 4},
						{5, 5, 5, 5, 5}}
		int k = 3;
		System.out.println(subSquareSum(mat,k));

	}
}