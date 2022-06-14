// *
//  * Definition for a binary tree node.
//  * struct TreeNode {
//  *     int val;
//  *     TreeNode *left;
//  *     TreeNode *right;
//  *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
//  *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
//  *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
//  * };

class Solution {
    bool issame(TreeNode* root, TreeNode* subRoot){
        // if(root->val==subRoot->val){
            // if(root && !subRoot || !root && subRoot){
            //     return false;
            // }
        if(!root && !subRoot){
            return true;
        }
        if(!root || !subRoot){
            return false;
        }
        if(root->val!=subRoot->val){
            return false;
        }
            return issame(root->left,subRoot->left) && issame(root->right,subRoot->right);
        // }
        // return false;
    }
//     bool check (TreeNode* root, TreeNode* subRoot){
//         if(root==NULL){
//             return false;
//         }
//         if (issame(root,subRoot)){
//             return true;
//         }
// //         if(root->val==subRoot->val){
// //             if(root && !subRoot || !root && subRoot){
// //                 return false;
// //             }
// //             if(root->val!=subRoot->val){
// //                 return false;
// //             }
// //             return check(root->left,subRoot->left) && check(root->right,subRoot->right);
// //             // check(root->right,subroot->right);
// //             return true;
            
// //         }
//         return (check(root->left,subRoot) || check(root->right,subRoot));
//         // check(root->right,subRoot);
//         // return false;
//     }
public:
    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        if(root==NULL){
            return false;
        }
        if (issame(root,subRoot)){
            return true;
        }
         return (isSubtree(root->left,subRoot) || isSubtree(root->right,subRoot));
        // return check(root,subRoot);
    }
};