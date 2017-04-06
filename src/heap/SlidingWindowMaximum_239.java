package heap;
//��ָoffer65
import java.util.*;
	//�������ڸ�˫�˶��� ��������ܵ�max��index
	//���Ƿŵ�ʱ���ܳ��ֵ�������� ��Ϊ����ӽ���������ԭ���Ĵ�
	//��˵��ԭ���Ĳ����ܳ�Ϊmax��
	//��˶����зŵ����ǵݼ���
	//���е�ͷ����Ϊmax
	public class SlidingWindowMaximum_239 {
		public int[] maxSlidingWindow(int[] nums, int k) {
		    if (k==0) return new int[0];
			int[] res = new int[nums.length-k+1];
			Deque<Integer> deque = new LinkedList<>();

			for (int i = 0; i < nums.length; i++) {
				while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
					deque.pollLast();
				deque.offerLast(i);
				int index = deque.peekFirst();
				if (i >= k - 1)
					res[i-k+1]=nums[index];
				if ((i - index) == k-1) //ͷ����index̫С�� ������������������ �Ͳ�����������һ����Ϊͷ����
					deque.pollFirst();
			}

			return res;
		}
	}
