package Array;

import java.util.Arrays;

public class ArrayNesting_565 {
	// 第一版答案 用一个groups数组来存放当前这个数属于哪个组
	// 最后再统计一下哪个组的个数最多
	public int arrayNesting(int[] nums) {
		int[] groups = new int[nums.length];
		Arrays.fill(groups, -1);
		for (int i = 0; i < nums.length; i++) {
			int idx = i;
			while (groups[idx] == -1) {
				groups[idx] = i;
				idx = nums[idx];
			}
		}
		int[] freq = new int[nums.length];
		int res = 0;
		for (int i : groups) {
			freq[i]++;
			res = Math.max(res, freq[i]);
		}
		return res;
	}

	// 在找下一个时就count
	// 与FindAllDuplicates_442相似 取反
	public int arrayNesting2(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			while (nums[i] != -1) {
				count++;
				int temp = nums[i];
				nums[i] = -1;
				i = temp;

			}
			res = Math.max(res, count);
		}
		return res;
	}
}
