class Solution {
public:
    int partitionArray(vector<int>& nums, int k) {
         int n=nums.size();
        sort(nums.begin(),nums.end());
        bool sequence=false;
        int count =0;
        int min=0;
        for(int i=0;i<n;i++){
            if(sequence && min+k>=nums[i]){
                
            }else{
                sequence=true;
                min=nums[i];
                ++count;
            }
        }
        return count ;
    }
};