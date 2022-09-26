class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        vector<int> ans;
        int n =nums.size();
        int num1= INT_MIN, num2= INT_MIN, count1=0,count2=0;
        
        for(int i=0;i<n;i++){
            if (num1==nums[i]) count1++;
            else if(num2==nums[i])count2++;
            else if(count1==0) num1= nums[i],count1++;
            else if (count2==0) num2= nums[i],count2++;
            else count1--,count2--;
        }
        
        count1=0;count2=0;
        for(int i=0;i<n;i++){
            if(nums[i]==num1) count1++;
            else if(nums[i]==num2) count2++;
        }
        
        if(count1>n/3) ans.push_back(num1);
        if(count2>n/3) ans.push_back(num2);
        
        return ans;
    }
};













// class Solution {
// public:
//     vector<int> majorityElement(vector<int>& nums) {
//         int n=nums.size();
//         unordered_map <int,int> mp;
//         vector<int> ans;
//         for(auto it:nums){
//             mp[it]++;
//         }
        
//         for(auto p:mp){
//             if(p.second>n/3) ans.push_back(p.first);
//         }
//         return ans;
//     }
// };