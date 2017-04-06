package backTracking;

import java.util.*;
// ��offer���ϵ�˼·һ��
//��PermutationsII_47���� ������Ҫһ��used �����������Ƿ��ù�
//�������Բ���used���� �� board[r][c]='*'�����õ�ǰ���char ����һ���ݹ鵽���charʱ ���������board[r][c] == word.charAt(k)

public class WordSearchII_212 {
	char[][] board = null;
	int rows = 0, cols = 0;
	boolean[][] used = null;

	public List<String> findWords(char[][] board, String[] words) {
		Set<String> res = new HashSet<String>();
		this.board = board;
		this.rows = board.length;
		this.cols = board[0].length;
		used = new boolean[rows][cols];
		for (String s : words)
			for (int i = 0; i < rows * cols; i++)
				if (helper(i / cols, i % cols, 0, s)) {
					res.add(s);
					break;
				}
		return new ArrayList<String>(res);
	}

	private boolean helper(int r, int c, int k, String word) {

		if (k == word.length())
			return true;
		if (r < 0 || r == rows || c < 0 || c == cols)
			return false;
		if (!used[r][c] && board[r][c] == word.charAt(k)) {
			used[r][c] = true; //
			boolean res = helper(r + 1, c, k + 1, word) || helper(r - 1, c, k + 1, word)
					|| helper(r, c + 1, k + 1, word) || helper(r, c - 1, k + 1, word);
			used[r][c] = false;
			return res;
		}
		return false;
	}
}