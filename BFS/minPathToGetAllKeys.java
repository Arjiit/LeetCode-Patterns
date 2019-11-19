class Solution {
	/*
	We use bits to store the keys found till now. We can move to each cell multiple times, with different number of keys available 
	to us at a particular time. Therefore time complexity - O(mn*2^k) as 2^k is the no. of states possible. K is no. of keys represented
	as bits can be 0/1.
	if we find a key and we want to add that information to already found key.
	keys = keys | (1 << (c - 'a'))

	To check if a key is present 
	(keys >> c-'a')&1 == 1

	To check if keys collected till now is all those are present.
	convert decimal representation 'k' to binary by (1 << k) - 1 and compare with keys. 
	*/
	int[][] dirs = new int[][]{{1,0}, {0,-1}, {-1,0}, {0,1}};
	public int shortestPathAllKeys(String[] grid){
		int m = grid.length;
		int n = grid[0].length();
		int startX = -1;
		int startY = -1;
		int k = 0;
		for (int i=0; i<m; i++){
			for (int j=0; j<n; j++) {
				char c = grid[i].charAt(j);
				if (c == '@') {
					startX = i;
					startY = j;
				}
				if (isKey(c)) {
					k++;
				}
			}
		}
        System.out.println(" key " + k);
		Node start = new Node(startX, startY, 0);
		Queue<Node> q = new LinkedList<>();
		q.offer(start);
		Set<String> visited = new HashSet<>();
		visited.add(startX + " " + startY + " " + 0);
		int level = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i=0; i<size; i++) {
				Node cur = q.poll();
				int res = (1 << k) - 1;
				//System.out.println(res);
				if (cur.keys == (1 << k) - 1) { // for 2 total keys, (1 << 2) - 1 = 4 -1 = 3.
					return level;
				}
				for (int[] d: dirs) {
					int x = cur.i + d[0];
					int y = cur.j + d[1];
					int keys = cur.keys;
                    
					if (!isValid(grid, x, y, m, n)) {
						continue;
					}
					char c = grid[x].charAt(y);
					if (isKey(c)) {
						keys = keys | (1 << (c - 'a')); // for 2 keys, it will look like 11 which is equal to 3.
					}
					if (isLock(c) && (keys >> (c - 'A') & 1) == 0) {
						continue;
					}
					if (visited.add(x + " " + y + " " + keys)) {
						q.offer(new Node(x, y, keys));
					}
				}
			}
			level++;
		}
		return -1;
	}

	public boolean isLock(char c) {
		return c >= 'A' && c <= 'F';
	}

	public boolean isKey(char c) {
		return c >= 'a' && c <= 'f';
	}

	public boolean isValid(String[] grid, int i, int j, int m, int n) {
		return i >= 0 && i < m && j >= 0 && j < n && grid[i].charAt(j) != '#';
	}

	class Node {
		int i, j, keys;
		public Node(int i, int j, int keys) {
			this.i = i;
			this.j = j;
			this.keys = keys;
		}
	}
}