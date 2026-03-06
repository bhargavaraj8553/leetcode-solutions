class Solution {
    public void sortColors(int[] nums) {

        /*
        Problem:
        The array contains only three values: 0, 1, and 2.
        We must sort it in-place in ONE pass and constant space.

        Intuition:
        Instead of sorting normally, we divide the array into regions.

        Regions we maintain during the algorithm:

        [0 ... low-1]     → all 0s
        [low ... mid-1]   → all 1s
        [mid ... high]    → unknown elements (not processed yet)
        [high+1 ... end]  → all 2s

        Visual representation during execution:

            0s | 1s | unknown | 2s
               low  mid      high

        Our goal is to shrink the "unknown" region.
        */

        int low = 0;                   // next position where a 0 should go
        int mid = 0;                   // current element we are inspecting
        int high = nums.length - 1;    // next position where a 2 should go

        /*
        Continue processing while unknown region exists.
        */
        while (mid <= high) {

            /*
            Case 1: nums[mid] == 1

            1 belongs in the middle region.
            It is already correctly positioned between 0s and 2s.

            So we simply move forward.
            */
            if (nums[mid] == 1) {
                mid++;
            }

            /*
            Case 2: nums[mid] == 0

            0 belongs on the left side.

            Swap it with the position pointed by 'low'.

            After swap:
            - the 0 goes into the correct region
            - the element swapped to mid must be 1
              (because region [low ... mid-1] contains only 1s)

            Therefore both pointers can move forward.
            */
            else if (nums[mid] == 0) {
                swap(mid, low, nums);
                low++;
                mid++;
            }

            /*
            Case 3: nums[mid] == 2

            2 belongs on the right side.

            Swap it with the position pointed by 'high'.

            IMPORTANT:
            We DO NOT move mid here.

            Because the element coming from the right side is unknown
            and must be checked again.

            So we only shrink the right boundary.
            */
            else {
                swap(mid, high, nums);
                high--;
            }
        }

        /*
        Time Complexity (TC):
        O(n)
        Each element is processed at most once.

        Space Complexity (SC):
        O(1)
        Sorting happens in-place without extra memory.
        */
    }

    /*
    Helper method to swap two indices in the array.
    */
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}