class Solution {
public:
    int sol(vector<int>& arr, int diff , unordered_map<int,int> & dp){
    // int solution(vector<int>& arr, int diff , vector<int> & dp){
        int n=arr.size(),maxi=1;
        for(int i=0;i<n;i++){
            int cnt=0;
            // for(int j=0;j<i;j++){
                // if(arr[i]-arr[j]==diff){
                    // int cnt=1;
            int temp=arr[i]-diff;
                    if(dp.count(temp)){
                        cnt =dp[temp];
                    }
                    // cnt=max(cnt,dp[j]+1);
                    dp[arr[i]]=1+cnt;
                    maxi=max(maxi,dp[arr[i]]);
                    //curr= max(curr,prev);
                    // prev=curr
                }
                
        return maxi;
                    
            }
    int longestSubsequence(vector<int>& arr, int diff) {
        int n =arr.size();
        // vector<int> dp(n,1);
        unordered_map<int,int> dp;
        // for(auto m:dp){
        //     m=1;
        // }
        return sol(arr,diff,dp);
    }
};