package backTracking;

//����������������permutation�ĸ��� ��������Բ���backtracking ������dp
//���Ƿ·�����dp
//���� ���k�Ӻ���ǰ ���ܶ� ��Ϊ��k��Сʱ ���Ǻ����ױ����� ���ǵ��������ܾ��޷������� ��ôǰ��Ķ�ǰ��������

public class BeautifulArrangement_526 {
	int res = 0;
	boolean[] used;

	public int countArrangement(int N) {
		used = new boolean[N + 1];
		backTracking(N, N);
		return res;
	}

	private void backTracking(int N, int k) {
		if (k == 1) {
			res++;
			return;
		}
		for (int i = 1; i <= N; i++)
			if (!used[i] && (i % k == 0 || k % i == 0)) {
				used[i] = true;
				backTracking(N, k - 1);
				used[i] = false;

			}

	}
}
