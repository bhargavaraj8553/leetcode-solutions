class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        int maxi= 0;
        for(auto it:costs){
            maxi= max(maxi , it);
        }
        
        vector<int> count(maxi+1, 0);
        for(int i=0;i<costs.size();i++){
            count[costs[i]]++;
        }   

        int ans = 0;
        for(int j=0; j<=maxi; j++){
            if(count[j] == 0){
                continue;
            }
            int numBars = min(coins/j, count[j]);
            ans += numBars;
            coins -= numBars * j;
        }
        return ans;
    }
};
