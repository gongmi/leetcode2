package heap;

import java.util.*;

public class TaskScheduler_621 {
	public int leastInterval(char[] tasks, int n) {
    int res=0;
    int countZeros=0;
    HashMap<Character,Integer> map=new HashMap<>();
    for(char task:tasks){
        map.put(task,map.getOrDefault(task,0)+1);
    }
    PriorityQueue<Map.Entry<Character,Integer>> heap=new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
    heap.addAll(map.entrySet());
    Queue<Map.Entry<Character,Integer>> waitQueue=new LinkedList<>();
    while(!heap.isEmpty()||!waitQueue.isEmpty()){
           res++;
        if (heap.isEmpty())
        waitQueue.offer(null);
        else{
        Map.Entry<Character,Integer> cur=heap.poll();
        cur.setValue(cur.getValue()-1);
            if (cur.getValue()==0){
                countZeros++;
                if (countZeros==map.size())
                    break;
            }
        waitQueue.offer(cur);  
        }
     
        if (waitQueue.size()<=n)
            continue;
       Map.Entry<Character,Integer> cur=waitQueue.poll(); 
        if (cur!=null&&cur.getValue()>0)
            heap.offer(cur);
    }
    return res;
}
}
