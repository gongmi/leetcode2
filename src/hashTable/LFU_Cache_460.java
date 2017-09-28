package hashTable;

import java.util.*;

public class LFU_Cache_460 {
	HashMap<Integer, Integer> values = new HashMap<>();// <key,value>
	HashMap<Integer, Integer> counts = new HashMap<>();// <key,count>
	HashMap<Integer, LinkedHashSet<Integer>> keys = new HashMap<>();// <count,Set<key>>
	int min = -1;
	final int CAPACITY;

	public LFU_Cache_460(int capacity) {
		CAPACITY = capacity;
	}

	public int get(int key) {
		if (values.containsKey(key)) {
			increaseCount(key);
			return values.get(key);
		}
		return -1;
	}

	public void put(int key, int value) {
		if (CAPACITY == 0)
			return;
		if (!values.containsKey(key) && values.size() == CAPACITY) {
			removeMin();
		}

		increaseCount(key);
		values.put(key, value);

	}

	private void removeMin() {
		LinkedHashSet<Integer> set = keys.get(min);
		int least = -1;
		for (int i : set) {
			least = i;
			break;
		}
		values.remove(least);
		counts.remove(least);
		set.remove(least);
	}

	private void increaseCount(int key) {
		int count = counts.getOrDefault(key, -1);
		LinkedHashSet<Integer> set = keys.get(count);
		if (set != null)
			set.remove(key);
		if (count <= min && (set == null || set.size() == 0)) {
			min = count + 1;
		}
		counts.put(key, count + 1);
		if (!keys.containsKey(count + 1))
			keys.put(count + 1, new LinkedHashSet<Integer>());
		LinkedHashSet<Integer> set2 = keys.get(count + 1);
		set2.add(key);
	}
}
