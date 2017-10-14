package string;

public class ShortestPalindrome_214 {
	// 第一版答案 过了 但是时间很长
	public String shortestPalindrome(String s) {
		if (s == null)
			return "";
		if (s.length() <= 1)
			return s;
		char[] a = s.toCharArray();
		int max = 0;
		for (int i = a.length - 1; i > 0; i--) {
			if (isPalindrome(a, 0, i)) {
				max = i;
				break;
			}
		}
		StringBuilder sb = new StringBuilder(s.substring(max + 1));
		sb.reverse();
		sb.append(s);
		return sb.toString();
	}

	private boolean isPalindrome(char[] a, int j, int k) {
		while (j < k) {
			if (a[j] != a[k])
				return false;
			j++;
			k--;
		}
		return true;
	}
}
