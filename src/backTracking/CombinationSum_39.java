package backTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39 {
	public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> list = new LinkedList<>();
		Arrays.sort(nums);
		backtrack(list, new LinkedList<Integer>(), nums, target, 0);
		return list;
	}
// 这个地方与许多top答案可能看起来不一样 但是其实是一样的
//	top答案是if (remain == 0) 我就修改了代码防止了再调用一次函数
//	直接在等于的时候就put 这样降低了了代码可读性
	private void backtrack2(List<List<Integer>> list, List<Integer> tempList,
			int[] nums, int remain, int start) {
		for (int i = start; i < nums.length && remain >= nums[i]; i++) {
			tempList.add(nums[i]);
			if (remain == nums[i])
				list.add(new LinkedList<>(tempList));
			else
				backtrack(list, tempList, nums, remain - nums[i], i);
			// not i + 1 because we can reuse same elements
			tempList.remove(tempList.size() - 1);
		}
	}
//	这是top答案
	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) return;
	    else if(remain == 0) list.add(new LinkedList<>(tempList));
	    else{ 
	        for(int i = start; i < nums.length; i++){
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
//或者不排序 不过这样就得 都遍历一遍
	public List<List<Integer>> combinationSum3(int[] nums, int target) {
		List<List<Integer>> list = new LinkedList<>();
		backtrack2(list, new LinkedList<Integer>(), nums, target, 0);
		return list;
	}

	private void backtrack3(List<List<Integer>> list, List<Integer> tempList,
			int[] nums, int remain, int start) {
		for (int i = start; i < nums.length; i++) {
			if (remain < nums[i])
				continue;
			tempList.add(nums[i]);
			if (remain == nums[i])
				list.add(new LinkedList<>(tempList));
			else
				backtrack(list, tempList, nums, remain - nums[i], i);
			// not i + 1 because we can reuse same elements
			tempList.remove(tempList.size() - 1);
		}
	}
}
