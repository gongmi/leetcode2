package sort;

import java.util.*;
//先排好序 然后一分为二 
//1234
//567
//然后 4736251
//不能1526374
//比如 12 与23 
//就是1223 应该是 2312才对

public class WiggleSortII_324 {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		int[] copy = new int[len];
		int left = (len + 1) / 2;
		int right = len;
		int c = 0;
		while (c < len) {
			copy[c++] = nums[--left];
			if (right > (len + 1) / 2)
				copy[c++] = nums[--right];
		}
		for (int i = 0; i < len; i++) {
			nums[i] = copy[i];
		}
	}
}
