class Solution{
public:
    bool containsDuplicate(vector<int>& nums) {
        int n=nums.size();
        // for(int i=0;i<n-1;i++){
        //     for(int j=0;j<n-i-1;j++){
        //         //2 1 5 8 4 1 6 4 2 5 9
        //         //12584164259
        //         //
        //         if(nums[j]>nums[j+1]){
        //         swap(nums[j],nums[j+1]);
        //         }
        //     }
        // }
        
        sort(nums.begin(),nums.end());
        for(int i=1;i<n;i++){
            if(nums[i-1]==nums[i]){
                return true;
                i++;
            }
        }
        return false;
    }
};