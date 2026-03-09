class Solution {

    public int longestOnes(int[] nums, int k) {

        /*
        Problem:
        --------
        We are given a binary array (0s and 1s).
        We can flip at most k zeros to ones.

        Goal:
        -----
        Find the length of the longest subarray that can contain only 1s
        after flipping at most k zeros.

        Example:
        --------
        nums = [1,1,1,0,0,0,1,1,1,1,0]
        k = 2

        We can flip two 0s to get the longest block of 1s.
        */

        /*
        Approach:
        ---------
        Sliding Window with variable size.

        Window definition:
        [l .... r]

        We expand r to include elements.
        We track how many zeros are inside the window.

        Constraint:
        ----------
        We can allow at most k zeros in the window.

        If zeroCount exceeds k:
            shrink window from left until valid again.
        */

        int l = 0;              // left pointer of window
        int r = 0;              // right pointer
        int maxLength = 0;      // stores best window size
        int zeroesCount = 0;    // count of zeros inside window

        while (r < nums.length) {

            /*
            Step 1: expand window by including nums[r]
            */
            if (nums[r] == 0) {
                zeroesCount++;
            }

            /*
            Step 2: if window becomes invalid (too many zeros),
            shrink window from the left.
            */
            if (zeroesCount > k) {

                if (nums[l] == 0) {
                    zeroesCount--;
                }

                l++;  // move left pointer
            }

            /*
            Step 3: window is valid when zeroesCount <= k

            update the maximum length of such window
            */
            if (zeroesCount <= k) {
                maxLength = Math.max(r - l + 1, maxLength);
            }

            /*
            Step 4: expand window
            */
            r++;
        }

        return maxLength;

        /*
        Time Complexity:
        ----------------
        O(N)

        Because:
        - r moves at most N times
        - l moves at most N times

        Total pointer movement ≤ 2N.

        Space Complexity:
        -----------------
        O(1)

        We only use a few variables.
        */
    }
}