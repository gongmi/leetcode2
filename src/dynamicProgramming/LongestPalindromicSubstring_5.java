package dynamicProgramming;
//��   SubSequence ������ ������������ͨ��˼· ������ȥѰ��palindrome
//time complexity ��O(n*n)
//����SubSequenceȴ���������ַ���
//��Ϊ��subSequence  ���Բ���j-- k++
//����ֻ�ܶ�סһ�߱���j ��k++
//������ʱ�临�Ӷȿ�����O(n*n*n) ����for
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