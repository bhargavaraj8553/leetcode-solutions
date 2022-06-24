class Solution {
public:
    int maximumWealth(vector<vector<int>>& accounts) {
        int maxsum=0;
        for(auto c:accounts){
            int sum=0;
            for(auto b:c){
                sum+=b;
            }
            maxsum=max(sum,maxsum);
        }
        return maxsum;
    }
};