class Solution {
    public int majorityElement(int[] nums) {
        int count =0;
        int maxElement= nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (count==0){
                count = 1;
                maxElement= nums[i];
            }
            else if  (nums[i]==maxElement){
                count++;
            } else{
                count--;
            }
        }
        return maxElement;
    }
}
