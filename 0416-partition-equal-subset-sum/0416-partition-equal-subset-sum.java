class Solution {

    // 🔹 Memoization (Top-Down DP) – Partition Equal Subset Sum

    // 🧠 Intuition (Brute Force):
    // At each index we have 2 choices:
    // 1. Take current number
    // 2. Do not take it
    //
    // Goal:
    // Can we form subset with sum = totalSum/2 ?

    // ✅ DP State:
    // dp[i][target] = can we form "target" using elements [0...i]

    // 💡 How to think:
    // Instead of building sum (ans), reduce target
    // → cleaner DP and correct state mapping

    // TC: O(n * target)
    // SC: O(n * target) + recursion stack

    public boolean canPartition(int[] nums) {

        int target = 0;

        // 🔹 Step 1: find total sum
        for (int i : nums) {
            target += i;
        }

        // ❌ If total sum is odd → cannot split into equal halves
        if (target % 2 != 0) return false;

        target = target / 2;

        int[][] dp = new int[nums.length][target + 1];

        // initialize dp with -1 → uncomputed
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return func(nums, nums.length - 1, target, dp);
    }

    private boolean func(int[] nums, int i, int target, int[][] dp) {

        // ✅ If target becomes 0 → subset found
        if (target == 0) {
            return true;
        }

        // ✅ Base case: only first element left
        if (i == 0) {
            return target == nums[0];
        }

        // 🔁 Reuse computed result
        if (dp[i][target] != -1) {
            return dp[i][target] == 1;
        }

        boolean take = false;

        // ➡️ Take current element (only if possible)
        if (nums[i] <= target) {
            take = func(nums, i - 1, target - nums[i], dp);
        }

        // ➡️ Not take current element
        boolean notTake = func(nums, i - 1, target, dp);

        boolean result = take || notTake;

        // store result
        dp[i][target] = result ? 1 : 0;

        return result;
    }
}


/*
🔥 YOUR PAST MISTAKES (VERY IMPORTANT LEARNING)

1. ❌ Wrong DP state (BIGGEST mistake)
   Earlier you used:
       func(i, ans)
       dp[i][target]
   → mismatch → DP collision → wrong answers

   ✅ Fix:
       func(i, target)
       dp[i][target]

--------------------------------------------------

2. ❌ Using "ans + nums[i]" approach
   → made DP complicated and incorrect mapping

   ✅ Fix:
       reduce target → (target - nums[i])

--------------------------------------------------

3. ❌ Incorrect DP indexing
   Using dp[i][target] while target wasn't changing properly

--------------------------------------------------

4. ❌ Base case confusion
   Missing clear condition for:
       target == 0

--------------------------------------------------

5. ❌ Not understanding overlapping subproblems
   Now fixed:
   State = (i, target), not path taken

--------------------------------------------------

🧠 FINAL MENTAL MODEL

func(i, target) =
    take (if nums[i] <= target)
    OR
    notTake

dp[i][target] stores result

--------------------------------------------------

🚀 TAKEAWAY

Always ensure:
    DP state = parameters that are changing in recursion

*/