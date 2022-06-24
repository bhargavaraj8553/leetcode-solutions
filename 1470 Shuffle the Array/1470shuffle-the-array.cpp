class Solution {
public:
    vector<int> shuffle(vector<int>& nums, int n) {
        vector<int> result(2*n);
        int i=0,j=0;
        while(i<2*n){
            result[i++]=nums[j];
            result[i]=nums[n+j];
            j++;i++;
        }
        return result;
    }
};