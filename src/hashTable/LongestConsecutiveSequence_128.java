package hashTable;
import java.util.*;
//������tag��union find  ������ȴ��union find ��һ��
//��Ϊ��ֻ��Ҫ�ҵ�����һ��union �����ں��ж��ٸ�union 
//���� ��Ӧ��value �������group ��root  ����group��size


//�������뵽��˼·
//��Ϊֻ��������ʱ�� ��ô˵���϶�Ҫ�ÿռ�
//����ʱ��ͨ������hashmap�� ��Ϊhash��get set��O(1)

//������������� [100, 4, 200, 1,0,-1 , 3, 2] 
//��2 ������ʱ ��Ҫ����4��3 ��1 0 -1����Ӧ��value
//����ȥ�����ĸ��µĻ�ʱ�临�ӶȾͲ��ܱ�֤o(n)
//������ʵֻ��Ҫ����-1��4 �Ϳ����� ��Ϊ ���м��  2 3 �������õ��� 
//��Ϊ��������ظ��� 2 3 ���� do nothing  ����Ժ� �� 5 ���� -2 ʲô��
//ֻ�Შ����4 ��-1  ����м�ľͲ��ø�����


public class LongestConsecutiveSequence_128 {
	public int longestConsecutive(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				int left = map.getOrDefault(nums[i] - 1, 0);
				int right = map.getOrDefault(nums[i] + 1, 0);
				int sum = left + right + 1;
				res = Math.max(res, sum);
				map.put(nums[i], sum);

				map.put(nums[i] - left, sum);
				map.put(nums[i] + right, sum);
			}
		}
		return res;
	}
}
