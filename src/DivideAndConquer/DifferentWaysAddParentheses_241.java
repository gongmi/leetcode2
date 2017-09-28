package DivideAndConquer;

import java.util.*;

public class DifferentWaysAddParentheses_241 {
	List<Integer> ret = new ArrayList<Integer>();

	public List<Integer> diffWaysToCompute(String input) {
		helper(input);
		return ret;
	}

	private void helper(String input) {
		ArrayList<Integer> indexs = new ArrayList<>();
		indexs.add(-1);
		char[] a = input.toCharArray();
		for (int i = 0; i < a.length; i++) {
			if ("+-*".contains(a[i] + "") && i != 0 && !"+-*".contains(a[i - 1] + "")) {
				indexs.add(i);
			}
		}
		indexs.add(a.length);

		for (int i = 0; i + 2 < indexs.size(); i++) {
			int L = indexs.get(i) + 1;
			int R = indexs.get(i + 2);
			int res = caculate(input.substring(L, R));
			if (indexs.size() == 3)
				ret.add(res);
			else
				helper(input.substring(0, L) + res + input.substring(R));
		}
	}

	private int caculate(String input) {
		System.out.println(input);
		if (input.contains("+")) {
			String[] array = input.split("+");
			return Integer.parseInt(array[0]) + Integer.parseInt(array[1]);
		}
		if (input.contains("*")) {
			String[] array = input.split("\\*");
			return Integer.parseInt(array[0]) * Integer.parseInt(array[1]);
		}
		String[] array = input.split("-");
		return Integer.parseInt(array[0]) - Integer.parseInt(array[1]);
	}
}
