package hashTable;

import java.util.*;

public class LRU_Cache_146 {

	// ��һ��𰸳�ʱ�� ��Ϊ list.remove(new Integer(key));
	// �������O(1)�� ���Ҫ�����Ĳ���
	// �������������Ӧ������ Ӧ���ǹ��İ�
	LinkedList<Integer> list;
	HashMap<Integer, Integer> map;
	int capacity;

	public LRU_Cache_146(int capacity) {
		list = new LinkedList<>();
		map = new HashMap<>(capacity);
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			list.remove(new Integer(key));// O(n)�����Ĳ���
			list.addLast(key);
			return map.get(key);
		}
		return -1;
	}

	// putҲ��һ��use ����ҲҪ����list�е�key��λ��
	public void put(int key, int value) {
		if (!map.containsKey(key))// insert
		{
			if (map.size() == capacity) {
				int invalid = list.removeFirst();
				map.remove(invalid);
			}

		} else {
			list.remove(new Integer(key));
		}
		list.addLast(key);
		map.put(key, value);
	}

}

// ����ֱ��ʹ��LinkedHashMap
class LRUCache {
	private LinkedHashMap<Integer, Integer> map;

	public LRUCache(int capacity) {
		map = new myLinkedHashMap<Integer, Integer>(capacity, 0.75f, true, capacity);
	}

	public int get(int key) {
		return map.getOrDefault(key, -1);
	}

	public void set(int key, int value) {
		map.put(key, value);
	}
}

class myLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
	private static final long serialVersionUID = 1L; // �����ϻ��л���

	private final int CAPACITY;

	public myLinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder, int capacity) {
		super(initialCapacity, loadFactor, accessOrder);
		CAPACITY = capacity;
	}

	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > CAPACITY;
	}
}
