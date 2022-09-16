class Solution {
    public:
        void nextPermutation(vector<int>& nums) {
            int n=nums.size(),i=0,j=0,num1=0,num2=0,count=0;
            for(i=n-1;i>0;i--){
                if(nums[i]>nums[i-1]){
                    num1=nums[i-1];   
                    for(j=n-1;j>i;j--){
                        if(nums[j]>num1){
                            num2=nums[j];
                            break;
                            }   
                    }
                    swap(nums[i-1],nums[j]);
                    reverse(nums.begin()+i,nums.end());
                    return;
                }
                if(i==1){
                    reverse(nums.begin(),nums.end());
                }
            }



                // if(i==1){
                //     if(nums[1]>nums[0]){
                //         swap(nums[0],nums[1]);
                //         reverse(nums.begin()+1,nums.end());
                //         break;
                //     }
                //     swap(nums[0],nums[n-1]);
                //     sort(nums.begin()+1,nums.end());
                //     break;
                // }
                // if(nums[i]>nums[i-1]){
                //     swap(nums[i],nums[i-1]);
                //     break;
                // }
            // }
            // if(i ==1){
            //     if(nums[i]>nums[i-1]){
            //         swap(nums[0],nums[n-1]);
            //         // for(int j=1;j<n;j++){
            //             // if(nums[]>nums[0]) ;
            //             // }
                // }
            //     else reverse(nums.begin(),nums.end());
            // }
    }
};