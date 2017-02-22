package hashTable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {
	// �Ȱ�string -> array<char> Ȼ��sort ʱ�临�Ӷ�O��nlgn��
	
	// Ȼ���sort��� array<char> -> string
	//	�˴����������ַ���1 Arrays.toString 2 String.valueOf
	
	// Ȼ�� Map<String, List<String>>
//	��󷵻صĽ��
//	LinkedList<List<String>>(map.values());
//	Ҳ����˵LinkedList(Collection<? extends E> c)
//	list�Ĺ�����԰��κ�Collection�ķŽ�ȥ ������map���ⶼ��collection��
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

	// ���� top�� �� �� �����upgrade

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