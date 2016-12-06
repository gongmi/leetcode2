package twoPointers;

import java.util.Arrays;


public class TwoSumII_167 {
	
	//û����binarysearch two pointer ʱ�临�Ӷ�O��n��
	public int[] twoSum2(int[] numbers, int target) {
	    int start = 0, end = numbers.length - 1;
	    while(start < end){
	        if(numbers[start] + numbers[end] == target) break;
	        if(numbers[start] + numbers[end] < target) start++;
	        else end--;
	    }
	    return new int[]{start + 1, end + 1};
	}

	//@param fromIndex the index of the first element (inclusive) to be searched
	//@param toIndex the index of the last element (exclusive) to be searched
	//exclusive���������������� 
	//�ҵķ��� ������ ʱ�����	
	public int[] twoSum(int[] numbers, int target) {
		int[] array = new int[2];
		int another = 0;
		int right = numbers.length;
//		ʱ�临�Ӷ� lg(n-1) + lg(n-2) + ... + lg(1) ~ O(lg(n!)) ~ O(nlgn). 
		for (int i = 0; i < numbers.length; i++) {
			another = target - numbers[i];
			//��������˿��˲��� ��Ϊ���û�л�ȥbinarySearch�Ļ� �Ứ�ܶ�ʱ��
			if (numbers[right - 1] < another)
				continue;

			right = Arrays.binarySearch(numbers, i + 1, right, another);
			if (right > 0) {
				array[0] = i + 1;
				array[1] = right + 1;
				break;
			}
			right = -right - 1;

		}

		return array;
	}

}
