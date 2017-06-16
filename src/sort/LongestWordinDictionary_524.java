package sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//我的第一版答案
//我利用了IsSubsequence_392的top答案
//时间复杂度为 n*length
public class LongestWordinDictionary_524 {
	public String findLongestWord(String s, List<String> d) {
		String res = "";
		for (String str : d)
			if (isSubsequence(str, s)) {
				if (str.length() > res.length() || str.length() == res.length()
						&& str.compareTo(res) < 0)
					res = str;
			}
		return res;
	}

	public boolean isSubsequence(String s, String t) {
		if (t.length() < s.length())
			return false;
		int prev = 0;
		for (int i = 0; i < s.length(); i++) {
			char tempChar = s.charAt(i);
			prev = t.indexOf(tempChar, prev);
			if (prev == -1)
				return false;
			prev++;
		}
		return true;
	}

	// 用sort 先把d中的所有单词 按照长度倒序排列
	// 如果长度相等 按照lexicographical顺序排列
	// 然后 再判断有没有subsequence 第一个即为res
	// 可是我认为没有必要sort sort的代价是很大的
	// 因为这里只需要求出最长的那一个 没有必要sort一下吧
	public String findLongestWord2(String s, List<String> d) {
		Collections.sort(d, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length())
					return s1.compareTo(s2);
				return s2.length() - s1.length();
			}
		});
		for (String str : d)
			if (isSubsequence(str, s))
				return str;
		return "";
	}
}
