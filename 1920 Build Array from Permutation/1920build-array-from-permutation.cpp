class Solution {
public:
    vector<int> buildArray(vector<int>& nums) {
        int n=nums.size();
        vector<int> output(n);
        for(int i=0;i<n;i++){
            output[i]=nums[nums[i]];
        }
        return output;
    }
};