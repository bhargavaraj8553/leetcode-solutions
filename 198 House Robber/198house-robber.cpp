class Solution {
public:
    // vec
    int ways(vector<int>& nums, int n){
            
        if(n==0) return nums[0];
        // =nums[0];
        int prev1=nums[0];
        int currno,prev2=0;
        // negative=0;
        // if(n<0) return 0;
        
        // if(dp[n]!=-1){
        //     return dp[n];
        // }
        for(int i=1;i<=n;i++){
            int pick = nums[i];
                if(i>1) pick+=prev2;
            int notpick = 0 + prev1;
            currno =max(pick,notpick);
            prev2=prev1;
            prev1=currno;
        }
        // for(int i=1;i<=n;i++){
        //     int pick = nums[i];
        //     if(i>1){
        //     pick+= dp[i-2];
        //     }
        //     int notpick = 0 + dp[i-1];
        //     dp[i]=max(pick,notpick);
        // }
        return currno;
        // int pick = nums[n]+ ways(nums, n-2,dp);
        // int notpick = 0 + ways(nums,n-1,dp);
        // return dp[n]= max(pick,notpick);
    }
    
    int rob(vector<int>& nums) {
        int n=nums.size();
        // vector<int> dp(n,-1);
        return ways(nums,n-1);
    }
};




// //tebulation
// class Solution {
// public:
//     int dp[200];
//     int noways(vector<int>& nums, int j){
//         // if(i<0) dp[i]=0;
//         dp[0]=nums[0];
//         dp[1]=nums[1];
//         dp[2]= nums[0]+nums[2];
//         int i=3;
        
//         while(i<= j){
//         dp[i]=nums[i]+max(dp[i-2],dp[i-3]);
//             i++;
//         }
//         return dp[j];
//     }
//     int rob(vector<int>& nums) {
//         int n=nums.size();
//         if(n==1) return nums[0];
//         if(n==2) return max(nums[0],nums[1]);
//         return max(noways(nums, n-1) ,noways(nums, n-2));
//     }
// };







// this is not a maths question 
// class Solution {
// public:
//     int rob(vector<int>& nums) {
//         int n=nums.size(),i=0,sum=0,sumeven=0;
//         while(i<n){
//             sum+=nums[i];
//             if(i%2==0) sumeven+=nums[i];
//             i++;
//         }
//         return max(sumeven,sum-sumeven);
//     }
// };