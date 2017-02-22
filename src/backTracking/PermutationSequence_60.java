package backTracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence_60 {
//	private int count = 0;
//	private List<Integer> list = new ArrayList<Integer>();
//	public String getPermutation(int n, int k) {
//		
//		backtrack(new ArrayList<Integer>(), n, k,new boolean[n+1]);
//		String res = "";
//		for (int num : list)
//			res = res + num;
//		return res;
//	}
//
//	private void backtrack(List<Integer> tempList, int n, int k, boolean[] used) {
//		if (tempList.size() == n) {
//			count++;
//			if (count == k)
//				list = new ArrayList<Integer>(tempList);
//			return;
//		}
//		for (int i = 1; i < n + 1&&count<k; i++) {
//			if (used[i])// element already exists, skip
//				continue;
//			tempList.add(i);
//			used[i] = true;
//			backtrack(tempList, n, k,used);
//			tempList.remove(tempList.size() - 1);
//			used[i] = false;
//		}
//	}
	private int count = 0;
	private String res = "";
	public String getPermutation(int n, int k) {
		backtrack("", n, k);
		return res;
	}

	private void backtrack(String tempStr, int n, int k) {
		if (tempStr.length() == n) {
			count++;
			if (count == k)
				res =tempStr;
			return;
		}
		for (int i = 1; i < n + 1&&count<k; i++) {
			if (tempStr.contains(Integer.toString('0' + i)))
				continue;
			backtrack(tempStr + i, n, k);
		}
	}
}
