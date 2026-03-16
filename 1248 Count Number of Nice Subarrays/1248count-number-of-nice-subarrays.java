class Solution {

    public int numberOfSubarrays(int[] nums, int k) {

        /*
        Problem:
        Count subarrays with exactly K odd numbers.

        Key Idea (Striver approach):
        -----------------------------
        Sliding window can easily count subarrays with "AT MOST K" odds,
        but not directly "EXACTLY K".

        So we use the trick:

            exactly(K) = atMost(K) - atMost(K-1)

        Why?
        atMost(K) contains subarrays with:
            0,1,2,...K odds

        atMost(K-1) contains:
            0,1,2,...K-1 odds

        Subtracting gives:
            exactly K odds.
        */

        return numberOfSubarraysWithSumK(nums, k) 
             - numberOfSubarraysWithSumK(nums, k - 1);
    }



    private int numberOfSubarraysWithSumK(int[] nums, int k) {

        /*
        Edge Case:
        ----------
        If k < 0 → impossible to have negative odd count.

        ⚠️ MISTAKE YOU MADE EARLIER:
        You did not handle this case.
        When k = 0 → we call atMost(-1) which should return 0.
        */
        if (k < 0) return 0;


        int l = 0;          // left pointer of sliding window
        int r = 0;          // right pointer
        int count = 0;      // number of odd numbers in window
        int result = 0;     // total subarrays with atMost(K)


        /*
        Sliding Window Logic
        --------------------
        Maintain window such that:

            oddCount <= K
        */

        while (r < nums.length) {


            /*
            EXPAND WINDOW

            Add nums[r] into window.

            ⚠️ MISTAKE YOU MADE EARLIER:
            You accidentally used nums[l] instead of nums[r].

            Rule to remember:
                r → element ENTERING window
                l → element LEAVING window
            */

            if (nums[r] % 2 == 1)
                count++;


            /*
            SHRINK WINDOW if invalid.

            If odd count exceeds K,
            move left pointer until valid again.
            */

            while (count > k) {

                if (nums[l] % 2 == 1)
                    count--;

                l++;
            }


            /*
            COUNT VALID SUBARRAYS

            If window [l..r] is valid,
            all subarrays ending at r are valid:

                [l..r]
                [l+1..r]
                ...
                [r..r]

            Total = (r - l + 1)

            ⚠️ MISTAKE YOU MADE EARLIER:
            You used result++ which counts only ONE subarray,
            but multiple valid subarrays may end at the same r.
            */

            result += r - l + 1;


            /*
            Move right pointer
            */
            r++;
        }

        return result;
    }


    /*
    ------------------------------------------------
    Time Complexity (Striver):
    ------------------------------------------------

    r moves from 0 → N
    l moves from 0 → N

    Total pointer movement ≤ 2N

    TC = O(N)


    ------------------------------------------------
    Space Complexity:
    ------------------------------------------------

    Only a few variables used.

    SC = O(1)


    ------------------------------------------------
    Pattern Recognition (IMPORTANT)
    ------------------------------------------------

    Whenever a problem asks:

        "Count subarrays with EXACTLY K something"

    First check if it can be converted to:

        atMost(K) - atMost(K-1)

    Examples using the SAME trick:

        Binary Subarrays With Sum
        Count Nice Subarrays
        Subarrays With K Distinct Elements
    */
}