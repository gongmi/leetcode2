package hashTable;

import java.util.*;
//�ܼ� ֻҪ��ͨ
//��ʵ������map��¼ÿһ��position �ж��ٷ�϶
//��϶�����Ǹ�����ש���ٵ��Ǹ�
public class BrickWall_554 {
	public int leastBricks(List<List<Integer>> wall) {
		//<position,slot counts>
		HashMap<Integer, Integer> map = new HashMap<>();
		int position = 0;
		for (List<Integer> list : wall) {
			position = 0;
			for (int i = 0; i < list.size() - 1; i++) {
				position += list.get(i);
				map.put(position, map.getOrDefault(position, 0) + 1);
			}
		}
		int maxCount = 0;

		for (int bricks : map.values()) {
			maxCount = Math.max(maxCount, bricks);
		}
		return wall.size() - maxCount;
	}
}
