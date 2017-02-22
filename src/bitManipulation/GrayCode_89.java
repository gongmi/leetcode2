package bitManipulation;

import java.util.LinkedList;
import java.util.List;
//The idea is simple. G(i) = i^ (i/2).
//i     = ...?01...1,    i+1      = ...?10...0, 
//(i>>1)=  ...?01...,   (i+1)>>1  =  ...?10..., 

// i   ^ (i>>1)    = xxx(?^0)10...0, 
//(i+1)^((i+1)>>1) = xxx(?^1)10...0. 
//so there is only one bit difference comes from (?^0) and (?^1).
public class GrayCode_89 {
	public List<Integer> grayCode(int n) {
	    List<Integer> result = new LinkedList<>();
	    for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
	    return result;
	}
}
