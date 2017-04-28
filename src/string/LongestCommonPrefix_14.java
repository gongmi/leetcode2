package string;

public class LongestCommonPrefix_14 {
	// 我是按照index 来循环 看所有的str 当前这个index一不一样
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0 || strs[0].length() == 0)
			return new String("");
		int i = 0;
		while (i < strs[0].length()) {
			char c = strs[0].charAt(i);
			for (String s : strs)
				if (i == s.length() || s.charAt(i) != c)
					return strs[0].substring(0, i);
			i++;
		}

		return strs[0];
	}
	 // public int indexOf(String substr)
// 返回substr第一次出现的位置！ 如果不存在 返回-1	我觉得这个算法时间复杂度仿佛更高
	public String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0)
			return "";
		String pre = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(pre) != 0)
				pre = pre.substring(0, pre.length() - 1);
		return pre;
	}
}
