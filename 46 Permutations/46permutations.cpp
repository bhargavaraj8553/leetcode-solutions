class Solution {
public:
    void recur(vector<int>& nums , int index ,vector<vector<int>> &ans){
        int n=nums.size();
        if(index==n){
            ans.push_back(nums);
            return;
        }
        
        for(int i=index;i<n;i++){
            swap(nums[index],nums[i]);
            // temp = nums;
            recur(nums,index+1,ans);
            swap(nums[index],nums[i]);
        }
    }
    
    vector<vector<int>> permute(vector<int>& nums) {
        
        vector<vector<int>> ans;
        // vector<int>temp;
        recur(nums,0, ans);
        return ans;
        
    }
};


















// class Solution {
// public:
//     void recur(vector<int>& nums,vector<vector<int>> &ans, vector<int> &temp , int index,vector<int>& visited){
//         int n= nums.size();
//         if(temp.size()==n){
//             ans.push_back(temp);
//             return;
//         }
        
//         for(int i=0;i<n;i++){
//             if(!visited[i]){
//                 temp.push_back(nums[i]);
//                 visited[i]=1;
//                 recur(nums, ans, temp, i,visited);
//                 temp.pop_back();
//                 visited[i]=0;
//             }
//         }
        
//     }
    
//     vector<vector<int>> permute(vector<int>& nums) {
//         int n= nums.size();
//         vector<int> visited(n,0);
//         vector<vector<int>> ans;
//         vector<int> temp;
        
//         recur(nums,ans, temp, 0 ,visited);
//         return ans;
        
        
//     }
// };