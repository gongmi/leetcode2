package twoPointers;

import java.util.*;
//与FindDuplicateNumber_287相似 只不过 那个是只需要返回一个
//这里是返回所有的重复的

public class FindAllDuplicates_442 {
	// 剑指offer的交换方法
	public List<Integer> findDuplicates(int[] nums) {
		HashSet<Integer> res = new HashSet<>();
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {
			nums[i]--;
		}
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i) {

				temp = nums[i];
				if (nums[temp] == temp) {
					res.add(temp + 1);
					break;
				}

				nums[i] = nums[temp];
				nums[temp] = temp;
			}
		}
		return new LinkedList<Integer>(res);
	}

	// 取反法 面试宝典p274
	// 因为是从1到n的数字 所以要先减1 来满足数组index从0到n-1
	public List<Integer> findDuplicates2(int[] nums) {
		LinkedList<Integer> res = new LinkedList<Integer>();
		for (int num : nums) {
			num = Math.abs(num) - 1;// 因为是从1到n的数字 所以要先减1 来满足数组index从0到n-1
			if (nums[num] < 0) {
				res.add(num + 1);
			} else {
				nums[num] = -nums[num];
			}
		}
		return res;
	}
}
