package hashTable;

import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

//190 ms 我的第一版  我remove后 如果set为空 我没有删 
//那么就会出现判断是否存在时 还要判断set是否为空
// 一定要用ArrayList 不要用LinkedList
public class RandomizedCollection_381 {
	public class RandomizedCollection {
		Map<Integer, LinkedHashSet<Integer>> map;
		ArrayList<Integer> list;

		public RandomizedCollection() {
			map = new HashMap<>();
			list = new ArrayList<>();
		}

		public boolean insert(int val) {
			boolean res;
			LinkedHashSet<Integer> set;
			if (!map.containsKey(val)) {
				set = new LinkedHashSet<Integer>();
				res = true;
			} else {
				set = map.get(val);
				if (set.isEmpty())
					res = true;
				else
					res = false;
			}

			set.add(list.size());
			map.put(val, set);
			list.add(val);
			return res;
		}

		public boolean remove(int val) {
			Set<Integer> removed_set;

			if (!map.containsKey(val))
				return false;

			removed_set = map.get(val);
			if (removed_set.isEmpty())
				return false;

			Iterator<Integer> it = removed_set.iterator();
			int index = it.next();
			removed_set.remove(index);

			int last_index = list.size() - 1;

			if (index != last_index) {
				int last_num = list.get(last_index);
				LinkedHashSet<Integer> replaced_set = map.get(last_num);
				replaced_set.remove(last_index);
				replaced_set.add(index);
				list.set(index, last_num);// override
				map.put(last_num, replaced_set);// override
			}
			list.remove(last_index);
			return true;
		}

		public int getRandom() {
			int random_index = new Random().nextInt(list.size());
			return list.get(random_index);
		}
	}
	//别人的答案和我一样的思想  只是更优化一些他利用了连缀性 比如locs.get(val).iterator().next();
//	这样就少建了很多对象
	public class RandomizedCollection2 {
	    ArrayList<Integer> nums;
		HashMap<Integer, Set<Integer>> locs;
		java.util.Random rand = new java.util.Random();
	    /** Initialize your data structure here. */
	    public RandomizedCollection2() {
	        nums = new ArrayList<Integer>();
		    locs = new HashMap<Integer, Set<Integer>>();
	    }
	    
	    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
	    public boolean insert(int val) {
	        boolean contain = locs.containsKey(val);
		    if ( ! contain ) locs.put( val, new LinkedHashSet<Integer>() ); 
		    locs.get(val).add(nums.size());        
		    nums.add(val);
		    return ! contain ;
	    }
	    
	    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
	    public boolean remove(int val) {
	        boolean contain = locs.containsKey(val);
		    if ( ! contain ) return false;
		    int loc = locs.get(val).iterator().next();
		    locs.get(val).remove(loc);
		    if (loc < nums.size() - 1 ) {
		       int lastone = nums.get( nums.size()-1 );
		       nums.set( loc , lastone );
		       locs.get(lastone).remove( nums.size()-1);
		       locs.get(lastone).add(loc);
		    }
		    nums.remove(nums.size() - 1);
		   
		    if (locs.get(val).isEmpty()) locs.remove(val);
		    return true;
	    }
	    
	    /** Get a random element from the collection. */
	    public int getRandom() {
	        return nums.get( rand.nextInt(nums.size()) );
	    }
	}
}
