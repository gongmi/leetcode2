package hashTable;

public class PermutationString_567 {
	// 用的滑动窗口 FindAllAnagrams_438
	// 就是求 s2中是否包含s1的anagram
	public boolean checkInclusion(String s1, String s2) {
		int[] freq = new int[256];
		for (int i = 0; i < s1.length(); i++)
			freq[s1.charAt(i)]++;
		int left = 0, right = 0;
		int count = s1.length();
		while (right < s2.length()) {
			if (freq[s2.charAt(right++)]-- > 0)
				count--;
			if (count == 0)
				return true;
			if (right - left < s1.length())
				continue;
			if (freq[s2.charAt(left++)]++ >= 0)
				count++;
		}
		return false;
	}

	// top答案 一样的思想 滑动窗口 窗口大小为len1
	public boolean checkInclusion2(String s1, String s2) {
		int len1 = s1.length(), len2 = s2.length();
		if (len1 > len2)
			return false;

		int[] count = new int[256];
		for (int i = 0; i < len1; i++) {
			count[s1.charAt(i)]++;
			count[s2.charAt(i)]--;
		}
		if (allZero(count))
			return true;

		for (int i = len1; i < len2; i++) {
			count[s2.charAt(i)]--;
			count[s2.charAt(i - len1)]++;
			if (allZero(count))
				return true;
		}

		return false;
	}

	private boolean allZero(int[] count) {
		for (int i = 0; i < 26; i++) {
			if (count[i] != 0)
				return false;
		}
		return true;
	}
}
