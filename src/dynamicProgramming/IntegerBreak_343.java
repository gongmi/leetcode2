package dynamicProgramming;

public class IntegerBreak_343 {
    public int integerBreak(int n) {
        
        if (n<6) return (n/2)*(n-n/2);
        int Nums_3=n/3;
        int left=n%3;
        if (left==2)  return (int)Math.pow(3,Nums_3)*2;
        if (left==1)  return (int)Math.pow(3,Nums_3-1)*4;
        return (int)Math.pow(3,Nums_3);
     }
}
