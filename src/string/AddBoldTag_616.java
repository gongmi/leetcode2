package string;

//解法一
//在s中把所有的dict的字符串的left和right找到 组成interval
//然后就是merge Interval了

//解法二
//用一个boolean的数组 标记这个char要不要被bold
//有点类似于火车票 很多站 很多张的问题

//要学会使用startsWith indexOf 等函数

public class AddBoldTag_616 {
	// 以下都是解法2 只是写法稍有不同
	// tutorial
	public String addBoldTag(String s, String[] dict) {
		boolean[] bold = new boolean[s.length()];
		for (String d : dict) {
			for (int i = 0; i <= s.length() - d.length(); i++) {
				if (s.substring(i, i + d.length()).equals(d)) {
					for (int j = i; j < i + d.length(); j++)
						bold[j] = true;
				}
			}
		}
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < s.length();) {
			if (bold[i]) {
				res.append("<b>");
				while (i < s.length() && bold[i])
					res.append(s.charAt(i++));
				res.append("</b>");
			} else
				res.append(s.charAt(i++));
		}
		return res.toString();
	}

	// top
	public String addBoldTag2(String s, String[] dict) {
		boolean[] bold = new boolean[s.length()];
		for (int i = 0, end = 0; i < s.length(); i++) {
			for (String word : dict) {
				if (s.startsWith(word, i)) {
					end = Math.max(end, i + word.length());
				}
			}
			bold[i] = end > i;
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (!bold[i]) {
				result.append(s.charAt(i));
				continue;
			}
			int j = i;
			while (j < s.length() && bold[j])
				j++;
			result.append("<b>" + s.substring(i, j) + "</b>");
			i = j - 1;
		}

		return result.toString();
	}
}
