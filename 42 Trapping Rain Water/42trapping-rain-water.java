class Solution {
    public int trap(int[] height) {

        // Two Pointer Approach (Optimal)
        //
        // Idea:
        // Water trapped at any index depends on:
        // min(maxLeft, maxRight) - height[i]
        //
        // Using two pointers, we can avoid extra arrays.
        // We maintain:
        // lMax = max height seen so far from left
        // rMax = max height seen so far from right

        int lMax = 0, rMax = 0, total = 0;
        int l = 0, r = height.length - 1;

        // We move the pointer which has smaller height,
        // because the smaller side decides the water level (min boundary).
        while (l < r) {

            // If left wall is smaller, then water at l depends only on lMax
            if (height[l] < height[r]) {

                // If current height is smaller than lMax,
                // it means water can be trapped here.
                if (lMax > height[l]) {
                    total += lMax - height[l];
                } 
                // else update lMax
                else {
                    lMax = height[l];
                }

                l++; // move left pointer
            } 
            // Else right wall is smaller or equal,
            // then water at r depends only on rMax
            else {

                // If current height is smaller than rMax,
                // water can be trapped here.
                if (rMax > height[r]) {
                    total += rMax - height[r];
                } 
                // else update rMax
                else {
                    rMax = height[r];
                }

                r--; // move right pointer
            }
        }

        return total;

        /*
         * Time Complexity (TC): O(N)
         * - Each pointer moves at most N times, so total traversal is linear.
         *
         * Space Complexity (SC): O(1)
         * - No extra arrays/stack used, only variables.
         */
    }
}
