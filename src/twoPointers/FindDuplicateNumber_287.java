package twoPointers;

//����1
//������142. Linked List Cycle II ��˼·
public class FindDuplicateNumber_287 {
	public int findDuplicate(int[] nums) {
		if (nums.length > 1) {
			int slow = nums[0];
			int fast = nums[nums[0]];
			while (slow != fast) {
				slow = nums[slow];
				fast = nums[nums[fast]];
			}

			fast = 0;
			while (fast != slow) {
				fast = nums[fast];
				slow = nums[slow];
			}
			return slow;
		}
		return -1;
	}
//��ָoffer�ķ��� ���� ������������������ ��index�������һ��ʱ
	public int findDuplicate2(int[] nums) {
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i) {

				temp = nums[i];
				if (nums[temp] == temp)
					return temp;
				nums[i] = nums[temp];
				nums[temp] = temp;
			}
		}
		return -1;
	}
}
