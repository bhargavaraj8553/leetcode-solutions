class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n= prices.size(),profit=0;
        for (int i=1; i<n;i++){
            if (prices[i]>prices[i-1]){
            profit+= prices[i]-prices[i-1];
        }
        
    }
    return profit;
        
    }
    
};


// class Solution {
// public:
//     int maxProfit(vector<int>& prices) {
//         int i=1,profit=0, n=prices.size();
//         int mini=prices[0], maxi= prices[n-1];
//         while(i<prices.size()){
//             if(prices[i]< min(prices[i+1],prices[i-1])){
//             mini= prices[i];
//             // maxi=mini;
//         }
//         else if (prices[i]> max(prices[i+1],prices[i-1])){
//             maxi=prices[i];
//             profit+= (maxi-mini);
//             // mini=maxi;
//         }
            
        
//         i++;
//         // maxi= prices[n-1];
//         }
//         if (profit==0){
//             profit = maxi-mini;
//         }
//         return max(profit,0);
        
//     }
// };














// // class Solution {
// // public:
// //     int maxProfit(vector<int>& prices) {
// //         int minSofar= 0;
// //        int maxSofar= 0;
// //         int maxProfit=0;
// //         for(int i=0;i<prices.size();i++){
// //            if (prices[i+1]>prices[i]){
// //                minSofar+=prices[i];
// //                for (int j=i;j<prices.size();j++){
// //                    if (prices[j+1]<prices[j]){
// //                        maxSofar+=prices[j];
// //                        break;
// //                    }
// //                }
// //            }
            
// //         }
// //         return (maxSofar-minSofar);
// //     }
// // };