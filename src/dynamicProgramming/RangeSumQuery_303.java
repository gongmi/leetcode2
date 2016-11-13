package dynamicProgramming;

public class RangeSumQuery_303 {
	private int[] S_nums;

	public RangeSumQuery_303(int[] nums) {
		int l = nums.length;
		S_nums = new int[l + 1];
		for (int i = 1; i < l + 1; i++)
			S_nums[i] = S_nums[i - 1] + nums[i - 1];
	}

	public int sumRange(int i, int j) {
		return S_nums[j + 1] - S_nums[i];
	}
	//法2 时间空间都很多
//	private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
//	public NumArray(int[] nums) {
//	    for (int i = 0; i < nums.length; i++) {
//	        int sum = 0;
//	        for (int j = i; j < nums.length; j++) {
//	            sum += nums[j];
//	            map.put(Pair.create(i, j), sum);
//	        }
//	    }
//	}
//
//	public int sumRange(int i, int j) {
//	    return map.get(Pair.create(i, j));
//	}
}
