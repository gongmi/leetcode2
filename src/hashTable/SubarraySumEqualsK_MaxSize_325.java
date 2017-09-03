package hashTable;

import java.util.HashMap;

//������ ��MinimumSizeSubarraySum_209����
//���ǲ���һ��  �ǵ�����ֻ������  �����ҵ�����С��size
//���Կ�������ָ��  ������target �Ͷ�����ߵ� С����target �ͼ����ұߵ�
//������� �и��� ���� ��һ��������target ��Ҫ���� ���ܺ����и��� ����֮��͵���target��
//��SubarraySumEqualsK_560���� ��˼�� ������HashMap
//�����ŵ���<preSum,index>
//���Ǻ��������ͬ��preSum �Ͳ�����
//��Ϊ������ֵ� һ��û��ǰ����ֵ� �õ��ĳ��ȴ�
public class SubarraySumEqualsK_MaxSize_325 {

	public int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			res = Math.max(res, i - map.getOrDefault(sum - k, i));
			map.putIfAbsent(sum, i);
		}
		return res;
	}
}
