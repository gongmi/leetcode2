package stack;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ImplementStackByQueues_225 {
//	�ҵķ��� ÿ��push��Ҫ����һ�� 
	class MyStack {
		   Queue<Integer> q =new ArrayDeque<>(); 
		   Queue<Integer> temp =new ArrayDeque<>(); 
		    // Push element x onto stack.
		    public void push(int x) {
		        while(!q.isEmpty())
		        temp.add(q.poll());
		        
		        q.add(x);
		        
		     while(!temp.isEmpty())
		        q.add(temp.poll());
		    }

		    // Removes the element on top of the stack.
		    public void pop() {
		        q.poll();
		    }

		    // Get the top element.
		    public int top() {
		        return q.peek();
		    }

		    // Return whether the stack is empty.
		    public boolean empty() {
		      return  q.isEmpty();
		    }
		}
//	��ʵֻҪһ��queue�Ϳ����� ���ұ��˵�queue������linkedlistʵ�ֵ�
	class MyStack2 {

	    private Queue<Integer> queue = new LinkedList<>();

	    public void push(int x) {
	        queue.add(x);
	        for (int i=1; i<queue.size(); i++)
	            queue.add(queue.remove());
	    }

	    public void pop() {
	        queue.remove();
	    }

	    public int top() {
	        return queue.peek();
	    }

	    public boolean empty() {
	        return queue.isEmpty();
	    }
	}
}
