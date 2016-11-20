package greedy;

public class GasStation_134 {
	// [1,2,3,4,5]
	// [3,4,5,1,2]

	public int canCompleteCircuit(int[] gas, int[] cost) {
		//��sum���ܵĲ�ĺ� ���С��0 ˵������ ����-1
		//��curSum���m��ʼ�ĺ� ���С��0 ˵������ 
		//�е���MaximumSubarray_53
//		// ��Kadane�㷨 ֻ����һ������
		// ��ǰ����Щ������С��0 �Ͳ�Ҫ��
		//��m�� ��0�������Ǹ�station
		int sum = 0;
		int preSum = 0, curSum = 0;
		int m = 0;//��Ӧ��ȡ��Ϊm Ӧ����start
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
	//���˵� һ����˼�� �������� ������m��ok��λ�� ���ǵ���okʱ ������
	public int canCompleteCircuit2(int[] gas, int[] cost) {
	    int sumGas = 0;
	    int sumCost = 0;
	    int start = 0;
	    int tank = 0;
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
