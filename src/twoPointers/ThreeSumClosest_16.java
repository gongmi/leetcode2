package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSumClosest_16 {
	// 与3 sum相同的方法
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int start = 0;
		int end = nums.length - 1;

		int diff = 0;
		int closet = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			start = i + 1;
			end = nums.length - 1;

			while (start < end) {
				diff = nums[start] + nums[end] + nums[i] - target;

				if (diff == 0)
					return target;

				if (Math.abs(diff) < Math.abs(closet - target))
					closet = nums[start] + nums[end] + nums[i];

				if (diff < 0) {
					start++;
					while (start < end && nums[start] == nums[start - 1])
						start++;
				} else {
					end--;
					while (start < end && nums[end] == nums[end + 1])
						end--;
				}

			}
		}
		return closet;
	}
}
