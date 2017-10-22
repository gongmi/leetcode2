package hashTable;

public class LongestRepeatingCharacterReplacement_424 {
	// 也是滑动窗口
	// 一开始我是在纠结 每个窗口里面怎么求 freq最多的那个char 难道是遍历一遍吗
	// 其实最多的那个char只可能是原来的 最多的那个char和新加入的那个char中比较
	// 而且maxCount只能是递增的 因为maxCount越大 len才可能越大 所以
	// 在后来的窗口中可能会有更小的maxCount 可是不管它了
	public int characterReplacement(String s, int k) {
		int left = 0, right = 0;
		int maxCount = 0;
		int len = 0;
		int[] freq = new int[26];

		for (right = 0; right < s.length(); right++) {
			maxCount = Math.max(maxCount, ++freq[s.charAt(right) - 'A']);
			while (right - left + 1 - maxCount > k)
				freq[s.charAt(left++) - 'A']--;
			len = Math.max(len, right - left + 1);
		}
		return len;
	}
}
