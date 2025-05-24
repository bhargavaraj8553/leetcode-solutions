class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int overallMaxValue=0;
        int localMaxValue=0;
        for (int num:nums){
            if (num==1) localMaxValue++;
            else {
                overallMaxValue= Math.max(localMaxValue,overallMaxValue);
                localMaxValue =0;
            }
        }
        return Math.max(localMaxValue,overallMaxValue);
    }
}
