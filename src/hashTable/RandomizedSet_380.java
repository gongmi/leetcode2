package hashTable;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet_380 {
	// 这个和普通的set唯一不同的地方就是这个random
	// 所以不能用原来的set 要用一个有编号的方式 然后用random函数随机输出一个数 这个数就对应着set里的数
	// 并且还要增 删 getRandom 都是 average O(1) time.
	// 用了map+list map<num,index> 的 index 与 list<num>的index对应
	// 主要是remove的时候 要用最后一个替换remove的那个
	// arraylist 144 ms
	// LinkedList 221 ms
	// 因为tests 中 getRandom用得很多
	// list.get(random_index);对于LinkedList 是需要遍历的
	// 但是insert 和 remove 其实对于arraylist来说都是线性时间
	// 因为insert就加在后面 remove并不需要像普通arraylist一样把后面的都往前移动
	// 只需要把最后一个替换到remove的位置 只需要保证与map中的entry对应就行了 和顺序无关

	// 这边还运用了list.remove(index); map.remove(key);都是返回element的
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
