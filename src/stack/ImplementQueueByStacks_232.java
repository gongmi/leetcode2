package stack;

import java.util.Stack;

public class ImplementQueueByStacks_232 {
//	我的方法  只需要修改push
//	 但是push 的时间复杂度是o（n）
	class MyQueue {
		Stack<Integer> s = new Stack<>();

		// Push element x to the back of queue.
		public void push(int x) {
			Stack<Integer> s2 = new Stack<>();

			while (!s.empty())
				s2.push(s.pop());

			s.push(x);

			while (!s2.empty())
				s.push(s2.pop());
		}

		// Removes the element from in front of queue.
		public void pop() {
			s.pop();
		}

		// Get the front element.
		public int peek() {
			return s.peek();
		}

		// Return whether the queue is empty.
		public boolean empty() {
			return s.empty();
		}
	}
//	别人的方法  时间复杂度是o（1） 用两个stack
	class MyQueue2 {

	    Stack<Integer> input = new Stack();
	    Stack<Integer> output = new Stack();
	    
	    public void push(int x) {
	        input.push(x);
	    }

	    public void pop() {
	        peek();
	        output.pop();
	    }

	    public int peek() {
	        if (output.empty())
	            while (!input.empty())
	                output.push(input.pop());
	        return output.peek();
	    }

	    public boolean empty() {
	        return input.empty() && output.empty();
	    }
	}
}
