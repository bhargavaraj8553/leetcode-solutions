class Solution {

    /*
    ===============================
    PROBLEM: Binary Tree Level Order Traversal II
    ===============================
    Return the level order traversal of a binary tree
    from BOTTOM level to TOP level.
    */

    /*
    -------------------------------------------------
    1️⃣ BRUTE FORCE INTUITION
    -------------------------------------------------
    - Perform normal level order traversal (top → bottom)
    - Store all levels in a list
    - Reverse the list at the end

    ❌ Problems:
    - Extra pass needed to reverse
    - Slightly less clean
    */

    /*
    -------------------------------------------------
    2️⃣ WHY THIS BFS APPROACH IS OPTIMAL
    -------------------------------------------------
    - Level order traversal is naturally BFS
    - Queue helps process nodes level by level
    - Instead of reversing at the end,
      we directly insert each level at index 0
    - Avoids an extra traversal
    */

    /*
    -------------------------------------------------
    3️⃣ HOW TO THINK ABOUT THIS APPROACH
    -------------------------------------------------
    Ask:
    "Am I dealing with LEVELS of a tree?"

    If YES:
    → BFS using Queue
    → Process nodes level-by-level using queue size

    For bottom-up order:
    → Either reverse at end
    → OR insert each level at front
    */

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        // Final answer: list of levels from bottom to top
        List<List<Integer>> ans = new ArrayList<>();

        // Edge case: empty tree
        if (root == null) return ans;

        // Queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();

        // Start BFS from root
        queue.offer(root);

        /*
        Continue until all levels are processed
        */
        while (!queue.isEmpty()) {

            /*
            Number of nodes at current level
            This is CRITICAL to separate levels
            */
            int queueSize = queue.size();

            // Stores values of nodes at current level
            List<Integer> oneLevel = new ArrayList<>();

            /*
            Process all nodes of current level
            */
            for (int i = 0; i < queueSize; i++) {

                // Remove node from front of queue
                TreeNode top = queue.poll();

                // Add node value to current level list
                oneLevel.add(top.val);

                // Add left child to queue (next level)
                if (top.left != null) queue.offer(top.left);

                // Add right child to queue (next level)
                if (top.right != null) queue.offer(top.right);
            }

            /*
            Insert current level at the BEGINNING
            to achieve bottom-up order
            */
            ans.add(0, oneLevel);
        }

        return ans;
    }

    /*
    -------------------------------------------------
    ⏱ TIME COMPLEXITY (TC)
    -------------------------------------------------
    O(N)
    - Each node is visited exactly once
    - N = number of nodes in the tree

    -------------------------------------------------
    📦 SPACE COMPLEXITY (SC)
    -------------------------------------------------
    O(N)
    - Queue can hold up to N nodes in worst case
    - Answer list also stores all nodes
    */

    /*
    -------------------------------------------------
    🔑 VALUE-ADDED NOTES (IMPORTANT)
    -------------------------------------------------
    - Always use queue.size() to process one level at a time
    - BFS is the default choice for LEVEL-based problems
    - Inserting at index 0 avoids reversing at the end
    - This pattern is reused in:
        • Zigzag traversal
        • Left / Right view
        • Level averages
    */
}
