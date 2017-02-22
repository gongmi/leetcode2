package backTracking;

import java.util.LinkedList;
import java.util.List;
// �ݹ�ĵ���
public class NQueens_51 {
	List<List<String>> res = new LinkedList<>();
	int[] q;

	public List<List<String>> solveNQueens(int n) {
		q = new int[n];
		place(0);
		return res;
	}

	// �����i�е�k�����Ƿ���԰ڷŻʺ�
	public boolean check(int row, int col) {
		int curRow = 0;
		while (curRow < row) // curRow=0~row-1 ���Ѿ������˻ʺ����
		{
			// ��curRow�еĻʺ��Ƿ���col
			// ��(curRow,q[curRow])��(row,col)�Ƿ���б����
			if (q[curRow] == col
					|| Math.abs(curRow - row) == Math.abs(q[curRow] - col))
				return false;
			curRow++;
		}
		return true;
	}

	public void place(int row) {
		int col;
		int n = q.length;
		if (row == n)
			add();
		else {
			for (col = 0; col < n; col++) // ��̽��row�е�ÿһ��col
			{
				if (check(row, col)) {
					q[row] = col;
					place(row + 1); // �ݹ������ڳɹ�������ϴε������ʱ�������һ������
				}
			}
		}
	}

	public void add() {
		List<String> list = new LinkedList<>();
		int row, col;
		int n = q.length;
		for (row = 0; row < n; row++) // ��
		{
			String s = "";
			for (col = 0; col < n; col++) // ��
			{
				if (q[row] != col)
					s += ".";
				else
					s += "Q";
			}
			list.add(s);
		}
		res.add(list);
	}
}
