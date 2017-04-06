package hashTable;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet_380 {
	// �������ͨ��setΨһ��ͬ�ĵط��������random
	// ���Բ�����ԭ����set Ҫ��һ���б�ŵķ�ʽ Ȼ����random����������һ���� ������Ͷ�Ӧ��set�����
	// ���һ�Ҫ�� ɾ getRandom ���� average O(1) time.
	// ����map+list map<num,index> �� index �� list<num>��index��Ӧ
	// ��Ҫ��remove��ʱ�� Ҫ�����һ���滻remove���Ǹ�
	// arraylist 144 ms
	// LinkedList 221 ms
	// ��Ϊtests �� getRandom�õúܶ�
	// list.get(random_index);����LinkedList ����Ҫ������
	// ����insert �� remove ��ʵ����arraylist��˵��������ʱ��
	// ��Ϊinsert�ͼ��ں��� remove������Ҫ����ͨarraylistһ���Ѻ���Ķ���ǰ�ƶ�
	// ֻ��Ҫ�����һ���滻��remove��λ�� ֻ��Ҫ��֤��map�е�entry��Ӧ������ ��˳���޹�

	// ��߻�������list.remove(index); map.remove(key);���Ƿ���element��
	public class RandomizedSet {
		Map<Integer, Integer> map;
		LinkedList<Integer> list;
		int size;

		/** Initialize your data structure here. */
		public RandomizedSet() {
			map = new HashMap<>();
			list = new LinkedList<>();
			size = 0;
		}

		public boolean insert(int val) {
			if (map.containsKey(val))
				return false;
			size = map.size();
			map.put(val, size);
			list.add(val);
			return true;
		}

		public boolean remove(int val) {
			if (!map.containsKey(val))
				return false;
			int index = map.remove(val);
			int last_index = list.size() - 1;
			int last_num = list.remove(last_index);
			if (index != last_index) {
				list.set(index, last_num);// override
				map.put(last_num, index);// override
			}
			return true;
		}

		/** Get a random element from the set. */
		public int getRandom() {
			size = map.size();
			int random_index = new Random().nextInt(size);
			return list.get(random_index);
		}
	}
}
