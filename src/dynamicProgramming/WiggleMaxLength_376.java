package dynamicProgramming;

public class WiggleMaxLength_376 {
	// ��һ�� ˼·������ ���Ǵ���̫�߳� ����ʱ����0ms  O(n) time
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
//�Ż���Ĵ���
	public int wiggleMaxLength(int[] nums) {
		if (nums.length < 2)
			return nums.length;
		int length = 1;
		int i = 1;
		 while(i<nums.length && nums[i] == nums[0]) i++; // �ҵ��ڶ�������λ�� ��i
		 if (i==nums.length) return 1;
		 length++;
		 int previous = nums[i-1]; 
		 int current= nums[i]; 
		for (int j = i; j < nums.length; j++) {//��i+1��ʼ��
			if (((current - previous) * (nums[j] - current)) < 0) {
				previous = current;
				length++;
			}
			current = nums[j];
		}
		return length;
	}

}
