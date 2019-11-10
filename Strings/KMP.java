class KMP {
	

	public boolean patternMatch(String input, String pattern) {
		int[] lps = new int[pattern.length()];

		lps[0] = 0;
		int len = 0;
		int i=1;
		while (i < pattern.length) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len > 0) {
					len = lps[len-1];
				} else {
					lps[i] = len;
					i++;
				}
			}
		}

		int i = 0;
		int j = 0;

		while(i < input.length){
			if (input.charAt(i) == pattern.charAt(j+1)) {
				i++;
				j++;
			} 

			if(j == pattern.length) {
				System.out.println("Found pattern at " + (i-j));
				j = lps[j-1]; // found pattern so reseting j, lps gives us where to start matching from and skipping redundant matching
			} else if (i < N && pattern.charAt(j) != input.charAt(i)) {
				if (j != 0) {
					j = lps[j-1];
				} else {
					i = i+1;
				}
			}
		}
	}

	public static void main(String[] args) {

	}
}