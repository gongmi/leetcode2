package stack;

import java.util.*;

public class Main_test {

	public static void main(String[] args) {
		DecodeString_394 main = new DecodeString_394();
		String res = main.decodeString("2[abc]3[cd]ef");
		System.out.println(res);
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		char[] a = s.toCharArray();
		for (char c : a) {
			switch (c) {
			case '(':
				stack.push(')');
				break;
			case '{':
				stack.push('}');
				break;
			case '[':
				stack.push(']');
				break;
			default:
				if (stack.pop() != c) {
					return false;
				}
			}

		}
		return true;
	}
}
