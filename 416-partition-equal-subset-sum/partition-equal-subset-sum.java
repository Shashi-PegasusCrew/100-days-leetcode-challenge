class Solution {
    boolean fun(int x, int i, int[] nums,int[][]dp) {
        if (i >=nums.length)
            return false;
        if (x == 0)
            return true;

        if (dp[x][i]!=-1)
          return dp[x][i]==1;    
        
            boolean take=false;
        if (x >= nums[i]) {
             take = fun(x - nums[i], i + 1, nums,dp);
        }
        boolean notTake=fun(x,i+1,nums,dp);

        dp[x][i]=(take ||notTake) ? 1 : 0;
        return  take || notTake;
    }

    public boolean canPartition(int[] nums) {
      
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum%2!=0)
         return false;
         int target=sum/2;
         int n=nums.length;
          int [][]dp=new int[target+1][n];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        } 
        return fun(sum / 2, 0, nums,dp);
    }
}