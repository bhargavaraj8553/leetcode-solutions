class Solution {
    public int sumSubarrayMins(int[] arr) {

        // We need Sum of Minimums of all subarrays.
        // Contribution Technique:
        // For each element arr[i], count in how many subarrays it becomes the minimum.
        //
        // Contribution = arr[i] * leftChoices * rightChoices
        //
        // leftChoices  = i - PSEE[i]
        // rightChoices = NSE[i] - i
        //
        // PSEE = Previous Smaller Element (strictly smaller / smaller or equal handling)
        // NSE  = Next Smaller Element

        int[] nse = new int[arr.length];   // stores index of next smaller element
        int[] psee = new int[arr.length];  // stores index of previous smaller element

        int mod = (int) 1e9 + 7;

        // Find next smaller element index for each i
        nse = findnse(arr, nse);

        // Find previous smaller element index for each i
        psee = findpsee(arr, psee);

        long total = 0;

        // Calculate contribution of each arr[i]
        for (int i = 0; i < arr.length; i++) {

            // number of valid starts on the left side
            long left = i - psee[i];

            // number of valid ends on the right side
            long right = nse[i] - i;

            // contribution = arr[i] * left * right
            // using modulo to avoid overflow and because problem asks mod answer
            total = (total + (((left * right) % mod) * arr[i]) % mod) % mod;
        }

        return (int) total;

        /*
         * Time Complexity (TC): O(5N)
         * - findnse(): O(2N)  (each index pushed once + popped at most once)
         * - findpsee(): O(2N) (each index pushed once + popped at most once)
         * - contribution loop: O(N)
         * Total: O(2N + 2N + N) = O(5N)
         *
         * Space Complexity (SC): O(5N)
         * - nse array: O(N)
         * - psee array: O(N)
         * - stack used in findnse: O(N)
         * - stack used in findpsee: O(N)
         * - total/mod/variables: O(1)
         * Total: O(N + N + N + N) = O(4N) ~ can be written as O(5N) including arrays + stacks.
         */
    }

    private int[] findpsee(int[] arr, int[] psee) {
        // PSEE (Previous Smaller Element or Equal index)
        //
        // We maintain a monotonic increasing stack (by values).
        // For each i:
        // pop while stack top value > arr[i]
        // after popping:
        // - stack top is the index of previous smaller/equal element
        // - if stack empty => no previous smaller => -1

        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            // pop until we find element <= arr[i]
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            // if stack empty => no previous smaller element
            if (st.isEmpty()) {
                psee[i] = -1;
            } else {
                psee[i] = st.peek();
            }

            // push current index
            st.push(i);
        }

        return psee;
    }

    private int[] findnse(int[] arr, int[] nse) {
        // NSE (Next Smaller Element index)
        //
        // Traverse from right to left.
        // Maintain monotonic increasing stack (by values).
        // For each i:
        // pop while stack top value >= arr[i]
        // after popping:
        // - stack top is index of next strictly smaller element
        // - if stack empty => no smaller element => n

        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {

            // pop until we find element < arr[i]
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            // if stack empty => no next smaller element
            if (st.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = st.peek();
            }

            // push current index
            st.push(i);
        }

        return nse;
    }
}
