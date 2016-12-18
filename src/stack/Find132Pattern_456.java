package stack;

import java.util.Stack;
//The idea is that we can use a stack to keep track of previous min-max intervals.
//Here is the principle to maintain the stack:
//For each number num in the array
//If stack is empty:
//    push a new Pair of num into stack
//If stack is not empty:
//
//    if num < stack.peek().min, push a new Pair of num into stack
//
//    if num >= stack.peek().min, we first pop() out the peek element, denoted as last
//
//        if num < last.max, we are done, return true;
//
//        if num >= last.max, we merge num into last, which means last.max = num.
//        Once we update last, if stack is empty, we just push back last.
//        However, the crucial part is:
//        If stack is not empty, the updated last might:
//           1 Entirely covered stack.peek(), i.e. last.min < stack.peek().min (which is always true) && last.max >= stack.peek().max, in which case we keep popping out stack.peek().
//           2 Form a 1-3-2 pattern, we are done ,return true
//           3 at the left of stack.peek() i.e. last.max < stack.peek().min 

class Pair {
	int min, max;

	public Pair(int min, int max) {
		this.min = min;
		this.max = max;
	}
}

public class Find132Pattern_456 {
	public boolean find132pattern(int[] nums) {
		Stack<Pair> stack = new Stack<>();
		Pair current;
		for (int n : nums) {
			if (stack.empty() || n < stack.peek().min)
				stack.push(new Pair(n, n));
			else {
				current = stack.peek();
				while (!stack.empty() && n >= stack.peek().max)
					stack.pop();
				if (!stack.empty() && n > stack.peek().min)
					return true;
				stack.push(new Pair(current.min, n));
			}
		}
		return false;
	}
//	更简单的方法 
	// push aj before ai (i < j, ai < aj)
	public boolean find132pattern2(int[] nums) {
		Stack<Integer> stack = new Stack<>(); 
		int min = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num <= min) {
				min = num;
			} else {
				while (!stack.empty()) {
					if (stack.peek() >= num) //min >= num
						break;
					stack.pop();
					if (stack.pop() > num)  //max >= num
						return true;
				}
				stack.push(num);
				stack.push(min);
			}
		}
		return false;
	}
}
