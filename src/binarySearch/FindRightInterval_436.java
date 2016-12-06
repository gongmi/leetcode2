package binarySearch;

import java.util.Map;
import java.util.TreeMap;

public class FindRightInterval_436 {
	//��1 ��TreeMap treemap�Զ������� ����ʱĳһ��keyʱ �����Ǻ���� Ӧ��Ҳ����lgn��ʱ�� �����ܵ���n*lgn
    public int[] findRightInterval(Interval[] intervals) {
        
        int len=intervals.length;
        //һ��Ҫ�����TreeMap ��ΪҪ��ceilingEntry���� ���������Mapû�У���
       TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
       
        for (int i=0;i<len;i++)
            map.put(intervals[i].start,i);
            
    int[] index=new int[len];
    for (int i=0;i<len;i++){
    Map.Entry<Integer,Integer> entry= map.ceilingEntry(intervals[i].end);
     if (entry!=null)
        index[i]= (int)entry.getValue(); 
        else
        index[i]=-1;
    }
      return index;
    }
    
//    ��2 ������interval��start���� ��index����end���� ����������ʱ��
//    ���ֲ����� arrays.binarysearch ��Ϊ����Դ��Ķ��ֲ��ұ����ǣ�
//    public static <T> int binarySearch(T[] a, T key, Comparator<? super T> c)
//    key�����������ͬһ������ �����ҵ�key ��int��   ����interval  
//    �Ҿ�ֹͣ�� ����������Լ�д��binarysearch
public int[] findRightInterval2(Interval[] intervals) {
        
        int n;
        if (intervals == null || (n = intervals.length) == 0) return new int[]{};
        
        int[] res = new int[intervals.length];
        Interval[] sintervals = new Interval[n];
        
        for (int i = 0; i < n; ++i) {
            sintervals[i] = new Interval(intervals[i].start, i);
        }
//        ����jdk7 IDE����ʶ ̫���� �Ҿ�ע���� Ӧ�ý⿪�� 
//        Arrays.sort(sintervals, (a, b)->a.start-b.start);
        
        int i = 0;
        for (; i < n; ++i) {
            int key = intervals[i].end;
            // binary search in sintervals for key
            int l = 0, r = n - 1;
            int right = -1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (sintervals[m].start == key) {
                    right = sintervals[m].end; 
                    break;
                } else if (sintervals[m].start < key) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            
            // if we haven't found the key, try looking for 'start' that's just greater
            if ((right == -1) && (l < n) && (sintervals[l].start > key)) 
                right = sintervals[l].end; 
            
            res[i] = right;
        }
        
        return res;
    }
}
