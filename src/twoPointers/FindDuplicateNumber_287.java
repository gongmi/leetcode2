package twoPointers;

//方法1
//类似于142. Linked List Cycle II 的思路
//与它的区别在于 那道题不一定有cycle 所以判断条件是
//while (fast != null && fast.next != null) {
//所以是从头开始的
//这道题是从0开始的 并且 一开始slow和fast都走一步
//如果都从0开始就会进不了while
public class FindDuplicateNumber_287 {
	public int findDuplicate(int[] nums) {
		if (nums.length > 1) {
			int slow = nums[0];
			int fast = nums[nums[0]];
			while (slow != fast) {
				slow = nums[slow];
				fast = nums[nums[fast]];
			}

			fast = 0;
			while (fast != slow) {
				fast = nums[fast];
				slow = nums[slow];
			}
			return slow;
		}
		return -1;
	}

	// 剑指offer的方法 交换 当遇到即将交换的数 的index与这个数一样时
	// 但是题目说了 不能够修改这个array 所以这个方法不可行
	public int findDuplicate2(int[] nums) {
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i) {

				temp = nums[i];
				if (nums[temp] == temp)
					return temp;
				nums[i] = nums[temp];
				nums[temp] = temp;
			}
		}
		return -1;
	}
}
