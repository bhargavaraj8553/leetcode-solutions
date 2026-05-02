
class Solution {
    public boolean canPartition(int[] nums) {
        int target =0;
        for (int i:nums){
            target+=i;
        }
        if (target%2!=0) return false;
        int[][] dp = new int[nums.length][(target/2)+1];
        for (int [] row: dp){
            Arrays.fill(row, -1);
        }
        return func(nums, nums.length-1, 0, target/2, dp);
    }

    private boolean func(int[] nums, int i, int ans, int target, int[][] dp){
        if (ans== target){
            return true;
        }
        if (i==0){
            return ans + nums[i] == target;
        }
        if (dp[i][ans]!=-1){
            return dp[i][ans]==1;
        }
        boolean take = false;
        if (ans+nums[i]<=target){
            take= func(nums, i-1, ans+nums[i], target, dp);
        }
        boolean notTake = func(nums, i-1, ans, target, dp);
        boolean result = take || notTake;
        dp[i][ans] = result? 1:0;
        return result;
    }
}