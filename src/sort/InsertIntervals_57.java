package sort;

import java.util.*;
//һ��ʼ���õ���binarysearch�������µ�intervalӦ�÷����ĸ�λ�ã�������ʵ����û�б�Ҫ
//��Ϊ�����ҵ���Ҳ�ñ���һ�����list �����븴����

public class InsertIntervals_57 {
	// top answer ��ʵ����һֱ�ı�start ��end ����ȴ����ֻ�ı�1��
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new LinkedList<>();
		int i = 0;
		while (i < intervals.size() && intervals.get(i).end < newInterval.start)
			result.add(intervals.get(i++));
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
			newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
			i++;
		}
		LinkedList<Integer> list=new LinkedList<>();
		result.add(newInterval);
		result.se
		while (i < intervals.size())
			result.add(intervals.get(i++));
		return result;
	}
}
