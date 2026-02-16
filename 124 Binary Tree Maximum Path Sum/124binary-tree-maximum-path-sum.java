class Solution {

    /*
    maxi stores the maximum path sum found anywhere in the tree.
    It is global because the best path may NOT pass through the root.
    */
    int maxi = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        /*
        We start a DFS traversal.
        The DFS will compute:
        1) The best path sum that can be extended upward (returned)
        2) Update the global maximum path sum (maxi)
        */
        dfs(root);
        return maxi;
    }

    private int dfs(TreeNode root) {

        /*
        Base case:
        An empty node contributes 0 to a path.
        */
        if (root == null) return 0;

        /*
        STEP 1: Get the maximum contribution from left and right subtrees.

        IMPORTANT:
        - We clamp values at 0.
        - Negative paths are discarded because they reduce the total sum.
        - If a subtree gives a negative sum, it's better to NOT take it at all.
        */
        int leftSum = Math.max(0, dfs(root.left));
        int rightSum = Math.max(0, dfs(root.right));

        /*
        STEP 2: Update the global maximum path sum.

        This represents the best path that PASSES THROUGH this node.
        Here, we are allowed to take:
            left subtree + current node + right subtree

        This path ENDS here, so it is valid to use BOTH children.
        */
        maxi = Math.max(maxi, root.val + leftSum + rightSum);

        /*
        STEP 3: Return the best path that can be EXTENDED to the parent.

        RULE:
        - A path going upward can choose ONLY ONE direction.
        - It cannot branch into both left and right.

        So we return:
            current node value + max(left contribution, right contribution)
        */
        return root.val + Math.max(leftSum, rightSum);
    }
}
