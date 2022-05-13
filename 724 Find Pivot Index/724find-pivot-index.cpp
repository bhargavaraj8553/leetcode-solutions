class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int n= nums.size();
        int leftsum=0,totsum=0;
        for (int i=0;i<n;i++){
            totsum+=nums[i];
        }
        
        for (int i=0; i<n ; i++){
            
            if (leftsum== totsum-leftsum-nums[i]){
                return i;
            }
            leftsum+= nums[i];
        }
        return -1;
                              
        
    }
};


















// class Solution {
// public:
//     int pivotIndex(vector<int>& nums) {
//         int n=nums.size(),pivot=0,sumj=0,sumi=0,i;
//         for (i=0;i<n-1;i++){
//             for (int j=i+2;j<n;j++){
//                 sumj+=nums[j];
//                 // cout<<sumj;
//             }
//             sumi+=nums[i];
//             // cout<<sumj+nums[0]+nums[1]<<endl;
            
//         //     cout<<sumj<<endl;
//         //     cout<<sumi<<endl;
//         // cout<<sumj+nums[1]<<endl;
//             if(sumi==sumj){
//                 pivot=i+1;
//                 // sumj=0;
//             return pivot;
//             }
//             if (i==0 && ((sumj+nums[1])==0)){
//                 return 0;
//             }
            
//             sumj=0;
         
//         }
//     // pivot=-1;
//      return (-1) ;  
//     }
// };