package string;

//ע��Character��������кܶ෽�������ã�����
public class ValidPalindrome_125 {
	public boolean isPalindrome(String s) {
		int len = s.length();
		int i = 0, j = len - 1;

		while (i < j) {
			if (!Character.isLetterOrDigit(s.charAt(i))) {
				i++;
				continue;
			}
			if (!Character.isLetterOrDigit(s.charAt(j))) {
				j--;
				continue;
			}

			if (Character.toLowerCase(s.charAt(i++)) != (Character.toLowerCase(s.charAt(j--))))
				return false;
		}
		return true;

	}
}
