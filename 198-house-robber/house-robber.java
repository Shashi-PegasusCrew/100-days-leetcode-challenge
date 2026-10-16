
class Solution {
    int fun(int[] nums){
         int prev2 = 0;
        int prev1 = 0;

        for (int i = 0; i < nums.length; i++) {
            int take = nums[i] + prev2;
            int notTake = prev1;

            int curr = Math.max(take, notTake);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
    public int rob(int[] nums) {
        return fun(nums);
       
    }
}
