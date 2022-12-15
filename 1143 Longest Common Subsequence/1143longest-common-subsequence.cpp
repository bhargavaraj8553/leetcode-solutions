//tabulation//0->n-1
class Solution {
public:
    int solution(string &s1, string &s2,int i,int j,vector<vector<int>>& dp){
        // int length=0;
        // if(i>=s1.length()|| j>=s2.length()){
        //     return 0;
        // }
        int n1=s1.length(),n2=s2.length();
        
        // if(dp[i][j]!=-1){
        //     return dp[i][j];
        // }
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                
                if(s1[i]==s2[j]){
                    dp[i][j] = 1+ dp[i+1][j+1];
                }
                else{
                    dp[i][j]= max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
       // return dp[i][j];
        return dp[0][0];
        
    }
    int longestCommonSubsequence(string text1, string text2) {
        vector<vector<int>> dp(text1.length()+1,vector<int> (text2.length()+1,0));
        int n1=text1.length(),n2=text2.length();
        return solution(text1,text2,n1-1,n2-1,dp);
    }
};

// memoization
//class Solution {
// public:
//     int solution(string &s1, string &s2,int i,int j,vector<vector<int>>& dp){
//         int length=0;
//         if(i>=s1.length()|| j>=s2.length()){
//             return 0;
//         }
        
//         if(dp[i][j]!=-1){
//             return dp[i][j];
//         }
//         if(s1[i]==s2[j]){
//             length=1+ solution(s1,s2,i+1,j+1,dp);
//         }
//         else{
//             length= max(solution(s1,s2,i+1,j,dp),solution(s1,s2,i,j+1,dp));
//         }
//        return dp[i][j]=length;
        
//     }
//     int longestCommonSubsequence(string text1, string text2) {
//         vector<vector<int>> dp(text1.length(),vector<int> (text2.length(),-1));
//         return solution(text1,text2,0,0,dp);
//     }
// };