class Solution {

    // 🔹 TABULATION (Bottom-Up DP)  ← Preferred (fast, no recursion)

    // 🧠 Brute force intuition:
    // From (i, j) → go to:
    // 1. (i+1, j)
    // 2. (i+1, j+1)
    // Take minimum path

    // ✅ DP Thinking:
    // dp[i][j] = triangle[i][j] + min(
    //      dp[i+1][j],
    //      dp[i+1][j+1]
    // )

    // 💡 How to think:
    // Recursion goes TOP → DOWN
    // So tabulation goes BOTTOM → UP
    // Start from last row (already known)

    // 🚀 Why optimized:
    // ❌ No recursion stack
    // ❌ No function calls
    // ✅ Direct computation

    // TC: O(n^2)
    // SC: O(n^2)

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        int[][] dp = new int[n][n];

        // 🔹 Base case: last row
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        // 🔹 Build from bottom → top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {

                dp[i][j] = triangle.get(i).get(j)
                        + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }


    /*
    // 🔹 MEMOIZATION (Top-Down DP)

    // 🧠 Same intuition:
    // func(i, j) = triangle[i][j] + min(
    //      func(i+1, j),
    //      func(i+1, j+1)
    // )

    // ❌ My past issue (important learning):
    // I assumed memoization = always fast
    // BUT recursion overhead + function calls + List access
    // → leads to TLE in Java

    // ❌ Possible mistake:
    // Accessing triangle.get(i) before checking i bounds

    // ❌ Possible mistake:
    // Using wrong column bounds (triangle is NOT rectangular)

    // ❌ Possible mistake:
    // Returning 0 instead of large value → wrong min path

    // TC: O(n^2)
    // SC: O(n^2) + recursion stack

    public int minimumTotal(List<List<Integer>> triangle) {

        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return func(triangle, 0, 0, dp);
    }

    private int func(List<List<Integer>> triangle, int i, int j, int[][] dp) {

        // ❌ Out of bounds
        if (i > triangle.size() - 1) return Integer.MAX_VALUE / 2;

        if (j > triangle.get(i).size() - 1) return Integer.MAX_VALUE / 2;

        // ✅ Base case
        if (i == triangle.size() - 1)
            return dp[i][j] = triangle.get(i).get(j);

        // 🔁 reuse
        if (dp[i][j] != -1) return dp[i][j];

        int sameIndex = triangle.get(i).get(j)
                + func(triangle, i + 1, j, dp);

        int nextIndex = triangle.get(i).get(j)
                + func(triangle, i + 1, j + 1, dp);

        return dp[i][j] = Math.min(sameIndex, nextIndex);
    }
    */


    // 🔥 FINAL TAKEAWAY (VERY IMPORTANT)

    // ❌ Memoization is NOT always fast in practice
    // because of recursion + stack + function calls

    // ✅ Tabulation is preferred for:
    // - large inputs
    // - 2D DP
    // - interview optimal solutions

    // 🧠 Golden rule:
    // If recursion depth or calls are high → convert to tabulation
}