package dynamicProgramming;

import java.util.Arrays;

public class Main_test {
	public boolean increasingTriplet(int[] nums) {
		int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
		for (int num : nums) {
			if (first == Integer.MIN_VALUE)
				first = num;
			else if (second == Integer.MIN_VALUE && num > first)
				second = num;
			else if (second != Integer.MIN_VALUE && num > second)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Permutation test=new Permutation();
		System.out.println(test.validPermutation(5, 2));
	}
}
