class Solution {

    public long subArrayRanges(int[] nums) {

        /*
         * Problem:
         * Sum of (max - min) over all subarrays.
         *
         * Brute Force intuition:
         * Generate all subarrays (O(N^2)) and for each subarray find max/min (O(N)) -> O(N^3).
         * Even if you optimize max/min inside subarray, still O(N^2) which is too slow.
         *
         * Optimized thought process (Key Observation):
         * Sum(max - min) over all subarrays
         * = Sum of all subarray maximums - Sum of all subarray minimums
         *
         * So we solve 2 separate problems:
         * 1) Sum of subarray maximums
         * 2) Sum of subarray minimums
         *
         * Contribution technique:
         * Instead of iterating subarrays, for each element nums[i]:
         * - count in how many subarrays nums[i] is the MAX
         * - count in how many subarrays nums[i] is the MIN
         *
         * Then:
         * total += nums[i] * countMax(i) - nums[i] * countMin(i)
         *
         * How to compute counts fast?
         * countMax(i) = (ways to extend left as MAX) * (ways to extend right as MAX)
         * countMin(i) = (ways to extend left as MIN) * (ways to extend right as MIN)
         *
         * To find left/right extension boundaries we use monotonic stacks:
         * - Next Greater element index
         * - Previous Greater or Equal index
         * - Next Smaller element index
         * - Previous Smaller or Equal index
         *
         * Duplicate handling (MOST IMPORTANT):
         * For MAX:
         * - Next strictly greater (>)  --> avoids double counting
         * - Previous greater or equal (>=)
         *
         * For MIN:
         * - Next strictly smaller (<)
         * - Previous smaller or equal (<=)
         */

        int n = nums.length;

        // For maximum contribution boundaries
        int[] nextGreaterElement = getNextGreaterElement(nums);              // Next Greater (strict)
        int[] prevGreaterOrEqualElement = getprevGreaterElement(nums);       // Prev Greater or Equal

        // For minimum contribution boundaries
        int[] nextSmallerElement = getNextSmallerElement(nums);              // Next Smaller (strict)
        int[] prevSmallerOrEqualElement = getprevSmallerOrEqualElement(nums);// Prev Smaller or Equal

        long ans = 0;

        // Each nums[i] contributes as both max and min in different subarrays
        for (int i = 0; i < n; i++) {

            // Count of subarrays where nums[i] is MAX:
            // choose start from (prevGreaterOrEqual+1 ... i)
            // choose end   from (i ... nextGreater-1)
            long countAsMax = (long) (nextGreaterElement[i] - i) * (i - prevGreaterOrEqualElement[i]);

            // Count of subarrays where nums[i] is MIN:
            // choose start from (prevSmallerOrEqual+1 ... i)
            // choose end   from (i ... nextSmaller-1)
            long countAsMin = (long) (nextSmallerElement[i] - i) * (i - prevSmallerOrEqualElement[i]);

            // Total range contribution of nums[i]
            ans += (long) nums[i] * countAsMax - (long) nums[i] * countAsMin;
        }

        /*
         * Time Complexity (TC): O(10N)
         * - 4 monotonic stack computations: each O(2N) => O(8N)
         * - final contribution loop: O(N)
         * Total: O(9N) ~ written as O(10N)
         *
         * Space Complexity (SC): O(6N)
         * - 4 arrays: O(4N)
         * - stack used: O(N) per helper (not simultaneously, but worst-case)
         * Total ~ O(5N) / O(6N) in detailed Striver-style counting
         */
        return ans;
    }


    // ------------------------ MIN Boundaries ------------------------

    /*
     * Previous Smaller or Equal Element Index (PSEE / PSSE)
     *
     * Why "Smaller OR Equal" here?
     * To handle duplicates properly so subarrays are counted once.
     *
     * Monotonic stack type:
     * Increasing stack of indices (nums[stack] increasing)
     */
    private int[] getprevSmallerOrEqualElement(int[] nums) {
        int n = nums.length;
        int[] psse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            // pop until stack top becomes <= nums[i]
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            psse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psse;
    }

    /*
     * Next Smaller Element Index (NSE) - Strictly smaller
     *
     * We use >= pop so remaining top becomes strictly smaller.
     */
    private int[] getNextSmallerElement(int[] nums) {
        int n = nums.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            // pop until top becomes < nums[i]
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }


    // ------------------------ MAX Boundaries ------------------------

    /*
     * Previous Greater or Equal Element Index (PGEE)
     *
     * pop while nums[top] < nums[i]
     * so remaining top becomes >= nums[i]
     */
    private int[] getprevGreaterElement(int[] nums) {
        int n = nums.length;
        int[] pgee = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            // pop smaller elements to maintain decreasing stack
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            pgee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pgee;
    }

    /*
     * Next Greater Element Index (NGE) - Strictly greater
     *
     * pop while nums[top] <= nums[i]
     * so remaining top becomes > nums[i]
     */
    private int[] getNextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            // pop until top becomes > nums[i]
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nge;
    }
}
