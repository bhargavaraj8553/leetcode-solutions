class Solution {
public:
    vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
        int n= candies.size(),maxi=INT_MIN;
        for(auto it:candies){
            maxi= max(maxi,it);
        }
        vector<bool> greatest(n,false);
        for(int i=0;i<n;i++){
            if(extraCandies+candies[i] >= maxi){
                greatest[i]=true;
            }
        }
        return greatest;
    }
};