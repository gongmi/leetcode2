package greedy;

import java.util.Stack;

public class RemoveDuplicateLetters_316 {
	public String removeDuplicateLetters(String s) {
		if (s.equals("") || s.length() == 1)
			return s;
		int[] freq = new int[26];
		char[] a = s.toCharArray();
		boolean[] visited = new boolean[26];
		for (char c : a) {
			freq[c - 'a']++;
		}
		Stack<Character> stack = new Stack<>();
		for (char c : a) {
			freq[c - 'a']--;
			if (visited[c - 'a'])
				continue;
			while (!stack.isEmpty() && c <= stack.peek() && freq[stack.peek() - 'a'] > 0) {
				visited[stack.pop() - 'a'] = false;
			}
			stack.push(c);
			visited[c - 'a'] = true;
		}
		String res = "";
		for (char c : stack) {
			res = res + c;
		}
		return res;
	}

	// 递归 每一次找最小的char 当遇到某一个char freq减为0的时候停止
	public String removeDuplicateLetters2(String s) {
		if (s.equals("") || s.length() == 1)
			return s;
		int[] freq = new int[26];
		char[] a = s.toCharArray();
		for (char c : a) {
			freq[c - 'a']++;
		}
		int min = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < a[min])
				min = i;
			if (--freq[a[i] - 'a'] == 0) {
				break;
			}
		}
		return a[min] + removeDuplicateLetters(s.substring(min + 1).replace(a[min] + "", ""));
	}
}
