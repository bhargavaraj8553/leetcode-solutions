class Solution {
    public int findMaxLength(int[] nums) {

        // Map to store: prefixSum -> first index where it appeared
        Map<Integer, Integer> map = new HashMap<>();

        // Important:
        // Prefix sum 0 at index -1 means before array starts sum = 0
        // Helps capture subarrays starting from index 0
        map.put(0, -1);

        int sum = 0;      // Running prefix sum
        int maxLen = 0;   // Result: longest length found

        for (int i = 0; i < nums.length; i++) {

            // Convert 0 to -1 so that:
            // equal number of 0s and 1s ⇒ total sum becomes 0
            sum += (nums[i] == 0) ? -1 : 1;

            // If this prefix sum was seen before,
            // subarray between previous index and current index sums to 0
            if (map.containsKey(sum)) {
                int prevIndex = map.get(sum);
                maxLen = Math.max(maxLen, i - prevIndex);
            } else {
                // Store only FIRST occurrence of this prefix sum
                // because earlier index gives longer subarray
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}
