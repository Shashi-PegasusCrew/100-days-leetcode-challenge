class Solution {
    int fun(int i,int j,int[]nums1,int[] nums2,int[][]dp){
        int n=nums1.length;
        int m=nums2.length;
        if(i>=n || j>=m)
          return 0;
          if(dp[i][j]!=-1)
           return dp[i][j];

        if(nums1[i]==nums2[j]){
            
            return 1+fun(i+1,j+1,nums1,nums2,dp);
        }else{
            int c1=fun(i+1,j,nums1,nums2,dp);
            int c2=fun(i,j+1,nums1,nums2,dp);
            return dp[i][j]=Math.max(c1,c2);
        }  
    }
    public int maxUncrossedLines(int[] nums1,int[] nums2 ) {
        
        int [][]dp=new int[nums1.length+1][nums2.length+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }


      return fun(0,0,nums1,nums2,dp);
    }
}