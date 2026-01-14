class Solution {
    public int[] nextGreaterElements(int[] nums) {

        // This is "Next Greater Element II" (circular array).
        // We use a monotonic decreasing stack.
        // Stack will store elements (not indices) such that stack top is the next greater candidate.

        Stack<Integer> stMonoTonic = new Stack<>();
        int[] nge2 = new int[nums.length];

        int n = nums.length;

        // Trick for circular array:
        // We traverse from right to left for 2*n elements.
        // Using i % n allows us to reuse indices as if the array is repeated twice.
        for (int i = 2 * n - 1; i >= 0; i--) {

            int idx = i % n;   // maps i to valid index in nums (circular behaviour)

            // Maintain monotonic decreasing stack:
            // Pop all elements <= current element because they cannot be NGE for current.
            while (!stMonoTonic.isEmpty() && stMonoTonic.peek() <= nums[idx]) {
                stMonoTonic.pop();
            }

            // We only store answers for the "original" indices (0 to n-1)
            // i < n ensures we don't overwrite answers during the first half (extra circular scan part)
            if (i < n) {
                // If stack is empty -> no greater element exists (even after circular traversal)
                if (stMonoTonic.isEmpty()) {
                    nge2[idx] = -1;
                } else {
                    // Stack top is the next greater element
                    nge2[idx] = stMonoTonic.peek();
                }
            }

            // Push current element (it can help elements on the left)
            stMonoTonic.push(nums[idx]);
        }

        return nge2;

        /*
         * Time Complexity (TC): O(4N)
         * - Loop runs 2N times
         * - Each element is pushed/popped at most once in total across traversal
         * So overall linear, represented as O(4N) (same as O(N))
         *
         * Space Complexity (SC): O(2N)
         * - Stack can store up to N elements in worst case
         * - Answer array stores N elements
         * Total: O(2N) (same as O(N))
         */
    }
}
