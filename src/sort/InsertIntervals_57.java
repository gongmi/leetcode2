package sort;

import java.util.*;
//一开始我用的是binarysearch来查找新的interval应该放在哪个位置，但是其实这样没有必要
//因为反正找到了也得遍历一遍这个list 是我想复杂了

public class InsertIntervals_57 {
	// top answer 其实就是一直改变start 和end 而我却想着只改变1次
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
