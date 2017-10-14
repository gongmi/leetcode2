package tree;

import java.util.*;

public class ContainsDuplicateIII_220 {
	// �������ʵ���� ����219. Contains Duplicate II �ı���
	// ֻ��������� ����nums[i] = nums[j]
	// �ǵ����õ���HashSet ��������
	// ����abs(nums[i] -nums[j]) <=t
	// ���� ����TreeSet �������� ��ceiling ��floor��������� ������������

	// ʱ�临�Ӷ� O(NlogK)
	TreeSet<Integer> set = new TreeSet<>();

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		for (int i = 0; i < nums.length; i++) {
			Integer higher = set.ceiling(nums[i]);
			Integer lower = set.floor(nums[i]);
			// Ϊ�˷�ֹ [-1,2147483647] ��������� ������long
			if (higher != null && (long) higher - (long) nums[i] <= t)
				return true;
			if (lower != null && (long) nums[i] - (long) lower <= t)
				return true;
			set.add(nums[i]);
			if (i >= k)
				set.remove(nums[i - k]);
		}
		return false;
	}

	// top�����õ�Ͱ�� ÿ���������� num/t��λ���� ��ӳ�䵽ͬһ��λ�õ�numһ��������Ҫ���
	// �ٿ��� num-1�� num+1��λ���ϵ����������� ����
	public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
		if (k < 1 || t < 0)
			return false;
		Map<Long, Long> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
			long bucket = remappedNum / ((long) t + 1);
			if (map.containsKey(bucket)
					|| (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
					|| (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
				return true;
			if (map.entrySet().size() >= k) {
				long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
				map.remove(lastBucket);
			}
			map.put(bucket, remappedNum);
		}
		return false;
	}
}
