package hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {
	// hash ����O(n) 55ms
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

	// sort ����O(nlgn)8ms
	public boolean isAnagram2(String s, String t) {
		char[] s_array = s.toCharArray();
		char[] t_array = t.toCharArray();
		Arrays.sort(s_array);
		Arrays.sort(t_array);
		return Arrays.equals(s_array, t_array);//ע������Ƚ����������Ƿ����
//		������s_array.equals(t_array); ���൱��s_array== t_array
	}

	// 7ms ����O(n) ��ÿ����ĸ��frequency����һ�������� top�𰸶���������� ��Ϊֻ����Сд��ĸ
//	26���ȵ�����Ϳ����� �ò���map
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
