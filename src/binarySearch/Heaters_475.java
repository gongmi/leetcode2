package binarySearch;

import java.util.Arrays;

//��ʵ���ֲ��Ҳ����� ������heaters�в���house��λ��  �����ö��ֲ��һ��һЩ
public class Heaters_475 {
	public int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(houses);
		Arrays.sort(heaters);
		int res = 0;
		int distance = 0;
		for (int house : houses) {
			int index = Arrays.binarySearch(heaters, house);
			if (index < 0) {
				index = -(index + 1);
				if (index == 0)
					distance = heaters[index] - house;
				else if (index == heaters.length)
					distance = house - heaters[index - 1];
				else
					distance = Math.min(heaters[index] - house, house - heaters[index - 1]);
				res = Math.max(res, distance);
			}
		}
		return res;
	}
}
