package backTracking;

public class RegularExpressionMatching_10 {
	public boolean isMatch(String s, String p) {
		return helper(s, p, 0, 0);
	}

	private boolean helper(String s, String p, int indexS, int indexP) {
		if (indexP >= p.length() && indexS >= s.length())
			return true;
		// pattern先到尾，匹配失败
		if (indexP >= p.length() && indexS != s.length())
			return false;
		char curP = p.charAt(indexP);
		// 模式第2个是*
		if (indexP < p.length() - 1 && p.charAt(indexP + 1) == '*') {
			// 且字符串第1个跟模式第1个匹配,分3种匹配模式
			if (indexS < s.length() && (curP == s.charAt(indexS) || curP == '.'))
				return helper(s, p, indexS + 1, indexP + 2) // 视为模式匹配1个字符
						|| helper(s, p, indexS + 1, indexP) // *匹配1个，再匹配str中的下一个
						|| helper(s, p, indexS, indexP + 2); // 模式后移2，视为x*匹配0个字符
				// 如不匹配，模式后移2位
			else
				return helper(s, p, indexS, indexP + 2);

		}
		// 模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
		if (indexS < s.length() && (curP == s.charAt(indexS) || curP == '.'))
			return helper(s, p, indexS + 1, indexP + 1);
		return false;
	}
}
