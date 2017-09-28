package string;
/*n=numRows
Δ=2n-2    1                           2n-1                         4n-3
Δ=        2                     2n-2  2n                    4n-4   4n-2
Δ=        3               2n-3        2n+1              4n-5       .
Δ=        .           .               .               .            .
Δ=        .       n+2                 .           3n               .
Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
Δ=2n-2    n                           3n-2                         5n-4
*/
//一开始想复杂了 没有想到用一个SB数组 
//其实就是从上往下 然后从左下角到右上角 iterative
public class ZigZagConversion_6 {
	public String convert(String s, int numRows) {
		if (numRows == 1)
			return s;
		char[] array = s.toCharArray();
		StringBuilder[] sb = new StringBuilder[numRows];
		for (int row = 0; row < numRows; row++)
			sb[row] = new StringBuilder();

		int i = 0;
		while (i < s.length()) {
			for (int row = 0; row < numRows && i < s.length(); row++)
				sb[row].append(array[i++]);
			for (int row = numRows - 2; row > 0 && i < s.length(); row--)
				sb[row].append(array[i++]);
		}

		for (int row = 1; row < numRows; row++)
			sb[0].append(sb[row]);
		return sb[0].toString();

	}
}
