package dynamicProgramming;
//与   SubSequence 的区别 这道题就是最普通的思路 遍历的去寻找palindrome
//time complexity 是O(n*n)
//但是SubSequence却不能用这种方法
//因为是subSequence  所以不能j-- k++
//而是只能定住一边比如j 令k++
//这样的时间复杂度恐怕是O(n*n*n) 三个for
public class LongestPalindromicSubstring_5 {
	private int low = 0, maxLen = 1;

	public String longestPalindrome(String s) {
		int len = s.length();
		if (len <= 1)
			return s;

		for (int i = 0; i < len; i++) {
			extendPalindrome(s, i, i);
			extendPalindrome(s, i, i + 1);
		}
		return s.substring(low, low + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (k - j - 1 > maxLen) {
			maxLen = k - j - 1;
			low = j + 1;
		}

	}
}