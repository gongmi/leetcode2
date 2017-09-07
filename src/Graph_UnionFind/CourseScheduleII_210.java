package Graph_UnionFind;

import java.util.*;

public class CourseScheduleII_210 {
	// ��CourseSchedule_207��� ֻ�������Ҫ��˳�������
	// �����ڽӱ� ����������ݽṹ���Ƿ���
	// [1,0]����1������0 �� ����������˵��0->1 �������0�������1
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];
		List<Integer>[] adj = new LinkedList[numCourses];
		int[] InDegree = new int[numCourses];
		for (int i = 0; i < numCourses; i++)
			adj[i] = new LinkedList<Integer>();
		for (int[] edge : prerequisites) {
			adj[edge[1]].add(edge[0]);
			InDegree[edge[0]]++;// ���
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