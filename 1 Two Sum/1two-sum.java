
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(valueIndexMap.containsKey(target - nums[i])){
                ans[0] = Math.min(valueIndexMap.get(target - nums[i]), i);
                ans[1] = Math.max(valueIndexMap.get(target - nums[i]), i);
            }
            valueIndexMap.put(nums[i], i);
        }
        return ans;
    }
}