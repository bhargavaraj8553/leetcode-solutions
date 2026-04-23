class Solution {

    /*
    =========================================================
    🧠 INTUITION
    =========================================================
    Problem: House Robber

    Rule:
    - Cannot rob adjacent houses

    At every index i, we have 2 choices:
    1. Rob current house → move to i+2
    2. Skip current house → move to i+1

    Goal:
    Maximize total money

    =========================================================
    💡 HOW TO THINK
    =========================================================
    This is a classic DP problem:
    "Make a decision at every index"

    NOT:
    - Don't force a path
    - Don't try future jumps manually (like i+3)

    =========================================================
    */

    public int rob(int[] nums) {

        // dp[i] = max money we can get starting from index i
        int[] dp = new int[nums.length];

        // initialize with -1 (means not computed yet)
        Arrays.fill(dp, -1);

        return func(nums, 0, dp);
    }

    public int func(int[] nums, int i, int[] dp){

        // Base case: out of bounds → no money
        if (i >= nums.length) return 0;

        // If already computed → reuse result (memoization)
        if (dp[i] != -1) return dp[i];

        /*
        =========================================================
        CHOICES
        =========================================================
        */

        // Option 1: rob this house → skip next house
        int robThisHouse = nums[i] + func(nums, i + 2, dp);

        // Option 2: skip this house → go to next
        int skipThisHouse = func(nums, i + 1, dp);

        // Store and return best choice
        return dp[i] = Math.max(robThisHouse, skipThisHouse);

        /*
        =========================================================
        ⏱️ TIME & SPACE COMPLEXITY
        =========================================================

        Time:
        O(n)
        - Each index computed once due to memoization

        Space:
        O(n) → dp array
        O(n) → recursion stack (worst case)

        =========================================================
        🚨 YOUR PAST MISTAKES (IMPORTANT)
        =========================================================

        ❌ MISTAKE #1:
        Forced robbing current house

        👉 Earlier:
        nums[i] + func(i+2) OR nums[i] + func(i+3)

        ❌ You never considered skipping

        -----------------------------------------------------

        ❌ MISTAKE #2:
        Thinking in terms of "future jumps"

        👉 Wrong mindset:
        "Should I go to i+2 or i+3?"

        ✅ Correct:
        "Rob OR Skip at current index"

        -----------------------------------------------------

        ❌ MISTAKE #3:
        Tried starting recursion from every index

        👉 Not needed → DP handles all cases from index 0

        -----------------------------------------------------

        ❌ MISTAKE #4:
        Exponential recursion (no memoization)

        👉 Fixed now using dp[]

        =========================================================
        🔥 FINAL RULE
        =========================================================

        DP problems = decision at each index

        rob(i) = max(
            nums[i] + rob(i+2),
            rob(i+1)
        )

        =========================================================
        */
    }
}