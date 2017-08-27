package twoPointers;

public class MoveZeroes_283 {
	public void moveZeroes(int[] nums) {
		int leftPos = 0;
		for (int num : nums) {
			if (num != 0) {
				nums[leftPos++] = num;
			}
		}
		while (leftPos < nums.length) {
			nums[leftPos++] = 0;
		}
	}
}
