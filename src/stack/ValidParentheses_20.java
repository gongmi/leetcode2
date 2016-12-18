package stack;

import java.util.Stack;

public class ValidParentheses_20 {
	// 别人的高级代码
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}


	// 我的 7ms
	public boolean isValid3(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (stack.empty()) {
				if (ch == ']' || ch == '}' || ch == ')')
					return false;
				else
					stack.push(ch);
			} else {
				if (ch == '[' || ch == '{' || ch == '(')
					stack.push(ch);
				else if ((ch == ']' && stack.pop() != '[')
						|| (ch == '}' && stack.pop() != '{')
						|| (ch == ')' && stack.pop() != '('))
					return false;
			}
		}
		return stack.empty();
	}
}
