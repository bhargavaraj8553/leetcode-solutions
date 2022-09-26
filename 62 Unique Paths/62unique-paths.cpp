class Solution {
public:
    int totalpaths(int m ,int n, vector<vector<int>>& dp){
        if(m==0) return 1;
        if(n==0) return 1;
        if(dp[m][n]!=-1) return dp[m][n];

        // int a=dp[m][n-1]= totalpaths(m,n-1);
        // int b=dp[m-1][n]= totalpaths(m-1,n);
        return dp[m][n]= totalpaths(m-1,n,dp) + totalpaths(m,n-1,dp);
    }
    
    int uniquePaths(int m, int n) {
        vector<vector<int>> dp(m, vector<int> (n,-1));
        return totalpaths(m-1,n-1,dp);

    }
};