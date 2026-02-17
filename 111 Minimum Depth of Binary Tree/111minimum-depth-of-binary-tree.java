class Solution {

    /*
    PROBLEM: Minimum Depth of Binary Tree

    Find the shortest path from the root node
    to the nearest LEAF node.
    */

    /*
    INTUITION (WHY BFS):
    - Minimum depth = first leaf encountered level by level
    - BFS explores tree level-wise
    - The moment we see a leaf, that level is the answer
    - DFS can go deep unnecessarily and needs extra conditions
    */

    public int minDepth(TreeNode root) {

        // Level represents current depth in BFS
        int level = 0;

        // Edge case: empty tree
        if (root == null) return 0;

        // Queue for level order traversal (BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        /*
        BFS traversal:
        Each iteration of while-loop processes one level
        */
        while (!queue.isEmpty()) {

            int queueSize = queue.size();
            level++; // entering a new level

            // Process all nodes of current level
            for (int i = 0; i < queueSize; i++) {

                TreeNode polled = queue.poll();

                /*
                If current node is a LEAF,
                we have found the minimum depth.
                BFS guarantees this is the closest leaf.
                */
                if (polled.left == null && polled.right == null) {
                    return level;
                }

                // Add children for next level
                if (polled.left != null) queue.offer(polled.left);
                if (polled.right != null) queue.offer(polled.right);
            }
        }

        // This line is theoretically unreachable
        return 0;
    }

    /*
    TIME COMPLEXITY (TC): O(N)
    - In worst case, all nodes are visited

    SPACE COMPLEXITY (SC): O(N)
    - Queue can hold up to N nodes in worst case
    */

    /*
    VALUE-ADDED NOTE:
    - Do NOT use naive DFS with min(left, right)
    - A null child does NOT represent a valid leaf path
    - BFS avoids this mistake naturally
    */
}
