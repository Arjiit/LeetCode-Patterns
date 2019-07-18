class Solution {
	public int leastInterval(char[] tasks, int n) {
	/*
		We follow a greedy approach by sorting the char count table
		after we have done a task and completed the cooling period.
		Number of iterations will be equal to resultant time O(time).
	*/
	int[] map = new int[26]

	for (int i=0; i<tasks.length; i++){
		map[tasks.charAt(i) - 'A']++;
	}

	Arrays.sort(map);
	int time = 0;

	while(map[25] > 0) {
		int i=0;
		while(i <= n) {
			if (i < 26 && map[25-i] > 0) {
				map[25-i]--;
			}
			i++;
			time++;
		}
		Arrays.sort(map);
	}

	return time;

	}
}