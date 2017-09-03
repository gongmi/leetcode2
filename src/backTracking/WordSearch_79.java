package backTracking;

import java.util.List;
// 和offer书上的思路一样
//与PermutationsII_47相似 都是需要一个used 数组来表征是否用过
//甚至可以不用used数组 用 board[r][c]='*'来禁用当前这个char 当下一个递归到这个char时 不可能相等board[r][c] == word.charAt(k)

public class WordSearch_79 {
	char[][] board = null;
	int rows = 0, cols = 0;
	boolean[][] used = null;
	String word = "";

	public boolean exist(char[][] board, String word) {
		this.board = board;
		this.rows = board.length;
		this.cols = board[0].length;
		this.word = word;
		used = new boolean[rows][cols];
		for (int i = 0; i < rows * cols; i++)
			if (helper(i / cols, i % cols, 0))
				return true;
		return false;
	}

	private boolean helper(int r, int c, int k) {

		if (k == word.length())
			return true;
		if (r < 0 || r == rows || c < 0 || c == cols)
			return false;
		if (!used[r][c] && board[r][c] == word.charAt(k)) {
			used[r][c] = true; //
			boolean res = helper(r + 1, c, k + 1) || helper(r - 1, c, k + 1)
					|| helper(r, c + 1, k + 1) || helper(r, c - 1, k + 1);
			used[r][c] = false;
			return res;
		}
		return false;
	}
}