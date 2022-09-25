class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int slow= nums[0],fast=nums[0],slow2=nums[0];
        // slow=nums[slow],fast= nums[fast];
        
        do{
            slow= nums[slow];
            fast= nums[nums[fast]];
        }
        while(slow!= fast);
        
        while(slow!=slow2){
            slow=nums[slow];
            slow2=nums[slow2];
        }
        
        return slow;
    }
};


// class Solution {
// public:
//     int findDuplicate(vector<int>& nums) {
//         // sort(nums.begin(),nums.end());
//         // int n=nums.size(),i=0;
        
        
//         while(i<n){
//             if(nums[i+1]==nums[i]) return nums[i];
//             else i++;
//         }
        
//         // int sum=0,n=nums.size();
//         // int sum1= (n)*(n+1)/2;
//         // for(auto it:nums){
//         //     sum+=it;
//         // }
//         return -1;
//     }
// };