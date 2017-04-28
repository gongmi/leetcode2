package twoPointers;

import java.util.*;

public class ThreeSum_15 {
	// 类似于TwoSumII_167 的2pointer 方法
	// 就是把target换成了这个数组里的每个元素 时间复杂度O（n*n）
	// 很慢
	public List<List<Integer>> threeSum(int[] nums) {
		int[] sorted_nums = nums;
		Arrays.sort(sorted_nums);

		// 这里换成了arraylist才能通过 因为原来的linkedlist 超时 contains函数是很慢的 array可以用二分法
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int start = 0;
		int end = nums.length - 1;
		for (int i = 0; i < nums.length; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			start = i + 1;
			end = nums.length - 1;
			while (start < end) {

				if (nums[start] + nums[end] + nums[i] < 0) {
					while (start < end && nums[start] == nums[start + 1])
						start++;// while循环把用过的重复的去掉了
					start++;
				} else if (nums[start] + nums[end] + nums[i] > 0) {
					while (start < end && nums[end] == nums[end - 1])
						end--; // while循环把用过的重复的去掉了
					end--;
				} else {
					// List<Integer> list=new LinkedList<Integer>();
					// list.add(sorted_nums[i]);
					// list.add(sorted_nums[start]);
					// list.add(sorted_nums[end]);
					// if (!res.contains(list))
					// res.add(list);
					res.add(Arrays.asList(nums[i], nums[start], nums[end]));
					start++;
					end--;
					// 把上面的改成下面的快多了 while循环把重复的去掉了 就不用判断contains了
					while (start < end && nums[start] == nums[start - 1])
						start++;
					while (start < end && nums[end] == nums[end + 1])
						end--;
				}
			}
		}
		return res;
	}

	// 我的第二版答案 用set 不用list 这样就不用去重了
	public List<List<Integer>> threeSum2(int[] nums) {
		Set<List<Integer>> set = new HashSet<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				if (nums[i] + nums[j] + nums[k] < 0)
					j++;
				else if (nums[i] + nums[j] + nums[k] > 0)
					k--;
				else {
					set.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
				}
			}
		}
		return new ArrayList<List<Integer>>(set);

	}
}
