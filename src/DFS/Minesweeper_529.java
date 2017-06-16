package DFS;

//就是 传统的DFS解法 反正都是上下左右的递归 和top答案差不多
public class Minesweeper_529 {
	char[][] board;
	int row;
	int col;
	int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { -1, -1 }, { 1, -1 }, { 1, 1 },
			{ -1, 1 } };

	public char[][] updateBoard(char[][] board, int[] click) {
		row = board.length;
		col = board[0].length;
		if (board[click[0]][click[1]] == 'M') {
			board[click[0]][click[1]] = 'X';
			return board;
		}
		this.board = board;
		click(click[0], click[1]);
		return this.board;
	}

	private void click(int x, int y) {
		if (x == row || x < 0 || y == col || y < 0)
			return;
		if (board[x][y] == 'E') {
			int count = 0;
			for (int[] dir : dirs)
				count += count(x + dir[0], y + dir[1]);
			if (count == 0) {
				board[x][y] = 'B';
				for (int[] dir : dirs)
					click(x + dir[0], y + dir[1]);
			} else
				board[x][y] = (char) ('0' + count);
		}
	}

	// 求 x y这个位置是不是M
	private int count(int x, int y) {
		if (x == row || x < 0 || y == col || y < 0)
			return 0;
		if (board[x][y] == 'M')
			return 1;
		else
			return 0;
	}
}
