package twoPointers;

import java.util.*;

public class IndexOf_28 {
	// top 只能膜拜
	public int strStr(String haystack, String needle) {
		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length())
					return i;
				if (i + j == haystack.length())
					return -1;
				if (needle.charAt(j) != haystack.charAt(i + j))
					break;
			}
		}
	}

	// 我的第一版
	public int strStr2(String haystack, String needle) {
		if (needle.equals(""))
			return 0;
		int i = 0, j = 0;
		int prev = 0;
		while (i < haystack.length()) {
			while (haystack.charAt(i) == needle.charAt(j)) {
				if (j == 0)
					prev = i;
				j++;
				i++;
				if (j == needle.length())
					return prev;
				if (i == haystack.length())
					return -1;
			}
			if (j == 0)
				i++;
			else
				i = prev + 1;
			j = 0;
		}
		return -1;
	}

	// 第二版答案 在看了大话数据结构之后
	public int strStr3(String haystack, String needle) {
		int i = 0, j = 0;
		while (i < haystack.length() && j < needle.length()) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				j++;
				i++;
			} else {
				i = i - j + 1;
				j = 0;
			}
		}
		if (j == needle.length())
			return i - needle.length();
		else
			return -1;
	}

	// KMP
//但是用kmp跑出来的时间比上面的brute更长 可能是测试用例的原因吧 
	public int strStr4(String haystack, String needle) {
		if (needle.equals(""))
			return 0;
		int i = 0, j = 0;
		int[] next = get_next(needle);
		while (i < haystack.length() && j < needle.length()) {
			if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
				j++;
				i++;
			} else
				j = next[j];
		}
		if (j == needle.length())
			return i - needle.length();
		else
			return -1;
	}

	public int[] get_next(String T) {
		int len = T.length();
		int[] next = new int[len];

		int i = 0, j = -1;
		next[0] = -1;
		while (i + 1 < len) {
			if (j == -1 || T.charAt(i) == T.charAt(j)) {
				i++;
				j++;
				next[i] = j;
			} else
				j = next[j];
		}
		return next;

	}

	public int[] get_nextval(String T) {
		int len = T.length();
		int[] nextval = new int[len];

		int i = 0, j = -1;
		nextval[0] = -1;
		while (i + 1 < len) {
			if (j == -1 || T.charAt(i) == T.charAt(j)) {
				i++;
				j++;
				if (T.charAt(i) != T.charAt(j))
					nextval[i] = j;
				else
					nextval[i] = nextval[j];
			} else
				j = nextval[j];
		}
		return nextval;

	}
}
