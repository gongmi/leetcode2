package twoPointers;

public class ValidPalindrome_125 {
	// 我的最原始答案
	public boolean isPalindrome(String s) {

		int len = s.length();
		int i = 0, j = len - 1;

		while (i < j) {
			if (!isalphanumeric(s.charAt(i))) {
				i++;
				continue;
			}
			if (!isalphanumeric(s.charAt(j))) {
				j--;
				continue;
			}

			if (Character.toLowerCase(s.charAt(i)) != (Character.toLowerCase(s.charAt(j))))
				return false;
			else {
				i++;
				j--;
			}
		}
		return true;

	}

	public boolean isalphanumeric(char c) { // Character 的自带函数isLetterOrDigit
		if ((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A') || (c <= '9' && c >= '0'))
			return true;
		else
			return false;
	}
}
