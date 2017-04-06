package binarySearch;

public class RotatedSortedArrayFindMin_153 {
//	��������ų��˺ܶ�߽���� ���Ǳ��˵Ĵ���ȴ�ܼ�
	
//	��right��left��ֵʱ ��һ������ mid-1�� mid+1�����ַ����ǵģ�
//	Ӧ����ôѡ�����Ǹ�����! Ϊʲô����ѡ��mid �� mid+1
//	��ָoffer�ڰ��� �������ϵ�codeû�������
	public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[right]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return nums[left];
	}
}
