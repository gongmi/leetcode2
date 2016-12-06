package binarySearch;

import java.util.Map;
import java.util.TreeMap;

public class FindRightInterval_436 {
	//法1 用TreeMap treemap自动排序了 当找时某一个key时 由于是红黑树 应该也是用lgn的时间 所以总的是n*lgn
    public int[] findRightInterval(Interval[] intervals) {
        
        int len=intervals.length;
        //一定要定义成TreeMap 因为要用ceilingEntry方法 这个方法在Map没有！！
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
    
//    法2 还是用interval的start排序 把index放在end那里 但是我做的时候
//    发现不能用 arrays.binarysearch 因为这个自带的二分查找必须是：
//    public static <T> int binarySearch(T[] a, T key, Comparator<? super T> c)
//    key和数组必须是同一种类型 但是我的key 是int的   不是interval  
//    我就停止了 可是这个人自己写了binarysearch
public int[] findRightInterval2(Interval[] intervals) {
        
        int n;
        if (intervals == null || (n = intervals.length) == 0) return new int[]{};
        
        int[] res = new int[intervals.length];
        Interval[] sintervals = new Interval[n];
        
        for (int i = 0; i < n; ++i) {
            sintervals[i] = new Interval(intervals[i].start, i);
        }
//        我是jdk7 IDE不认识 太丑了 我就注释了 应该解开的 
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
