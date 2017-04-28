package Other;

import java.util.HashSet;
//ÿ��i����ͬʱ��� ��i�� ���� ��i�������Ƿ�valid
public class ValidSudoku_36 {
	public boolean isValidSudoku(char[][] board) {
		HashSet<Character> col = new HashSet<>();
		HashSet<Character> row = new HashSet<>();
		HashSet<Character> cube = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			col.clear();
			row.clear();
			cube.clear();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !col.add(board[i][j]))
					return false;
				if (board[j][i] != '.' && !row.add(board[j][i]))
					return false;
				int cubeRow = 3 * (i / 3) + j / 3;
				int cubeCol = 3 * (i % 3) + j % 3;
				if (board[cubeRow][cubeCol] != '.' && !cube.add(board[cubeRow][cubeCol]))
					return false;
			}
		}
		return true;
	}
}
