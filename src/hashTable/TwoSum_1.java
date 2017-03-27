package hashTable;

import java.util.HashMap;
import java.util.Map;
// ��TwoSumII_167��ͬ �����arrayû������ ���Բ��ʺ���two pointer
// ���Ҳ��ܴ�³������  ��Ϊ����� index��û����
// ��hashmap ʱ�临�Ӷ�ֻ��O��n��
// ��Ϊhashmap��put ��containsֻ��ҪO��1��
public class TwoSum_1 {
	    public int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> index = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				if (index.containsKey(target - nums[i]))
					return new int[] { index.get(target - nums[i]), i };
				index.put(nums[i], i);
			}
			return new int[2];
		}
}
