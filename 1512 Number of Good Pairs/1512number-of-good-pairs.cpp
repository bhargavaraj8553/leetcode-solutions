class Solution {
public:
    int numIdenticalPairs(vector<int>& nums) {
        int sum=0;
        unordered_map<int,int> freq;
        for(auto it:nums){
            freq[it]++;
        }
        for(auto it:freq){
            if(it.second>1){
            int a=it.second;
            sum+= (a*(a-1))/2;}
        }
        return sum;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(nums[i]==nums[j]){
        //             count++;
        //         }
        //     }
        // }
        // return count;
    }
};