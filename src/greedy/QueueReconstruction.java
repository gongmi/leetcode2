package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
//注意；排序的应用 因为许多insert 所以用linkedlist 
//并且toarray的应用 用 public <T> T[] toArray(T[] a) {
//不能用toArray() 因为返回一个object【】
//并且这里要写明是二维数组


public class QueueReconstruction {
	public int[][] reconstructQueue(int[][] people) {
		//25ms
		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] p1, int[] p2) {
				if (p2[0] == p1[0])
					return p1[1] - p2[1];
				else
					return p2[0] - p1[0];
			}
		});
//		82 ms
//		Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
		LinkedList<int[]> l = new LinkedList<int[]>();
		for (int[] p : people)
			l.add(p[1], p);
		return l.toArray(new int[people.length][]);
//		return l.toArray(new int[0][0]);
//		return (int[][])l.toArray();  

	}
}
