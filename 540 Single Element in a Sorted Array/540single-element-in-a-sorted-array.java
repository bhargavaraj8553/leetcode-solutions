class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        if (nums.length==1) return nums[0];
        while (left<=right){
            int mid = (left + right) /2;
            if (mid==0 && nums[mid]!= nums[mid+1] ||
                    mid == nums.length-1 && nums[mid]!= nums[mid-1] ||
                    nums[mid]!= nums[mid+1] && nums[mid]!= nums[mid-1]){
                return nums[mid];
            }
            else if ((mid%2==0) && nums[mid+1]== nums[mid]){
                left = mid +1;
            } else if ((mid%2==1) && nums[mid-1]== nums[mid]) {
                left = mid +1;
            } else {
                right = mid -1;
            }
        }
        return 0;
    }
}