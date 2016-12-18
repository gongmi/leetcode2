package hashTable;

import java.util.HashMap;
import java.util.Map;

public class NumberBoomerangs_447 {
	//��ʵ�ҵ�˼���ǶԵ� ����û�뵽����ֻ��Ҫһ��hashmap�͹��� 
//	ÿ�������˵�һ�������е� pair �Ϳ����������hashmap
//	��Ϊ֮ǰ�뵽���� ���ظ��� i��j �� j��i �����͵��� HashMap����
//	��ʵ�ظ���Ͳ��ظ����ʱ�临�Ӷȶ���O(n^2)
//	n+n-1+n-2+������+1=(1+n)*n/2=O(n^2)
	public int numberOfBoomerangs(int[][] points) {
		int n = points.length;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int result = 0;
		int distance;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) continue; //���ظ���
				distance = (int) (Math.pow((points[i][0] - points[j][0]), 2) + Math
						.pow((points[i][1] - points[j][1]), 2));
				map.put(distance, map.getOrDefault(distance, 0) + 1);
			}

//			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//				int nums = entry.getValue();
//				result = result + nums * (nums - 1);
//			}
			for (int nums : map.values())
				result = result + nums * (nums - 1);
			map.clear();
		}
		return result;
	}

	// ֮ǰ�ķ��� Time Limit Exceeded
	public int numberOfBoomerangs2(int[][] points) {
		int n = points.length;
		HashMap<Integer, Integer>[] map_array = new HashMap[n];
		int result = 0;
		for (int i = 0; i < n; i++)
			map_array[i] = new HashMap<>();
		int distance;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++) { //�����ظ���
				distance = (int) (Math.pow((points[i][0] - points[j][0]), 2) + Math
						.pow((points[i][1] - points[j][1]), 2));
				map_array[i].put(distance,
						map_array[i].getOrDefault(distance, 0) + 1);
				map_array[j].put(distance,
						map_array[j].getOrDefault(distance, 0) + 1);
			}

		for (int i = 0; i < n; i++)
			for (Map.Entry<Integer, Integer> entry : map_array[i].entrySet()) {
				int nums = entry.getValue();
				if (nums >= 2)
					result = result + nums * (nums - 1);
			}
		return result;
	}
}
