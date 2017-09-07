package Graph_UnionFind;

import java.util.*;

public class CourseSchedule_207 {
	   int row ;
	    int col ;
	     int[][] maxPath;
	    public int longestIncreasingPath(int[][] matrix) {
	        if (matrix==null||matrix.length==0||matrix[0].length==0)
	            return 0;
	         row=matrix.length;
	        col=matrix[0].length;
	         maxPath=new int[row][col];
	        
	        int max=0;
	        for(int r=0;r<row;r++){
	             for(int c=0;c<col;c++){
	              max=Math.max(max, build(matrix,r,c,Integer.MIN_VALUE)); 
	             }
	        }
	        return max;
	    }
	    private int  build(int[][] matrix,int r,int c,int prev) {
	        if (r<0||r==row||c<0||c==col||prev>=matrix[r][c]){
	            return 0;
	        }
	        if(maxPath[r][c]!=0){
	        return maxPath[r][c];
	        }
	        int up=build(matrix,r-1,c,matrix[r][c]);
	        int down=build(matrix,r+1,c,matrix[r][c]);
	        int left=build(matrix,r,c-1,matrix[r][c]);
	        int right=build(matrix,r,c+1,matrix[r][c]);
	        int cur=1+Math.max(up,Math.max(down,Math.max(left,right)));
	        maxPath[r][c]=cur;
	        return cur;
	    }
}