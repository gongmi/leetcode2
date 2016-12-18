package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation_150 {
//	Attention！！！Attention
//	String的相等！！不能用==
	public int evalRPN(String[] tokens) {
		int left, right, val = 0;
		Stack<Integer> stack = new Stack<>();
		for (String s : tokens) {
//			if (s == "+" || s == "-" || s == "*" || s == "/") {
			if ("+-*/".contains(s)) {	
				right = stack.pop();
				left = stack.pop();
				switch (s) {
				case "+":
					val = left + right;
					break;
				case "-":
					val = left - right;
					break;
				case "*":
					val = left * right;
					break;
				case "/":
					val = left / right;
					break;
				}
				stack.push(val);
			} else
				stack.push(Integer.parseInt(s));

		}

		return stack.pop();
	}
}
