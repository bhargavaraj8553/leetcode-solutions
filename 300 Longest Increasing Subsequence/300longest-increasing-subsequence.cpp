class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n=nums.size(),maxi=1;
        // vector<int> dp(n,1);
        //10 9 2 5 3 7 101 18
        //10
        //18 5 7 101 
        vector<int> vec;
        vec.push_back(nums[0]);
        for(int i=1;i<n;i++){
            if(nums[i]>vec[vec.size()-1]){
                vec.push_back(nums[i]);
            }
            else {
                // for(int j=0;j<vec.size();j++){
                int j = lower_bound(vec.begin(),vec.end(),nums[i])-vec.begin();
                    // if(vec[j]>=nums[i]){
                        vec[j]=nums[i];
                        // break;
                    // }
                }
                // nums[0]=nums[i];
            // }
        }
        return vec.size();
            // for(int j=0;j<i;j++){
//                 // if(nums[i]>nums[j]){
//                 //     dp[i]=max(dp[i],dp[j]+1);
//                 // }
//                 // int val=1;
//                 if(dp.count(nums[i-1])){
//                     val=dp[nums[i-1]];
//                 }
            
//             if(nums[i]>nums[i-1]){
//                 dp[nums[i]]=1+val;
//                 // dp[nums[i]] = max(dp[nums[i]], 1+ val );
                
//                 }
//             maxi= max(maxi,dp[nums[i]]);
//             // }
        // }
        // return maxi;
    }
};