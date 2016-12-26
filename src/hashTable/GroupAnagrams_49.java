package hashTable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {
	// 先把string -> array<char> 然后sort 时间复杂度O（nlgn）
	
	// 然后把sort后的 array<char> -> string
	//	此处可以用两种方法1 Arrays.toString 2 String.valueOf
	
	// 然后 Map<String, List<String>>
//	最后返回的结果
//	LinkedList<List<String>>(map.values());
//	也就是说LinkedList(Collection<? extends E> c)
//	list的构造可以把任何Collection的放进去 （除了map以外都是collection）
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] s_array = s.toCharArray();
			Arrays.sort(s_array);
			String s_sorted = Arrays.toString(s_array);
			if (map.containsKey(s_sorted))
				map.get(s_sorted).add(s);
			else {
				List<String> list = new LinkedList<>();
				list.add(s);
				map.put(s_sorted, list);
			}
		}
		List<List<String>> res = new LinkedList<>();

		for (List<String> list : map.values())
			res.add(list);

		return res;
	}

	// 看了 top答案 后 把 上面的upgrade

	public List<List<String>> groupAnagrams2(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] s_array = s.toCharArray();
			Arrays.sort(s_array);
			String s_sorted = String.valueOf(s_array);
			if (!map.containsKey(s_sorted))
				map.put(s_sorted, new LinkedList<String>());
			map.get(s_sorted).add(s);
		}
		return new LinkedList<List<String>>(map.values());
	}
}
