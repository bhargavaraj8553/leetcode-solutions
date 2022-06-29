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
    int sum=0;
    void sumofleaves(TreeNode* root){
        if(!root) return;
        if(root->left && !root->left->left && !root->left->right){
            sum+=root->left->val;
        }
        sumOfLeftLeaves(root->left);
        sumOfLeftLeaves(root->right);
    }
    int sumOfLeftLeaves(TreeNode* root) {
        sumofleaves(root);
        return sum;
        // if(root==NULL) return;
        // if(!root->left->left && !root->left->right){
        //     sum+=root->left->value;
        //     return;
        // }
        // sumOfLeftLeaves(root->left);
        // sumOfLeftLeaves(root->right);
    }
};