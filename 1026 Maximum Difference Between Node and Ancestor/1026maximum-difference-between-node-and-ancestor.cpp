/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    // int maxAncestorDiff(TreeNode* root) {
        
    // }
    int maxAncestorDiff(TreeNode* root) {
  int max_diff = 0;
  dfs(root, root->val, root->val, max_diff);
  return max_diff;
}

void dfs(TreeNode* node, int min_val, int max_val, int& max_diff) {
  if (!node) return;

  // Update the maximum difference found so far.
  max_diff = max(max_diff, abs(node->val - min_val));
  max_diff = max(max_diff, abs(node->val - max_val));

  // Update the minimum and maximum values for the ancestors of the current node.
  min_val = min(min_val, node->val);
  max_val = max(max_val, node->val);

  // Recursively search the left and right subtrees for a greater difference.
  dfs(node->left, min_val, max_val, max_diff);
  dfs(node->right, min_val, max_val, max_diff);
}
};