package hashTable;


public class MinimumWindowSubstring_76 {
	// top answer ��template
//	��ʵ���ҵĲ�� ֻ�����õ�while (count == 0) {
//	���ҷ�����if ((freq[s.charAt(right++)]--) > 0)�ĺ���
//	�����������
	public String minWindow(String s, String t) {
		int minStart = 0,minLen = Integer.MAX_VALUE;
		int left = 0, right = 0, count = t.length();
		
		int[] freq = new int[256];
		for (int i = 0; i < t.length(); i++)
			freq[t.charAt(i)]++;

		while (right < s.length()) {
			if ((freq[s.charAt(right++)]--) > 0)
				count--;
			
			while (count == 0) {
				if ((right - left) < minLen) {
					minStart = left;
					minLen = right - left;
				}
				if ((freq[s.charAt(left++)]++) >= 0)
					count++;
			}
		}
		if (minLen != Integer.MAX_VALUE)
			return s.substring(minStart, minStart + minLen);
		return "";
	}

	public String minWindow2(String s, String t) {
		// String res =""; һ��ʼ���õ�������洢���ܵ���Сstring ����������ʱ�� 14ms
		int minStart = 0; // �洢index��ʼλ���� min length ���� 4ms
		int minLen = Integer.MAX_VALUE;
		int[] freq = new int[256];
		for (int i = 0; i < t.length(); i++)
			freq[t.charAt(i)]++;

		int left = 0, right = 0, count = t.length();

		while (right < s.length() + 1) {
			if (count == 0) {
				// if(res==""||(right-left)<res.length())
				// res=s.substring(left,right);
				if ((right - left) < minLen) {
					minStart = left;
					minLen = right - left;
				}
				if ((freq[s.charAt(left)]++) >= 0)
					count++;

				left++;
			} else if (right < s.length()) {
				if ((freq[s.charAt(right)]--) > 0)
					count--;

				right++;
			} else
				break;
		}
		if (minLen != Integer.MAX_VALUE)
			return s.substring(minStart, minStart + minLen);
		return "";
	}
}
