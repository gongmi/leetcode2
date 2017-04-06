package hashTable;
//��Arrays.copyOf  freq.putAll(frequency) 
//ֻ�е�<>���ǻ����������Ͳ������ ����Ƕ��� ��ǳ���Ƶ�
import java.util.LinkedList;
import java.util.List;

//https://discuss.leetcode.com/topic/68976/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem
//discuss�� �����ַ���Ӧ�õ����������Ŀ
//MinimumWindowSubstring_76
//LongestSubstrWithoutRepeatChars_3
// Time Complexity will be O(n)
// ��֮ǰ�ķ�������O(n^2)
//������ҵı�����д�ĺܸ��� ��ʵ������ �ܼ򵥵� ����ȥ���Ǳ����Щchar
public class FindAllAnagrams_438 {

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new LinkedList<>();
		int[] freq = new int[26];
		for (int i = 0; i < p.length(); i++)
			freq[p.charAt(i) - 'a']++;

		int left = 0, right = 0, count = p.length();

		while (right < s.length()) {
			if ((freq[s.charAt(right) - 'a']--) > 0)  //�����������Щchar������ ���߶��p���char������
				count--;                                //������freq�ﱻ��Ϊ����

			if (count == 0)
				res.add(left);
			right++;

			if ((right - left) != p.length())
				continue;

			if ((freq[s.charAt(left) - 'a']++) >= 0)  //����Ǹ��� ����ᱻ�ų��� ��� ��ʵֻ��freq�������char��������
				count++;

			left++;
		}
		return res;
	}

}
