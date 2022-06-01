class Solution {
public:
    int numJewelsInStones(string jewels, string stones) {
    int count=0;
        for (auto j:jewels){
            for(auto s:stones){
                if (j==s) count++;
            }
        }
        return count;
    }
};