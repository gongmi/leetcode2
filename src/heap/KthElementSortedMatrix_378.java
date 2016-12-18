package heap;

import java.util.PriorityQueue;

public class KthElementSortedMatrix_378 {
	// top答案   110ms PriorityQueue的构造函数中写上comparator
	
	// 27 ms compareTo写在类中  
	public int kthSmallest(int[][] matrix, int k) {
	        int n=matrix.length;
	        PriorityQueue<Tuple> pq=new  PriorityQueue<>();
	        for(int i=0;i<n;i++)
	        pq.offer(new Tuple(0,i,matrix[0][i]));
	        
	        for(int i=0;i<k-1;i++)
	        { Tuple tuple=pq.poll();
	         if (tuple.x==n-1) continue;
	         pq.offer(new Tuple(tuple.x+1,tuple.y,matrix[tuple.x+1][tuple.y]));
	        }
	        
	        return pq.poll().val;
	        
	    }
}

class Tuple implements Comparable<Tuple> {
	int x, y, val;

	public Tuple(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}

	@Override
	public int compareTo(Tuple t) {
		// TODO Auto-generated method stub
		return this.val - t.val;
	}
}
