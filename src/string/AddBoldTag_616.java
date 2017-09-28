package string;

//�ⷨһ
//��s�а����е�dict���ַ�����left��right�ҵ� ���interval
//Ȼ�����merge Interval��

//�ⷨ��
//��һ��boolean������ ������charҪ��Ҫ��bold
//�е������ڻ�Ʊ �ܶ�վ �ܶ��ŵ�����

//Ҫѧ��ʹ��startsWith indexOf �Ⱥ���

public class AddBoldTag_616 {
	// ���¶��ǽⷨ2 ֻ��д�����в�ͬ
	// tutorial
	public String addBoldTag(String s, String[] dict) {
		boolean[] bold = new boolean[s.length()];
		for (String d : dict) {
			for (int i = 0; i <= s.length() - d.length(); i++) {
				if (s.substring(i, i + d.length()).equals(d)) {
					for (int j = i; j < i + d.length(); j++)
						bold[j] = true;
				}
			}
		}
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < s.length();) {
			if (bold[i]) {
				res.append("<b>");
				while (i < s.length() && bold[i])
					res.append(s.charAt(i++));
				res.append("</b>");
			} else
				res.append(s.charAt(i++));
		}
		return res.toString();
	}

	// top
	public String addBoldTag2(String s, String[] dict) {
		boolean[] bold = new boolean[s.length()];
		for (int i = 0, end = 0; i < s.length(); i++) {
			for (String word : dict) {
				if (s.startsWith(word, i)) {
					end = Math.max(end, i + word.length());
				}
			}
			bold[i] = end > i;
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (!bold[i]) {
				result.append(s.charAt(i));
				continue;
			}
			int j = i;
			while (j < s.length() && bold[j])
				j++;
			result.append("<b>" + s.substring(i, j) + "</b>");
			i = j - 1;
		}

		return result.toString();
	}
}
