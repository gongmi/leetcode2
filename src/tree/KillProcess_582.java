package tree;

import java.util.*;
//���ǽ�ppid->pids �Ž�map��
//Ȼ��ݹ��ɾ��ÿһ��ppid �Լ�ppid��Ӧ��children

public class KillProcess_582 {
	HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
	List<Integer> res = new LinkedList<>();

	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		for (int i = 0; i < pid.size(); i++) {
			map.putIfAbsent(ppid.get(i), new LinkedList<Integer>());
			map.get(ppid.get(i)).add(pid.get(i));
		}
		kill(kill);
		
		return res;
	}

	// �˴��ĵݹ���Ըĳ���queue
	private void kill(int k) {
		res.add(k);
		if (map.get(k) != null) {
			for (int i : map.get(k))
				kill(i);
		}
	}
}
