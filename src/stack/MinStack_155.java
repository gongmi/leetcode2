package stack;

import java.util.Stack;

public class MinStack_155 {
	// �ҵķ����Ƚ���ͨ ����һ��stack���min
	public class MinStack {
		Stack<Integer> s, min;

		public MinStack() {
			s = new Stack<>();
			min = new Stack<>();
		}

		public void push(int x) {
			s.push(x);
			if (min.empty())
				min.push(x);
			else
				min.push(Math.min(min.peek(), x));
		}

		public void pop() {
			s.pop();
			min.pop();

		}

		public int top() {
			return s.peek();
		}

		public int getMin() {
			return min.peek();
		}
	}
//	���˵ķ��� ֻ��һ��int ���min  ��pushʱmin���ű�ʱ �Ͱ���һ��minֵҲ����stack�� 
//	
	public class MinStack2 {
	    int min = Integer.MAX_VALUE;
	    Stack<Integer> stack = new Stack<Integer>();
	    public void push(int x) {
	        // only push the old minimum value when the current 
	        // minimum value changes after pushing the new value x
	        if(x <= min){          
	            stack.push(min);
	            min=x;
	        }
	        stack.push(x);
	    }

	    public void pop() {
	        // if pop operation could result in the changing of the current minimum value, 
	        // pop twice and change the current minimum value to the last minimum value.
	        if(stack.pop() == min) min=stack.pop();
	    }

	    public int top() {
	        return stack.peek();
	    }

	    public int getMin() {
	        return min;
	    }
	}
	/**
	 * Your MinStack object will be instantiated and called as such: MinStack
	 * obj = new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */
}
