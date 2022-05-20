class Solution {
    public : bool divisorGame(int n) {
        return (n%2)==0;
    }
};

// class Solution {
// private:
//     int dp[1001];
//     int win(int n){
//         if (n==1){ 
//             return 0;
//         }
//         if (dp[n]!=-1) {
//             return dp[n];
//             }
//         else{
//             for(int i=1;i*i<n;i++){
//                 if(n%i==0){
//                     if(win(n-i)==0){
//                         dp[n]= 1;
//                         return dp[n];
//                     }
//                     if ((i!=1) && win(n-(n/i))==0){
//                     return dp[n]=1;
//                     }
//                 }
//             }
//         }
//         dp[n]=0;
//         return dp[n];
//     }
//     public:
//     bool divisorGame(int n) {
//         memset (dp ,-1 ,sizeof dp);
//         return win(n);
//     }
// };













// // class Solution {
// //     private : 
// //     int dp[1001];
// //     int help(int n){
      
// //         if (n==1) return 0;
// //           if (dp[n]!=-1) return dp[n];
// //         else{
// //             for (int i=1;i<n;i++){
// //                 if(n%i==0){
// //                     if(help(n-i)==0){
// //                         return dp[n]=1;
// //                     }
// //                 }
// //             }
// //         }
// //         return dp[n]=0;
// //     }
// // public:
// //     bool divisorGame(int n) {
// //         memset(dp , -1 ,sizeof(dp));
// //         return help(n);
// //     }
// // };





















// // class Solution {
// // public:
// //     bool divisorGame(int n , int count=0) {
// //         if (n==2) {return true;}
// //         if (n==3) {return false;}
// //         bool value = true;
        
// //         for(int x=2;x<n;x++){
// //             if (n%x==0){
// //                 n=n-x;
// //                 if (count %2==0){
// //                     value = (!divisorGame(n,++count) & value);
// //                 }
// //                 else {
// //                     value = (divisorGame(n,++count) & value);
// //                 }
// //             }
// //         }
// //         return value;
// //     }
// // };