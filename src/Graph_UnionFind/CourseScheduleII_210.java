package Graph_UnionFind;

import java.util.*;

public class CourseScheduleII_210 {
	// 与CourseSchedule_207差不多 只不过这个要把顺序输出来
	// 构造邻接表 这里与大话数据结构的是反的
	// [1,0]代表1依赖于0 即 对于书上来说是0->1 即完成了0才能完成1
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];
		List<Integer>[] adj = new LinkedList[numCourses];
		int[] InDegree = new int[numCourses];
		for (int i = 0; i < numCourses; i++)
			adj[i] = new LinkedList<Integer>();
		for (int[] edge : prerequisites) {
			adj[edge[1]].add(edge[0]);
			InDegree[edge[0]]++;// 入度
		}
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < numCourses; i++) {
			if (InDegree[i] == 0) {
				s.push(i);
			}
		}
		int count = 0;
		while (!s.isEmpty()) {
			int cur = s.pop();
			res[count++] = cur;
			List<Integer> nexts = adj[cur];

			for (int next : nexts) {
				InDegree[next]--;
				if (InDegree[next] == 0) {
					s.push(next);
				}
			}
		}
		return count == numCourses ? res : new int[0];
	}
}