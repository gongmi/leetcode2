package greedy;

public class GasStation_134 {
	// [1,2,3,4,5]
	// [3,4,5,1,2]

	public int canCompleteCircuit(int[] gas, int[] cost) {
		// 用sum存总的差的和 如果小于0 说明不行 返回-1
		// 用curSum存从m开始的和 如果小于0 说明抛弃
		// 有点像MaximumSubarray_53
		// // 用Kadane算法 只遍历一遍数组
		// 当前面那些加起来小于0 就不要了
		// 用m存 从0到正的那个station
		int sum = 0;
		int preSum = 0, curSum = 0;
		int m = 0;// 不应该取名为m 应该是start
		for (int i = 0; i < gas.length; i++) {
			sum += gas[i] - cost[i];

			curSum = preSum + gas[i] - cost[i];
			if (preSum == 0 && curSum > 0) {
				m = i;
				preSum = curSum;
			}
			if (curSum < 0)
				preSum = 0;
		}
		if (sum < 0)
			return -1;
		return m;
	}

	// 我的第二版答案
	// 不用 preSum 与 curSum 来判断
//	用一个index来表示 之前有没有找到一个station
	public int canCompleteCircuit1(int[] gas, int[] cost) {
		int index = -1;
		int sum = 0, cursum = 0;
		for (int i = 0; i < gas.length; i++) {
			sum += gas[i] - cost[i];
			cursum += gas[i] - cost[i];
			if (cursum >= 0 && index == -1) {
				index = i;
			} else if (cursum < 0) {
				index = -1;
				cursum = 0;
			}
		}
		return sum >= 0 ? index : -1;
	}

	// 别人的 一样的思想 区别在于 他不用m存ok的位置 而是当不ok时 往后找
	public int canCompleteCircuit2(int[] gas, int[] cost) {
		int sumGas = 0;
		int sumCost = 0;
		int start = 0;
		int tank = 0;
		String s="";
		for (int i = 0; i < gas.length; i++) {
			sumGas += gas[i];
			sumCost += cost[i];
			tank += gas[i] - cost[i];
			if (tank < 0) {
				start = i + 1;
				tank = 0;
			}
		}
		if (sumGas < sumCost) {
			return -1;
		} else {
			return start;
		}
	}
}
