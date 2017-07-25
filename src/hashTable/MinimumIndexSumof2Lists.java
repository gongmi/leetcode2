package hashTable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumof2Lists {
//	和top一样 要注意res.toArray(new String[0]);的运用！
	
	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < list1.length; i++) {
			map.put(list1[i], i);
		}
		int minSum = Integer.MAX_VALUE;
		List<String> res = new LinkedList<>();

		for (int i = 0; i < list2.length; i++) {
			int index = map.getOrDefault(list2[i], -1);
			if (index != -1 && index + i <= minSum) {
				if (index + i < minSum) {
					res.clear();
					minSum = index + i;
				}
				res.add(list2[i]);
			}
		}
		return res.toArray(new String[0]);
	}
}
