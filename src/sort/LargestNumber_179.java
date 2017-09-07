package sort;

import java.util.Arrays;
import java.util.Comparator;

// ��ָoffer33
public class LargestNumber_179 {

	public String largestNumber(int[] nums) {

		String[] snums = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			snums[i] = "" + nums[i];
		}
		// ����Ҫת��string�����������
		// ��Ϊֻ���������Ͳſ��Զ������� ���ȥ��Դ��
		Arrays.sort(snums, new Comparator<String>() {
			public int compare(String i1, String i2) {
				String s1 = i1 + i2;
				String s2 = i2 + i1;
				return s2.compareTo(s1);
			}
		});
		StringBuilder sb = new StringBuilder();
		// ����000�������
		if (snums[0].equals("0"))
			return "0";

		for (int i = 0; i < snums.length; i++) {
			sb.append(snums[i]);
		}
		return sb.toString();
	}
}
