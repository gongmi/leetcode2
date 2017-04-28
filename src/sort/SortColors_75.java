package sort;

public class SortColors_75 {
	// �ҵİ취 �൱��bitmap ���������˿ռ� ����in place
	// two pass ��ɨ������ ��ʱ�临�Ӷ���O(2n)

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
// in place ������ԭ���Ļ�����
// ���ǲ��ý����ķ��� ��ֽ��дд������������ ���ǰ����е�2���ŵ��ұ�  
//	0���ŵ���� ��ô�м�ľ���1

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
