package sort;

import java.util.*;
//���ź��� Ȼ��һ��Ϊ�� 
//1234
//567
//Ȼ�� 4736251
//����1526374
//���� 12 ��23 
//����1223 Ӧ���� 2312�Ŷ�

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
