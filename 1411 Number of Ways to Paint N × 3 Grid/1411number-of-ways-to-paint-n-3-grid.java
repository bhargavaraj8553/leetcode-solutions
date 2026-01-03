class Solution {

    public int numOfWays(int n) {

        // We have to return the answer modulo 10^9 + 7
        // because the number of ways grows very fast
        final int MOD = 1000000007;

        /*
         * x = number of ways where the LAST painted row
         *     is of TYPE A (all 3 colors are different, like R-Y-G)
         *
         * y = number of ways where the LAST painted row
         *     is of TYPE B (first and third same, like R-Y-R)
         *
         * For n = 1:
         *  - Type A patterns = 6
         *  - Type B patterns = 6
         */
        long x = 6;   // dpA[1]
        long y = 6;   // dpB[1]

        /*
         * We already handled row 1.
         * Now we compute results for rows 2 to n.
         *
         * At each step, we calculate:
         *  - new_x = ways to make current row TYPE A
         *  - new_y = ways to make current row TYPE B
         *
         * These depend ONLY on the previous row's x and y.
         */
        for (int i = 2; i <= n; i++) {

            /*
             * new_x (Type A row):
             *
             * 1) From previous Type A row:
             *    - There are 3 valid ways to form a Type A row
             *      without violating vertical constraints
             *
             * 2) From previous Type B row:
             *    - There are 2 valid ways to form a Type A row
             *
             * Total:
             *   new_x = 3 * x + 2 * y
             */
            long new_x = (3 * x + 2 * y) % MOD;

            /*
             * new_y (Type B row):
             *
             * 1) From previous Type A row:
             *    - There are 2 valid ways to form a Type B row
             *
             * 2) From previous Type B row:
             *    - There are 2 valid ways to form a Type B row
             *
             * Total:
             *   new_y = 2 * x + 2 * y
             */
            long new_y = (2 * x + 2 * y) % MOD;

            // Move DP forward:
            // current row becomes the "previous row" for next iteration
            x = new_x;
            y = new_y;
        }

        /*
         * Final answer:
         * - The last row can be either Type A or Type B
         * - So total ways = x + y
         */
        return (int) ((x + y) % MOD);
    }
}
