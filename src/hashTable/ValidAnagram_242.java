package hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {
	// hash 理论O(n) 55ms
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++)
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

		for (int i = 0; i < t.length(); i++) {
			if (map.get(t.charAt(i)) == null || map.get(t.charAt(i)) == 0)
				return false;
			else
				map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
		}
		return true;
	}

	// sort 理论O(nlgn)8ms
	public boolean isAnagram2(String s, String t) {
		char[] s_array = s.toCharArray();
		char[] t_array = t.toCharArray();
		Arrays.sort(s_array);
		Arrays.sort(t_array);
		return Arrays.equals(s_array, t_array);//注意这里比较两个数组是否相等
//		不是用s_array.equals(t_array); 这相当于s_array== t_array
	}

	// 7ms 理论O(n) 把每个字母的frequency放在一个数组里 top答案都是这个方法 因为只包含小写字母
//	26长度的数组就可以了 用不着map
	public boolean isAnagram3(String s, String t) {
		if (s.length() != t.length())
			return false;

		int[] freq = new int[26];
		for (int i = 0; i < s.length(); i++) {
			freq[s.charAt(i) - 'a']++;
			freq[t.charAt(i) - 'a']--;
		}

		for (int i : freq)
			if (i != 0)
				return false;

		return true;

	}
}
