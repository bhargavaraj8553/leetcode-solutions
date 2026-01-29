class Solution {
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        int heightLeft = maxDepth(root.left);
        int heightRight = maxDepth(root.right);
        
        return 1 + Math.max(heightLeft, heightRight);
    }
}