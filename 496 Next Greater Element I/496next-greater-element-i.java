class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // We use a monotonic decreasing stack (top will always be the nearest greater candidate).
        // Idea:
        // For each element in nums2, find its Next Greater Element (NGE) to the right.
        // Then answer queries for nums1 using a lookup table.

        Stack<Integer> st = new Stack<>();

        // Lookup table for NGE of each value in nums2.
        // Constraints: 0 <= nums[i] <= 10000, so we can use direct indexing instead of HashMap.
        int[] ngeHashTable = new int[10001];

        // Step 1: Pre-compute NGE for nums2 from right to left
        // Why right to left?
        // Because stack then stores only elements to the right of current index.
        for (int i = nums2.length - 1; i >= 0; i--) {

            // Pop all elements <= current element
            // because they cannot be the NGE of current element (or any element further left).
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            // If stack becomes empty -> no greater element exists on the right side
            // otherwise stack top is the first greater element
            ngeHashTable[nums2[i]] = st.isEmpty() ? -1 : st.peek();

            // Push current element to stack as it can be NGE for elements on the left
            st.push(nums2[i]);
        }

        // Step 2: Fill answer for nums1 using NGE computed from nums2
        for (int j = 0; j < nums1.length; j++) {
            nums1[j] = ngeHashTable[nums1[j]];
        }

        return nums1;

        /*
         * Time Complexity (TC):
         * - Building NGE for nums2: O(n) where n = nums2.length (each element pushed/popped at most once)
         * - Answering nums1 queries: O(m) where m = nums1.length
         * Overall: O(n + m)
         *
         * Space Complexity (SC):
         * - Stack: O(n) worst-case
         * - Lookup array: O(10001) ~ O(1) (constant size due to constraints)
         * Overall: O(n)
         */
    }
}
