package stack;

import java.util.*;

public class BasicCalculator_224 {
	public int calculate(String s) {
		// 我先对s进行了处理 把它变成了 string数组 其中放了 nums与operators
		ArrayList<String> list = new ArrayList<>();
		int preIdx = -1;
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+'
					|| s.charAt(i) == '-') {
				String num = s.substring(preIdx + 1, i).trim();
				if (!num.equals(""))
					list.add(num);
				list.add(s.charAt(i) + "");
				preIdx = i;
			}
		String last = s.substring(preIdx + 1, s.length()).trim();
		if (!last.equals(""))
			list.add(last);
		Stack<Integer> nums = new Stack<>();
		Stack<String> ops = new Stack<>();

		for (String str : list) {
			if (str.equals("(")) {
				ops.push(str);
			} else if (str.equals("+") || str.equals("-") || str.equals(")")) {
				if (!ops.isEmpty() && !ops.peek().equals("(")) {
					calc(ops, nums);
				}
				if (str.equals(")"))
					ops.pop();
				else
					ops.push(str);
			} else {
				nums.push(Integer.parseInt(str));
			}
		}
		if (!ops.isEmpty()) {
			calc(ops, nums);
		}
		return nums.peek();
	}

	private void calc(Stack<String> ops, Stack<Integer> nums) {
		String operator = ops.pop();
		int left, right, val = 0;
		right = nums.pop();
		left = nums.pop();
		if (operator.equals("+"))
			val = left + right;
		else
			val = left - right;
		nums.push(val);
	}

	// top
	public int calculate2(String s) {
		if (s == null)
			return 0;

		int result = 0;
		int sign = 1;
		int num = 0;

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(sign);

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c >= '0' && c <= '9') {
				num = num * 10 + (c - '0');

			} else if (c == '+' || c == '-') {
				result += sign * num;
				sign = stack.peek() * (c == '+' ? 1 : -1);
				num = 0;

			} else if (c == '(') {
				stack.push(sign);

			} else if (c == ')') {
				stack.pop();
			}
		}

		result += sign * num;
		return result;
	}

}
