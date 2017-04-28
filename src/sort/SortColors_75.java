package sort;

public class SortColors_75 {
	// 我的办法 相当于bitmap 可是这用了空间 不是in place
	// two pass 即扫描两遍 即时间复杂度是O(2n)

	// [0,2,1,2,2,1,2,2,2,2,1,0,1,2]
	public void sortColors(int[] nums) {
		int[] freqs = new int[3];
		for (int i : nums)
			freqs[i]++;
		int i = 0;
		for (int j = 0; j < 3; j++)
			while (freqs[j]-- > 0)
				nums[i++] = j;
	}
// in place 就是在原来的基础上
// 这是采用交换的方法 在纸上写写画画就明白了 就是把所有的2都放到右边  
//	0都放到左边 那么中间的就是1

	public void sortColors2(int[] nums) {
		int zero = 0;
		int second = nums.length - 1;
		for (int i = 0; i <= second; i++) {
			if (nums[i] == 0)
				swap(nums, i, zero++);
			else if (nums[i] == 2)
				swap(nums, i--, second--);
		}
	}

	private void swap(int[] a, int index1, int index2) {
		int tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}

}
