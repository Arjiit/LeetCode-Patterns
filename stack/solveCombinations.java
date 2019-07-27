public class Solution {
	static List<List> solve(int capacity, List<List> foregroundAppList, List<List> backgroundAppList) {
		Map<Integer, List<List>> map = new HashMap<>();
		int maxSum = 0;

		for (List f: foregroundAppList) {
			for (List b: backgroundAppList) {
				int m1 = f.get(1);
				int m2 = f.get(1);

				if (sum <= capacity && sum >= maxSum) {
					List<List<Integer>> temp = new ArrayList<List<Integer>>();
					List<Integer> ltemp = new ArrayList<>();
					ltemp.add(0, f.get(0));
					ltemp.add(1, b.get(0));
					temp.add(ltemp);

				if (map.containsKey(sum)) {
					map.put(sum, temp);
				} else {
					List<List> list = map.get(sum);
					list.add(ltemp)
				}
				maxSum = sum;
			}
		}
	}
	return map.get(maxSum);
}

}

public class Solution {
	static List<List> solve(int capacity, List<List> foregroundAppList, List<List> backgroundAppList) {
		PriorityQueue<List> pq = new PriorityQueue<>((a, b) -> a.get(2) - b.get(2));

		for (List<Integer> b: backgroundAppList) {
			for (List<Integer> f: foregroundAppList) {
				int diff = f.get(1) - b.get(1);
				List<Integer> list = new ArrayList<>();
				list.add(b.get(0));
				list.add(f.get(1));
				list.add(diff);
			}
		}	
		List<List<Integer>> res = new ArrayList<>();

		while(!pq.isEmpty()) {
			List<Integer> k = pq.poll();

			if (k.get(2) < 0) {
				continue;
			} else if (k.get(2) == 0) {
				k.remove(2);
				res.add(k);
			} else if (res.size() == 0) {
				k.remove(2);
				res.add(k);
				break;
			}
		}
		return res;
	}
}
