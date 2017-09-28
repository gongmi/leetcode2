package hashTable;

import java.util.*;

public class ImplementMagicDictionary_676 {
	// �տ�ʼ�� ���� û�п��ǵ�ɾ�����Ǹ�char��λ�� ������ i����sub�� ����
	HashMap<String, String> map = new HashMap<>();

	public ImplementMagicDictionary_676() {
	}

	public void buildDict(String[] dict) {
		for (String s : dict) {
			for (int i = 0; i < s.length(); i++) {
				String sub = i + "," + s.substring(0, i) + s.substring(i + 1);
				if (map.containsKey(sub))
					map.put(sub, ""); // �������������� ��˵��search��ʱ�� �����subһ���� ��һ������
				else
					map.put(sub, s);// ֻ����һ��
			}
		}
	}

	public boolean search(String word) {
		if (word.equals(""))
			return false;
		for (int i = 0; i < word.length(); i++) {
			String sub = i + "," + word.substring(0, i) + word.substring(i + 1);
			if (map.containsKey(sub) && !map.get(sub).equals(word))
				return true;
		}
		return false;
	}

	// ���õĴ� value ���ô�String ֻ��Ҫ��i����char ���Ұ�i����i �� �����ǿ�ͷ ����������
	HashMap<String, Character> map2 = new HashMap<>();

	public void buildDict2(String[] dict) {
		for (String s : dict) {
			for (int i = 0; i < s.length(); i++) {
				String sub = s.substring(0, i) + "" + i + "" + s.substring(i + 1);
				if (map2.containsKey(sub))
					map2.put(sub, '*'); // �������������� ��˵��search��ʱ�� �����subһ���� ��һ������
				else
					map2.put(sub, s.charAt(i));// ֻ����һ��
			}
		}
	}

	public boolean search2(String word) {
		if (word.equals(""))
			return false;
		for (int i = 0; i < word.length(); i++) {
			String sub = word.substring(0, i) + "" + i + "" + word.substring(i + 1);
			if (map2.containsKey(sub) && map2.get(sub) != word.charAt(i))
				return true;
		}
		return false;
	}
}
