package dynamicProgramming;

public class CountNumbers_357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n==0) return 1;
        if (n==1) return 10;
        int addition=9;
        for (int i=9;i>(10-n);i--)
        addition=addition*i;
        return countNumbersWithUniqueDigits(n-1)+addition;
        
    }


//别人的代码 没有用递归 更节省时间 o（9）=o（1）
//public int countNumbersWithUniqueDigits(int n) {
//    if (n == 0)     return 1;
//    
//    int res = 10;
//    int uniqueDigits = 9;
//    int availableNumber = 9;
//    while (n-- > 1 && availableNumber > 0) {
//        uniqueDigits = uniqueDigits * availableNumber;
//        res += uniqueDigits;
//        availableNumber--;
//    }
//    return res;
//}
}