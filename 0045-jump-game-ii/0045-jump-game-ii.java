class Solution {
    public int jump(int[] nums) {

        // Number of jumps taken so far
        int totalJump = 0;

        // Farthest index reachable from current range
        int coverage = 0;

        // End of current jump range (current BFS level)
        int lastIndex = 0;

        // Target index to reach
        int destination = nums.length - 1;

        // No need to process destination itself
        for (int i = 0; i < destination; i++) {

            // Update farthest position reachable
            coverage = Math.max(coverage, i + nums[i]);

            // Reached end of current jump range
            if (i == lastIndex) {

                // Move to next jump range
                lastIndex = coverage;

                // One jump consumed
                totalJump++;

                // Destination already covered
                if (coverage >= destination)
                    return totalJump;
            }
        }

        return totalJump;
    }
}

/*
 * Intuition:
 *
 * Think of indices as BFS levels/ranges.
 *
 * lastIndex -> end of current range reachable using current jumps
 *
 * coverage -> farthest index reachable from all positions
 *             inside current range
 *
 * Whenever we reach lastIndex:
 * - Current range is exhausted
 * - We must take another jump
 * - New range becomes [old lastIndex + 1 ... coverage]
 *
 * Example:
 *
 * nums = [2,3,1,1,4]
 *
 * Jump 0:
 * Range = [0]
 *
 * From index 0:
 * coverage = 2
 *
 * Jump 1:
 * Range = [1,2]
 *
 * From indices 1,2:
 * coverage = 4
 *
 * Jump 2:
 * Destination reached
 *
 * Answer = 2
 *
 * TC: O(n)
 * SC: O(1)
 */