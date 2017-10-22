package dynamicProgramming;

import java.util.HashSet;
//第一版答案 超时 当 input是
//abcdefghijklmnopqrstuvwxyz
//abcdefghijklmnopqrstuvwxyz
//abcdefghijklmnopqrstuvwxyz...
//时间复杂度是O(N*N)

public class UniqueSubstringsInWraparoundString_467 {
	public int findSubstringInWraproundString(String p) {
		if (p == null || p.length() == 0)
			return 0;
		HashSet<String> set = new HashSet<>();
		int start = 0;
		set.add(p.substring(0, 1));
		char[] a = p.toCharArray();
		for (int i = 1; i < p.length(); i++) {
			if (((a[i] + 26) - (a[i - 1] + 1)) % 26 != 0)
				start = i;
			for (int j = start; j <= i; j++) {
				set.add(p.substring(j, i + 1));
			}
		}
		return set.size();
	}

	// 看了top思路之后的答案
	public int findSubstringInWraproundString2(String p) {
		if (p == null || p.length() == 0)
			return 0;
		int[] maxLen = new int[26];

		int start = 0;

		char[] a = p.toCharArray();
		maxLen[a[0] - 'a'] = 1;
		for (int i = 1; i < p.length(); i++) {
			if (((a[i] + 26) - (a[i - 1] + 1)) % 26 != 0)
				start = i;
			maxLen[a[i] - 'a'] = Math.max(maxLen[a[i] - 'a'], i + 1 - start);
		}
		int res = 0;
		for (int i = 0; i < 26; i++)
			res += maxLen[i];
		return res;
	}
}
