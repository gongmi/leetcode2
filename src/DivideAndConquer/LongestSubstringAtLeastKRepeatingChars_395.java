package DivideAndConquer;

import java.util.*;

public class LongestSubstringAtLeastKRepeatingChars_395 {

	public int longestSubstring(String s, int k) {
		if (s == null || s.equals(""))
			return 0;
		int[] freq = new int[26];
		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}
		HashSet<Character> set = new HashSet<>(); // 找到所有不符合atleastk的char 放进去
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (freq[i] > 0 && freq[i] < k) {
				count += freq[i];
				set.add((char) ('a' + i));
			}

		}
		if (set.isEmpty())
			return s.length();
		if (count == s.length())
			return 0;
		LinkedList<String> queue = new LinkedList<>(); // 把s 根据set中的char 分成很多段
		queue.add(s);
		for (char c : set) {

			String[] array = queue.poll().split(c + "");
			queue.addAll(Arrays.asList(array));

		}
		int res = 0;
		for (String str : queue)
			res = Math.max(res, longestSubstring(str, k));
		return res;
	}

	// 看了top后 第二版答案 每次只找出一个不满足的char
	public int longestSubstring2(String s, int k) {
		if (s == null || s.equals(""))
			return 0;
		int[] freq = new int[26];
		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}
		char bad = 0;
		for (int i = 0; i < 26; i++) {
			if (freq[i] > 0 && freq[i] < k) {
				bad = (char) ('a' + i);
				break;
			}
		}
		if (bad == 0)
			return s.length();

		String[] subString = s.split(bad + "");
		int res = 0;
		for (String str : subString)
			res = Math.max(res, longestSubstring(str, k));
		return res;
	}
}