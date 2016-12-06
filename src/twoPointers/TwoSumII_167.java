package twoPointers;

import java.util.Arrays;


public class TwoSumII_167 {
	
	//没有用binarysearch two pointer 时间复杂度O（n）
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
	//exclusive！！！！！！！！ 
	//我的方法 不够好 时间更多	
	public int[] twoSum(int[] numbers, int target) {
		int[] array = new int[2];
		int another = 0;
		int right = numbers.length;
//		时间复杂度 lg(n-1) + lg(n-2) + ... + lg(1) ~ O(lg(n!)) ~ O(nlgn). 
		for (int i = 0; i < numbers.length; i++) {
			another = target - numbers[i];
			//这个加上了快了不少 因为如果没有还去binarySearch的话 会花很多时间
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
