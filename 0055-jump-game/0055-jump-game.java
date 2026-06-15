class Solution {
    public boolean canJump(int[] nums) {

        // Farthest index reachable so far
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            // Current index is unreachable
            if (i > maxIndex) return false;

            // Update farthest reachable index
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }

        // Reached all indices successfully
        return true;
    }
}

/*
 * Greedy Intuition:
 * Track the farthest position we can reach.
 * If we ever reach an index beyond that range,
 * we are stuck and cannot proceed.
 *
 * TC: O(n)
 * SC: O(1)
 */