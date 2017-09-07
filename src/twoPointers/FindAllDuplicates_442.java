package twoPointers;

import java.util.*;
//��FindDuplicateNumber_287���� ֻ���� �Ǹ���ֻ��Ҫ����һ��
//�����Ƿ������е��ظ���

public class FindAllDuplicates_442 {
	// ��ָoffer�Ľ�������
	public List<Integer> findDuplicates(int[] nums) {
		HashSet<Integer> res = new HashSet<>();
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {
			nums[i]--;
		}
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i) {

				temp = nums[i];
				if (nums[temp] == temp) {
					res.add(temp + 1);
					break;
				}

				nums[i] = nums[temp];
				nums[temp] = temp;
			}
		}
		return new LinkedList<Integer>(res);
	}

	// ȡ���� ���Ա���p274
	// ��Ϊ�Ǵ�1��n������ ����Ҫ�ȼ�1 ����������index��0��n-1
	public List<Integer> findDuplicates2(int[] nums) {
		LinkedList<Integer> res = new LinkedList<Integer>();
		for (int num : nums) {
			num = Math.abs(num) - 1;// ��Ϊ�Ǵ�1��n������ ����Ҫ�ȼ�1 ����������index��0��n-1
			if (nums[num] < 0) {
				res.add(num + 1);
			} else {
				nums[num] = -nums[num];
			}
		}
		return res;
	}
}
