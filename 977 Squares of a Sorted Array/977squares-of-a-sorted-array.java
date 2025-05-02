
class Solution {
    public int[] sortedSquares(int[] nums) {
        int i=0;
        int j= nums.length-1;
        int k = nums.length-1;

        int[] result = new int[nums.length];

        while (i<=j){
            if (sq(nums[i])> sq(nums[j])){
                result[k--]= sq(nums[i++]);
            } else {
                result[k--] = sq(nums[j--]);
            }
        }
        return result;

    }

    private int sq(int n){
        return n*n;
    }
}