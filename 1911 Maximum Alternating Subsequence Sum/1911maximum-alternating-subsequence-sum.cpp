class Solution {
public:
    long long int dp[100001][2];
    long long solution(vector<int>& nums ,int i, int flag){
        int n=nums.size();
        if(i>=n) return 0;
        long long int take=0,nottake=0;
        if(dp[i][flag]!=-1){
            return dp[i][flag];
        }
        nottake= solution(nums ,i+1, flag);
        if(flag==1) take+=nums[i];
        else take-=nums[i];
        take+= solution(nums,i+1, 1-flag);
        return dp[i][flag]=max(take,nottake);
    }
    
    long long maxAlternatingSum(vector<int>& nums) {
        int n=nums.size();
        // int dp[n][2];
        for(int i=0;i<n;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        return solution(nums,0,1);
        
    }
};







// class Solution {
// public:
//     long long int val(vector<int>& nums,int i,bool eveodd,vector<long long int>& dp){
//         // int i=0;
//         long long int n=nums.size();
//         long long int take, nottake;
//         if(dp[i]!=-1) return dp[i];
//         if(i>= n) return 0;
//         if(eveodd==1){
//         take= val(nums,i+1,0,dp) + nums[i];
//         nottake = val(nums,i+1,1,dp);
//         return dp[i]=max(take,nottake);
//         }
//         else{
//         take= val(nums,i+1,1,dp) - nums[i];
//         nottake = val(nums,i+1,0,dp);
//         return dp[i]=max(take,nottake);
//         }
//         // return dp[0];
//         // final=max(take,nottake);
//         // if(eveodd==1) nottake = val(nums,i+1,1);
//         // else nottake = val(nums,i+1,0);
//     }
//     long long maxAlternatingSum(vector<int>& nums) {//621245
        
//         // take = dp[i,1];// 6 
//         // take = dp[i,-1];
//         int n=nums.size();
//         vector<long long int> dp(n,-1);
//         return val(nums,0,1,dp);
//     }
// };