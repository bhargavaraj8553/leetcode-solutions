class Solution {

    // 🔹 Memoization (Top-Down DP) – Cherry Pickup II (2 robots)

    // 🧠 Brute force intuition:
    // Two robots start at:
    //   robot1 → (0, 0)
    //   robot2 → (0, c-1)
    //
    // At each row i:
    //   robot1 can go: j1 → (j1-1, j1, j1+1)
    //   robot2 can go: j2 → (j2-1, j2, j2+1)
    //
    // Total 9 combinations at every step
    //
    // Collect cherries:
    //   if both on same cell → count once
    //   else → count both

    // ✅ DP state:
    // dp[i][j1][j2] = max cherries from row i → last row
    // when robot1 at j1 and robot2 at j2

    // 🚀 Why memoization:
    // Same (i, j1, j2) repeats → avoid recomputation

    // TC: O(r * c * c * 9) ≈ O(r * c^2)
    // SC: O(r * c * c) + recursion stack

    public int cherryPickup(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        int[][][] dp = new int[r][c][c];

        // initialize dp with -1 → uncomputed
        for (int[][] squareDp : dp) {
            for (int[] singleRow : squareDp) {
                Arrays.fill(singleRow, -1);
            }
        }

        return func(grid, 0, 0, c - 1, r, c, dp);
    }

    private static int func(int[][] grid, int i, int j1, int j2,
                            int m, int n, int[][][] dp) {

        // ❌ Out of bounds → invalid path
        // return very small so it never affects max
        if (j1 < 0 || j1 > n - 1 || j2 < 0 || j2 > n - 1)
            return Integer.MIN_VALUE / 2;

        // ✅ Base case: last row
        // collect cherries (avoid double count)
        if (i == m - 1) {
            if (j1 != j2) return grid[i][j1] + grid[i][j2];
            else return grid[i][j1];
        }

        // 🔁 reuse computed result
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int maxi = Integer.MIN_VALUE;

        // 🔹 try all 9 combinations of moves
        for (int d1 = -1; d1 < 2; d1++) {
            for (int d2 = -1; d2 < 2; d2++) {

                // 🧠 current row contribution
                int curr;
                if (j1 == j2) curr = grid[i][j1];          // same cell → count once
                else curr = grid[i][j1] + grid[i][j2];     // different → count both

                // ➡️ next state (row i+1)
                int next = func(grid, i + 1, j1 + d1, j2 + d2, m, n, dp);

                // 🔄 take best among all 9 possibilities
                maxi = Math.max(maxi, curr + next);
            }
        }

        // store result
        return dp[i][j1][j2] = maxi;
    }
}


/*
🔥 YOUR UNDERSTANDING (important)

1. ❌ Earlier mistake:
   - Tried solving as 2 independent paths → WRONG

2. ❌ Then:
   - Single robot DP → WRONG

3. ✅ Now:
   - State (i, j1, j2) → CORRECT
   - 9 transitions → CORRECT
   - Same cell handling → CORRECT
   - Memoization → CORRECT


⚠️ Possible mistakes (not in your code now):

- Forgetting j1 == j2 case → double counting
- Returning 0 for invalid → wrong max result
- Missing one of 9 transitions → incomplete solution
- Not using dp → exponential time


🧠 Final DP relation:

func(i, j1, j2) =
    cherries at current row
    +
    max over all (d1, d2 ∈ {-1,0,1})
        func(i+1, j1+d1, j2+d2)


🚀 Next step (important for interviews):

Convert this → TABULATION
Then → SPACE OPTIMIZATION (2D → 1D)

This is a classic high-value DP pattern.
*/