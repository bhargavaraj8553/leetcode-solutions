
class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums){
            count.put(num, count.getOrDefault(num, 0)+1);
            if (count.get(num)== nums.length/2){
                return num;
            }
        }
        return -1;

    }
}