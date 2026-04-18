class Solution {

    /*
    =========================================================
    🧠 INTUITION (BRIEF)
    =========================================================
    - Always try to use bricks first
    - But bricks are limited → we want to save them
    - If a bigger climb appears later:
        → replace previous large brick usage with ladder
    - Use MAX HEAP to track largest climbs where bricks were used

    =========================================================
    💡 CORE IDEA
    =========================================================
    - pq stores climbs where bricks were used
    - If we run out of bricks:
        → use ladder
        → and if needed, swap largest past brick usage
    */

    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        // max heap → track largest brick usage
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;

        for (; i < heights.length - 1; i++) {

            // no cost if next building is lower/equal
            if (heights[i + 1] <= heights[i]) {
                continue;
            }

            int diff = heights[i + 1] - heights[i];

            // use bricks if possible
            if (bricks >= diff) {
                bricks -= diff;
                pq.add(diff); // track where bricks were used

            } else if (ladders > 0) {

                // try to optimize by swapping
                if (!pq.isEmpty()) {

                    int max_bricks_past = pq.peek();

                    // if previous climb was bigger → better to use ladder there
                    if (max_bricks_past > diff) {

                        // refund bricks
                        bricks += max_bricks_past;
                        pq.remove();

                        // use bricks for current smaller climb
                        bricks -= diff;
                        pq.add(diff);
                    }
                }

                // use ladder
                ladders--;

            } else {
                // no bricks or ladders → stop
                break;
            }
        }

        return i;

        /*
        =========================================================
        ⏱️ TIME & SPACE
        =========================================================

        Time:
        O(n log n)
        - each insert/remove from heap → log n

        Space:
        O(n)
        - heap stores climbs

        =========================================================
        🔥 KEY TAKEAWAY
        =========================================================

        - Greedy decision:
          use ladder for largest climb

        - Max heap helps:
          "replace previous worst brick usage"

        =========================================================
        */
    }
}