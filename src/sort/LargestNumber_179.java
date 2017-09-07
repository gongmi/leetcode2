package sort;

import java.util.Arrays;
import java.util.Comparator;

// 剑指offer33
public class LargestNumber_179 {

	public String largestNumber(int[] nums) {

		String[] snums = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			snums[i] = "" + nums[i];
		}
		// 必须要转成string数组才能排序
		// 因为只有引用类型才可以定制排序 点进去看源码
		Arrays.sort(snums, new Comparator<String>() {
			public int compare(String i1, String i2) {
				String s1 = i1 + i2;
				String s2 = i2 + i1;
				return s2.compareTo(s1);
			}
		});
		StringBuilder sb = new StringBuilder();
		// 处理000这种情况
		if (snums[0].equals("0"))
			return "0";

		for (int i = 0; i < snums.length; i++) {
			sb.append(snums[i]);
		}
		return sb.toString();
	}
}
