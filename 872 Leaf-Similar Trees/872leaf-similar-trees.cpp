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
    vector<int> getLeafValues(TreeNode* root) {
  vector<int> leafValues;

  if (!root) {
    return leafValues;
  }

  if (!root->left && !root->right) {
    // This is a leaf node, add its value to the vector.
    leafValues.push_back(root->val);
    return leafValues;
  }

  // Recursively get the leaf values of the left and right subtrees.
  vector<int> leftLeafValues = getLeafValues(root->left);
  vector<int> rightLeafValues = getLeafValues(root->right);

  // Append the leaf values of the right subtree to the ones of the left subtree.
  leafValues.insert(leafValues.end(), leftLeafValues.begin(), leftLeafValues.end());
  leafValues.insert(leafValues.end(), rightLeafValues.begin(), rightLeafValues.end());

  return leafValues;
}

// Returns true if the two given trees are leaf-similar, false otherwise.
bool leafSimilar(TreeNode* root1, TreeNode* root2) {
  // Get the leaf values of both trees.
  vector<int> leafValues1 = getLeafValues(root1);
  vector<int> leafValues2 = getLeafValues(root2);

  // Check if the two sequences of leaf values are equal.
  return leafValues1 == leafValues2;
}
    // bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        
    // }
};