package string;
/*n=numRows
��=2n-2    1                           2n-1                         4n-3
��=        2                     2n-2  2n                    4n-4   4n-2
��=        3               2n-3        2n+1              4n-5       .
��=        .           .               .               .            .
��=        .       n+2                 .           3n               .
��=        n-1 n+1                     3n-3    3n-1                 5n-5
��=2n-2    n                           3n-2                         5n-4
*/
//һ��ʼ�븴���� û���뵽��һ��SB���� 
//��ʵ���Ǵ������� Ȼ������½ǵ����Ͻ� iterative
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
