package stack;

import java.util.*;

public class BasicCalculatorII_227 {
	public int calculate(String s) {
		ArrayList<String> list = new ArrayList<>();
		int preIdx = -1;
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '+'
					|| s.charAt(i) == '-') {
				String num = s.substring(preIdx + 1, i).trim();
				if (!num.equals(""))
					list.add(num);
				list.add(s.charAt(i) + "");
				preIdx = i;
			}
		list.add(s.substring(preIdx + 1, s.length()).trim());
		ArrayList<String> temp = new ArrayList<>();
		int i = 0;
		while (i < list.size()) {
			String str = list.get(i);
			int last = temp.size() - 1;
			if ("*/".contains(str)) {
				int left = Integer.parseInt(temp.get(last));
				int right = Integer.parseInt(list.get(i + 1));
				if (str.equals("*"))
					temp.set(last, left * right + "");
				if (str.equals("/"))
					temp.set(last, left / right + "");
				i = i + 2;
			} else {
				temp.add(str);
				i++;
			}
		}
		int res = 0;
		int sign = 1;
		for (String string : temp) {
			if ("+-".contains(string)) {
				sign = string.equals("+") ? 1 : -1;
			} else {
				res += sign * Integer.parseInt(string);
			}
		}
		return res;
	}

	// top答案 它没有进行s的处理 要注意Character.isDigit(c)的使用！！
	public int calculate2(String s) {
		int len;
		if (s == null || (len = s.length()) == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int num = 0;
		char op = '+';
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(s.charAt(i))) {
				num = num * 10 + s.charAt(i) - '0';
			}
			// 如果当前是操作符 则计算上一个操作符 然后把当前操作符用op存放 用于下一次计算
			if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
				if (op == '-') {
					stack.push(-num);
				}
				if (op == '+') {
					stack.push(num);
				}
				if (op == '*') {
					stack.push(stack.pop() * num);
				}
				if (op == '/') {
					stack.push(stack.pop() / num);
				}
				op = s.charAt(i);
				num = 0;
			}
		}

		int re = 0;
		for (int i : stack) {
			re += i;
		}
		return re;
	}
}
