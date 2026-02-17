class Solution {

    /*
    PROBLEM: Binary Tree Right Side View
    Return the nodes visible when the tree is viewed from the right side.
    */

    /*
    BRUTE FORCE INTUITION:
    - For each level, store all nodes
    - Take the last node of every level

    WHY BFS (OPTIMAL):
    - Right side view is a LEVEL-based problem
    - BFS processes tree level by level naturally
    */

    public List<Integer> rightSideView(TreeNode root) {

        // Stores the rightmost node of each level
        List<Integer> ans = new ArrayList<>();

        // Edge case: empty tree
        if (root == null) return ans;

        // Queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        /*
        BFS traversal:
        Each iteration of while-loop processes ONE level
        */
        while (!queue.isEmpty()) {

            // Number of nodes in current level
            int queueSize = queue.size();

            // Traverse all nodes of current level
            for (int i = 0; i < queueSize; i++) {

                TreeNode polled = queue.poll();

                /*
                If this is the LAST node of the level,
                it will be visible from the right side
                */
                if (i == queueSize - 1) {
                    ans.add(polled.val);
                }

                // Add children for next level
                if (polled.left != null) queue.offer(polled.left);
                if (polled.right != null) queue.offer(polled.right);
            }
        }

        return ans;
    }

    /*
    TC: O(N)  → each node visited once
    SC: O(N)  → queue + result list
    */
}
