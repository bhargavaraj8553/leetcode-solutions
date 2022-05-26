class Solution {
public:
    int minMoves(vector<int>& nums) {
        
        int mini= INT_MAX,i=0,sum=0,n=nums.size();
        while(i<n){
            mini = min(mini,nums[i]);
            sum+=nums[i++]; 
        }
        // cout<<sum;
        return sum-(n*mini);
    }
};












// class Solution {
//     private: int 
//     int n=nums.size(),count=0,counter=0;
//         int maxi= nums[0];
//         while(i<n){
//             maxi= max(maxi,nums[i]);
//             i++;
//         }
//     for(int i=0 ; i<n && counter<n-1;i++){
//             if(nums[i]>maxi && count<1){
//                 i++;
//                 count++;
//             }
//             nums[i]++;
//             counter++;
//         }
// public:
//     int minMoves(vector<int>& nums) {
//         // int n=nums.size(),count=0,counter=0;
//         // int maxi= nums[0];
//         // while(i<n){
//         //     maxi= max(maxi,nums[i]);
//         //     i++;
//         // }
//         // for(int i=0 ; i<n && counter<n-1;i++){
//         //     if(nums[i]>max && count<1){
//         //         i++;
//         //         count++;
//         //     }
//         //     nums[i]++;
//         //     counter++;
//         // }
//     }
// };