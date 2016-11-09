package dynamicProgramming;

public class CountingBits_338 {
    //第一版速度太慢 用的是
    // public int[] countBits(int num) {
    //     int[] A= new int[num+1];
    //     A[0]=0;
        
    //     int i=0;
    //     int j;
    //     while(true)
    //   {
    //       for (j=(int)Math.pow(2,i);j<Math.min((int)Math.pow(2,i+1),num+1);j++)
    //       A[j]=A[j-(int)Math.pow(2,i)]+1;
        
    //     if(j==num+1) break;
    //     i++;
    //   }
    //   return A;
        
    // }
    
    //看了别人的答案后
        public int[] countBits(int num) {
        int[] A= new int[num+1];
        A[0]=0;
 
       
        for (int i=1;i<num+1;i++)
          A[i]=A[i/2]+i%2;
 
      return A;
        
    }
}
