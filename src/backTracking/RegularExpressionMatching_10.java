package backTracking;

public class RegularExpressionMatching_10 {
	public boolean isMatch(String s, String p) {
		return helper(s, p, 0, 0);
	}

	private boolean helper(String s, String p, int indexS, int indexP) {
		if (indexP >= p.length() && indexS >= s.length())
			return true;
		// pattern�ȵ�β��ƥ��ʧ��
		if (indexP >= p.length() && indexS != s.length())
			return false;
		char curP = p.charAt(indexP);
		// ģʽ��2����*
		if (indexP < p.length() - 1 && p.charAt(indexP + 1) == '*') {
			// ���ַ�����1����ģʽ��1��ƥ��,��3��ƥ��ģʽ
			if (indexS < s.length() && (curP == s.charAt(indexS) || curP == '.'))
				return helper(s, p, indexS + 1, indexP + 2) // ��Ϊģʽƥ��1���ַ�
						|| helper(s, p, indexS + 1, indexP) // *ƥ��1������ƥ��str�е���һ��
						|| helper(s, p, indexS, indexP + 2); // ģʽ����2����Ϊx*ƥ��0���ַ�
				// �粻ƥ�䣬ģʽ����2λ
			else
				return helper(s, p, indexS, indexP + 2);

		}
		// ģʽ��2������*�����ַ�����1����ģʽ��1��ƥ�䣬�򶼺���1λ������ֱ�ӷ���false
		if (indexS < s.length() && (curP == s.charAt(indexS) || curP == '.'))
			return helper(s, p, indexS + 1, indexP + 1);
		return false;
	}
}
