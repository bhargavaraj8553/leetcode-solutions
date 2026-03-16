
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numberOfSubarrays(nums, goal)- numberOfSubarrays(nums, goal-1);
    }

    public int numberOfSubarrays(int[] nums, int k) {
        //[2,2,2,1,2,2,1,2,2,2] k=2
        if (k < 0) return 0;
        int result =0;
        int l =0, r=0, sum=0;
        while (r< nums.length){
            sum+= nums[r];
            while (sum>k && l< nums.length){
                sum -= nums[l];
                l++;
            }
            if (sum<=k){
                result+= r-l+1;
            }
            r++;
        }
        return result;
    }
}

   