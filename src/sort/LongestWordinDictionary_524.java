package sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//�ҵĵ�һ���
//��������IsSubsequence_392��top��
//ʱ�临�Ӷ�Ϊ n*length
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

	// ��sort �Ȱ�d�е����е��� ���ճ��ȵ�������
	// ���������� ����lexicographical˳������
	// Ȼ�� ���ж���û��subsequence ��һ����Ϊres
	// ��������Ϊû�б�Ҫsort sort�Ĵ����Ǻܴ��
	// ��Ϊ����ֻ��Ҫ��������һ�� û�б�Ҫsortһ�°�
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
