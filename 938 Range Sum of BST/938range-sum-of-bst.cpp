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
    // int value=0;
    // void sum(TreeNode* root, int low, int high){
    //     if(root==NULL) return;
    //     if(root->val>=low && root->val<=high)value+=root->val;
    //     sum(root->left,low,high);
    //     sum(root->right,low,high);
    // }
    int value=0;
    int rangeSumBST(TreeNode* root, int low, int high) {
        if(root==NULL) return 0;
        if(root && root->val>=low && root->val<=high) value+= root->val;
        rangeSumBST(root->left,low,high);
        rangeSumBST(root->right,low,high);
        return value;
    }
};