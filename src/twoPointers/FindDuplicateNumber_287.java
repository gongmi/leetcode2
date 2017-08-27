package twoPointers;

//����1
//������142. Linked List Cycle II ��˼·
//�������������� �ǵ��ⲻһ����cycle �����ж�������
//while (fast != null && fast.next != null) {
//�����Ǵ�ͷ��ʼ��
//������Ǵ�0��ʼ�� ���� һ��ʼslow��fast����һ��
//�������0��ʼ�ͻ������while
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

	// ��ָoffer�ķ��� ���� ������������������ ��index�������һ��ʱ
	// ������Ŀ˵�� ���ܹ��޸����array �����������������
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
