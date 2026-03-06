
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumCountMap = new HashMap<>();
        int ansCount =0;
        int prefSum = 0;
        sumCountMap.put(0,1);

        for (int i = 0; i < nums.length; i++) {
            prefSum+=nums[i];
            if (sumCountMap.containsKey(prefSum-k)){
                ansCount+= sumCountMap.get(prefSum-k);
            }
            sumCountMap.put(prefSum, sumCountMap.getOrDefault(prefSum,0)+1);
        }
        return ansCount;
    }
}