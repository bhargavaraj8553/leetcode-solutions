class Solution {
    public boolean check(int[] nums) {
        int inversionCount = 0;
        int n = nums.length;
        if (n<2) return true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]<nums[i-1]){
                inversionCount++;
                if(inversionCount>1) return false;
            }
        }
        if (nums[0]<nums[n-1]) inversionCount++;
        return inversionCount<=1;
    }
}