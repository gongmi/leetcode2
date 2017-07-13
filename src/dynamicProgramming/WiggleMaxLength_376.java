package dynamicProgramming;

//
public class WiggleMaxLength_376 {
	// 第一版 思路清晰的 就是代码太冗长 但是时间是0ms O(n) time
	// public int wiggleMaxLength(int[] nums) {
	// if (nums.length<2) return nums.length;
	// int length = 1;
	// boolean flag = true;
	// int current = nums[0];
	// int k = 0;
	// for (int i = 1; i < nums.length; i++) {
	// if (nums[i] != current) {
	// if (nums[i] > current)
	// flag = true;
	// else
	// flag = false;
	// current = nums[i];
	// length++;
	// k = i;
	// break;
	// }
	//
	// }
	// for (int i = k + 1; i < nums.length; i++) {
	// if (flag) {
	// if (nums[i] < current) {
	// length++;
	// flag = false;
	// }
	// } else {
	// if (nums[i] > current) {
	// length++;
	// flag = true;
	// }
	// }
	// current = nums[i];
	// }
	// return length;
	//
	// }
	// 优化后的代码
	public int wiggleMaxLength(int[] nums) {
		if (nums.length < 2)
			return nums.length;
		int length = 1;
		int i = 1;
		while (i < nums.length && nums[i] == nums[0])
			i++; // 找到第二个数的位置 為i
		if (i == nums.length)
			return 1;
		length++;
		int previous = nums[i - 1];
		int current = nums[i];
		for (int j = i; j < nums.length; j++) {// 从i+1开始找
			if (((current - previous) * (nums[j] - current)) < 0) {
				previous = current;
				length++;
			}
			current = nums[j];
		}
		return length;
	}

	// 第二次做的答案 没有讨论开头 用 Integer.MAX_VALUE 在for循环里面包括开头
	// 模板与IncreasingTripletSubsequence_334相似 只用两个变量就可以了
	public int wiggleMaxLength2(int[] nums) {
		int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
		int len = 0;
		for (int num : nums) {
			if (first == Integer.MAX_VALUE) {
				first = num;
				len++;
			} else if (second == Integer.MAX_VALUE) {
				if (num != first) {
					second = num;
					len++;
				}
			} else {
				if ((second - first) * (num - second) < 0) {//当满足wiggle时
					first = second;
					len++;
				}
				second = num;//任何情况下都要替换second  当满足wiggle时 当不满足当满足wiggle时 也要 替换来增大以后的概率哦
			}
		}
		return len;
	}

}
