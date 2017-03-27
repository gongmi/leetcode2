package hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
//���鲻��ֱ�Ӹ�ֵ ������ָ��ͬһ������ ǳ����
//��Arrays.copyOf ���
//0 1 2���ַ���������д�� ʱ�䳬���� 
//freq.putAll(frequency); map�ĸ��� Ҳ�������
//ֻ�е�<>���ǻ����������Ͳ������ ����Ƕ��� ��ǳ���Ƶ�

public class FindAllAnagrams_438 {
	// �����MinimumWindowSubstring_76��������
	// Time Complexity will be O(n)
	// ��֮ǰ�ķ�������O(n^2)
//	������ҵı�����д�ĺܸ��� ��ʵ������ �ܼ򵥵� ����ȥ���Ǳ����Щchar
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

	// public List<Integer> findAnagrams0(String s, String p) {
	// boolean flag=false;
	// List<Integer> res = new LinkedList<>();
	// char[] sArray=s.toCharArray();
	// char[] pArray=p.toCharArray();
	// HashMap<Character,Integer> frequency=new HashMap<>();
	// HashMap<Character,Integer> freq = new HashMap<>();
	// for (char c:pArray)
	// frequency.put(c,frequency.getOrDefault(c,0)+1);
	//
	//
	// int i = 0;
	// while (i < s.length() - p.length() + 1) {
	// freq.clear();
	// freq.putAll(frequency);
	// if(flag)
	// {
	// if (sArray[i-1]==sArray[i + p.length() -1])
	// {res.add(i++); flag=true;}
	// else
	// {flag=false;
	// if (!freq.containsKey(sArray[i + p.length() -1]))
	// i=i + p.length();
	// else
	// i++;
	// }
	// continue;
	// }
	//
	// for (int j = 0; j < p.length(); j++) {
	// if (!freq.containsKey(sArray[i + j])) {
	// flag = false;
	// i=i+j+1;
	// break;
	// }
	// if (freq.get(sArray[i + j])==0) {
	// flag = false;
	// i=i+1;
	// break;
	// }
	// freq.put(sArray[i + j],freq.get(sArray[i + j])-1);
	// flag = true;
	// }
	// if (flag)
	// res.add(i++);
	// }
	// return res;
	// }
	// public List<Integer> findAnagrams1(String s, String p) {
	// boolean flag;
	// List<Integer> res = new LinkedList<>();
	// int[] frequency = new int[26];
	// for (int i = 0; i < p.length(); i++)
	// frequency[p.charAt(i) - 'a']++;
	//
	// for (int i = 0; i < s.length() - p.length()+1; i++) {
	// flag = true;
	// // int[] freq = frequency;
	// int[] freq = Arrays.copyOf(frequency, frequency.length);
	// for (int j = 0; j < p.length(); j++) {
	// if ((freq[s.charAt(i + j) - 'a']) == 0) {
	// flag = false;
	// break;
	// }
	// freq[s.charAt(i + j) - 'a']--;
	// }
	// if (flag)
	// res.add(i);
	// }
	// return res;
	// }
	public List<Integer> findAnagrams2(String s, String p) {
		boolean flag = false;
		List<Integer> res = new LinkedList<>();
		int[] frequency = new int[26];
		for (int i = 0; i < p.length(); i++)
			frequency[p.charAt(i) - 'a']++;

		for (int i = 0; i < s.length() - p.length() + 1; i++) {
			if (flag) {
				if (s.charAt(i - 1) == s.charAt(i + p.length() - 1)) {
					res.add(i);
					flag = true;
				} else
					flag = false;
				continue;
			}
			int[] freq = Arrays.copyOf(frequency, frequency.length);
			for (int j = 0; j < p.length(); j++) {
				if ((freq[s.charAt(i + j) - 'a']) == 0) {
					flag = false;
					break;
				}
				freq[s.charAt(i + j) - 'a']--;
				flag = true;
			}
			if (flag)
				res.add(i);
		}
		return res;
	}
}
