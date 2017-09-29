package dynamicProgramming;

import java.util.*;

public class FrogJump_403 {
	public boolean canCross(int[] stones) {
		if (stones == null || stones.length == 0)
			return false;
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		for (int stone : stones) {
			map.put(stone, new HashSet<Integer>());
		}
		map.get(0).add(1);
		int last = stones[stones.length - 1];
		for (int i : stones) {
			HashSet<Integer> set = map.get(i);
			for (int step : set) {
				if (step != 0 && map.containsKey(step + i))
					map.get(step + i).addAll(Arrays.asList(step, step - 1, step + 1));
			}
		}
		return map.get(last).size() != 0;
	}
}
