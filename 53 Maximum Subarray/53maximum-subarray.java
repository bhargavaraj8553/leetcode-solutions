class Solution {
    public int maxSubArray(int[] nums) {
        //kadane's algorithm
        //to get the subarray start and end index
        int maxSum = nums[0];
        int sum = 0;
        int initialStart= 0;
        int ansStart=0;
        int ansEnd=0;
        for (int i=0;i<nums.length;i++) {
            if (sum==0){
                initialStart= i;
            }
            sum += nums[i];
            if (maxSum < sum) {
                maxSum = sum;
                ansStart = initialStart;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println("The start and end index of subarray are :" +  ansStart + " and " + ansEnd);
        return maxSum;

    }
}