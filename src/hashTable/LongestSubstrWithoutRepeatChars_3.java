package hashTable;

import java.util.Arrays;

//有tutorial！

public class LongestSubstrWithoutRepeatChars_3 {
	// 标准模板代码 用 count存放重复的char数
	public int lengthOfLongestSubstring(String s) {
		int left = 0, right = 0, count = 0, res = 0;

		int[] freq = new int[256];

		while (right < s.length()) {
			if ((freq[s.charAt(right++)]++) > 0)
				count++;
			while (count > 0) {
				if ((freq[s.charAt(left++)]--) == 2)
					count--;
			}
			res = Math.max(res, right - left);
		}
		return res;
	}

	// 我写的 用 count存放当前不重复的char的数
	public int lengthOfLongestSubstring2(String s) {
		if (s.equals(""))
			return 0;
		int res = Integer.MIN_VALUE;
		int left = 0, right = 0, count = 0, prev = 0;
		int[] freq = new int[256];
		while (right < s.length()) {
			prev = count;
			if ((freq[s.charAt(right++)]++) == 0)
				count++;
			if (right == s.length()) {
				res = Math.max(res, count);
				break;
			}
			while (prev >= count) {
				res = Math.max(res, count);
				if ((freq[s.charAt(left++)]--) != 2)
					count--;
				else
					break;
			}
		}
		return res;
	}

	// 另一种别人的方法 Sliding Window Optimized
	// cache[ ]中存放的是char上一次出现的位置+1
	// i一直往前
	// j在后面
	// 当遇到一个曾经出现过的char时 即cache[char ]>0时
	// j替换为cache[char] 即 char上一次出现的位置的后一个位置
	// 当遇到一个曾经没出现过的char时 即cache[char ]=0时
	// j不动
	// if s[j] have a duplicate in the range [i,j) with index j​′​​,
	// we don't need to increase i little by little.
	// We can skip all the elements in the range [i,j′]
	// and let to be j′+1directly.
	public int lengthOfLongestSubstring3(String s) {
		int res = 0;
		int[] cache = new int[256];
		for (int i = 0, j = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			j = (cache[c] > 0) ? Math.max(j, cache[c]) : j;
			res = Math.max(res, i - j + 1);
			cache[c] = i + 1;
		}
		return res;
	}

	// 我第二次写的代码 和3是一样的思想 只是我的left是他的j
	public int lengthOfLongestSubstring4(String s) {
		int left = -1;
		int[] cache = new int[256];
		Arrays.fill(cache, -1);
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			left = Math.max(cache[c], left);
			int len = i - left;
			res = Math.max(res, len);
			cache[c] = i;
		}
		return res;
	}
}
