package hashTable;

import java.util.*;
//很简单 只要想通
//其实就是用map记录每一个position 有多少缝隙
//缝隙最多的那个就是砖最少的那个
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
