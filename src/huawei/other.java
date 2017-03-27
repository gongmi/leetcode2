package huawei;

import java.util.ArrayList;
import java.util.Stack;

public class other {
	public Integer calculate(ArrayList<String> postOrder) {
		Stack stack = new Stack();
		for (int i = 0; i < postOrder.size(); i++) {
			if (Character.isDigit(postOrder.get(i).charAt(0))) {
				stack.push(Integer.parseInt(postOrder.get(i)));
			} else {
				Integer back = (Integer) stack.pop();
				Integer front = (Integer) stack.pop();
				Integer res = 0;
				switch (postOrder.get(i).charAt(0)) {
				case '+':
					res = front + back;
					break;
				case '-':
					res = front - back;
					break;
				case '*':
					res = front * back;
					break;
				case '/':
					res = front / back;
					break;
				}
				stack.push(res);
			}
		}
		return (Integer) stack.pop();
	}
}
