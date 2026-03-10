class Solution {
    public int totalFruit(int[] fruits) {

        /*
        Problem:
        --------
        We want the longest subarray containing at most 2 distinct fruit types.

        Interpretation:
        ----------------
        You have two baskets.
        Each basket can hold only one fruit type.
        You move from left to right picking fruits.

        So we must maintain a window with at most 2 fruit types.

        Sliding Window Representation:

            [ l ......... r ]

        l → left pointer
        r → right pointer

        fruitFreqMap → stores frequency of fruits currently inside window
        */

        int l = 0;
        int r = 0;
        int maxLength = 0;

        HashMap<Integer, Integer> fruitFreqMap = new HashMap<>();


        /*
        Standard Sliding Window Approach (Recommended):

        Expand r
        If window becomes invalid (>2 fruit types)
            shrink l until valid again
        Update answer
        */

        while (r < fruits.length) {

            // Add the current fruit into the window
            fruitFreqMap.put(
                    fruits[r],
                    fruitFreqMap.getOrDefault(fruits[r], 0) + 1
            );


            /*
            If window becomes invalid
            (more than 2 fruit types)
            shrink from the left until valid
            */
            while (fruitFreqMap.size() > 2) {

                int freq = fruitFreqMap.get(fruits[l]);

                // Decrease frequency of left fruit
                if (freq == 1) {
                    fruitFreqMap.remove(fruits[l]);
                } else {
                    fruitFreqMap.put(fruits[l], freq - 1);
                }

                l++;
            }

            /*
            Window is now valid (≤2 fruit types)
            update maximum window length
            */
            maxLength = Math.max(maxLength, r - l + 1);

            r++;
        }

        return maxLength;
    }



    /*
    ---------------------------------------------------
    YOUR "IF VERSION" (COMMENTED)
    ---------------------------------------------------

    This version shrinks the window only once per step.

    It can work for many cases, but it does NOT guarantee
    that the window becomes valid immediately.

    Standard sliding window pattern prefers using:

        while (window invalid)

    so the window invariant is always restored.
    */


    /*
    public int totalFruit(int[] fruits) {

        int l=0, r=0, maxLength=0;
        HashMap<Integer, Integer> fruitFreqMap = new HashMap<>();

        while (r < fruits.length) {

            // Add fruit to window
            fruitFreqMap.put(fruits[r],
                    fruitFreqMap.getOrDefault(fruits[r], 0) + 1);

            // If window becomes invalid
            if (fruitFreqMap.size() > 2) {

                int freqL = fruitFreqMap.get(fruits[l]);

                if (freqL == 1) {
                    fruitFreqMap.remove(fruits[l]);
                } else {
                    fruitFreqMap.put(fruits[l], freqL - 1);
                }

                l++;
            }

            // If window valid update answer
            if (fruitFreqMap.size() <= 2) {
                maxLength = Math.max(r - l + 1, maxLength);
            }

            r++;
        }

        return maxLength;
    }
    */


    /*
    Time Complexity:
    ----------------
    r moves at most N times
    l moves at most N times

    Total pointer movement ≤ 2N

    O(2N) → O(N)


    Space Complexity:
    -----------------
    O(1)

    Because map size never exceeds 3
    (at most 3 before shrinking)
    */
}