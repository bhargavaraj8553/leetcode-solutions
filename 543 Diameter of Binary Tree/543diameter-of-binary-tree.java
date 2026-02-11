class Solution {

    /*
    max stores the maximum diameter found so far.
    Diameter = number of edges in the longest path between any two nodes.
    */
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        /*
        We trigger a DFS that computes height of each subtree.
        While computing height, we also update the diameter.
        */
        findMaxHeight(root);
        return max;
    }

    /*
    This function returns the HEIGHT of the subtree rooted at `root`.

    At the same time, it updates `max` with the best diameter found
    passing through this node.
    */
    private int findMaxHeight(TreeNode root) {

        // Base case: empty subtree has height 0
        if (root == null) return 0;

        /*
        Step 1: Get height of left subtree
        Step 2: Get height of right subtree
        These calls must finish BEFORE we process the current node,
        which is why this is a POSTORDER DFS.
        */
        int leftHeight = findMaxHeight(root.left);
        int rightHeight = findMaxHeight(root.right);

        /*
        Step 3: Compute diameter passing through this node.

        The longest path that passes through this node is:
        leftHeight + rightHeight
        (edges from deepest left node to deepest right node)
        */
        max = Math.max(max, leftHeight + rightHeight);

        /*
        Step 4: Return height of current subtree to parent.
        Height = 1 (current node) + max of left/right subtree height
        */
        return 1 + Math.max(leftHeight, rightHeight);
    }

    /*
    NOTE:
    We do NOT use a separate getHeight() function.
    That would recompute heights repeatedly and cause O(N^2) time.
    */
}
