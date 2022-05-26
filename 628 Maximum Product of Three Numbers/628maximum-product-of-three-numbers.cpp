// class Solution {
// public:
//     int maximumProduct(vector<int>& nums) {
        
//         sort(nums.begin(),nums.end());
//         return max(nums[0]*nums[1]*nums[nums.size()-1], nums[nums.size()-1]*nums[nums.size()-2]*nums[nums.size()-3]);
        
//     }
// };


class Solution {
public:
    int maximumProduct(vector<int>& nums) {
        int n= nums.size();
        int min1= INT_MAX, min2= INT_MAX;
        int max1= INT_MIN, max2= INT_MIN, max3=INT_MIN;
        
        for(int i=0;i<n;i++){
            if (nums[i]<min1){
                min2=min1;
                min1=nums[i];
            }
            else if (nums[i]<min2){
                min2=nums[i];
            }
            
            if(nums[i]>max1){
                max3=max2;
                max2=max1;
                max1=nums[i];
            }
            else if (nums[i]>max2){
                max3=max2;
                max2=nums[i];
            }
            else if (nums[i]>max3){
                max3=nums[i];
            }
        }
        return max(max1*max2*max3, max1*min1*min2);
    }
};













// // class Solution {
// //     private: 
// //     int maxnu(vector<int>& nums , int max1, int max2){
// //         int maxi= 0, i=0,n= nums.size();
// //         while(i++<n && abs(nums[i])<=abs(max1) && abs(nums[i]) <= abs(max2))           {
// //             if (abs(nums[i])==abs(max1) || abs(nums[i]) == abs(max2)){
// //                 continue;
                
// //             }
// //             if(nums[i]<0 || maxi <0){
// //                 if(abs(maxi)<abs(nums[i])){
// //                     maxi = nums[i];
// //                 }
// //             }
// //             else{  
// //                 maxi=max(maxi,nums[i]);
// //             }
// //             // i++;
// //             }
// //         return maxi;
// //     }
    
// // public:
// //     int maximumProduct(vector<int>& nums) {
// //         int num1,num2,num3;
// //         num1=maxnu(nums,INT_MAX,INT_MAX);
// //         num2= maxnu(nums,num1,INT_MAX);
// //         num3=maxnu(nums,num1,num2);
        
// //         return (num1*num2*num3);
// //     }
// // };