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
    // string tmp;
    // vector<string> result;
    void allpaths(TreeNode* root,vector<string> &result, string tmp){
        if(root == NULL) return ;
        // tmp.push_back(root->val);
        if(root->left == NULL && root->right == NULL){
            tmp += to_string(root->val);
            result.push_back(tmp);
            // tmp={""};
            // return ;
        }
        else{
        tmp = tmp+ to_string(root->val) +'-'+'>' ;}
        // tmp=tmp+'-'+'>';
        allpaths(root->left,result,tmp);
        allpaths(root->right,result,tmp);
    }
// class Solution {
// //     vector<string> path;
//     string str;
//     vector<string> allpaths(TreeNode* root,vector<string> &path){
//         // string str;
//         if(root->left==NULL && root->right==NULL){
//             str.push_back(root->val);
//             path.push_back(str);
//             str.clear();
//             return {};
//         }
//         str.push_back(root->val);
//         str=str+'-'+'>';
//         allpaths(root->left,path);
//         allpaths(root->right,path);
//         return path;
//     }
// public:
//     vector<string> binaryTreePaths(TreeNode* root) {
//         vector<string> path;
//         return allpaths(root,path);
//     }
// };
    vector<string> binaryTreePaths(TreeNode* root) {
        
//         if(root == NULL) return{""} ;
//         temp.push_back(root->val);
        
//         binaryTreePaths(root->left);
//         binaryTreePaths(root->right);
        vector<string> result;
        string tmp;
        allpaths(root,result,tmp);
        return result;
    }
};