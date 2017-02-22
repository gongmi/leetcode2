package backTracking;

import java.util.LinkedList;
import java.util.List;
// 递归的调用
public class NQueens_51 {
	List<List<String>> res = new LinkedList<>();
	int[] q;

	public List<List<String>> solveNQueens(int n) {
		q = new int[n];
		place(0);
		return res;
	}

	// 检验第i行的k列上是否可以摆放皇后
	public boolean check(int row, int col) {
		int curRow = 0;
		while (curRow < row) // curRow=0~row-1 是已经放置了皇后的行
		{
			// 第curRow行的皇后是否在col
			// 或(curRow,q[curRow])与(row,col)是否在斜线上
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
			for (col = 0; col < n; col++) // 试探第row行的每一个col
			{
				if (check(row, col)) {
					q[row] = col;
					place(row + 1); // 递归总是在成功完成了上次的任务的时候才做下一个任务
				}
			}
		}
	}

	public void add() {
		List<String> list = new LinkedList<>();
		int row, col;
		int n = q.length;
		for (row = 0; row < n; row++) // 行
		{
			String s = "";
			for (col = 0; col < n; col++) // 列
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
