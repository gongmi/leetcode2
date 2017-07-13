package dynamicProgramming;

//
public class WiggleMaxLength_376 {
	// ��һ�� ˼·������ ���Ǵ���̫�߳� ����ʱ����0ms O(n) time
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
	// �Ż���Ĵ���
	public int wiggleMaxLength(int[] nums) {
		if (nums.length < 2)
			return nums.length;
		int length = 1;
		int i = 1;
		while (i < nums.length && nums[i] == nums[0])
			i++; // �ҵ��ڶ�������λ�� ��i
		if (i == nums.length)
			return 1;
		length++;
		int previous = nums[i - 1];
		int current = nums[i];
		for (int j = i; j < nums.length; j++) {// ��i+1��ʼ��
			if (((current - previous) * (nums[j] - current)) < 0) {
				previous = current;
				length++;
			}
			current = nums[j];
		}
		return length;
	}

	// �ڶ������Ĵ� û�����ۿ�ͷ �� Integer.MAX_VALUE ��forѭ�����������ͷ
	// ģ����IncreasingTripletSubsequence_334���� ֻ�����������Ϳ�����
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
				if ((second - first) * (num - second) < 0) {//������wiggleʱ
					first = second;
					len++;
				}
				second = num;//�κ�����¶�Ҫ�滻second  ������wiggleʱ �������㵱����wiggleʱ ҲҪ �滻�������Ժ�ĸ���Ŷ
			}
		}
		return len;
	}

}
