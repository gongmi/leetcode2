package twoPointers;

import java.util.*;

public class FindAllNumbersDisappeared_448 {
	// 取反法 与top答案一样

	public List<Integer> findDisappearedNumbers(int[] nums) {
		LinkedList<Integer> res = new LinkedList<Integer>();
		for (int num : nums) {
			num = Math.abs(num) - 1;// 因为是从1到n的数字 所以要先减1 来满足数组index从0到n-1
			if (nums[num] > 0) {
				nums[num] = -nums[num];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				res.add(i + 1);
			}
		}
		return res;
	}
}
